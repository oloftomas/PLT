package CPP;
import CPP.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  CPP.Absyn.Program.Visitor<CPP.Absyn.Program,A>,
  CPP.Absyn.Def.Visitor<CPP.Absyn.Def,A>,
  CPP.Absyn.Arg.Visitor<CPP.Absyn.Arg,A>,
  CPP.Absyn.Stm.Visitor<CPP.Absyn.Stm,A>,
  CPP.Absyn.Exp.Visitor<CPP.Absyn.Exp,A>,
  CPP.Absyn.Type.Visitor<CPP.Absyn.Type,A>,
  CPP.Absyn.TypeN.Visitor<CPP.Absyn.TypeN,A>
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
    }    public Def visit(CPP.Absyn.DFunemp p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      ListArg listarg_ = new ListArg();
      for (Arg x : p.listarg_)
      {
        listarg_.add(x.accept(this,arg));
      }
      return new CPP.Absyn.DFunemp(type_, id_, listarg_);
    }    public Def visit(CPP.Absyn.DTypedef p, A arg)
    {
      ListId listid_ = p.listid_;
      String id_ = p.id_;
      return new CPP.Absyn.DTypedef(listid_, id_);
    }    public Def visit(CPP.Absyn.DTypedeft p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      return new CPP.Absyn.DTypedeft(type_, id_);
    }    public Def visit(CPP.Absyn.DVardeq p, A arg)
    {
      ListTypeN listtypen_ = new ListTypeN();
      for (TypeN x : p.listtypen_)
      {
        listtypen_.add(x.accept(this,arg));
      }
      return new CPP.Absyn.DVardeq(listtypen_);
    }    public Def visit(CPP.Absyn.QConuse p, A arg)
    {
      ListId listid_ = p.listid_;
      return new CPP.Absyn.QConuse(listid_);
    }
/* Arg */
    public Arg visit(CPP.Absyn.ADeclemp p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      return new CPP.Absyn.ADeclemp(type_);
    }    public Arg visit(CPP.Absyn.ADecl p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      return new CPP.Absyn.ADecl(type_, id_);
    }    public Arg visit(CPP.Absyn.ADeclass p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.ADeclass(type_, id_, exp_);
    }
/* Stm */
    public Stm visit(CPP.Absyn.SExp p, A arg)
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
      ListTypeN listtypen_ = new ListTypeN();
      for (TypeN x : p.listtypen_)
      {
        listtypen_.add(x.accept(this,arg));
      }
      return new CPP.Absyn.SDecls(type_, id_, listtypen_);
    }    public Stm visit(CPP.Absyn.SInit p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      ListTypeN listtypen_ = new ListTypeN();
      for (TypeN x : p.listtypen_)
      {
        listtypen_.add(x.accept(this,arg));
      }
      return new CPP.Absyn.SInit(type_, listtypen_);
    }    public Stm visit(CPP.Absyn.STypedef p, A arg)
    {
      ListId listid_ = p.listid_;
      String id_ = p.id_;
      return new CPP.Absyn.STypedef(listid_, id_);
    }    public Stm visit(CPP.Absyn.STypedeft p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      return new CPP.Absyn.STypedeft(type_, id_);
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
    }    public Stm visit(CPP.Absyn.SIf p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      Stm stm_ = p.stm_.accept(this, arg);
      return new CPP.Absyn.SIf(exp_, stm_);
    }    public Stm visit(CPP.Absyn.SIfElse p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      Stm stm_1 = p.stm_1.accept(this, arg);
      Stm stm_2 = p.stm_2.accept(this, arg);
      return new CPP.Absyn.SIfElse(exp_, stm_1, stm_2);
    }    public Stm visit(CPP.Absyn.SFor p, A arg)
    {
      Arg arg_ = p.arg_.accept(this, arg);
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      Stm stm_ = p.stm_.accept(this, arg);
      return new CPP.Absyn.SFor(arg_, exp_1, exp_2, stm_);
    }    public Stm visit(CPP.Absyn.SDoWhile p, A arg)
    {
      Stm stm_ = p.stm_.accept(this, arg);
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.SDoWhile(stm_, exp_);
    }
