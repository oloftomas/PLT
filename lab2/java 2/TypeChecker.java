import CPP.Absyn.*;
import java.util.*;
import java.io.*;

public class TypeChecker {

    public void typecheck(Program p) {
        /*	

        	PASS 1
			
			foreach in p
				add all functions to signature list:
					implement program visitor
					and def visitor


			PASS 2
			implement ALL visitors down to Exp
			do checkerino
        */
		Env env = new Env();

    }

    // Program visitor, dont know about <Def,Env>
    public class ProgramVisitor implements Program.Visitor<Def,Env> {
    	public Def visit(PDefs p, Env env) {
    		for (Def x : p.listdef_) {

    		}
    		return null;
    	}
    }

    // Def visitor, dont know about <Env,Env>
    public class DefVisitor implements Def.Visitor<Env,Env> {
    	// create FunType objs
    	public Env visit(DFun p, Env env) {
    		p.type_.accept(new TypeVisitor<TypeCode,Type>(), env);

    		
    	}
    }

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
    		return TypeCode.CBool;
    	}

    	public TypeCode visit(Type_int p, Type ty) {
    		return TypeCode.CInt;
    	}

    	public TypeCode visit(Type_double p, Type ty) {
    		return TypeCode.CDouble;
    	}

    	public TypeCode visit(Type_void p, Type ty) {
    		return TypeCode.CVoid;
    	}    	
    }
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
    // WHEN CREATED?
    public static class FunType {
    	public LinkedList<Type> args;
    	public Type val;

    	FunType() {

    	}

    }

    // Environment class
    // in pass 1 : Add ALL function defs to sig by using update meths
    // in pass 2 : use Env but remove contexts that are out of scope
    public static class Env {
    	public Map<String, FunType> signature;
    	public LinkedList<Map<String,Type>> contexts;

    	// Constructor
    	public Env() {
    		signature.clear();
    		contexts.clear();
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
