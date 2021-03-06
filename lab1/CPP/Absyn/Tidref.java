package CPP.Absyn; // Java Package generated by the BNF Converter.

public class Tidref extends Type {
  public final ListId listid_;
  public Tidref(ListId p1) { listid_ = p1; }

  public <R,A> R accept(CPP.Absyn.Type.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.Tidref) {
      CPP.Absyn.Tidref x = (CPP.Absyn.Tidref)o;
      return this.listid_.equals(x.listid_);
    }
    return false;
  }

  public int hashCode() {
    return this.listid_.hashCode();
  }


}
