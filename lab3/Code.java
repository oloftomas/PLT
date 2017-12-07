// Code.java
// Created by github.com/andreasabel/java-adt

import CPP.Absyn.*;

class Fun {
    public String id;
    public FunType funType;
    public Fun (String id, FunType funType) {
        this.id = id;
        this.funType = funType;
    }
    public String toJVM() {
      return id + funType.toJVM();
    }
}

// TEST this extends Code
class Label extends Code {
    public int label;
    public Label (int label) {
        this.label = label;
    }
    /*
    public String toJVM() {
      return "L" + label;
    }
    */
    public <R> R accept(CodeVisitor<R> v) {
        return v.visit(this);
    }
}

abstract class Code {
    public abstract <R> R accept (CodeVisitor<R> v);
}

class Comment extends Code {
  public String comment;
  public Comment (String c) { comment = c; }
  public <R> R accept (CodeVisitor<R> v) {
    return v.visit(this);
  }
}

class Store extends Code {
    public Type type;
    public Integer addr;
    public Store (Type type, Integer addr) {
        this.type = type;
        this.addr = addr;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class Load extends Code {
    public Type type;
    public Integer addr;
    public Load (Type type, Integer addr) {
        this.type = type;
        this.addr = addr;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class IConst extends Code {
    public Integer immed;
    public IConst (Integer immed) {
        this.immed = immed;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class Dup extends Code {
    public Type type;
    public Dup (Type type) {
        this.type = type;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class Pop extends Code {
    public Type type;
    public Pop (Type type) {
        this.type = type;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class Return extends Code {
    public Type type;
    public Return (Type type) {
        this.type = type;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class Call extends Code {
    public Fun fun;
    public Call (Fun fun) {
        this.fun = fun;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class Add extends Code {
    public Type type;
    public Add (Type type) {
        this.type = type;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class Sub extends Code {
    public Type type;
    public Sub (Type type) {
        this.type = type;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class Mul extends Code {
    public Type type;
    public Mul (Type type) {
        this.type = type;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class Div extends Code {
    public Type type;
    public Div (Type type) {
        this.type = type;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class IfLt extends Code {
    public Type type;
    public Label label;
    public IfLt (Type type, Label label) {
        this.type = type;
        this.label = label;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class IfGt extends Code {
    public Type type;
    public Label label;
    public IfGt (Type type, Label label) {
        this.type = type;
        this.label = label;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class IfLtEq extends Code {
    public Type type;
    public Label label;
    public IfLtEq (Type type, Label label) {
        this.type = type;
        this.label = label;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class IfGtEq extends Code {
    public Type type;
    public Label label;
    public IfGtEq (Type type, Label label) {
        this.type = type;
        this.label = label;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class IfEq extends Code {
    public Type type;
    public Label label;
    public IfEq (Type type, Label label) {
        this.type = type;
        this.label = label;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class IfNEq extends Code {
    public Type type;
    public Label label;
    public IfNEq (Type type, Label label) {
        this.type = type;
        this.label = label;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class IfZ extends Code {
    public Type type;
    public Label label;
    public IfZ (Type type, Label label) {
        this.type = type;
        this.label = label;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class IfNZ extends Code {
    public Type type;
    public Label label;
    public IfNZ (Type type, Label label) {
        this.type = type;
        this.label = label;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit (this);
    }
}

class And extends Code {
    public And () {}
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit(this);
    }
}

class Or extends Code {
    public Or () {}
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit(this);
    }
}

class Goto extends Code {
    public Label label;
    public Goto(Label label) {
        this.label = label;
    }
    public <R> R accept (CodeVisitor<R> v) {
        return v.visit(this);
    }
}

interface CodeVisitor<R> {
    public R visit (Label c);
    public R visit (Comment c);
    public R visit (Store c);
    public R visit (Load c);
    public R visit (IConst c);
    public R visit (Dup c);
    public R visit (Pop c);
    public R visit (Return c);
    public R visit (Call c);
    public R visit (Add c);
    public R visit (Sub c);
    public R visit (Mul c);
    public R visit (Div c);
    public R visit (IfLt c);
    public R visit (IfGt c);
    public R visit (IfLtEq c);
    public R visit (IfGtEq c);
    public R visit (IfEq c);
    public R visit (IfNEq c);
    public R visit (IfZ c);
    public R visit (IfNZ c);
    public R visit (And c);
    public R visit (Or c);
    public R visit (Goto c);
}

class CodeToJVM implements CodeVisitor<String> {

  public String visit (Label c) {
    return "L" + c.label + ":\n";
  }

  public String visit (Comment c) {
    return "\n  ;; " + c.comment;
  }

  public String visit (Store c) {
    String prefix = (c.type instanceof Type_double) ? "d" : "i";
    int a = c.addr;
    String separator = (a <= 3) ? "_" : " ";
    return prefix + "store" + separator + a + "\n";
  }

  public String visit (Load c) {
    String prefix = (c.type instanceof Type_double) ? "d" : "i";
    int a = c.addr;
    String separator = (a <= 3) ? "_" : " ";
    return prefix + "load" + separator + a + "\n";
  }

  public String visit (IConst c) {
    int i = c.immed.intValue();
    if (i == -1) return "iconst_m1\n";
    if (i >= 0 && i <= 5) return "iconst_" + i + "\n";
    if (i >= -128 && i < 128) return "bipush " + i + "\n";
    return "ldc " + c.immed.toString() + "\n";
  }

  public String visit (Dup c) {
    if (c.type instanceof Type_void) return "";
    else if (c.type instanceof Type_double) return "dup2\n";
    else return "dup\n";
  }

  public String visit (Pop c) {
    if (c.type instanceof Type_void) return "";
    else if (c.type instanceof Type_double) return "pop2\n";
    else return "pop\n";
  }

  public String visit (Return c) {
    if (c.type instanceof Type_void) return "return\n";
    else if (c.type instanceof Type_double) return "dreturn\n";
    else return "ireturn\n";
  }

  public String visit (Call c) {
    return "invokestatic " + c.fun.toJVM() + "\n";
  }

  public String visit (Add c) {
    return (c.type instanceof Type_double ? "d" : "i") + "add\n";
  }

  public String visit (Sub c) {
    return (c.type instanceof Type_double ? "d" : "i") + "sub\n";
  }

  public String visit (Mul c) {
    return (c.type instanceof Type_double ? "d" : "i") + "mul\n";
  }

  public String visit (Div c) {
    return (c.type instanceof Type_double ? "d" : "i") + "div\n";
  }

  public String visit (IfLt c) {
    // TODO for doubles
    return "if_icmplt " + "L" + c.label.label + "\n";
  }

  public String visit (IfGt c) {
    // TODO for doubles
    return "if_icmpgt " + "L" + c.label.label + "\n";
  }

  public String visit (IfLtEq c) {
    // TODO for doubles
    return "if_icmple " + "L" + c.label.label + "\n";
  }

  public String visit (IfGtEq c) {
    // TODO for doubles
    return "if_icmpge " + "L" + c.label.label + "\n";
  }

  public String visit (IfEq c) {
    // TODO for doubles
    return "if_icmpeq " + "L" + c.label.label + "\n";
  }

  public String visit (IfNEq c) {
    // TODO for doubles
    return "if_icmpne " + "L" + c.label.label + "\n";
  }

  public String visit (IfZ c) {
    return "ifeq " + "L" + c.label.label + "\n";
  }

  public String visit (IfNZ c) {
    return "ifne " + "L" + c.label.label + "\n";
  }

  public String visit (And c) {
    return ("iand\n");
  }

  public String visit (Or c) {
    return ("ior\n");
  }

  public String visit (Goto c) {
    return "goto L" + c.label.label + "\n";
  }

}
