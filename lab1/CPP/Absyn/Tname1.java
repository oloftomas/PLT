package CPP.Absyn; // Java Package generated by the BNF Converter.

public class Tname1 extends TypeN {
  public final String id_;
  public Tname1(String p1) { id_ = p1; }

  public <R,A> R accept(CPP.Absyn.TypeN.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.Tname1) {
      CPP.Absyn.Tname1 x = (CPP.Absyn.Tname1)o;
      return this.id_.equals(x.id_);
    }
    return false;
  }

  public int hashCode() {
    return this.id_.hashCode();
  }


}