/* Exp */
    public Exp visit(CPP.Absyn.EInt p, A arg)
    {
      Integer integer_ = p.integer_;
      return new CPP.Absyn.EInt(integer_);
    }    public Exp visit(CPP.Absyn.EString p, A arg)
    {
      ListString liststring_ = p.liststring_;
      return new CPP.Absyn.EString(liststring_);
    }    public Exp visit(CPP.Absyn.EDouble p, A arg)
    {
      Double double_ = p.double_;
      return new CPP.Absyn.EDouble(double_);
    }    public Exp visit(CPP.Absyn.EQcon p, A arg)
    {
      ListId listid_ = p.listid_;
      return new CPP.Absyn.EQcon(listid_);
    }    public Exp visit(CPP.Absyn.EChar p, A arg)
    {
      Character char_ = p.char_;
      return new CPP.Absyn.EChar(char_);
    }    public Exp visit(CPP.Absyn.EIndex p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EIndex(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.ECall p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      ListExp listexp_ = new ListExp();
      for (Exp x : p.listexp_)
      {
        listexp_.add(x.accept(this,arg));
      }
      return new CPP.Absyn.ECall(exp_, listexp_);
    }    public Exp visit(CPP.Absyn.EDot p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EDot(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EArrow p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EArrow(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EPInc p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.EPInc(exp_);
    }    public Exp visit(CPP.Absyn.EPDec p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.EPDec(exp_);
    }    public Exp visit(CPP.Absyn.Einc p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.Einc(exp_);
    }    public Exp visit(CPP.Absyn.Edec p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.Edec(exp_);
    }    public Exp visit(CPP.Absyn.EDeref p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.EDeref(exp_);
    }    public Exp visit(CPP.Absyn.ENeg p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.ENeg(exp_);
    }    public Exp visit(CPP.Absyn.EMul p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EMul(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EDiv p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EDiv(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EMod p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EMod(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EAdd p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EAdd(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.ESub p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.ESub(exp_1, exp_2);
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
    }    public Exp visit(CPP.Absyn.ELt p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.ELt(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EGt p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EGt(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.ELteq p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.ELteq(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EGteq p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EGteq(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EEq p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EEq(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.ENeq p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.ENeq(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EConj p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EConj(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EDisj p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EDisj(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EAss p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EAss(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EAssp p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EAssp(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.EAssm p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      return new CPP.Absyn.EAssm(exp_1, exp_2);
    }    public Exp visit(CPP.Absyn.ECond p, A arg)
    {
      Exp exp_1 = p.exp_1.accept(this, arg);
      Exp exp_2 = p.exp_2.accept(this, arg);
      Exp exp_3 = p.exp_3.accept(this, arg);
      return new CPP.Absyn.ECond(exp_1, exp_2, exp_3);
    }    public Exp visit(CPP.Absyn.EThrow p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.EThrow(exp_);
    }
/* Type */
    public Type visit(CPP.Absyn.Ttype1 p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      return new CPP.Absyn.Ttype1(type_);
    }    public Type visit(CPP.Absyn.Ttype2 p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      return new CPP.Absyn.Ttype2(type_);
    }    public Type visit(CPP.Absyn.Ttype3 p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      return new CPP.Absyn.Ttype3(type_);
    }    public Type visit(CPP.Absyn.Ttype4 p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      return new CPP.Absyn.Ttype4(type_);
    }    public Type visit(CPP.Absyn.Tbool p, A arg)
    {
      return new CPP.Absyn.Tbool();
    }    public Type visit(CPP.Absyn.Tdouble p, A arg)
    {
      return new CPP.Absyn.Tdouble();
    }    public Type visit(CPP.Absyn.Tint p, A arg)
    {
      return new CPP.Absyn.Tint();
    }    public Type visit(CPP.Absyn.Tvoid p, A arg)
    {
      return new CPP.Absyn.Tvoid();
    }    public Type visit(CPP.Absyn.Tid p, A arg)
    {
      ListId listid_ = p.listid_;
      return new CPP.Absyn.Tid(listid_);
    }
/* TypeN */
    public TypeN visit(CPP.Absyn.Tname1 p, A arg)
    {
      String id_ = p.id_;
      return new CPP.Absyn.Tname1(id_);
    }    public TypeN visit(CPP.Absyn.Tname2 p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      return new CPP.Absyn.Tname2(type_, id_);
    }    public TypeN visit(CPP.Absyn.Tnameinit1 p, A arg)
    {
      String id_ = p.id_;
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.Tnameinit1(id_, exp_);
    }    public TypeN visit(CPP.Absyn.Tnameinit2 p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      String id_ = p.id_;
      Exp exp_ = p.exp_.accept(this, arg);
      return new CPP.Absyn.Tnameinit2(type_, id_, exp_);
    }
}