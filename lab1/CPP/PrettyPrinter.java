package CPP;
import CPP.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  private static final int INDENT_WIDTH = 2;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + INDENT_WIDTH;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       int t;
       _n_ = _n_ - INDENT_WIDTH;
       for(t=0; t<INDENT_WIDTH; t++) {
         backup();
       }
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(CPP.Absyn.Program foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.Program foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.ListDef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.ListDef foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.Def foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.Def foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.ListArg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.ListArg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.ListStm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.ListStm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.Arg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.Arg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.Stm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.Stm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.Exp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.Exp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.ListExp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.ListExp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.ListString foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.ListString foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.Type foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.Type foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.TypeN foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.TypeN foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.ListTypeN foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.ListTypeN foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(CPP.Absyn.ListId foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(CPP.Absyn.ListId foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(CPP.Absyn.Program foo, int _i_)
  {
    if (foo instanceof CPP.Absyn.Prog)
    {
       CPP.Absyn.Prog _prog = (CPP.Absyn.Prog) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_prog.listdef_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(CPP.Absyn.ListDef foo, int _i_)
  {
     for (java.util.Iterator<Def> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }  }

  private static void pp(CPP.Absyn.Def foo, int _i_)
  {
    if (foo instanceof CPP.Absyn.DFun)
    {
       CPP.Absyn.DFun _dfun = (CPP.Absyn.DFun) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_dfun.type_, 0);
       pp(_dfun.id_, 0);
       render("(");
       pp(_dfun.listarg_, 0);
       render(")");
       render("{");
       pp(_dfun.liststm_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.DFunemp)
    {
       CPP.Absyn.DFunemp _dfunemp = (CPP.Absyn.DFunemp) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_dfunemp.type_, 0);
       pp(_dfunemp.id_, 0);
       render("(");
       pp(_dfunemp.listarg_, 0);
       render(")");
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.DTypedef)
    {
       CPP.Absyn.DTypedef _dtypedef = (CPP.Absyn.DTypedef) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("typedef");
       pp(_dtypedef.listid_, 0);
       pp(_dtypedef.id_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.DTypedeft)
    {
       CPP.Absyn.DTypedeft _dtypedeft = (CPP.Absyn.DTypedeft) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("typedef");
       pp(_dtypedeft.type_, 0);
       pp(_dtypedeft.id_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.DVardeq)
    {
       CPP.Absyn.DVardeq _dvardeq = (CPP.Absyn.DVardeq) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_dvardeq.listtypen_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.QConuse)
    {
       CPP.Absyn.QConuse _qconuse = (CPP.Absyn.QConuse) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("using");
       pp(_qconuse.listid_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(CPP.Absyn.ListArg foo, int _i_)
  {
     for (java.util.Iterator<Arg> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(CPP.Absyn.ListStm foo, int _i_)
  {
     for (java.util.Iterator<Stm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }  }

  private static void pp(CPP.Absyn.Arg foo, int _i_)
  {
    if (foo instanceof CPP.Absyn.ADeclemp)
    {
       CPP.Absyn.ADeclemp _adeclemp = (CPP.Absyn.ADeclemp) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_adeclemp.type_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ADecl)
    {
       CPP.Absyn.ADecl _adecl = (CPP.Absyn.ADecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_adecl.type_, 0);
       pp(_adecl.id_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ADeclass)
    {
       CPP.Absyn.ADeclass _adeclass = (CPP.Absyn.ADeclass) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_adeclass.type_, 0);
       pp(_adeclass.id_, 0);
       render("=");
       pp(_adeclass.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(CPP.Absyn.Stm foo, int _i_)
  {
    if (foo instanceof CPP.Absyn.SExp)
    {
       CPP.Absyn.SExp _sexp = (CPP.Absyn.SExp) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sexp.exp_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.SDecl)
    {
       CPP.Absyn.SDecl _sdecl = (CPP.Absyn.SDecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sdecl.type_, 0);
       pp(_sdecl.id_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.SDecls)
    {
       CPP.Absyn.SDecls _sdecls = (CPP.Absyn.SDecls) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sdecls.type_, 0);
       pp(_sdecls.id_, 0);
       render(",");
       pp(_sdecls.listtypen_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.SInit)
    {
       CPP.Absyn.SInit _sinit = (CPP.Absyn.SInit) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sinit.type_, 0);
       pp(_sinit.listtypen_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.STypedef)
    {
       CPP.Absyn.STypedef _stypedef = (CPP.Absyn.STypedef) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("typedef");
       pp(_stypedef.listid_, 0);
       pp(_stypedef.id_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.STypedeft)
    {
       CPP.Absyn.STypedeft _stypedeft = (CPP.Absyn.STypedeft) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("typedef");
       pp(_stypedeft.type_, 0);
       pp(_stypedeft.id_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.SReturn)
    {
       CPP.Absyn.SReturn _sreturn = (CPP.Absyn.SReturn) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("return");
       pp(_sreturn.exp_, 0);
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.SWhile)
    {
       CPP.Absyn.SWhile _swhile = (CPP.Absyn.SWhile) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("while");
       render("(");
       pp(_swhile.exp_, 0);
       render(")");
       pp(_swhile.stm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.SBlock)
    {
       CPP.Absyn.SBlock _sblock = (CPP.Absyn.SBlock) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{");
       pp(_sblock.liststm_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.SIf)
    {
       CPP.Absyn.SIf _sif = (CPP.Absyn.SIf) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("if");
       render("(");
       pp(_sif.exp_, 0);
       render(")");
       pp(_sif.stm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.SIfElse)
    {
       CPP.Absyn.SIfElse _sifelse = (CPP.Absyn.SIfElse) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("if");
       render("(");
       pp(_sifelse.exp_, 0);
       render(")");
       pp(_sifelse.stm_1, 0);
       render("else");
       pp(_sifelse.stm_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.SFor)
    {
       CPP.Absyn.SFor _sfor = (CPP.Absyn.SFor) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("for");
       render("(");
       pp(_sfor.arg_, 0);
       render(";");
       pp(_sfor.exp_1, 0);
       render(";");
       pp(_sfor.exp_2, 0);
       render(")");
       pp(_sfor.stm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.SDoWhile)
    {
       CPP.Absyn.SDoWhile _sdowhile = (CPP.Absyn.SDoWhile) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("do");
       pp(_sdowhile.stm_, 0);
       render("while");
       render("(");
       pp(_sdowhile.exp_, 0);
       render(")");
       render(";");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(CPP.Absyn.Exp foo, int _i_)
  {
    if (foo instanceof CPP.Absyn.EInt)
    {
       CPP.Absyn.EInt _eint = (CPP.Absyn.EInt) foo;
       if (_i_ > 15) render(_L_PAREN);
       pp(_eint.integer_, 0);
       if (_i_ > 15) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EString)
    {
       CPP.Absyn.EString _estring = (CPP.Absyn.EString) foo;
       if (_i_ > 15) render(_L_PAREN);
       pp(_estring.liststring_, 0);
       if (_i_ > 15) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EDouble)
    {
       CPP.Absyn.EDouble _edouble = (CPP.Absyn.EDouble) foo;
       if (_i_ > 15) render(_L_PAREN);
       pp(_edouble.double_, 0);
       if (_i_ > 15) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EQcon)
    {
       CPP.Absyn.EQcon _eqcon = (CPP.Absyn.EQcon) foo;
       if (_i_ > 15) render(_L_PAREN);
       pp(_eqcon.listid_, 0);
       if (_i_ > 15) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EChar)
    {
       CPP.Absyn.EChar _echar = (CPP.Absyn.EChar) foo;
       if (_i_ > 15) render(_L_PAREN);
       pp(_echar.char_, 0);
       if (_i_ > 15) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EIndex)
    {
       CPP.Absyn.EIndex _eindex = (CPP.Absyn.EIndex) foo;
       if (_i_ > 14) render(_L_PAREN);
       pp(_eindex.exp_1, 14);
       render("[");
       pp(_eindex.exp_2, 0);
       render("]");
       if (_i_ > 14) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ECall)
    {
       CPP.Absyn.ECall _ecall = (CPP.Absyn.ECall) foo;
       if (_i_ > 14) render(_L_PAREN);
       pp(_ecall.exp_, 14);
       render("(");
       pp(_ecall.listexp_, 0);
       render(")");
       if (_i_ > 14) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EDot)
    {
       CPP.Absyn.EDot _edot = (CPP.Absyn.EDot) foo;
       if (_i_ > 13) render(_L_PAREN);
       pp(_edot.exp_1, 13);
       render(".");
       pp(_edot.exp_2, 14);
       if (_i_ > 13) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EArrow)
    {
       CPP.Absyn.EArrow _earrow = (CPP.Absyn.EArrow) foo;
       if (_i_ > 13) render(_L_PAREN);
       pp(_earrow.exp_1, 13);
       render("->");
       pp(_earrow.exp_2, 14);
       if (_i_ > 13) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EPInc)
    {
       CPP.Absyn.EPInc _epinc = (CPP.Absyn.EPInc) foo;
       if (_i_ > 13) render(_L_PAREN);
       pp(_epinc.exp_, 13);
       render("++");
       if (_i_ > 13) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EPDec)
    {
       CPP.Absyn.EPDec _epdec = (CPP.Absyn.EPDec) foo;
       if (_i_ > 13) render(_L_PAREN);
       pp(_epdec.exp_, 13);
       render("--");
       if (_i_ > 13) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Einc)
    {
       CPP.Absyn.Einc _einc = (CPP.Absyn.Einc) foo;
       if (_i_ > 12) render(_L_PAREN);
       render("++");
       pp(_einc.exp_, 12);
       if (_i_ > 12) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Edec)
    {
       CPP.Absyn.Edec _edec = (CPP.Absyn.Edec) foo;
       if (_i_ > 12) render(_L_PAREN);
       render("--");
       pp(_edec.exp_, 12);
       if (_i_ > 12) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EDeref)
    {
       CPP.Absyn.EDeref _ederef = (CPP.Absyn.EDeref) foo;
       if (_i_ > 12) render(_L_PAREN);
       render("*");
       pp(_ederef.exp_, 12);
       if (_i_ > 12) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ENeg)
    {
       CPP.Absyn.ENeg _eneg = (CPP.Absyn.ENeg) foo;
       if (_i_ > 12) render(_L_PAREN);
       render("!");
       pp(_eneg.exp_, 12);
       if (_i_ > 12) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EMul)
    {
       CPP.Absyn.EMul _emul = (CPP.Absyn.EMul) foo;
       if (_i_ > 11) render(_L_PAREN);
       pp(_emul.exp_1, 11);
       render("*");
       pp(_emul.exp_2, 12);
       if (_i_ > 11) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EDiv)
    {
       CPP.Absyn.EDiv _ediv = (CPP.Absyn.EDiv) foo;
       if (_i_ > 11) render(_L_PAREN);
       pp(_ediv.exp_1, 11);
       render("/");
       pp(_ediv.exp_2, 12);
       if (_i_ > 11) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EMod)
    {
       CPP.Absyn.EMod _emod = (CPP.Absyn.EMod) foo;
       if (_i_ > 11) render(_L_PAREN);
       pp(_emod.exp_1, 11);
       render("%");
       pp(_emod.exp_2, 12);
       if (_i_ > 11) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EAdd)
    {
       CPP.Absyn.EAdd _eadd = (CPP.Absyn.EAdd) foo;
       if (_i_ > 10) render(_L_PAREN);
       pp(_eadd.exp_1, 10);
       render("+");
       pp(_eadd.exp_2, 11);
       if (_i_ > 10) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ESub)
    {
       CPP.Absyn.ESub _esub = (CPP.Absyn.ESub) foo;
       if (_i_ > 10) render(_L_PAREN);
       pp(_esub.exp_1, 10);
       render("-");
       pp(_esub.exp_2, 11);
       if (_i_ > 10) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ELShift)
    {
       CPP.Absyn.ELShift _elshift = (CPP.Absyn.ELShift) foo;
       if (_i_ > 9) render(_L_PAREN);
       pp(_elshift.exp_1, 9);
       render("<<");
       pp(_elshift.exp_2, 10);
       if (_i_ > 9) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ERShift)
    {
       CPP.Absyn.ERShift _ershift = (CPP.Absyn.ERShift) foo;
       if (_i_ > 9) render(_L_PAREN);
       pp(_ershift.exp_1, 9);
       render(">>");
       pp(_ershift.exp_2, 10);
       if (_i_ > 9) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ELt)
    {
       CPP.Absyn.ELt _elt = (CPP.Absyn.ELt) foo;
       if (_i_ > 8) render(_L_PAREN);
       pp(_elt.exp_1, 8);
       render("<");
       pp(_elt.exp_2, 9);
       if (_i_ > 8) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EGt)
    {
       CPP.Absyn.EGt _egt = (CPP.Absyn.EGt) foo;
       if (_i_ > 8) render(_L_PAREN);
       pp(_egt.exp_1, 8);
       render(">");
       pp(_egt.exp_2, 9);
       if (_i_ > 8) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ELteq)
    {
       CPP.Absyn.ELteq _elteq = (CPP.Absyn.ELteq) foo;
       if (_i_ > 8) render(_L_PAREN);
       pp(_elteq.exp_1, 8);
       render("<=");
       pp(_elteq.exp_2, 9);
       if (_i_ > 8) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EGteq)
    {
       CPP.Absyn.EGteq _egteq = (CPP.Absyn.EGteq) foo;
       if (_i_ > 8) render(_L_PAREN);
       pp(_egteq.exp_1, 8);
       render(">=");
       pp(_egteq.exp_2, 9);
       if (_i_ > 8) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EEq)
    {
       CPP.Absyn.EEq _eeq = (CPP.Absyn.EEq) foo;
       if (_i_ > 7) render(_L_PAREN);
       pp(_eeq.exp_1, 7);
       render("==");
       pp(_eeq.exp_2, 8);
       if (_i_ > 7) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ENeq)
    {
       CPP.Absyn.ENeq _eneq = (CPP.Absyn.ENeq) foo;
       if (_i_ > 7) render(_L_PAREN);
       pp(_eneq.exp_1, 7);
       render("!=");
       pp(_eneq.exp_2, 8);
       if (_i_ > 7) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EConj)
    {
       CPP.Absyn.EConj _econj = (CPP.Absyn.EConj) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_econj.exp_1, 3);
       render("&&");
       pp(_econj.exp_2, 4);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EDisj)
    {
       CPP.Absyn.EDisj _edisj = (CPP.Absyn.EDisj) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_edisj.exp_1, 2);
       render("||");
       pp(_edisj.exp_2, 3);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EAss)
    {
       CPP.Absyn.EAss _eass = (CPP.Absyn.EAss) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_eass.exp_1, 2);
       render("=");
       pp(_eass.exp_2, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EAssp)
    {
       CPP.Absyn.EAssp _eassp = (CPP.Absyn.EAssp) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_eassp.exp_1, 2);
       render("+=");
       pp(_eassp.exp_2, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EAssm)
    {
       CPP.Absyn.EAssm _eassm = (CPP.Absyn.EAssm) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_eassm.exp_1, 2);
       render("-=");
       pp(_eassm.exp_2, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ECond)
    {
       CPP.Absyn.ECond _econd = (CPP.Absyn.ECond) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_econd.exp_1, 2);
       render("?");
       pp(_econd.exp_2, 0);
       render(":");
       pp(_econd.exp_3, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.EThrow)
    {
       CPP.Absyn.EThrow _ethrow = (CPP.Absyn.EThrow) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("throw");
       pp(_ethrow.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(CPP.Absyn.ListExp foo, int _i_)
  {
     for (java.util.Iterator<Exp> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(CPP.Absyn.ListString foo, int _i_)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }  }

  private static void pp(CPP.Absyn.Type foo, int _i_)
  {
    if (foo instanceof CPP.Absyn.Ttype1)
    {
       CPP.Absyn.Ttype1 _ttype1 = (CPP.Absyn.Ttype1) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_ttype1.type_, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Ttype2)
    {
       CPP.Absyn.Ttype2 _ttype2 = (CPP.Absyn.Ttype2) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_ttype2.type_, 1);
       render("&");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Ttype3)
    {
       CPP.Absyn.Ttype3 _ttype3 = (CPP.Absyn.Ttype3) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("const");
       pp(_ttype3.type_, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Ttype4)
    {
       CPP.Absyn.Ttype4 _ttype4 = (CPP.Absyn.Ttype4) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("const");
       pp(_ttype4.type_, 1);
       render("&");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tbool)
    {
       CPP.Absyn.Tbool _tbool = (CPP.Absyn.Tbool) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("bool");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tdouble)
    {
       CPP.Absyn.Tdouble _tdouble = (CPP.Absyn.Tdouble) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("double");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tint)
    {
       CPP.Absyn.Tint _tint = (CPP.Absyn.Tint) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("int");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tvoid)
    {
       CPP.Absyn.Tvoid _tvoid = (CPP.Absyn.Tvoid) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("void");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tid)
    {
       CPP.Absyn.Tid _tid = (CPP.Absyn.Tid) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_tid.listid_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
  }

  private static void pp(CPP.Absyn.TypeN foo, int _i_)
  {
    if (foo instanceof CPP.Absyn.Tname1)
    {
       CPP.Absyn.Tname1 _tname1 = (CPP.Absyn.Tname1) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_tname1.id_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tname2)
    {
       CPP.Absyn.Tname2 _tname2 = (CPP.Absyn.Tname2) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_tname2.type_, 0);
       pp(_tname2.id_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tnameinit1)
    {
       CPP.Absyn.Tnameinit1 _tnameinit1 = (CPP.Absyn.Tnameinit1) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_tnameinit1.id_, 0);
       render("=");
       pp(_tnameinit1.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tnameinit2)
    {
       CPP.Absyn.Tnameinit2 _tnameinit2 = (CPP.Absyn.Tnameinit2) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_tnameinit2.type_, 0);
       pp(_tnameinit2.id_, 0);
       render("=");
       pp(_tnameinit2.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(CPP.Absyn.ListTypeN foo, int _i_)
  {
     for (java.util.Iterator<TypeN> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(CPP.Absyn.ListId foo, int _i_)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render("::");
       } else {
         render("");
       }
     }  }


  private static void sh(CPP.Absyn.Program foo)
  {
    if (foo instanceof CPP.Absyn.Prog)
    {
       CPP.Absyn.Prog _prog = (CPP.Absyn.Prog) foo;
       render("(");
       render("Prog");
       render("[");
       sh(_prog.listdef_);
       render("]");
       render(")");
    }
  }

  private static void sh(CPP.Absyn.ListDef foo)
  {
     for (java.util.Iterator<Def> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(CPP.Absyn.Def foo)
  {
    if (foo instanceof CPP.Absyn.DFun)
    {
       CPP.Absyn.DFun _dfun = (CPP.Absyn.DFun) foo;
       render("(");
       render("DFun");
       sh(_dfun.type_);
       sh(_dfun.id_);
       render("[");
       sh(_dfun.listarg_);
       render("]");
       render("[");
       sh(_dfun.liststm_);
       render("]");
       render(")");
    }
    if (foo instanceof CPP.Absyn.DFunemp)
    {
       CPP.Absyn.DFunemp _dfunemp = (CPP.Absyn.DFunemp) foo;
       render("(");
       render("DFunemp");
       sh(_dfunemp.type_);
       sh(_dfunemp.id_);
       render("[");
       sh(_dfunemp.listarg_);
       render("]");
       render(")");
    }
    if (foo instanceof CPP.Absyn.DTypedef)
    {
       CPP.Absyn.DTypedef _dtypedef = (CPP.Absyn.DTypedef) foo;
       render("(");
       render("DTypedef");
       render("[");
       sh(_dtypedef.listid_);
       render("]");
       sh(_dtypedef.id_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.DTypedeft)
    {
       CPP.Absyn.DTypedeft _dtypedeft = (CPP.Absyn.DTypedeft) foo;
       render("(");
       render("DTypedeft");
       sh(_dtypedeft.type_);
       sh(_dtypedeft.id_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.DVardeq)
    {
       CPP.Absyn.DVardeq _dvardeq = (CPP.Absyn.DVardeq) foo;
       render("(");
       render("DVardeq");
       render("[");
       sh(_dvardeq.listtypen_);
       render("]");
       render(")");
    }
    if (foo instanceof CPP.Absyn.QConuse)
    {
       CPP.Absyn.QConuse _qconuse = (CPP.Absyn.QConuse) foo;
       render("(");
       render("QConuse");
       render("[");
       sh(_qconuse.listid_);
       render("]");
       render(")");
    }
  }

  private static void sh(CPP.Absyn.ListArg foo)
  {
     for (java.util.Iterator<Arg> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(CPP.Absyn.ListStm foo)
  {
     for (java.util.Iterator<Stm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(CPP.Absyn.Arg foo)
  {
    if (foo instanceof CPP.Absyn.ADeclemp)
    {
       CPP.Absyn.ADeclemp _adeclemp = (CPP.Absyn.ADeclemp) foo;
       render("(");
       render("ADeclemp");
       sh(_adeclemp.type_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ADecl)
    {
       CPP.Absyn.ADecl _adecl = (CPP.Absyn.ADecl) foo;
       render("(");
       render("ADecl");
       sh(_adecl.type_);
       sh(_adecl.id_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ADeclass)
    {
       CPP.Absyn.ADeclass _adeclass = (CPP.Absyn.ADeclass) foo;
       render("(");
       render("ADeclass");
       sh(_adeclass.type_);
       sh(_adeclass.id_);
       sh(_adeclass.exp_);
       render(")");
    }
  }

  private static void sh(CPP.Absyn.Stm foo)
  {
    if (foo instanceof CPP.Absyn.SExp)
    {
       CPP.Absyn.SExp _sexp = (CPP.Absyn.SExp) foo;
       render("(");
       render("SExp");
       sh(_sexp.exp_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.SDecl)
    {
       CPP.Absyn.SDecl _sdecl = (CPP.Absyn.SDecl) foo;
       render("(");
       render("SDecl");
       sh(_sdecl.type_);
       sh(_sdecl.id_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.SDecls)
    {
       CPP.Absyn.SDecls _sdecls = (CPP.Absyn.SDecls) foo;
       render("(");
       render("SDecls");
       sh(_sdecls.type_);
       sh(_sdecls.id_);
       render("[");
       sh(_sdecls.listtypen_);
       render("]");
       render(")");
    }
    if (foo instanceof CPP.Absyn.SInit)
    {
       CPP.Absyn.SInit _sinit = (CPP.Absyn.SInit) foo;
       render("(");
       render("SInit");
       sh(_sinit.type_);
       render("[");
       sh(_sinit.listtypen_);
       render("]");
       render(")");
    }
    if (foo instanceof CPP.Absyn.STypedef)
    {
       CPP.Absyn.STypedef _stypedef = (CPP.Absyn.STypedef) foo;
       render("(");
       render("STypedef");
       render("[");
       sh(_stypedef.listid_);
       render("]");
       sh(_stypedef.id_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.STypedeft)
    {
       CPP.Absyn.STypedeft _stypedeft = (CPP.Absyn.STypedeft) foo;
       render("(");
       render("STypedeft");
       sh(_stypedeft.type_);
       sh(_stypedeft.id_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.SReturn)
    {
       CPP.Absyn.SReturn _sreturn = (CPP.Absyn.SReturn) foo;
       render("(");
       render("SReturn");
       sh(_sreturn.exp_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.SWhile)
    {
       CPP.Absyn.SWhile _swhile = (CPP.Absyn.SWhile) foo;
       render("(");
       render("SWhile");
       sh(_swhile.exp_);
       sh(_swhile.stm_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.SBlock)
    {
       CPP.Absyn.SBlock _sblock = (CPP.Absyn.SBlock) foo;
       render("(");
       render("SBlock");
       render("[");
       sh(_sblock.liststm_);
       render("]");
       render(")");
    }
    if (foo instanceof CPP.Absyn.SIf)
    {
       CPP.Absyn.SIf _sif = (CPP.Absyn.SIf) foo;
       render("(");
       render("SIf");
       sh(_sif.exp_);
       sh(_sif.stm_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.SIfElse)
    {
       CPP.Absyn.SIfElse _sifelse = (CPP.Absyn.SIfElse) foo;
       render("(");
       render("SIfElse");
       sh(_sifelse.exp_);
       sh(_sifelse.stm_1);
       sh(_sifelse.stm_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.SFor)
    {
       CPP.Absyn.SFor _sfor = (CPP.Absyn.SFor) foo;
       render("(");
       render("SFor");
       sh(_sfor.arg_);
       sh(_sfor.exp_1);
       sh(_sfor.exp_2);
       sh(_sfor.stm_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.SDoWhile)
    {
       CPP.Absyn.SDoWhile _sdowhile = (CPP.Absyn.SDoWhile) foo;
       render("(");
       render("SDoWhile");
       sh(_sdowhile.stm_);
       sh(_sdowhile.exp_);
       render(")");
    }
  }

  private static void sh(CPP.Absyn.Exp foo)
  {
    if (foo instanceof CPP.Absyn.EInt)
    {
       CPP.Absyn.EInt _eint = (CPP.Absyn.EInt) foo;
       render("(");
       render("EInt");
       sh(_eint.integer_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EString)
    {
       CPP.Absyn.EString _estring = (CPP.Absyn.EString) foo;
       render("(");
       render("EString");
       render("[");
       sh(_estring.liststring_);
       render("]");
       render(")");
    }
    if (foo instanceof CPP.Absyn.EDouble)
    {
       CPP.Absyn.EDouble _edouble = (CPP.Absyn.EDouble) foo;
       render("(");
       render("EDouble");
       sh(_edouble.double_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EQcon)
    {
       CPP.Absyn.EQcon _eqcon = (CPP.Absyn.EQcon) foo;
       render("(");
       render("EQcon");
       render("[");
       sh(_eqcon.listid_);
       render("]");
       render(")");
    }
    if (foo instanceof CPP.Absyn.EChar)
    {
       CPP.Absyn.EChar _echar = (CPP.Absyn.EChar) foo;
       render("(");
       render("EChar");
       sh(_echar.char_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EIndex)
    {
       CPP.Absyn.EIndex _eindex = (CPP.Absyn.EIndex) foo;
       render("(");
       render("EIndex");
       sh(_eindex.exp_1);
       sh(_eindex.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ECall)
    {
       CPP.Absyn.ECall _ecall = (CPP.Absyn.ECall) foo;
       render("(");
       render("ECall");
       sh(_ecall.exp_);
       render("[");
       sh(_ecall.listexp_);
       render("]");
       render(")");
    }
    if (foo instanceof CPP.Absyn.EDot)
    {
       CPP.Absyn.EDot _edot = (CPP.Absyn.EDot) foo;
       render("(");
       render("EDot");
       sh(_edot.exp_1);
       sh(_edot.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EArrow)
    {
       CPP.Absyn.EArrow _earrow = (CPP.Absyn.EArrow) foo;
       render("(");
       render("EArrow");
       sh(_earrow.exp_1);
       sh(_earrow.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EPInc)
    {
       CPP.Absyn.EPInc _epinc = (CPP.Absyn.EPInc) foo;
       render("(");
       render("EPInc");
       sh(_epinc.exp_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EPDec)
    {
       CPP.Absyn.EPDec _epdec = (CPP.Absyn.EPDec) foo;
       render("(");
       render("EPDec");
       sh(_epdec.exp_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.Einc)
    {
       CPP.Absyn.Einc _einc = (CPP.Absyn.Einc) foo;
       render("(");
       render("Einc");
       sh(_einc.exp_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.Edec)
    {
       CPP.Absyn.Edec _edec = (CPP.Absyn.Edec) foo;
       render("(");
       render("Edec");
       sh(_edec.exp_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EDeref)
    {
       CPP.Absyn.EDeref _ederef = (CPP.Absyn.EDeref) foo;
       render("(");
       render("EDeref");
       sh(_ederef.exp_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ENeg)
    {
       CPP.Absyn.ENeg _eneg = (CPP.Absyn.ENeg) foo;
       render("(");
       render("ENeg");
       sh(_eneg.exp_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EMul)
    {
       CPP.Absyn.EMul _emul = (CPP.Absyn.EMul) foo;
       render("(");
       render("EMul");
       sh(_emul.exp_1);
       sh(_emul.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EDiv)
    {
       CPP.Absyn.EDiv _ediv = (CPP.Absyn.EDiv) foo;
       render("(");
       render("EDiv");
       sh(_ediv.exp_1);
       sh(_ediv.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EMod)
    {
       CPP.Absyn.EMod _emod = (CPP.Absyn.EMod) foo;
       render("(");
       render("EMod");
       sh(_emod.exp_1);
       sh(_emod.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EAdd)
    {
       CPP.Absyn.EAdd _eadd = (CPP.Absyn.EAdd) foo;
       render("(");
       render("EAdd");
       sh(_eadd.exp_1);
       sh(_eadd.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ESub)
    {
       CPP.Absyn.ESub _esub = (CPP.Absyn.ESub) foo;
       render("(");
       render("ESub");
       sh(_esub.exp_1);
       sh(_esub.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ELShift)
    {
       CPP.Absyn.ELShift _elshift = (CPP.Absyn.ELShift) foo;
       render("(");
       render("ELShift");
       sh(_elshift.exp_1);
       sh(_elshift.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ERShift)
    {
       CPP.Absyn.ERShift _ershift = (CPP.Absyn.ERShift) foo;
       render("(");
       render("ERShift");
       sh(_ershift.exp_1);
       sh(_ershift.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ELt)
    {
       CPP.Absyn.ELt _elt = (CPP.Absyn.ELt) foo;
       render("(");
       render("ELt");
       sh(_elt.exp_1);
       sh(_elt.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EGt)
    {
       CPP.Absyn.EGt _egt = (CPP.Absyn.EGt) foo;
       render("(");
       render("EGt");
       sh(_egt.exp_1);
       sh(_egt.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ELteq)
    {
       CPP.Absyn.ELteq _elteq = (CPP.Absyn.ELteq) foo;
       render("(");
       render("ELteq");
       sh(_elteq.exp_1);
       sh(_elteq.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EGteq)
    {
       CPP.Absyn.EGteq _egteq = (CPP.Absyn.EGteq) foo;
       render("(");
       render("EGteq");
       sh(_egteq.exp_1);
       sh(_egteq.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EEq)
    {
       CPP.Absyn.EEq _eeq = (CPP.Absyn.EEq) foo;
       render("(");
       render("EEq");
       sh(_eeq.exp_1);
       sh(_eeq.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ENeq)
    {
       CPP.Absyn.ENeq _eneq = (CPP.Absyn.ENeq) foo;
       render("(");
       render("ENeq");
       sh(_eneq.exp_1);
       sh(_eneq.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EConj)
    {
       CPP.Absyn.EConj _econj = (CPP.Absyn.EConj) foo;
       render("(");
       render("EConj");
       sh(_econj.exp_1);
       sh(_econj.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EDisj)
    {
       CPP.Absyn.EDisj _edisj = (CPP.Absyn.EDisj) foo;
       render("(");
       render("EDisj");
       sh(_edisj.exp_1);
       sh(_edisj.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EAss)
    {
       CPP.Absyn.EAss _eass = (CPP.Absyn.EAss) foo;
       render("(");
       render("EAss");
       sh(_eass.exp_1);
       sh(_eass.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EAssp)
    {
       CPP.Absyn.EAssp _eassp = (CPP.Absyn.EAssp) foo;
       render("(");
       render("EAssp");
       sh(_eassp.exp_1);
       sh(_eassp.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EAssm)
    {
       CPP.Absyn.EAssm _eassm = (CPP.Absyn.EAssm) foo;
       render("(");
       render("EAssm");
       sh(_eassm.exp_1);
       sh(_eassm.exp_2);
       render(")");
    }
    if (foo instanceof CPP.Absyn.ECond)
    {
       CPP.Absyn.ECond _econd = (CPP.Absyn.ECond) foo;
       render("(");
       render("ECond");
       sh(_econd.exp_1);
       sh(_econd.exp_2);
       sh(_econd.exp_3);
       render(")");
    }
    if (foo instanceof CPP.Absyn.EThrow)
    {
       CPP.Absyn.EThrow _ethrow = (CPP.Absyn.EThrow) foo;
       render("(");
       render("EThrow");
       sh(_ethrow.exp_);
       render(")");
    }
  }

  private static void sh(CPP.Absyn.ListExp foo)
  {
     for (java.util.Iterator<Exp> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(CPP.Absyn.ListString foo)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(CPP.Absyn.Type foo)
  {
    if (foo instanceof CPP.Absyn.Ttype1)
    {
       CPP.Absyn.Ttype1 _ttype1 = (CPP.Absyn.Ttype1) foo;
       render("(");
       render("Ttype1");
       sh(_ttype1.type_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.Ttype2)
    {
       CPP.Absyn.Ttype2 _ttype2 = (CPP.Absyn.Ttype2) foo;
       render("(");
       render("Ttype2");
       sh(_ttype2.type_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.Ttype3)
    {
       CPP.Absyn.Ttype3 _ttype3 = (CPP.Absyn.Ttype3) foo;
       render("(");
       render("Ttype3");
       sh(_ttype3.type_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.Ttype4)
    {
       CPP.Absyn.Ttype4 _ttype4 = (CPP.Absyn.Ttype4) foo;
       render("(");
       render("Ttype4");
       sh(_ttype4.type_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.Tbool)
    {
       CPP.Absyn.Tbool _tbool = (CPP.Absyn.Tbool) foo;
       render("Tbool");
    }
    if (foo instanceof CPP.Absyn.Tdouble)
    {
       CPP.Absyn.Tdouble _tdouble = (CPP.Absyn.Tdouble) foo;
       render("Tdouble");
    }
    if (foo instanceof CPP.Absyn.Tint)
    {
       CPP.Absyn.Tint _tint = (CPP.Absyn.Tint) foo;
       render("Tint");
    }
    if (foo instanceof CPP.Absyn.Tvoid)
    {
       CPP.Absyn.Tvoid _tvoid = (CPP.Absyn.Tvoid) foo;
       render("Tvoid");
    }
    if (foo instanceof CPP.Absyn.Tid)
    {
       CPP.Absyn.Tid _tid = (CPP.Absyn.Tid) foo;
       render("(");
       render("Tid");
       render("[");
       sh(_tid.listid_);
       render("]");
       render(")");
    }
  }

  private static void sh(CPP.Absyn.TypeN foo)
  {
    if (foo instanceof CPP.Absyn.Tname1)
    {
       CPP.Absyn.Tname1 _tname1 = (CPP.Absyn.Tname1) foo;
       render("(");
       render("Tname1");
       sh(_tname1.id_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.Tname2)
    {
       CPP.Absyn.Tname2 _tname2 = (CPP.Absyn.Tname2) foo;
       render("(");
       render("Tname2");
       sh(_tname2.type_);
       sh(_tname2.id_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.Tnameinit1)
    {
       CPP.Absyn.Tnameinit1 _tnameinit1 = (CPP.Absyn.Tnameinit1) foo;
       render("(");
       render("Tnameinit1");
       sh(_tnameinit1.id_);
       sh(_tnameinit1.exp_);
       render(")");
    }
    if (foo instanceof CPP.Absyn.Tnameinit2)
    {
       CPP.Absyn.Tnameinit2 _tnameinit2 = (CPP.Absyn.Tnameinit2) foo;
       render("(");
       render("Tnameinit2");
       sh(_tnameinit2.type_);
       sh(_tnameinit2.id_);
       sh(_tnameinit2.exp_);
       render(")");
    }
  }

  private static void sh(CPP.Absyn.ListTypeN foo)
  {
     for (java.util.Iterator<TypeN> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(CPP.Absyn.ListId foo)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

