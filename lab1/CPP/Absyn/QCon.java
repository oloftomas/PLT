package CPP.Absyn; // Java Package generated by the BNF Converter.

public class QCon extends Exp {
  public final Type type_1, type_2;
  public final ListId listid_1, listid_2;
  public QCon(Type p1, ListId p2, Type p3, ListId p4) { type_1 = p1; listid_1 = p2; type_2 = p3; listid_2 = p4; }

  public <R,A> R accept(CPP.Absyn.Exp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof CPP.Absyn.QCon) {
      CPP.Absyn.QCon x = (CPP.Absyn.QCon)o;
      return this.type_1.equals(x.type_1) && this.listid_1.equals(x.listid_1) && this.type_2.equals(x.type_2) && this.listid_2.equals(x.listid_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(37*(this.type_1.hashCode())+this.listid_1.hashCode())+this.type_2.hashCode())+this.listid_2.hashCode();
  }


}
