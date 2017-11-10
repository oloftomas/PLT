package CPP.Absyn; // Java Package generated by the BNF Converter.

public class Ttype1 extends Type {
  public final Type type_;
  public Ttype1(Type p1) { type_ = p1; }

  public <R,A> R accept(CPP.Absyn.Type.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.Ttype1) {
      CPP.Absyn.Ttype1 x = (CPP.Absyn.Ttype1)o;
      return this.type_.equals(x.type_);
    }
    return false;
  }

  public int hashCode() {
    return this.type_.hashCode();
  }


}
