package CPP;
import CPP.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  CPP.Absyn.Program.Visitor<CPP.Absyn.Program,A>,
  CPP.Absyn.Def.Visitor<CPP.Absyn.Def,A>,
  CPP.Absyn.Stm.Visitor<CPP.Absyn.Stm,A>,
  CPP.Absyn.Arg.Visitor<CPP.Absyn.Arg,A>,
  CPP.Absyn.Exp.Visitor<CPP.Absyn.Exp,A>,
  CPP.Absyn.Type.Visitor<CPP.Absyn.Type,A>
{
/* Program */
    public Program visit(CPP.Absyn.Prog p, A arg)
    {
      ListDef listdef_ = new ListDef();
      for (Def x : p.listdef_)
      {
        listdef_.add(x.accept(this,arg));
      }
      return new CPP.Absyn.Prog(listdef_);
    }
/* Def */
    public Def visit(CPP.Absyn.DFun p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      ListArg listarg_ = new ListArg();
      for (Arg x : p.listarg_)
      {
        listarg_.add(x.accept(this,arg));
      }
      ListStm liststm_ = new ListStm();
      for (Stm x : p.liststm_)
      {
        liststm_.add(x.accept(this,arg));
      }
      return new CPP.Absyn.DFun(type_, id_, listarg_, liststm_);
    }    public Def visit(CPP.Absyn.QConuse p, A arg)
    {
      ListId listid_ = p.listid_;
      return new CPP.Absyn.QConuse(listid_);
    }
/* Stm */
    public Stm visit(CPP.Absyn.QCondec p, A arg)
    {
      String id_1 = p.id_1;
      Type type_ = p.type_.accept(this, arg);
      String id_2 = p.id_2;
      return new CPP.Absyn.QCondec(id_1, type_, id_2);
    }    public Stm visit(CPP.Absyn.SExp p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.SExp(exp_);
    }    public Stm visit(CPP.Absyn.SDecl p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      return new CPP.Absyn.SDecl(type_, id_);
    }    public Stm visit(CPP.Absyn.SDecls p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      ListId listid_ = p.listid_;
      return new CPP.Absyn.SDecls(type_, id_, listid_);
    }    public Stm visit(CPP.Absyn.SInit p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.SInit(type_, id_, exp_);
    }    public Stm visit(CPP.Absyn.SReturn p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.SReturn(exp_);
    }    public Stm visit(CPP.Absyn.SWhile p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      Stm stm_ = p.stm_.accept(this, arg);
      return new CPP.Absyn.SWhile(exp_, stm_);
    }    public Stm visit(CPP.Absyn.SBlock p, A arg)
    {
      ListStm liststm_ = new ListStm();
      for (Stm x : p.liststm_)
      {
        liststm_.add(x.accept(this,arg));
      }
      return new CPP.Absyn.SBlock(liststm_);
    }    public Stm visit(CPP.Absyn.SIfElse p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      Stm stm_1 = p.stm_1.accept(this, arg);
      Stm stm_2 = p.stm_2.accept(this, arg);
      return new CPP.Absyn.SIfElse(exp_, stm_1, stm_2);
    }
/* Arg */
    public Arg visit(CPP.Absyn.ADecl p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      return new CPP.Absyn.ADecl(type_, id_);
    }
/* Exp */
    public Exp visit(CPP.Absyn.EInt p, A arg)
    {
      Integer integer_ = p.integer_;
      return new CPP.Absyn.EInt(integer_);
    }    public Exp visit(CPP.Absyn.EString p, A arg)
    {
      String string_ = p.string_;
      return new CPP.Absyn.EString(string_);
    }    public Exp visit(CPP.Absyn.EQcon p, A arg)
    {
      ListId listid_ = p.listid_;
      return new CPP.Absyn.EQcon(listid_);
    }    public Exp visit(CPP.Absyn.ELShift p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.ELShift(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.ERShift p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.ERShift(exp_1, exp_2);
    }
/* Type */
    public Type visit(CPP.Absyn.Tbool p, A arg)
    {
      return new CPP.Absyn.Tbool();
    }    public Type visit(CPP.Absyn.Tdouble p, A arg)
    {
      return new CPP.Absyn.Tdouble();
    }    public Type visit(CPP.Absyn.Tint p, A arg)
    {
      return new CPP.Absyn.Tint();
    }    public Type visit(CPP.Absyn.Tstring p, A arg)
    {
      return new CPP.Absyn.Tstring();
    }    public Type visit(CPP.Absyn.Tvoid p, A arg)
    {
      return new CPP.Absyn.Tvoid();
    }
}