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
    }    public R visit(CPP.Absyn.DFunemp p, A arg)
    { /* Code For DFunemp Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      for (Arg x: p.listarg_)
      { /* ... */ }
      return null;
    }    public R visit(CPP.Absyn.DTypedef p, A arg)
    { /* Code For DTypedef Goes Here */
      for (String x: p.listid_)
      { /* ... */ }
      //p.id_;
      return null;
    }    public R visit(CPP.Absyn.QConuse p, A arg)
    { /* Code For QConuse Goes Here */
      for (String x: p.listid_)
      { /* ... */ }
      return null;
    }
  }
  public class ArgVisitor<R,A> implements Arg.Visitor<R,A>
  {
    public R visit(CPP.Absyn.ADeclemp p, A arg)
    { /* Code For ADeclemp Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.ADecl p, A arg)
    { /* Code For ADecl Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      return null;
    }    public R visit(CPP.Absyn.ADeclass p, A arg)
    { /* Code For ADeclass Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
  }
  public class StmVisitor<R,A> implements Stm.Visitor<R,A>
  {
    public R visit(CPP.Absyn.SExp p, A arg)
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
    }    public R visit(CPP.Absyn.STypedef p, A arg)
    { /* Code For STypedef Goes Here */
      for (String x: p.listid_)
      { /* ... */ }
      //p.id_;
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
    }    public R visit(CPP.Absyn.SIf p, A arg)
    { /* Code For SIf Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      p.stm_.accept(new StmVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.SIfElse p, A arg)
    { /* Code For SIfElse Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      p.stm_1.accept(new StmVisitor<R,A>(), arg);
      p.stm_2.accept(new StmVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.SFor p, A arg)
    { /* Code For SFor Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      //p.id_;
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      p.exp_3.accept(new ExpVisitor<R,A>(), arg);
      p.stm_.accept(new StmVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.SDoWhile p, A arg)
    { /* Code For SDoWhile Goes Here */
      p.stm_.accept(new StmVisitor<R,A>(), arg);
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
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
      for (String x: p.liststring_)
      { /* ... */ }
      return null;
    }    public R visit(CPP.Absyn.EDouble p, A arg)
    { /* Code For EDouble Goes Here */
      //p.double_;
      return null;
    }    public R visit(CPP.Absyn.EQcon p, A arg)
    { /* Code For EQcon Goes Here */
      for (String x: p.listid_)
      { /* ... */ }
      return null;
    }    public R visit(CPP.Absyn.EChar p, A arg)
    { /* Code For EChar Goes Here */
      //p.char_;
      return null;
    }        public R visit(CPP.Absyn.EIndex p, A arg)
    { /* Code For EIndex Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.ECall p, A arg)
    { /* Code For ECall Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      for (Exp x: p.listexp_)
      { /* ... */ }
      return null;
    }        public R visit(CPP.Absyn.EDot p, A arg)
    { /* Code For EDot Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.EArrow p, A arg)
    { /* Code For EArrow Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      //p.id_;
      return null;
    }    public R visit(CPP.Absyn.EPInc p, A arg)
    { /* Code For EPInc Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.EPDec p, A arg)
    { /* Code For EPDec Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(CPP.Absyn.Einc p, A arg)
    { /* Code For Einc Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.Edec p, A arg)
    { /* Code For Edec Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.EDeref p, A arg)
    { /* Code For EDeref Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.ENeg p, A arg)
    { /* Code For ENeg Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(CPP.Absyn.EMul p, A arg)
    { /* Code For EMul Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.EDiv p, A arg)
    { /* Code For EDiv Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.EMod p, A arg)
    { /* Code For EMod Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(CPP.Absyn.EAdd p, A arg)
    { /* Code For EAdd Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.ESub p, A arg)
    { /* Code For ESub Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
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
    }        public R visit(CPP.Absyn.ELt p, A arg)
    { /* Code For ELt Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.EGt p, A arg)
    { /* Code For EGt Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.ELteq p, A arg)
    { /* Code For ELteq Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.EGteq p, A arg)
    { /* Code For EGteq Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(CPP.Absyn.EEq p, A arg)
    { /* Code For EEq Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.ENeq p, A arg)
    { /* Code For ENeq Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(CPP.Absyn.EConj p, A arg)
    { /* Code For EConj Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(CPP.Absyn.EDisj p, A arg)
    { /* Code For EDisj Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(CPP.Absyn.EAss p, A arg)
    { /* Code For EAss Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.EAssp p, A arg)
    { /* Code For EAssp Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.EAssm p, A arg)
    { /* Code For EAssm Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.ECond p, A arg)
    { /* Code For ECond Goes Here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      p.exp_3.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(CPP.Absyn.EThrow p, A arg)
    { /* Code For EThrow Goes Here */
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }                
  }
  public class TypeVisitor<R,A> implements Type.Visitor<R,A>
  {
    public R visit(CPP.Absyn.Ttype1 p, A arg)
    { /* Code For Ttype1 Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.Ttype2 p, A arg)
    { /* Code For Ttype2 Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.Ttype3 p, A arg)
    { /* Code For Ttype3 Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.Ttype4 p, A arg)
    { /* Code For Ttype4 Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(CPP.Absyn.Tbool p, A arg)
    { /* Code For Tbool Goes Here */
      return null;
    }    public R visit(CPP.Absyn.Tdouble p, A arg)
    { /* Code For Tdouble Goes Here */
      return null;
    }    public R visit(CPP.Absyn.Tint p, A arg)
    { /* Code For Tint Goes Here */
      return null;
    }    public R visit(CPP.Absyn.Tvoid p, A arg)
    { /* Code For Tvoid Goes Here */
      return null;
    }    public R visit(CPP.Absyn.Tid p, A arg)
    { /* Code For Tid Goes Here */
      for (String x: p.listid_)
      { /* ... */ }
      return null;
    }
  }
}