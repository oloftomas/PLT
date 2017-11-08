package CPP;

import CPP.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* Program */
    public R visit(CPP.Absyn.Prog p, A arg) {
      R r = leaf(arg);
      for (Def x : p.listdef_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Def */
    public R visit(CPP.Absyn.DFun p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      for (Arg x : p.listarg_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      for (Stm x : p.liststm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Arg */
    public R visit(CPP.Absyn.ADecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }

/* Stm */
    public R visit(CPP.Absyn.SExp p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(CPP.Absyn.SDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(CPP.Absyn.SInit p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(CPP.Absyn.SReturn p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(CPP.Absyn.SWhile p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      r = combine(p.stm_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(CPP.Absyn.SBlock p, A arg) {
      R r = leaf(arg);
      for (Stm x : p.liststm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(CPP.Absyn.SIfElse p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      r = combine(p.stm_1.accept(this, arg), r, arg);
      r = combine(p.stm_2.accept(this, arg), r, arg);
      return r;
    }

/* Exp */
    public R visit(CPP.Absyn.EInt p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(CPP.Absyn.EString p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(CPP.Absyn.EQcon p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(CPP.Absyn.ELShift p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(CPP.Absyn.ERShift p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }

/* Type */
    public R visit(CPP.Absyn.Tbool p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(CPP.Absyn.Tdouble p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(CPP.Absyn.Tint p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(CPP.Absyn.Tstring p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(CPP.Absyn.Tvoid p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
