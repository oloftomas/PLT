import CPP.Absyn.*;
import java.util.*;
import java.io.*;

public class TypeChecker {

	private Map<String,FunType> signature;
	private List<Map<String,Type>> contexts;

    public void typecheck(Program p) {
        /*	
        	PASS 1
			
			PDefs pd = p.accept();

			foreach in p
				add all functions to signature list:
					implement program visitor
					and def visitor


			PASS 2
			implement ALL visitors down to Exp
			do checkerino
        */

		// build symbol table
		//env.signature = p.accept(new ProgramVisitor(), null);
		p.accept(new ProgramVisitor(), null);

    }

    // Program visitor
    public class ProgramVisitor implements Program.Visitor<Object,Object> {
    	public Object visit(PDefs p, Object o) {
    		signature = new HashMap<String,FunType>();

    		// TODO add primitive functions (printInt, printDouble etc)

    		// Add all defs to signature
    		for (Def d : p.listdef_) {
    			d.accept(new DefToSigVisitor(), null);
    		}

    		// Check definitions
    		for (Def d : p.listdef_) {
    			//d.accept(new DefVisitor(), null);
    		}

    		return null;
    	}
    }

    public class DefToSigVisitor implements Def.Visitor<Object,Object> {
    	public Object visit(DFun p, Object o) {
    		// check in function is already defined
    		if (signature.containsKey(p.id_)) {
    			throw new TypeException("Function " + p.id_ + " already defined");
    		}
    		// Add function to signature
    		FunType ft = new FunType(p.listarg_, p.type_);
    		signature.put(p.id_, ft);

    		return null;
    	}
    }

    // Def visitor
    public class DefVisitor implements Def.Visitor<SigElement,Object> {
    	public SigElement visit(DFun p, Object o) {
    		
    		// reimplement whole thing but update signature throughout
    		// and not with only returns
    		if (signature.containsKey(p.id_)) {
    			throw new TypeException("function " + p.id_ + " already declared");
    		}

    		LinkedList<Type> argTypeList = new LinkedList<Type>();
    		for (Arg a : p.listarg_) {
    			argTypeList.push(a.accept(new ArgVisitor(), null));
    		}

    		// create FunType obj
    		//FunType ft = new FunType(argTypeList, p.type_);

    		//SigElement sigElem = new SigElement(p.id_, ft);

    		return null;
    	}
    }

    // Function Type
    public class FunType {
    	public ListArg args;
    	public Type retType;

    	FunType(ListArg alist, Type ty) {
    		args = alist;
    		retType = ty;
    	}
    }

    // Help class for (String,FunType) tuple
    public class SigElement {
    	final String id;
    	final FunType funType;

    	public SigElement(String s, FunType ft) {
    		id = s;
    		funType = ft;
    	}
    }

    public class ArgVisitor implements Arg.Visitor<Type,Object> {
    	public Type visit(ADecl p, Object o) {
    		return p.type_;
    	}
    }

/*
    // Checking statements, copied from book
    public class CheckStm implements Stm.Visitor<Env,Env> {
    	public Env visit(SDecls p, Env env) {
    		env.updateVar(p.id_, p.type_);
    		return env;
    	}

    	public Env visit(SExp p, Env env) {
    		inferExp(p.exp_, env);
    		return env;
    	}

    	public Env visit(SInit p, Env env) {
    		
    	}

    	//...
    }

    // Check Exp class or use infer smart...

    // Infering Expressions 
    public static class InferExp implements Exp.Visitor<Type,Env> {
    	public Type visit(ETrue p, Env env) {

    	}

    	public Type visit(EFalse p, Env env) {

    	}

    	public Type visit(EInt p, Env env) {
    		
    	}

    	public Type visit(EDouble p, Env env) {

    	}
    	// ...

    }

 
    public class TypeVisitor implements Type.Visitor<TypeCode,Type> {
    	public TypeCode visit(Type_bool p, Type ty) {

    	}

    	public TypeCode visit(Type_int p, Type ty) {
    		
    	}

    	public TypeCode visit(Type_double p, Type ty) {
    		
    	}

    	public TypeCode visit(Type_void p, Type ty) {
    		
    	}    	
    }
*/

    // Environment class
    // in pass 1 : Add ALL function defs to sig by using update meths
    // in pass 2 : use Env but remove contexts that are out of scope

    /*
    public static class Env {
    	public static Map<String, FunType> signature;
    	public static LinkedList<Map<String,Type>> contexts;

    	// Constructor
    	public Env() {

    	}

    	public static Type lookVar(String id) {
    		return null;
    	}

    	public static FunType lookFun(String id) {
    		if (signature.containsKey(id)) {
    			return signature.get(id);
    		} else {
    			throw new TypeException("Function " + id + " does not exist");
    		}
    	}

    	public static void updateVar(String id, Type ty) {

    	}

    	public static void updateFun(String id, FunType ft) {
    		if (!signature.containsKey(id)) {
    			signature.put(id,ft);
    		} else {
    			throw new TypeException("Function " + id + " does not exist");
    		}
    	}
    }
	*/
    // TypeCode for type comparisson
    public static enum TypeCode { CInt, CDouble, CBool, CVoid }

}
