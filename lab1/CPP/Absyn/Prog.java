package CPP.Absyn; // Java Package generated by the BNF Converter.

public class Prog extends Program {
  public final ListDef listdef_;
  public Prog(ListDef p1) { listdef_ = p1; }

  public <R,A> R accept(CPP.Absyn.Program.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.Prog) {
      CPP.Absyn.Prog x = (CPP.Absyn.Prog)o;
      return this.listdef_.equals(x.listdef_);
    }
    return false;
  }

  public int hashCode() {
    return this.listdef_.hashCode();
  }


}
