import CPP.Absyn.*;
import java.util.*;
import java.io.*;

/*
   TypeChecker for lab3
   TODO implement setType?
*/
public class TypeChecker {

	private Map<String,FunType> signature;
	private List<Map<String,Type>> contexts;

	private Type returnType;

	public final Type BOOL   = new Type_bool();
	public final Type INT    = new Type_int();
	public final Type DOUBLE = new Type_double();
	public final Type VOID   = new Type_void();

    // Entry point
    public void typecheck(Program p) {
		p.accept(new ProgramVisitor(), null);
    }

    // Program visitor
    public class ProgramVisitor implements Program.Visitor<Object,Object> {
    	public Object visit(PDefs p, Object o) {
    		signature = new HashMap<String,FunType>();
    		// TODO add primitive functions (printInt, printDouble etc)
    		signature.put("printInt", new FunType(singleArg(INT), VOID));
    		signature.put("readInt", new FunType(new ListArg(), INT));
    		signature.put("printDouble", new FunType(singleArg(DOUBLE), VOID));
    		signature.put("readDouble", new FunType(new ListArg(), DOUBLE));

    		// Build symbol table
    		for (Def d : p.listdef_) {
    			d.accept(new DefToSigVisitor(), null);
    		}

    		// Check for main function
    		FunType ft = signature.get("main");
    		if (ft == null) {
    			throw new TypeException("function main undefined");
    		}
    		if (!ft.retType.equals(INT)) {
    			throw new TypeException("function main should return int");
    		}
    		if (!ft.args.isEmpty()) {
    			throw new TypeException("function main does not take arguments");
    		}

    		// Check definitions
    		for (Def d : p.listdef_) {
    			d.accept(new DefVisitor(), null);
    		}

    		return null;
    	}
    }

    public ListArg singleArg(Type ty) {
    	ListArg la = new ListArg();
    	la.add(new ADecl(ty, "x"));
    	return la;
    }

