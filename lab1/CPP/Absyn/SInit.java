package CPP.Absyn; // Java Package generated by the BNF Converter.

public class SInit extends Stm {
  public final Type type_;
  public final ListTypeN listtypen_;
  public SInit(Type p1, ListTypeN p2) { type_ = p1; listtypen_ = p2; }

  public <R,A> R accept(CPP.Absyn.Stm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.SInit) {
      CPP.Absyn.SInit x = (CPP.Absyn.SInit)o;
      return this.type_.equals(x.type_) && this.listtypen_.equals(x.listtypen_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.type_.hashCode())+this.listtypen_.hashCode();
  }


}
