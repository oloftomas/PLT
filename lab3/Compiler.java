import CPP.Absyn.*;
import java.util.*;

public class Compiler {

	// Compiler output
	LinkedList<String> output;
	// Signature map
	Map<String,FunType> signature;
	// Context list
	List<Map<String,CxtEntry>> context;

	// State variables
	int nextLocal = 0;
	int limitLocals = 0;
	int limitStack = 0;
	int currentStack = 0;
	int nextLabel = 0;

	boolean returned = false;

	// TODO predef types int, double, bool and void

	public class CxtEntry {
		final Type type;
		final Integer addr;

		CxtEntry(Type t, Integer a) {
			type = t;
			addr = a;
		}
	}

	public final Type BOOL = new Type_bool();
	public final Type INT = new Type_int();
	public final Type DOUBLE = new Type_double();
	public final Type VOID = new Type_void();


	public void compile(String name, Program p) {
		// Init output
		output = new LinkedList();

		// output boiler
		output.add(".class public " + name + "\n");
		output.add(".super java/lang/Object\n");
		output.add("\n");
		output.add(".method public <init>()V\n");
		output.add("  .limit locals 1\n");
		output.add("\n");
		output.add("  aload_0\n");
		output.add("  invocespecial java/lang/Object/<init>()V\n");
		output.add("  return\n");
		output.add("\n");
		output.add(".end method\n");
		output.add("\n");
		output.add(".method public static main([Ljava/lang/String;)V\n");
		output.add("  .limit locals 1\n");
		output.add("  .limit stack  1\n");
		output.add("\n");
		output.add("  invokestatic " + name + "/main()I\n");
		output.add("  pop\n");
		output.add("  return\n");
		output.add("\n");
		output.add(".end method\n");
		output.add("\n");

		// Create signature
		signature = new HashMap();

		// Add built-in functions
		// printInt
		ListArg intArg = new ListArg();
		intArg.add(new ADecl(INT, "x"));
		signature.put("printInt", new Fun("Runtime/printInt", new FunType(VOID, intArg)));

		// printDouble
		ListArg doubleArg = new ListArg();
		doubleArg.add(new ADecl(DOUBLE, "x"));
		signature.put("printDouble", new Fun("Runtime/printDouble", new FunType(VOID, doubleArg)));

		// readInt
		signature.put("readInt", new Fun("Runtime/readInt", new FunType(INT, new ListArg())));

		// readDouble
		signature.put("readDouble", new Fun("Runtime/readDouble", new FunType(DOUBLE, new ListArg())));

		// Add functions to signature
		for (Def d : (PDefs)p.listdef_) {
			DFun def = (DFun)d;
			signature.put(def.id_, new Fun(name + "/" + def.id_, new FunType(def.type_, def.listarg_)));
		}

		// Run compiler/visit whole program
		p.accept(new ProgramVisitor(), null);

		// Output result
		for (String s : output) {
			System.out.println(s);
		}
	}

	public class ProgramVisitor implements Program.Visitor<Object,Object> {
		public Object visit(PDefs p, Object o) {
			for (Def d : p.listdef_) {
				d.accept(new DefVisitor(), null);
			}
			return null;
		}
	}

	public class DefVisitor implements Def.Visitor<Object,Object> {
		public Object visit(DFun p, Object o) {
			// Reset state for new function
			context = new LinkedList();
			context.add(new HashMap());
			nextLocal = 0;
			limitLocals = 0;
			limitStack = 0;
			currentStack = 0;

			// save current output
			LinkedList<String> savedOutput = output;
			output = new LinkedList();

			// Compile function :

			// Add function parameters to context
			for (Arg a : p.listarg_) {
				a.accept(new ArgVisitor(), null);
			}
			for (Stm s : p.liststm_) {
				s.accept(new StmVisitor(), null);
			}

			// add new output to old output
			LinkedList<String> newOutput = output;
			output = savedOutput;

			Fun f = new Fun(p.id_, new FunType(p.type_, p.listarg_));
			output.add("\n.method public static " + f.toJVM() + "\n");
			output.add("  .limit locals " + limitLocals + "\n");
			output.add("  .limit stack " + limitStack + "\n\n");

			for (String s : newOutput) {
				output.add("  " + s);
			}
			output.add("\n.end method\n");
			return null;
		}
	}

