package CPP.Absyn; // Java Package generated by the BNF Converter.

public abstract class Decl implements java.io.Serializable {
  public abstract <R,A> R accept(Decl.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(CPP.Absyn.Dec p, A arg);

  }

}