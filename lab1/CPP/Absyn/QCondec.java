package CPP.Absyn; // Java Package generated by the BNF Converter.

public class QCondec extends Stm {
  public final String id_1, id_2;
  public final Type type_;
  public QCondec(String p1, Type p2, String p3) { id_1 = p1; type_ = p2; id_2 = p3; }

  public <R,A> R accept(CPP.Absyn.Stm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.QCondec) {
      CPP.Absyn.QCondec x = (CPP.Absyn.QCondec)o;
      return this.id_1.equals(x.id_1) && this.type_.equals(x.type_) && this.id_2.equals(x.id_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.id_1.hashCode())+this.type_.hashCode())+this.id_2.hashCode();
  }


}
