import java.util.*;
import Fun.Absyn.*;

public class Interpreter {

    // Signature
    final Map<String,Exp> sig = new HashMap();

    // Strategy, CBV or CBN
    final boolean strategy;

    // Ctrl debug printing
    final boolean debug = false;

    public Interpreter (boolean strategy) {
        this.strategy = strategy;
    }

    public void interpret (Program p) {
        System.out.println(p.accept(new ProgramVisitor(), null).intValue());
    }

    public class ProgramVisitor implements Program.Visitor<Value,Object> {
        public Value visit (Prog p, Object o) {
            // build signature
            for (Def d : p.listdef_) {
                d.accept(new DefVisitor(), null);
            }
            // execute main
            return p.main_.accept(new MainVisitor(), null);
        }
    }

    public class MainVisitor implements Main.Visitor<Value,Object> {
        public Value visit (DMain p, Object o) {
            if (debug) {
                for (String key : sig.keySet()) {
                    System.out.println("Check: Found key " + key + " in the signature");
                }
                System.out.println("Evaluating main expression: " + 
                    Fun.PrettyPrinter.print(p.exp_));
            }
            return p.exp_.accept(new EvalVisitor(), new Empty());
        }
    }

    public class DefVisitor implements Def.Visitor<Object,Object> {
        public Object visit (DDef p, Object o) {
            // Abstract over args, right to left
            Exp e = p.exp_;

            Collections.reverse(p.listident_);
            for (String s : p.listident_) {
                e = new EAbs(s, e);
            }

            // Add to signature
            sig.put(p.ident_, e);

            if (debug) {
                if (sig.get(p.ident_) != null) {
                    System.out.println("Added " + p.ident_ + " to the signature");
                } else {
                    System.out.println("Failed to add " + p.ident_ + " to the signature");
                }
            }
            return null;
        }
    }

    public class EvalVisitor implements Exp.Visitor<Value,Environment> {
        public Value visit (EVar p, Environment env) {
            if (debug) {
                for (String key : sig.keySet()) {
                    System.out.println("EVar: Found key " + key + " in the signature");
                }
                System.out.println("Resolving variable " + p.ident_);
            }

            // Look first in local environment
            Value v = env.lookup(p.ident_);
            if (v != null) {
                if (debug) {
                    System.out.println("Found " + p.ident_ + " in the environment");
                }
                return v;
            }

            // Look then in the global signature
            if (debug) {
                if (sig.isEmpty()) {
                    System.out.println("Signature is empty!");
                } else {
                    System.out.println("Signature is not empty!");
                }
                for (String key : sig.keySet()) {
                    System.out.println("Found key " + key + " in the signature");
                }
            }

            Exp e = sig.get(p.ident_);
            if (e != null) {
                if (debug) {
                    System.out.println("Found " + p.ident_ + " in the signature");
                }
                return e.accept(this, new Empty());
            } else {
            // not found?
                throw new RuntimeException("unbound variable " + p.ident_);
            }

        }
        public Value visit (EInt p, Environment env) {
            return new VInt(p.integer_);
        }

        public Value visit (EApp p, Environment env) {
            if (debug) {
                for (String key : sig.keySet()) {
                    System.out.println("EApp: Found key " + key + " in the signature");
                }
            }
            if (strategy) {
                todo("call-by-name");
            }

            // Evaluate function
            Value vFun = p.exp_1.accept(this, env);
            // Evaluate argument
            Value vArg = p.exp_2.accept(this, env);
            
            return vFun.apply(vArg);
        }

        public Value visit (EAdd p, Environment env) {
            if (strategy) {
                todo("eadd call-by-name");
            }

            Value v1 = p.exp_1.accept(this, env);
            Value v2 = p.exp_2.accept(this, env);
            return new VInt(v1.intValue() + v2.intValue());
        }
        public Value visit (ESub p, Environment env) {
            if (strategy) {
                todo("esub call-by-name");
            }

            Value v1 = p.exp_1.accept(this, env);
            Value v2 = p.exp_2.accept(this, env);
            return new VInt(v1.intValue() - v2.intValue());
        }
        public Value visit (ELt p, Environment env) {
            if (strategy) {
                todo("less-than call-by-name");
            }
            Value v1 = p.exp_1.accept(this, env);
            Value v2 = p.exp_2.accept(this, env);
            if (v1.intValue() < v2.intValue()) {
                return new VInt(1);
            }
            return new VInt(0);
        }

        public Value visit (EIf p, Environment env) {
            if (debug) {
                System.out.println("In if, evaluating condition");
            }
            Value vCon = p.exp_1.accept(this, env);
            if (vCon.intValue() == 0) {
                Value vElse = p.exp_3.accept(this, env);
                return vElse;
            }
            Value vIf = p.exp_2.accept(this, env);
            return vIf;
        }

        public Value visit (EAbs p, Environment env) {
            return new VClos(p.ident_, p.exp_, env);
        }
    }

    // TODOs
    public void todo (String msg) {
        throw new RuntimeException("TODO: " + msg);
    }

    // Value 

    abstract class Value {
        abstract public int intValue();
        abstract public Value apply(Value v);
    }

    // Numeric values
    class VInt extends Value {
        final int val;

        public VInt (int i) {
            val = i;
        }

        public int intValue() {
            return val;
        }

        public Value apply (Value v) {
            throw new RuntimeException("Cannot apply a number");
        }
    }

    // Function values

    class VClos extends Value {
        final String s;
        final Exp body;
        final Environment env;

        public VClos (String s, Exp body, Environment env) {
            this.s = s;
            this.body = body;
            this.env = env;
        }

        public int intValue() {
            throw new RuntimeException("not an integer");
        }

        public Value apply (Value v) {
            return body.accept(new EvalVisitor(), new Extend(s,v,env));
            // TODO add x=v to env
        }
        // TODO: call by name
    }

    // Environment

    abstract class Environment {
        abstract Value lookup (String s);
    }

    class Empty extends Environment {
        Value lookup (String s) {
            return null;
        }
    }

    class Extend extends Environment {
        final String s;
        final Value v;              // TODO: call by name
        final Environment rest;

        public Extend (String s, Value v, Environment rest) {
            if (debug) {
                System.out.println("Extend env: Adding " + s);
            }
            this.s = s;
            this.v = v;
            this.rest = rest;
        }

        Value lookup (String t) {
            if (s.equals(t)) {
                return v;
            } else {
                return rest.lookup(t);
            }
            // TODO: call by name
        }
    }

}

