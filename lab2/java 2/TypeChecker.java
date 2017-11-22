import CPP.Absyn.*;
import java.util.*;
import java.io.*;

public class TypeChecker {

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
		Env env = new Env();

		// build symbol table
		env.signature = p.accept(new ProgramVisitor(), null);


    }

    // Program visitor
    public class ProgramVisitor implements Program.Visitor<Map<String,FunType>,Object> {
    	public Map<String,FunType> visit(PDefs p, Object o) {
    		Map<String,FunType> sigMap = new HashMap<String,FunType>();
    		SigElement temp;
    		int i = 0;
    		for (Def x : p.listdef_) {
    			temp = x.accept(new DefVisitor(), null);
    			sigMap.put(temp.id, temp.funType);
    		}
    		return sigMap;
    	}
    }

    // Def visitor
    public class DefVisitor implements Def.Visitor<SigElement,Object> {
    	public SigElement visit(DFun p, Object o) {
    		
    		LinkedList<Type> argTypeList = new LinkedList<Type>();
    		for (Arg a : p.listarg_) {
    			argTypeList.push(a.accept(new ArgVisitor(), null));
    		}

    		// create FunType obj
    		FunType ft = new FunType(argTypeList, p.type_);

    		SigElement sigElem = new SigElement();
    		sigElem.id = p.id_;
    		sigElem.funType = ft;

    		return sigElem;
    	}
    }

    // Help class for (String,FunType) tuple
    public class SigElement {
    	public String id;
    	public FunType funType;
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
    /*
    public static TypeCode typeCode(Type ty) {
		if (ty.equals(new Type_int())) {
			return TypeCode.CInt;
		} else if (ty.equals(new Type_double())) {
			return TypeCode.CDouble;
		} else if (ty.equals(new Type_bool())) {
			return TypeCode.CBool;
		} else if (ty.equals(new Type_void())) {
			return TypeCode.CVoid;
		}
		return null;
	}
	*/

    // Function Type
    public static class FunType {
    	public LinkedList<Type> args;
    	public Type val;

    	FunType(LinkedList<Type> tlist, Type ty) {
    		args = tlist;
    		val = ty;
    	}

    }

    // Environment class
    // in pass 1 : Add ALL function defs to sig by using update meths
    // in pass 2 : use Env but remove contexts that are out of scope
    public static class Env {
    	public static Map<String, FunType> signature;
    	public static LinkedList<Map<String,Type>> contexts;

    	// Constructor
    	public Env() {

    	}

    	/* int main() { 
    		int x; 
    		if(1) {
    			bool x;
    			 
    		}
    	*/


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

    // TypeCode for type comparisson
    public static enum TypeCode { CInt, CDouble, CBool, CVoid }

}
