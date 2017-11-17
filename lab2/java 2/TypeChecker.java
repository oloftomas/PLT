import CPP.Absyn.*;

public class TypeChecker {

    public void typecheck(Program p) {
        // INSERT SMART STUFF HERE
    }

    public static class CheckStm implements Stm.Visitor<Env,Env> {
    	public Env visit(SDecl p, Env env) {
    		env.updateVar(p.id_, p.type_);
    		return env;
    	}

    	public Env visit(SExp p, Env env) {
    		InferExp(s.exp_, env);
    		return env;
    	}
    }

    public static class InferExp implements Exp.Visitor<Type,Env> {
    	public Type visit(EInt p, Env env) {

    	}

    	public Type visit(EDouble p, Env env) {

    	}
    }




    public static class FunType {
    	public LinkedList<Type> args;
    	public Type val;
    }

    public static class Env {
    	public HashMap<String, FunType> signature;
    	public LinkedList<Map<String,Type>> contexts;

    	public static Type lookVar(String id) {
    		 
    	}

    	public static FunType lookFun(String id) {

    	}

    	public static void updateVar(String id, Type ty) {

    	}

    	public static void updateFun(String id, Type ty) {

    	}
    }

    public static enum TypeCode { CInt, CDouble, CBool, CVoid }

}
