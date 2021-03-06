package CPP.Absyn; // Java Package generated by the BNF Converter.

public class EVar extends Exp {
  public final ListVar listvar_;
  public EVar(ListVar p1) { listvar_ = p1; }

  public <R,A> R accept(CPP.Absyn.Exp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.EVar) {
      CPP.Absyn.EVar x = (CPP.Absyn.EVar)o;
      return this.listvar_.equals(x.listvar_);
    }
    return false;
  }

  public int hashCode() {
    return this.listvar_.hashCode();
  }


}
