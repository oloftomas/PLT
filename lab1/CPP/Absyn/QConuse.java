package CPP.Absyn; // Java Package generated by the BNF Converter.

public class QConuse extends Def {
  public final ListId listid_;
  public QConuse(ListId p1) { listid_ = p1; }

  public <R,A> R accept(CPP.Absyn.Def.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.QConuse) {
      CPP.Absyn.QConuse x = (CPP.Absyn.QConuse)o;
      return this.listid_.equals(x.listid_);
    }
    return false;
  }

  public int hashCode() {
    return this.listid_.hashCode();
  }


}
