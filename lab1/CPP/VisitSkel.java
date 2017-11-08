package CPP;
import CPP.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ProgramVisitor<R,A> implements Program.Visitor<R,A>
  {
    public R visit(CPP.Absyn.Prog p, A arg)
    { /* Code For Prog Goes Here */
      for (Def x: p.listdef_)
      { /* ... */ }
      return null;
    }
  }
  public class DefVisitor<R,A> implements Def.Visitor<R,A>
  {
    public R visit(CPP.Absyn.DFun p, A arg)
    { /* Code For DFun Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      for (Arg x: p.listarg_)
      { /* ... */ }
      for (Stm x: p.liststm_)
      { /* ... */ }
      return null;
    }    public R visit(CPP.Absyn.QConuse p, A arg)
    { /* Code For QConuse Goes Here */
      for (String x: p.listid_)
      { /* ... */ }
      return null;
    }
  }
  public class StmVisitor<R,A> implements Stm.Visitor<R,A>
  {
    public R visit(CPP.Absyn.QCondec p, A arg)
    { /* Code For QCondec Goes Here */
      //p.id_1;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_2;
      return null;
    }    public R visit(CPP.Absyn.SExp p, A arg)
    { /* Code For SExp Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.SDecl p, A arg)
    { /* Code For SDecl Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      return null;
    }    public R visit(CPP.Absyn.SDecls p, A arg)
    { /* Code For SDecls Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      for (String x: p.listid_)
      { /* ... */ }
      return null;
    }    public R visit(CPP.Absyn.SInit p, A arg)
    { /* Code For SInit Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.SReturn p, A arg)
    { /* Code For SReturn Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.SWhile p, A arg)
    { /* Code For SWhile Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      p.stm_.accept(new StmVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.SBlock p, A arg)
    { /* Code For SBlock Goes Here */
      for (Stm x: p.liststm_)
      { /* ... */ }
      return null;
    }    public R visit(CPP.Absyn.SIfElse p, A arg)
    { /* Code For SIfElse Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      p.stm_1.accept(new StmVisitor<R,A>(), arg);
      p.stm_2.accept(new StmVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ArgVisitor<R,A> implements Arg.Visitor<R,A>
  {
    public R visit(CPP.Absyn.ADecl p, A arg)
    { /* Code For ADecl Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      return null;
    }
  }
  public class ExpVisitor<R,A> implements Exp.Visitor<R,A>
  {
    public R visit(CPP.Absyn.EInt p, A arg)
    { /* Code For EInt Goes Here */
      //p.integer_;
      return null;
    }    public R visit(CPP.Absyn.EString p, A arg)
    { /* Code For EString Goes Here */
      //p.string_;
      return null;
    }    public R visit(CPP.Absyn.EQcon p, A arg)
    { /* Code For EQcon Goes Here */
      for (String x: p.listid_)
      { /* ... */ }
      return null;
    }        public R visit(CPP.Absyn.ELShift p, A arg)
    { /* Code For ELShift Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.ERShift p, A arg)
    { /* Code For ERShift Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }                                                            
  }
  public class TypeVisitor<R,A> implements Type.Visitor<R,A>
  {
    public R visit(CPP.Absyn.Tbool p, A arg)
    { /* Code For Tbool Goes Here */
      return null;
    }    public R visit(CPP.Absyn.Tdouble p, A arg)
    { /* Code For Tdouble Goes Here */
      return null;
    }    public R visit(CPP.Absyn.Tint p, A arg)
    { /* Code For Tint Goes Here */
      return null;
    }    public R visit(CPP.Absyn.Tstring p, A arg)
    { /* Code For Tstring Goes Here */
      return null;
    }    public R visit(CPP.Absyn.Tvoid p, A arg)
    { /* Code For Tvoid Goes Here */
      return null;
    }
  }
}