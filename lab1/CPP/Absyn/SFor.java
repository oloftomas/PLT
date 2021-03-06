package CPP.Absyn; // Java Package generated by the BNF Converter.

public class SFor extends Stm {
  public final Arg arg_;
  public final Exp exp_1, exp_2;
  public final Stm stm_;
  public SFor(Arg p1, Exp p2, Exp p3, Stm p4) { arg_ = p1; exp_1 = p2; exp_2 = p3; stm_ = p4; }

  public <R,A> R accept(CPP.Absyn.Stm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.SFor) {
      CPP.Absyn.SFor x = (CPP.Absyn.SFor)o;
      return this.arg_.equals(x.arg_) && this.exp_1.equals(x.exp_1) && this.exp_2.equals(x.exp_2) && this.stm_.equals(x.stm_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(37*(this.arg_.hashCode())+this.exp_1.hashCode())+this.exp_2.hashCode())+this.stm_.hashCode();
  }


}
