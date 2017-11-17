package CPP.Absyn; // Java Package generated by the BNF Converter.

public class SInits extends Stm {
  public final Type type_;
  public final String id_;
  public final Exp exp_1, exp_2;
  public final ListId listid_;
  public SInits(Type p1, String p2, Exp p3, ListId p4, Exp p5) { type_ = p1; id_ = p2; exp_1 = p3; listid_ = p4; exp_2 = p5; }

  public <R,A> R accept(CPP.Absyn.Stm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.SInits) {
      CPP.Absyn.SInits x = (CPP.Absyn.SInits)o;
      return this.type_.equals(x.type_) && this.id_.equals(x.id_) && this.exp_1.equals(x.exp_1) && this.listid_.equals(x.listid_) && this.exp_2.equals(x.exp_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(37*(37*(this.type_.hashCode())+this.id_.hashCode())+this.exp_1.hashCode())+this.listid_.hashCode())+this.exp_2.hashCode();
  }


}