    // Def visitor for adding to signature
    public class DefToSigVisitor implements Def.Visitor<Object,Object> {
    	public Object visit(DFun p, Object o) {
    		// check if function is already defined
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
    public class DefVisitor implements Def.Visitor<Object,Object> {
    	public Object visit(DFun p, Object o) {
    		
    		// set return type and context
    		returnType = p.type_;
    		contexts = new LinkedList();
    		contexts.add(new HashMap());

    		// add arguments to context
    		for (Arg a : p.listarg_) {
    			a.accept(new ArgVisitor(), null);
    		}

    		// check function statements
    		for (Stm s : p.liststm_) {
    			s.accept(new StmVisitor(), null);
    		}

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

    // Argument Visitor
    public class ArgVisitor implements Arg.Visitor<Object,Object> {
    	public Object visit(ADecl p, Object o) {
            if (!p.type_.equals(VOID)) {
                newVar(p.id_, p.type_);
                return null;
            }
            throw new TypeException("Argument should not be type void");
        }
    }

    // Statement Visitor
    public class StmVisitor implements Stm.Visitor<Object,Object> {
    	public Object visit(SExp p, Object o) {
    		p.exp_.accept(new ExpVisitor(), null);
    		return null;
    	}
    	public Object visit(SDecls p, Object o) {
    		// Add all <Id,Type>-pairs from p.listid_ to current block
            for (String s : p.listid_) {
                if (!p.type_.equals(VOID)) {
                    newVar(s, p.type_);
                } else {
                    throw new TypeException("Variables should not be type void");
                }
            }
            return null;	
    	}
    	public Object visit(SInit p, Object o) {
    		// Get type of initexp
    		Type t = p.exp_.accept(new ExpVisitor(), null);
    		// Check if type matches with vartype
    		check(p.type_, t);
    		// Add var to current block
    		newVar(p.id_, p.type_);
    		return null;
    	}
    	public Object visit(SReturn p, Object o) {
    		// Check that return exp is same type as function type
    		Type t = isEqualTypes(returnType, p.exp_.accept(new ExpVisitor(), null));
    		return null;
    	}
    	public Object visit(SWhile p, Object o) {
    		// Check that expression is bool
    		check(BOOL, p.exp_.accept(new ExpVisitor(), null));
    		// Add, visit and remove statement block
            newBlock();
    		p.stm_.accept(this, null);
            popBlock();
    		return null;
    	}
    	public Object visit(SBlock p, Object o) {
    		// Add new top block
    		newBlock();
    		// Visit all statements in the new block
    		for (Stm s : p.liststm_) {
    			s.accept(new StmVisitor(), null);
    		}
            // Remove top block
            popBlock();
    		return null;
    	}
    	public Object visit(SIfElse p, Object o) {
    		// Check that expression is bool
    		check(BOOL, p.exp_.accept(new ExpVisitor(), null));
    		// Visit if statement
            newBlock();
    		p.stm_1.accept(this, null);
            popBlock();
    		// Visit else statement
            newBlock();
    		p.stm_2.accept(this, null);
            popBlock();
    		return null;
    	}
    }

    // Expression Visitor
    // TODO extend so that each exp also sets Type!
    public class ExpVisitor implements Exp.Visitor<Type,Object> {
    	// Literals
    	public Type visit(ETrue p, Object o) {
    		return p.setType(BOOL);
    	}
    	public Type visit(EFalse p, Object o) {
    		return p.setType(BOOL);
    	}
    	public Type visit(EInt p, Object o) {
    		return p.setType(INT);
    	}
    	public Type visit(EDouble p, Object o) {
    		return p.setType(DOUBLE);
    	}
    	public Type visit(EId p, Object o) {
    		return p.setType(lookupVar(p.id_));
    	}

    	// Function call
    	public Type visit(EApp p, Object o) {
    		//Check if function is defined
    		FunType ft = signature.get(p.id_);
    		if (ft == null) {
    			throw new TypeException("undefined function " + p.id_);
    		}

    		if (ft.args.size() != p.listexp_.size()) {
    			throw new TypeException("Function " + p.id_ + " does not have correct number of arguments");
    		}

    		int i = 0;
    		for (Exp e : p.listexp_) {
    			ADecl a = (ADecl)(ft.args.get(i));
    			check(a.type_, e.accept(new ExpVisitor(), null));
    			i++;
    		}
    		return p.setType(ft.retType);
    	}

    	// Arithmetics and comparison
    	public Type visit(EPostIncr p, Object o) {
    		return p.setType(isNumType(lookupVar(p.id_)));
    	}
    	public Type visit(EPostDecr p, Object o) {
    		return p.setType(isNumType(lookupVar(p.id_)));
    	}
    	public Type visit(EPreIncr p, Object o) {
    		return p.setType(isNumType(lookupVar(p.id_)));	
    	}
    	public Type visit(EPreDecr p, Object o) {
    		return p.setType(isNumType(lookupVar(p.id_)));
    	}
    	public Type visit(ETimes p, Object o) {
			return p.setType(isEqualTypes(isNumType(p.exp_1.accept(this, null)),
								isNumType(p.exp_2.accept(this, null))));
    	}
    	public Type visit(EDiv p, Object o) {
    		return p.setType(isEqualTypes(isNumType(p.exp_1.accept(this, null)),
								isNumType(p.exp_2.accept(this, null))));
    	}
    	public Type visit(EPlus p, Object o) {
    		return p.setType(isEqualTypes(isNumType(p.exp_1.accept(this, null)),
								isNumType(p.exp_2.accept(this, null))));
    	}
    	public Type visit(EMinus p, Object o) {
    		return p.setType(isEqualTypes(isNumType(p.exp_1.accept(this, null)),
								isNumType(p.exp_2.accept(this, null))));
    	}

    	public Type visit(ELt p, Object o) {
    		Type t1 = isNumType(p.exp_1.accept(this, null));
    		Type t2 = isNumType(p.exp_2.accept(this, null));

    		Type dummy = isEqualTypes(t1,t2);
    		return p.setType(BOOL);
    	}
    	public Type visit(EGt p, Object o) {
    		Type t1 = isNumType(p.exp_1.accept(this, null));
    		Type t2 = isNumType(p.exp_2.accept(this, null));

    		Type dummy = isEqualTypes(t1,t2);
    		return p.setType(BOOL);
    	}
    	public Type visit(ELtEq p, Object o) {
    		Type t1 = isNumType(p.exp_1.accept(this, null));
    		Type t2 = isNumType(p.exp_2.accept(this, null));

    		Type dummy = isEqualTypes(t1,t2);
    		return p.setType(BOOL);
    	}
    	public Type visit(EGtEq p, Object o) {
    		Type t1 = isNumType(p.exp_1.accept(this, null));
    		Type t2 = isNumType(p.exp_2.accept(this, null));

    		Type dummy = isEqualTypes(t1,t2);
    		return p.setType(BOOL);
    	}

    	// Equality/inequality
    	public Type visit(EEq p, Object o) {
    		Type t1 = p.exp_1.accept(this, null);
    		Type t2 = p.exp_2.accept(this, null);

    		if (!isEqualTypes(t1,t2).equals(VOID)) {
    			return p.setType(BOOL);
    		}
    		throw new TypeException("Equality cannot operate on void");
    	}
    	public Type visit(ENEq p, Object o) {
    		Type t1 = p.exp_1.accept(this, null);
    		Type t2 = p.exp_2.accept(this, null);

    		if (!isEqualTypes(t1,t2).equals(VOID)) {
    			return p.setType(BOOL);
    		}
    		throw new TypeException("Inequality cannot operate on void");
    	}

    	// Logic
    	public Type visit(EAnd p, Object o) {
    		Type t1 = p.exp_1.accept(this, null);
    		Type t2 = p.exp_2.accept(this, null);

    		check(BOOL,t1);
    		check(BOOL,t2);

    		return p.setType(isEqualTypes(t1,t2));
    	}
    	public Type visit(EOr p, Object o) {
    		Type t1 = p.exp_1.accept(this, null);
    		Type t2 = p.exp_2.accept(this, null);

    		check(BOOL,t1);
    		check(BOOL,t2);

    		return p.setType(isEqualTypes(t1,t2));
    	}

    	public Type visit(EAss p, Object o) {
    		// Check if variable is declared and same type as expression
    		Type t = isEqualTypes(lookupVar(p.id_), p.exp_.accept(this, null));

    		return p.setType(t);
    	}

    }

    // Add variable to context
    public void newVar(String id, Type ty) {
    	// Get top context block
    	Map<String,Type> m = contexts.get(0);

    	// Check if variable is already declared
    	if (m.containsKey(id)) {
    		throw new TypeException("var " + id + " is already declared in this scope");
    	}
    	m.put(id,ty);
    }

    // Add new top block to contexts
    public void newBlock() {
    	contexts.add(0, new HashMap());
    }

    // Remove top block from contexts
    public void popBlock() {
    	contexts.remove(0);
    }

    public Type lookupVar(String id) {
    	for (Map<String,Type> m : contexts) {
    		Type t = m.get(id);
    		if (t != null) {
    			return t;
    		}
    	}
    	throw new TypeException("unbound variable " + id);
    }

    public String isVar(Exp e) {
    	if (e instanceof EId) {
    		return ((EId)e).id_;
    	} else {
    		throw new TypeException("expected variable, found " + e);
    	}
    }

    public void check(Type t, Type u) {
    	if (!t.equals(u)) {
    		throw new TypeException("Expected type " + t + " but found type " + u);
    	}
    }

    public Type isNumType(Type t) {
    	if (!t.equals(INT) && !t.equals(DOUBLE)) {
    		throw new TypeException("expected expression of numeric type");
    	}
    	return t;
    }

    public Type isEqualTypes(Type t, Type u) {
    	if (!t.equals(u)) {
    		throw new TypeException("expected types " + t + " and " + u + " to be equal");
    	}
    	return t;
    }

}
