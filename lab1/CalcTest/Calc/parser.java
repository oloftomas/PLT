
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Fri Nov 03 16:42:33 CET 2017
//----------------------------------------------------

package Calc;


/** CUP v0.10k generated parser.
  * @version Fri Nov 03 16:42:33 CET 2017
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\011\000\002\002\004\000\002\003\005\000\002\003" +
    "\005\000\002\003\003\000\002\004\005\000\002\004\005" +
    "\000\002\004\003\000\002\005\003\000\002\005\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\006\010\004\012\007\001\002\000\006\010" +
    "\004\012\007\001\002\000\016\002\ufffb\004\ufffb\005\ufffb" +
    "\006\ufffb\007\ufffb\011\ufffb\001\002\000\016\002\ufffe\004" +
    "\ufffe\005\ufffe\006\016\007\015\011\ufffe\001\002\000\016" +
    "\002\ufffa\004\ufffa\005\ufffa\006\ufffa\007\ufffa\011\ufffa\001" +
    "\002\000\010\002\013\004\012\005\011\001\002\000\006" +
    "\010\004\012\007\001\002\000\006\010\004\012\007\001" +
    "\002\000\004\002\001\001\002\000\016\002\000\004\000" +
    "\005\000\006\016\007\015\011\000\001\002\000\006\010" +
    "\004\012\007\001\002\000\006\010\004\012\007\001\002" +
    "\000\016\002\ufffd\004\ufffd\005\ufffd\006\ufffd\007\ufffd\011" +
    "\ufffd\001\002\000\016\002\ufffc\004\ufffc\005\ufffc\006\ufffc" +
    "\007\ufffc\011\ufffc\001\002\000\016\002\uffff\004\uffff\005" +
    "\uffff\006\016\007\015\011\uffff\001\002\000\010\004\012" +
    "\005\011\011\023\001\002\000\016\002\ufff9\004\ufff9\005" +
    "\ufff9\006\ufff9\007\ufff9\011\ufff9\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\010\003\007\004\005\005\004\001\001\000" +
    "\010\003\021\004\005\005\004\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\004\020\005\004\001\001\000\006\004\013\005\004" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\005" +
    "\017\001\001\000\004\005\016\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



  public Calc.Absyn.Exp pExp() throws Exception
  {
	java_cup.runtime.Symbol res = parse();
	return (Calc.Absyn.Exp) res.value;
  }

public <B,A extends java.util.LinkedList<? super B>> A cons_(B x, A xs) { xs.addFirst(x); return xs; }

public void syntax_error(java_cup.runtime.Symbol cur_token)
{
	report_error("Syntax Error, trying to recover and continue parse...", cur_token);
}

public void unrecovered_syntax_error(java_cup.runtime.Symbol cur_token) throws java.lang.Exception
{
	throw new Exception("Unrecoverable Syntax Error");
}


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Exp2 ::= _SYMB_4 Exp _SYMB_5 
            {
              Calc.Absyn.Exp RESULT = null;
		Calc.Absyn.Exp p_2 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = p_2; 
              CUP$parser$result = new java_cup.runtime.Symbol(3/*Exp2*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // Exp2 ::= _INTEGER_ 
            {
              Calc.Absyn.Exp RESULT = null;
		Integer p_1 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Calc.Absyn.EInt(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(3/*Exp2*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Exp1 ::= Exp2 
            {
              Calc.Absyn.Exp RESULT = null;
		Calc.Absyn.Exp p_1 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*Exp1*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Exp1 ::= Exp1 _SYMB_3 Exp2 
            {
              Calc.Absyn.Exp RESULT = null;
		Calc.Absyn.Exp p_1 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Calc.Absyn.Exp p_3 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Calc.Absyn.EDiv(p_1,p_3); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*Exp1*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Exp1 ::= Exp1 _SYMB_2 Exp2 
            {
              Calc.Absyn.Exp RESULT = null;
		Calc.Absyn.Exp p_1 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Calc.Absyn.Exp p_3 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Calc.Absyn.EMul(p_1,p_3); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*Exp1*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Exp ::= Exp1 
            {
              Calc.Absyn.Exp RESULT = null;
		Calc.Absyn.Exp p_1 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(1/*Exp*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Exp ::= Exp _SYMB_1 Exp1 
            {
              Calc.Absyn.Exp RESULT = null;
		Calc.Absyn.Exp p_1 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Calc.Absyn.Exp p_3 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Calc.Absyn.ESub(p_1,p_3); 
              CUP$parser$result = new java_cup.runtime.Symbol(1/*Exp*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // Exp ::= Exp _SYMB_0 Exp1 
            {
              Calc.Absyn.Exp RESULT = null;
		Calc.Absyn.Exp p_1 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Calc.Absyn.Exp p_3 = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Calc.Absyn.EAdd(p_1,p_3); 
              CUP$parser$result = new java_cup.runtime.Symbol(1/*Exp*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= Exp EOF 
            {
              Object RESULT = null;
		Calc.Absyn.Exp start_val = (Calc.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = new java_cup.runtime.Symbol(0/*$START*/, RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}
