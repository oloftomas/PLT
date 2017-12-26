import CPP.Absyn.*;
import java.util.*;

public class Interpreter {

	private Map<String,DFun> signature;
	private List<Map<String,Value>> env;

    Scanner scan = new Scanner(System.in);

    public void interpret(Program p) {
    	p.accept(new ProgramVisitor(), null);
    }

    public class ProgramVisitor implements Program.Visitor<Object,Object> {
    	public Object visit(PDefs p, Object o) {
    		signature = new HashMap();

    		// Add definitions to signature
    		for (Def d : p.listdef_) {
    			d.accept(new DefToSigVisitor(), null);
    		}

    		// Find main
    		DFun main = signature.get("main");
    		if (main == null) {
    			throw new RuntimeException("Impossible: main function missing");
    		}

    		// Add main block to env
    		env = new LinkedList();
    		env.add(new HashMap());

    		// Execute function body
    		for (Stm s : main.liststm_) {
                try {
                    s.accept(new StmVisitor(), null);
                } catch (ReturnException r) {
                    return null;
                }
    		}

    		return null;
    	}
    }

    public class DefToSigVisitor implements Def.Visitor<Object,Object> {
    	public Object visit(DFun p, Object o) {
    		signature.put(p.id_, p);
    		return null;
    	}
    }

    public class DefVisitor implements Def.Visitor<Object,Object> {
    	public Object visit(DFun p, Object o) {
    		return null;
    	}
    }

    public class ArgVisitor implements Arg.Visitor<Object,Object> {
    	public Object visit(ADecl p, Object o) {
    		newVar(p.id_, null);
    		return null;
    	}
    }

    public class StmVisitor implements Stm.Visitor<Value,Object> {
    	public Value visit(SExp p, Object o) {
    		p.exp_.accept(new ExpVisitor(), null);
    		return null;
    	}
    	public Value visit(SDecls p, Object o) {
    		for (String s : p.listid_) {
    			newVar(s, null);
    		}
    		return null;	
    	}
    	public Value visit(SInit p, Object o) {
    		// Add new variable with value to env
    		Value v = p.exp_.accept(new ExpVisitor(), null);
    		newVar(p.id_, v);
    		return null;
    	}
    	public Value visit(SReturn p, Object o) {
    		Value v = p.exp_.accept(new ExpVisitor(), null);
    		popBlock();
    		throw new ReturnException(v);
    	}
    	public Value visit(SWhile p, Object o) {
    		Value v;
    		while (((VBool)p.exp_.accept(new ExpVisitor(), null)).value) {
                newBlock();
    			v = p.stm_.accept(new StmVisitor(), null);
                popBlock();
    		}
    		return null;
    	}
    	public Value visit(SBlock p, Object o) {
    		newBlock();
    		for (Stm s : p.liststm_) {
    			s.accept(new StmVisitor(), null);
    		}
    		popBlock();
    		return null;
    	}
    	public Value visit(SIfElse p, Object o) {
    		Value v;
    		if (((VBool)p.exp_.accept(new ExpVisitor(), null)).value) {
    			newBlock();
    			v = p.stm_1.accept(new StmVisitor(), null);
    			popBlock();
    		} else {
    			newBlock();
    			v = p.stm_2.accept(new StmVisitor(), null);
    			popBlock();
    		}
    		return null;
    	}
    }

    public class ExpVisitor implements Exp.Visitor<Value,Object> {
    	public Value visit(ETrue p, Object o) {
    		return new VBool(true);
    	}
    	public Value visit(EFalse p, Object o) {
    		return new VBool(false);
    	}
    	public Value visit(EInt p, Object o) {
    		return new VInt(p.integer_);
    	}
    	public Value visit(EDouble p, Object o) {
    		return new VDouble(p.double_);
    	}
    	public Value visit(EId p, Object o) {
    		return lookupVar(p.id_);
    	}

    	public Value visit(EApp p, Object o) {
    		// Primitive functions
    		if (p.id_.equals("printInt")) {
    			newBlock();
    			Value v = p.listexp_.get(0).accept(new ExpVisitor(), null);
    			System.out.println(((VInt)v).value);
    			popBlock();
    			return null;
    		}
    		if (p.id_.equals("printDouble")) {
    			newBlock();
    			Value v = p.listexp_.get(0).accept(new ExpVisitor(), null);
    			System.out.println(((VDouble)v).value);
    			popBlock();
    			return null;
    		}
    		if (p.id_.equals("readInt")) {
    			newBlock();
    			int r = scan.nextInt();
    			popBlock();
    			return new VInt(r);
    		}
    		if (p.id_.equals("readDouble")) {
    			newBlock();
    			double r = scan.nextDouble();
    			popBlock();
    			return new VDouble(r);
    		}

    		// Get called function from signature
    		DFun f = signature.get(p.id_);

    		List<Value> paramEvals = new LinkedList<Value>();
    		for (Exp e : p.listexp_) {
    			paramEvals.add(e.accept(new ExpVisitor(), null));
    		}

    		newBlock();

    		// add argument id:s to env
    		int i = 0;
    		for (Arg a : f.listarg_) {
    			a.accept(new ArgVisitor(), null);
    			updateVar(((ADecl)a).id_, paramEvals.get(i));
    			i++;
    		}

    		newBlock();
    		try {
    			for (Stm s : f.liststm_) {
    				s.accept(new StmVisitor(), null);
    			}
    		} catch (ReturnException r) {
    			popBlock();
    			return r.retVal;
    		}
            popBlock();
    		popBlock();
    		return null;    		
    	}

