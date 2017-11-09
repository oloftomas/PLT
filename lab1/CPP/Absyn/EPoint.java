package CPP.Absyn; // Java Package generated by the BNF Converter.

public class EPoint extends Exp {
  public final Exp exp_;
  public final String id_;
  public EPoint(Exp p1, String p2) { exp_ = p1; id_ = p2; }

  public <R,A> R accept(CPP.Absyn.Exp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.EPoint) {
      CPP.Absyn.EPoint x = (CPP.Absyn.EPoint)o;
      return this.exp_.equals(x.exp_) && this.id_.equals(x.id_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.exp_.hashCode())+this.id_.hashCode();
  }


}
