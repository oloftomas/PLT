package CPP;
import CPP.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* Program */
    public R visit(CPP.Absyn.Prog p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(CPP.Absyn.Program p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Def */
    public R visit(CPP.Absyn.DFun p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(CPP.Absyn.Def p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Arg */
    public R visit(CPP.Absyn.ADecl p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(CPP.Absyn.Arg p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Stm */
    public R visit(CPP.Absyn.SExp p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SInit p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SReturn p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SWhile p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SBlock p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SIfElse p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(CPP.Absyn.Stm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Exp */
    public R visit(CPP.Absyn.EInt p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.EString p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.ELShift p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.ERShift p, A arg) { return visitDefault(p, arg); }














    public R visitDefault(CPP.Absyn.Exp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Type */
    public R visit(CPP.Absyn.Tbool p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tdouble p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tint p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tstring p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tvoid p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(CPP.Absyn.Type p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