    	public Value visit(EPostIncr p, Object o) {
    		Value v1 = lookupVar(p.id_);
    		Value v2;
    		if (v1 instanceof VInt) {
    			v2 = new VInt(((VInt)v1).value + 1);
    		} else {
    			v2 = new VDouble(((VDouble)v1).value + 1.0);
    		}
    		updateVar(p.id_, v2);
    		return v1;    		
    	}
    	public Value visit(EPostDecr p, Object o) {
    		Value v1 = lookupVar(p.id_);
    		Value v2;
    		if (v1 instanceof VInt) {
    			v2 = new VInt(((VInt)v1).value - 1);
    		} else {
    			v2 = new VDouble(((VDouble)v1).value - 1.0);
    		}
    		updateVar(p.id_, v2);
    		return v1;  
    	}
    	public Value visit(EPreIncr p, Object o) {
    		Value v1 = lookupVar(p.id_);
    		Value v2;
    		if (v1 instanceof VInt) {
    			v2 = new VInt(((VInt)v1).value + 1);
    		} else {
    			v2 = new VDouble(((VDouble)v1).value + 1.0);
    		}
    		updateVar(p.id_, v2);
    		return v2; 
    	}
    	public Value visit(EPreDecr p, Object o) {
    		Value v1 = lookupVar(p.id_);
    		Value v2;
    		if (v1 instanceof VInt) {
    			v2 = new VInt(((VInt)v1).value - 1);
    		} else {
    			v2 = new VDouble(((VDouble)v1).value - 1.0);
    		}
    		updateVar(p.id_, v2);
    		return v2;     		
    	}

    	public Value visit(ETimes p, Object o) {
    		Value v1 = p.exp_1.accept(this, null);
    		Value v2 = p.exp_2.accept(this, null);
    		Value r;

    		if (v1 instanceof VInt) {
    			r = new VInt(((VInt)v1).value * ((VInt)v2).value);
    		} else {
    			r = new VDouble(((VDouble)v1).value * ((VDouble)v2).value);
    		}
    		return r;
    	}
    	public Value visit(EDiv p, Object o) {
    		Value v1 = p.exp_1.accept(this, null);
    		Value v2 = p.exp_2.accept(this, null);
    		Value r;

    		if (v1 instanceof VInt) {
    			r = new VInt(((VInt)v1).value / ((VInt)v2).value);
    		} else {
    			r = new VDouble(((VDouble)v1).value / ((VDouble)v2).value);
    		}
    		return r;
    	}
    	public Value visit(EPlus p, Object o) {
    		Value v1 = p.exp_1.accept(this, null);
    		Value v2 = p.exp_2.accept(this, null);
    		Value r;

    		if (v1 instanceof VInt) {
    			r = new VInt(((VInt)v1).value + ((VInt)v2).value);
    		} else {
    			r = new VDouble(((VDouble)v1).value + ((VDouble)v2).value);
    		}
    		return r;
    	}
    	public Value visit(EMinus p, Object o) {
    		Value v1 = p.exp_1.accept(this, null);
    		Value v2 = p.exp_2.accept(this, null);
    		Value r;

    		if (v1 instanceof VInt) {
    			r = new VInt(((VInt)v1).value - ((VInt)v2).value);
    		} else {
    			r = new VDouble(((VDouble)v1).value - ((VDouble)v2).value);
    		}
    		return r;
    	}