	public class ArgVisitor implements Arg.Visitor<Object,Object> {
		public Object visit(ADecl p, Object o) {
			newVar(p.id_, p.type_);
			return null;
		}
	}

	public class StmVisitor implements Stm.Visitor<Object,Object> {
		public Object visit(SExp p, Object o) {
			p.exp_.accept(new ExpVisitor(), null);
			emit(new Pop(p.exp_.getType()));
			return null;
		}
		public Object visit(SDecls p, Object o) {
			for (String s : p.listid_) {
				newVar(s, p.type_);
			}
			return null;
		}
		public Object visit(SInit p, Object o) {
			newVar(p.id_, p.type_);
			p.exp_.accept(new ExpVisitor(), null);
			CxtEntry ce = lookupVar(p.id_);
			emit (new Store(ce.type, ce.addr));
			return null;
		}
		public Object visit(SReturn p, Object o) {
			p.exp_.accept(new ExpVisitor(), null);
			emit (new Return(p.exp_.getType()));
			return null;
		}
		public Object visit(SWhile p, Object o) {
			return null;
		}
		public Object visit(SBlock p, Object o) {
			return null;
		}
		public Object visit(SIfElse p, Object o) {
			return null;
		}
	}

	public class ExpVisitor implements Exp.Visitor<Object,Object> {

	}

	void emit(Code c) {
		String line = c.accept(new CodeToJVM());
		if (!line.isEmpty()) {
			output.add(line);
		}
		adjustStack(c);
	}

	void newVar(String s, Type t) {
		// Get top block of context
		Map<String,CxtEntry> m = context.get(0);
		// Add variable to context with nextLocal addr
		CxtEntry ce = new CxtEntry(t, nextLocal);
		m.put(s, ce);
		// inc nextLocal
		++nextLocal;
		if (nextLocal > limitLocals) {
			limitLocals = nextLocal;
		}
	}

	CxtEntry lookupVar(String s) {
		Map m = context.get(0);
		return null;
		//throw new RuntimeException("Impossible: unbound variable " + x);
	}

	// Adjust stack depending on c
	void adjustStack(Code c) {
		c.accept(new AdjustStack());
	}

	// inc stack by size of type, also handles stacklimit
	void incStack(Type t) {
		currentStack = currentStack + t.accept(new Size(), null);
		if (currentStack > limitStack) {
			limitStack = currentStack;
		}
	}

	// Dec stack by size of type
	void decStack(Type t) {
		currentStack = currentStack - t.accept(new Size(), null);
	}

	class Size implements Type.Visitor<Integer,Object> {
		public Integer visit(Type_bool t, Object o)   { return 1; }
		public Integer visit(Type_int t, Object o)    { return 1; }
		public Integer visit(Type_double t, Object o) { return 2; }
		public Integer visit(Type_void t, Object o)   { return 0; }
	}

	class AdjustStack implements CodeVisitor<Object> {
		public Object visit(Comment a) {                   return null; }
		public Object visit(Store a)   { decStack(a.type); return null; }
		public Object visit(Load a)    { incStack(a.type); return null; }
		public Object visit(IConst c)  { incStack(INT);    return null; }
		public Object visit(Dup c)     { intStack(c.type); return null; }
		public Object visit(Pop c)     { decStack(c.type); return null; }
		public Object visit(Return c)  { decStack(c.type); return null; }

		public Object visit(Call c) {
			FunType ft = c.fun.funType;
			for (Arg a : ft.args) {
				decStack(((ADecl)a).type_);
			}
			incStack(ft.returnType);
			return null;
		}

		public Object visit(Add c)     { decStack(c.type); return null; }
	}

}
