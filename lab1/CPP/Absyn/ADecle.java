package CPP.Absyn; // Java Package generated by the BNF Converter.

public class ADecle extends Arg {
  public final Type type_;
  public ADecle(Type p1) { type_ = p1; }

  public <R,A> R accept(CPP.Absyn.Arg.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.ADecle) {
      CPP.Absyn.ADecle x = (CPP.Absyn.ADecle)o;
      return this.type_.equals(x.type_);
    }
    return false;
  }

  public int hashCode() {
    return this.type_.hashCode();
  }


}