    	public Value visit(ELt p, Object o) {
    		Value v1 = p.exp_1.accept(this, null);
    		Value v2 = p.exp_2.accept(this, null);

    		if (v1 instanceof VInt) {
    			if (((VInt)v1).value < ((VInt)v2).value) {
    				return new VBool(true);
    			} else {
    				return new VBool(false);
    			}
    		} else {
    			if (((VDouble)v1).value < ((VDouble)v2).value) {
    				return new VBool(true);
    			} else {
    				return new VBool(false);
    			}
    		}
    	}
    	public Value visit(EGt p, Object o) {
    		Value v1 = p.exp_1.accept(this, null);
    		Value v2 = p.exp_2.accept(this, null);

    		if (v1 instanceof VInt) {
    			if (((VInt)v1).value > ((VInt)v2).value) {
    				return new VBool(true);
    			} else {
    				return new VBool(false);
    			}
    		} else {
    			if (((VDouble)v1).value > ((VDouble)v2).value) {
    				return new VBool(true);
    			} else {
    				return new VBool(false);
    			}
    		}
    	}
    	public Value visit(ELtEq p, Object o) {
    		Value v1 = p.exp_1.accept(this, null);
    		Value v2 = p.exp_2.accept(this, null);

    		if (v1 instanceof VInt) {
    			if (((VInt)v1).value <= ((VInt)v2).value) {
    				return new VBool(true);
    			} else {
    				return new VBool(false);
    			}
    		} else {
    			if (((VDouble)v1).value <= ((VDouble)v2).value) {
    				return new VBool(true);
    			} else {
    				return new VBool(false);
    			}
    		}
    	}
    	public Value visit(EGtEq p, Object o) {
    		Value v1 = p.exp_1.accept(this, null);
    		Value v2 = p.exp_2.accept(this, null);

    		if (v1 instanceof VInt) {
    			if (((VInt)v1).value >= ((VInt)v2).value) {
    				return new VBool(true);
    			} else {
    				return new VBool(false);
    			}
    		} else {
    			if (((VDouble)v1).value >= ((VDouble)v2).value) {
    				return new VBool(true);
    			} else {
    				return new VBool(false);
    			}
    		}
    	}

    	public Value visit(EEq p, Object o) {
    		Value v1 = p.exp_1.accept(new ExpVisitor(), null);
    		Value v2 = p.exp_2.accept(new ExpVisitor(), null);

    		if (v1 instanceof VInt) {
    			if (((VInt)v1).value.equals(((VInt)v2).value)) {
    				return new VBool(true);
    			}
    		} else if (v1 instanceof VDouble) {
    			if (((VDouble)v1).value.equals(((VDouble)v2).value)) {
    				return new VBool(true);
    			}
    		} else if (v1 instanceof VBool) {
    			if (((VBool)v1).value == ((VBool)v2).value) {
    				return new VBool(true);
    			}
    		}
    		return new VBool(false);		
    	}
    	public Value visit(ENEq p, Object o) {
    		Value v1 = p.exp_1.accept(this, null);
    		Value v2 = p.exp_2.accept(this, null);

    		if (v1 instanceof VInt) {
    			if (!((VInt)v1).value.equals(((VInt)v2).value)) {
    				return new VBool(true);
    			}
    		} else if (v1 instanceof VDouble) {
    			if (!((VDouble)v1).value.equals(((VDouble)v2).value)) {
    				return new VBool(true);
    			}
    		} else if (v1 instanceof VBool) {
    			if (((VBool)v1).value != ((VBool)v2).value) {
    				return new VBool(true);
    			}
    		}
    		return new VBool(false);
    	}

    	public Value visit(EAnd p, Object o) {
    		if (!(((VBool)p.exp_1.accept(this, null)).value)) {
    			return new VBool(false);
    		} else if (!(((VBool)p.exp_2.accept(this, null)).value)) {
    			return new VBool(false);
    		}
    		return new VBool(true);
    	}
    	public Value visit(EOr p, Object o) {
    		if (((VBool)p.exp_1.accept(this, null)).value) {
    			return new VBool(true);
    		} else if 	(((VBool)p.exp_2.accept(this, null)).value) {
    			return new VBool(true);
    		}
    		return new VBool(false);
    	}

    	public Value visit(EAss p, Object o) {
    		Value v = p.exp_.accept(this, null);
    		updateVar(p.id_, v);
    		return v;    		
    	}
    }

    // Add variable to env
    public void newVar(String id, Value v) {
    	// Get top env block
    	Map<String,Value> m = env.get(0);
    		// Add variable and value to top env block
    		m.put(id,v);
    }

    // Add new block to env
    public void newBlock() {
    	env.add(0, new HashMap());
    }

    // Remove top block from env
    public void popBlock() {
    	env.remove(0);
    }

    public Value lookupVar(String id) {
    	for (Map<String,Value> m : env) {
    		if (m.containsKey(id)) {
    			Value v = m.get(id);
    			if (v != null) {
    				return v;
    			}
    		}
    	}
    	throw new RuntimeException("uninitialized variable " + id);
    }

    public void updateVar(String id, Value v) {
    	for (Map<String,Value> m : env) {
    		if (m.containsKey(id)) {
    			m.replace(id, v);
    			return;
    		}
    	}
    	throw new RuntimeException("Internal ERROR: variable " + id + " not found");
    }

}
