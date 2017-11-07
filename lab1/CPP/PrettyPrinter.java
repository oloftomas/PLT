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
    if (foo instanceof CPP.Absyn.ADecl)
    {
       CPP.Absyn.ADecl _adecl = (CPP.Absyn.ADecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_adecl.type_, 0);
       pp(_adecl.id_, 0);
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
    else     if (foo instanceof CPP.Absyn.SInit)
    {
       CPP.Absyn.SInit _sinit = (CPP.Absyn.SInit) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sinit.type_, 0);
       pp(_sinit.id_, 0);
       render("=");
       pp(_sinit.exp_, 0);
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
       if (_i_ > 14) render(_L_PAREN);
       printQuoted(_estring.string_);
       if (_i_ > 14) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ELShift)
    {
       CPP.Absyn.ELShift _elshift = (CPP.Absyn.ELShift) foo;
       if (_i_ > 10) render(_L_PAREN);
       pp(_elshift.exp_1, 10);
       render("<<");
       pp(_elshift.exp_2, 11);
       if (_i_ > 10) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.ERShift)
    {
       CPP.Absyn.ERShift _ershift = (CPP.Absyn.ERShift) foo;
       if (_i_ > 10) render(_L_PAREN);
       pp(_ershift.exp_1, 10);
       render(">>");
       pp(_ershift.exp_2, 11);
       if (_i_ > 10) render(_R_PAREN);
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

  private static void pp(CPP.Absyn.Type foo, int _i_)
  {
    if (foo instanceof CPP.Absyn.Tbool)
    {
       CPP.Absyn.Tbool _tbool = (CPP.Absyn.Tbool) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("bool");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tdouble)
    {
       CPP.Absyn.Tdouble _tdouble = (CPP.Absyn.Tdouble) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("double");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tint)
    {
       CPP.Absyn.Tint _tint = (CPP.Absyn.Tint) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("int");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tstring)
    {
       CPP.Absyn.Tstring _tstring = (CPP.Absyn.Tstring) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("string");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof CPP.Absyn.Tvoid)
    {
       CPP.Absyn.Tvoid _tvoid = (CPP.Absyn.Tvoid) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("void");
       if (_i_ > 0) render(_R_PAREN);
    }
  }


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
    if (foo instanceof CPP.Absyn.ADecl)
    {
       CPP.Absyn.ADecl _adecl = (CPP.Absyn.ADecl) foo;
       render("(");
       render("ADecl");
       sh(_adecl.type_);
       sh(_adecl.id_);
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
    if (foo instanceof CPP.Absyn.SInit)
    {
       CPP.Absyn.SInit _sinit = (CPP.Absyn.SInit) foo;
       render("(");
       render("SInit");
       sh(_sinit.type_);
       sh(_sinit.id_);
       sh(_sinit.exp_);
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
       sh(_estring.string_);
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

  private static void sh(CPP.Absyn.Type foo)
  {
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
    if (foo instanceof CPP.Absyn.Tstring)
    {
       CPP.Absyn.Tstring _tstring = (CPP.Absyn.Tstring) foo;
       render("Tstring");
    }
    if (foo instanceof CPP.Absyn.Tvoid)
    {
       CPP.Absyn.Tvoid _tvoid = (CPP.Absyn.Tvoid) foo;
       render("Tvoid");
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

