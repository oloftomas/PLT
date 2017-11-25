import CPP.Absyn.*;

public class Interpreter {

	private Map<String,DFun> signature;
	private List<Map<String,Value>> env;

    public void interpret(Program p) {
    	p.accept(new ProgramVisitor(), null);
        //throw new RuntimeException("Not yet an interpreter");
    }

    public class ProgramVisitor implements Program.Visitor<Object,Object> {
    	public void visit(PDefs p, Object o) {
    		signature = new HashMap();

    		// Add definitions to signature
    		for (Def d : p.listdef_) {
    			d.accept(new DefVisitor(), null);
    		}

    		// Find main
    		DFun main = signature.get("main");
    		if (main == null) {
    			throw new RuntimeException("Impossible: main function missing");
    		}

    		// Execute function body
    		for (Stm s : main.liststm_) {
    			s.accept(new StmVisitor(), null);
    		}

    		return null;
    	}
    }

    public class DefVisitor implements Def.Visitor<Object,Object> {
    	public void visit(DFun p, Object o) {
    		// TODO
    	}
    }

    public class StmVisitor implements Stm.Visitor<Value,Object> {
    	public Value visit(SExp p, Object o) {
    		return null;
    	}
    	public Value visit(SDecls p, Object o) {
    		return null;	
    	}
    	public Value visit(SInit p, Object o) {
    		Value 
    		return null;
    	}
    	public Value visit(SReturn p, Object o) {
    		return null;
    	}
    	public Value visit(SWhile p, Object o) {
    		return null;
    	}
    	public Value visit(SBlock p, Object o) {
    		return null;
    	}
    	public Value visit(SIfElse p, Object o) {
    		return null;
    	}
    }

}
