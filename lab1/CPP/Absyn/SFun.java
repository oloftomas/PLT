package CPP.Absyn; // Java Package generated by the BNF Converter.

public class SFun extends Stm {
  public final Type type_;
  public final String id_;
  public final ListArg listarg_;
  public SFun(Type p1, String p2, ListArg p3) { type_ = p1; id_ = p2; listarg_ = p3; }

  public <R,A> R accept(CPP.Absyn.Stm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.SFun) {
      CPP.Absyn.SFun x = (CPP.Absyn.SFun)o;
      return this.type_.equals(x.type_) && this.id_.equals(x.id_) && this.listarg_.equals(x.listarg_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.type_.hashCode())+this.id_.hashCode())+this.listarg_.hashCode();
  }


}
