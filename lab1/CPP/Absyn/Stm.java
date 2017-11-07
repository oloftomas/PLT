package CPP.Absyn; // Java Package generated by the BNF Converter.

public abstract class Stm implements java.io.Serializable {
  public abstract <R,A> R accept(Stm.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(CPP.Absyn.SExp p, A arg);
    public R visit(CPP.Absyn.SDecl p, A arg);
    public R visit(CPP.Absyn.SInit p, A arg);
    public R visit(CPP.Absyn.SReturn p, A arg);
    public R visit(CPP.Absyn.SWhile p, A arg);
    public R visit(CPP.Absyn.SBlock p, A arg);
    public R visit(CPP.Absyn.SIfElse p, A arg);

  }

}