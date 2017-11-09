package CPP.Absyn; // Java Package generated by the BNF Converter.

public class ECall extends Exp {
  public final Exp exp_;
  public final ListExp listexp_;
  public ECall(Exp p1, ListExp p2) { exp_ = p1; listexp_ = p2; }

  public <R,A> R accept(CPP.Absyn.Exp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.ECall) {
      CPP.Absyn.ECall x = (CPP.Absyn.ECall)o;
      return this.exp_.equals(x.exp_) && this.listexp_.equals(x.listexp_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.exp_.hashCode())+this.listexp_.hashCode();
  }


}
