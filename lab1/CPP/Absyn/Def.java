package CPP.Absyn; // Java Package generated by the BNF Converter.

public abstract class Def implements java.io.Serializable {
  public abstract <R,A> R accept(Def.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(CPP.Absyn.DFun p, A arg);
    public R visit(CPP.Absyn.QConuse p, A arg);

  }

}
