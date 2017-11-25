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
    public R visit(CPP.Absyn.DFunemp p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.DTypedef p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.DTypedeft p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.DVardeq p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.QConuse p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(CPP.Absyn.Def p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Arg */
    public R visit(CPP.Absyn.ADeclemp p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.ADecl p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.ADeclass p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(CPP.Absyn.Arg p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Stm */
    public R visit(CPP.Absyn.SExp p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SDecls p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SInit p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.STypedef p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.STypedeft p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SReturn p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SWhile p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SBlock p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SIf p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SIfElse p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SFor p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.SDoWhile p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(CPP.Absyn.Stm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Exp */
    public R visit(CPP.Absyn.EInt p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EString p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EDouble p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EQcon p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EChar p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.EIndex p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.ECall p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.EDot p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EArrow p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EPInc p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EPDec p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.Einc p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Edec p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EDeref p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.ENeg p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.EMul p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EDiv p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EMod p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.EAdd p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.ESub p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.ELShift p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.ERShift p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.ELt p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EGt p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.ELteq p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EGteq p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.EEq p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.ENeq p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.EConj p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.EDisj p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.EAss p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EAssp p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.EAssm p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.ECond p, A arg) { return visitDefault(p, arg); }

    public R visit(CPP.Absyn.EThrow p, A arg) { return visitDefault(p, arg); }




    public R visitDefault(CPP.Absyn.Exp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Type */
    public R visit(CPP.Absyn.Ttype1 p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Ttype2 p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Ttype3 p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Ttype4 p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tbool p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tdouble p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tint p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tvoid p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tid p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(CPP.Absyn.Type p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* TypeN */
    public R visit(CPP.Absyn.Tname1 p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tname2 p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tnameinit1 p, A arg) { return visitDefault(p, arg); }
    public R visit(CPP.Absyn.Tnameinit2 p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(CPP.Absyn.TypeN p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
