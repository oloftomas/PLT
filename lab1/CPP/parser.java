
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Wed Nov 08 15:27:10 CET 2017
//----------------------------------------------------

package CPP;


/** CUP v0.10k generated parser.
  * @version Wed Nov 08 15:27:10 CET 2017
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\061\000\002\002\004\000\002\003\003\000\002\004" +
    "\002\000\002\004\004\000\002\005\012\000\002\006\002" +
    "\000\002\006\003\000\002\006\005\000\002\007\002\000" +
    "\002\007\004\000\002\010\004\000\002\011\004\000\002" +
    "\011\005\000\002\011\007\000\002\011\005\000\002\011" +
    "\007\000\002\011\005\000\002\011\011\000\002\012\003" +
    "\000\002\012\003\000\002\012\003\000\002\012\005\000" +
    "\002\013\005\000\002\013\005\000\002\013\003\000\002" +
    "\014\003\000\002\015\003\000\002\016\003\000\002\017" +
    "\003\000\002\020\003\000\002\021\003\000\002\022\003" +
    "\000\002\023\003\000\002\024\003\000\002\025\003\000" +
    "\002\026\003\000\002\027\003\000\002\030\003\000\002" +
    "\031\003\000\002\032\002\000\002\032\003\000\002\032" +
    "\005\000\002\033\003\000\002\033\003\000\002\033\003" +
    "\000\002\033\003\000\002\033\003\000\002\034\003\000" +
    "\002\034\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\116\000\016\002\uffff\016\uffff\017\uffff\022\uffff\024" +
    "\uffff\025\uffff\001\002\000\004\002\120\001\002\000\016" +
    "\002\000\016\006\017\014\022\013\024\012\025\011\001" +
    "\002\000\004\031\uffd7\001\002\000\004\031\015\001\002" +
    "\000\016\002\ufffe\016\ufffe\017\ufffe\022\ufffe\024\ufffe\025" +
    "\ufffe\001\002\000\004\031\uffd3\001\002\000\004\031\uffd4" +
    "\001\002\000\004\031\uffd5\001\002\000\004\031\uffd6\001" +
    "\002\000\004\004\016\001\002\000\016\005\ufffc\016\006" +
    "\017\014\022\013\024\012\025\011\001\002\000\004\031" +
    "\117\001\002\000\006\005\ufffb\010\115\001\002\000\004" +
    "\005\022\001\002\000\004\006\023\001\002\000\036\004" +
    "\ufff9\006\ufff9\007\ufff9\016\ufff9\017\ufff9\021\ufff9\022\ufff9" +
    "\023\ufff9\024\ufff9\025\ufff9\026\ufff9\027\ufff9\030\ufff9\031" +
    "\ufff9\001\002\000\036\004\044\006\041\007\037\016\006" +
    "\017\014\021\035\022\013\023\034\024\012\025\011\026" +
    "\033\027\030\030\025\031\053\001\002\000\012\005\uffef" +
    "\011\uffef\013\uffef\014\uffef\001\002\000\012\005\uffde\011" +
    "\uffde\013\uffde\014\uffde\001\002\000\012\005\uffe9\011\uffe9" +
    "\013\uffe9\014\uffe9\001\002\000\012\005\uffee\011\uffee\013" +
    "\uffee\014\uffee\001\002\000\012\005\uffdf\011\uffdf\013\112" +
    "\014\111\001\002\000\036\004\ufff8\006\ufff8\007\ufff8\016" +
    "\ufff8\017\ufff8\021\ufff8\022\ufff8\023\ufff8\024\ufff8\025\ufff8" +
    "\026\ufff8\027\ufff8\030\ufff8\031\ufff8\001\002\000\004\004" +
    "\105\001\002\000\012\004\044\027\030\030\025\031\053" +
    "\001\002\000\004\004\075\001\002\000\004\031\070\001" +
    "\002\000\016\002\ufffd\016\ufffd\017\ufffd\022\ufffd\024\ufffd" +
    "\025\ufffd\001\002\000\006\005\uffe0\011\uffe0\001\002\000" +
    "\036\004\ufff9\006\ufff9\007\ufff9\016\ufff9\017\ufff9\021\ufff9" +
    "\022\ufff9\023\ufff9\024\ufff9\025\ufff9\026\ufff9\027\ufff9\030" +
    "\ufff9\031\ufff9\001\002\000\006\005\uffe1\011\uffe1\001\002" +
    "\000\006\005\uffe2\011\uffe2\001\002\000\012\004\044\027" +
    "\030\030\025\031\053\001\002\000\006\005\uffe3\011\uffe3" +
    "\001\002\000\004\011\063\001\002\000\006\005\uffe4\011" +
    "\uffe4\001\002\000\006\005\uffe5\011\uffe5\001\002\000\006" +
    "\005\uffe6\011\uffe6\001\002\000\006\005\uffe7\011\uffe7\001" +
    "\002\000\014\005\uffd2\011\uffd2\013\uffd2\014\uffd2\015\061" +
    "\001\002\000\006\005\uffe8\011\uffe8\001\002\000\012\005" +
    "\uffed\011\uffed\013\uffed\014\uffed\001\002\000\012\005\uffdb" +
    "\011\uffdb\013\uffdb\014\uffdb\001\002\000\012\005\uffdc\011" +
    "\uffdc\013\uffdc\014\uffdc\001\002\000\012\005\uffdd\011\uffdd" +
    "\013\uffdd\014\uffdd\001\002\000\004\031\053\001\002\000" +
    "\012\005\uffd1\011\uffd1\013\uffd1\014\uffd1\001\002\000\040" +
    "\004\ufff6\006\ufff6\007\ufff6\016\ufff6\017\ufff6\020\ufff6\021" +
    "\ufff6\022\ufff6\023\ufff6\024\ufff6\025\ufff6\026\ufff6\027\ufff6" +
    "\030\ufff6\031\ufff6\001\002\000\004\005\065\001\002\000" +
    "\012\005\uffec\011\uffec\013\uffec\014\uffec\001\002\000\036" +
    "\004\044\006\041\007\067\016\006\017\014\021\035\022" +
    "\013\023\034\024\012\025\011\026\033\027\030\030\025" +
    "\031\053\001\002\000\040\004\ufff1\006\ufff1\007\ufff1\016" +
    "\ufff1\017\ufff1\020\ufff1\021\ufff1\022\ufff1\023\ufff1\024\ufff1" +
    "\025\ufff1\026\ufff1\027\ufff1\030\ufff1\031\ufff1\001\002\000" +
    "\006\011\072\012\071\001\002\000\012\004\044\027\030" +
    "\030\025\031\053\001\002\000\040\004\ufff5\006\ufff5\007" +
    "\ufff5\016\ufff5\017\ufff5\020\ufff5\021\ufff5\022\ufff5\023\ufff5" +
    "\024\ufff5\025\ufff5\026\ufff5\027\ufff5\030\ufff5\031\ufff5\001" +
    "\002\000\004\011\074\001\002\000\040\004\ufff4\006\ufff4" +
    "\007\ufff4\016\ufff4\017\ufff4\020\ufff4\021\ufff4\022\ufff4\023" +
    "\ufff4\024\ufff4\025\ufff4\026\ufff4\027\ufff4\030\ufff4\031\ufff4" +
    "\001\002\000\012\004\044\027\030\030\025\031\053\001" +
    "\002\000\004\005\077\001\002\000\034\004\044\006\041" +
    "\016\006\017\014\021\035\022\013\023\034\024\012\025" +
    "\011\026\033\027\030\030\025\031\053\001\002\000\004" +
    "\020\101\001\002\000\034\004\044\006\041\016\006\017" +
    "\014\021\035\022\013\023\034\024\012\025\011\026\033" +
    "\027\030\030\025\031\053\001\002\000\040\004\ufff0\006" +
    "\ufff0\007\ufff0\016\ufff0\017\ufff0\020\ufff0\021\ufff0\022\ufff0" +
    "\023\ufff0\024\ufff0\025\ufff0\026\ufff0\027\ufff0\030\ufff0\031" +
    "\ufff0\001\002\000\004\011\104\001\002\000\040\004\ufff3" +
    "\006\ufff3\007\ufff3\016\ufff3\017\ufff3\020\ufff3\021\ufff3\022" +
    "\ufff3\023\ufff3\024\ufff3\025\ufff3\026\ufff3\027\ufff3\030\ufff3" +
    "\031\ufff3\001\002\000\012\004\044\027\030\030\025\031" +
    "\053\001\002\000\004\005\107\001\002\000\034\004\044" +
    "\006\041\016\006\017\014\021\035\022\013\023\034\024" +
    "\012\025\011\026\033\027\030\030\025\031\053\001\002" +
    "\000\040\004\ufff2\006\ufff2\007\ufff2\016\ufff2\017\ufff2\020" +
    "\ufff2\021\ufff2\022\ufff2\023\ufff2\024\ufff2\025\ufff2\026\ufff2" +
    "\027\ufff2\030\ufff2\031\ufff2\001\002\000\012\004\044\027" +
    "\030\030\025\031\053\001\002\000\012\004\044\027\030" +
    "\030\025\031\053\001\002\000\012\005\uffeb\011\uffeb\013" +
    "\uffeb\014\uffeb\001\002\000\012\005\uffea\011\uffea\013\uffea" +
    "\014\uffea\001\002\000\016\005\ufffc\016\006\017\014\022" +
    "\013\024\012\025\011\001\002\000\004\005\ufffa\001\002" +
    "\000\006\005\ufff7\010\ufff7\001\002\000\004\002\001\001" +
    "\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\116\000\006\003\003\004\004\001\001\000\002\001" +
    "\001\000\006\005\007\033\006\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\010\006\020\010\017\033\016\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\007\023\001\001\000\050\011\031\012" +
    "\055\013\030\014\045\015\053\016\051\017\050\020\047" +
    "\021\046\022\044\023\042\024\041\025\037\026\026\027" +
    "\025\030\057\031\056\033\035\034\054\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\044\012\055\013\030\014\102\015\053\016\051\017" +
    "\050\020\047\021\046\022\044\023\042\024\041\025\037" +
    "\026\026\027\025\030\057\031\056\034\054\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\007\065\001\001\000\002\001\001\000" +
    "\002\001\001\000\044\012\055\013\030\014\063\015\053" +
    "\016\051\017\050\020\047\021\046\022\044\023\042\024" +
    "\041\025\037\026\026\027\025\030\057\031\056\034\054" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\034\061\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\050\011\031\012\055" +
    "\013\030\014\045\015\053\016\051\017\050\020\047\021" +
    "\046\022\044\023\042\024\041\025\037\026\026\027\025" +
    "\030\057\031\056\033\035\034\054\001\001\000\002\001" +
    "\001\000\002\001\001\000\044\012\055\013\030\014\072" +
    "\015\053\016\051\017\050\020\047\021\046\022\044\023" +
    "\042\024\041\025\037\026\026\027\025\030\057\031\056" +
    "\034\054\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\044\012\055\013\030\014\075\015\053" +
    "\016\051\017\050\020\047\021\046\022\044\023\042\024" +
    "\041\025\037\026\026\027\025\030\057\031\056\034\054" +
    "\001\001\000\002\001\001\000\050\011\077\012\055\013" +
    "\030\014\045\015\053\016\051\017\050\020\047\021\046" +
    "\022\044\023\042\024\041\025\037\026\026\027\025\030" +
    "\057\031\056\033\035\034\054\001\001\000\002\001\001" +
    "\000\050\011\101\012\055\013\030\014\045\015\053\016" +
    "\051\017\050\020\047\021\046\022\044\023\042\024\041" +
    "\025\037\026\026\027\025\030\057\031\056\033\035\034" +
    "\054\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\044\012\055\013\030\014\105\015\053\016" +
    "\051\017\050\020\047\021\046\022\044\023\042\024\041" +
    "\025\037\026\026\027\025\030\057\031\056\034\054\001" +
    "\001\000\002\001\001\000\050\011\107\012\055\013\030" +
    "\014\045\015\053\016\051\017\050\020\047\021\046\022" +
    "\044\023\042\024\041\025\037\026\026\027\025\030\057" +
    "\031\056\033\035\034\054\001\001\000\002\001\001\000" +
    "\016\012\055\026\113\027\025\030\057\031\056\034\054" +
    "\001\001\000\016\012\055\026\112\027\025\030\057\031" +
    "\056\034\054\001\001\000\002\001\001\000\002\001\001" +
    "\000\010\006\115\010\017\033\016\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

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



  public CPP.Absyn.Program pProgram() throws Exception
  {
	java_cup.runtime.Symbol res = parse();
	return (CPP.Absyn.Program) res.value;
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
          case 48: // ListId ::= Id _SYMB_9 ListId 
            {
              CPP.Absyn.ListId RESULT = null;
		String p_1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		CPP.Absyn.ListId p_3 = (CPP.Absyn.ListId)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_3; p_3.addFirst(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(26/*ListId*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 47: // ListId ::= Id 
            {
              CPP.Absyn.ListId RESULT = null;
		String p_1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.ListId(); RESULT.addLast(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(26/*ListId*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // Type ::= _SYMB_17 
            {
              CPP.Absyn.Type RESULT = null;
		 RESULT = new CPP.Absyn.Tvoid(); 
              CUP$parser$result = new java_cup.runtime.Symbol(25/*Type*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // Type ::= _SYMB_16 
            {
              CPP.Absyn.Type RESULT = null;
		 RESULT = new CPP.Absyn.Tstring(); 
              CUP$parser$result = new java_cup.runtime.Symbol(25/*Type*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // Type ::= _SYMB_14 
            {
              CPP.Absyn.Type RESULT = null;
		 RESULT = new CPP.Absyn.Tint(); 
              CUP$parser$result = new java_cup.runtime.Symbol(25/*Type*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // Type ::= _SYMB_11 
            {
              CPP.Absyn.Type RESULT = null;
		 RESULT = new CPP.Absyn.Tdouble(); 
              CUP$parser$result = new java_cup.runtime.Symbol(25/*Type*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // Type ::= _SYMB_10 
            {
              CPP.Absyn.Type RESULT = null;
		 RESULT = new CPP.Absyn.Tbool(); 
              CUP$parser$result = new java_cup.runtime.Symbol(25/*Type*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // ListExp ::= Exp _SYMB_4 ListExp 
            {
              CPP.Absyn.ListExp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		CPP.Absyn.ListExp p_3 = (CPP.Absyn.ListExp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_3; p_3.addFirst(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(24/*ListExp*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // ListExp ::= Exp 
            {
              CPP.Absyn.ListExp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.ListExp(); RESULT.addLast(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(24/*ListExp*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // ListExp ::= 
            {
              CPP.Absyn.ListExp RESULT = null;
		 RESULT = new CPP.Absyn.ListExp(); 
              CUP$parser$result = new java_cup.runtime.Symbol(24/*ListExp*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // Exp14 ::= Exp15 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(23/*Exp14*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // Exp13 ::= Exp14 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(22/*Exp13*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // Exp12 ::= Exp13 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(21/*Exp12*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // Exp11 ::= Exp12 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(20/*Exp11*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // Exp9 ::= Exp10 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(19/*Exp9*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // Exp8 ::= Exp9 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(18/*Exp8*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // Exp7 ::= Exp8 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(17/*Exp7*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // Exp6 ::= Exp7 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(16/*Exp6*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // Exp5 ::= Exp6 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(15/*Exp5*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // Exp4 ::= Exp5 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(14/*Exp4*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // Exp3 ::= Exp4 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(13/*Exp3*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // Exp2 ::= Exp3 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(12/*Exp2*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // Exp1 ::= Exp2 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(11/*Exp1*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // Exp ::= Exp1 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(10/*Exp*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // Exp10 ::= Exp11 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*Exp10*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // Exp10 ::= Exp10 _SYMB_8 Exp11 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		CPP.Absyn.Exp p_3 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.ERShift(p_1,p_3); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*Exp10*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // Exp10 ::= Exp10 _SYMB_7 Exp11 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		CPP.Absyn.Exp p_3 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.ELShift(p_1,p_3); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*Exp10*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // Exp15 ::= _SYMB_0 Exp _SYMB_1 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.Exp p_2 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = p_2; 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*Exp15*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // Exp15 ::= ListId 
            {
              CPP.Absyn.Exp RESULT = null;
		CPP.Absyn.ListId p_1 = (CPP.Absyn.ListId)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.EQcon(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*Exp15*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // Exp15 ::= _STRING_ 
            {
              CPP.Absyn.Exp RESULT = null;
		String p_1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.EString(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*Exp15*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // Exp15 ::= _INTEGER_ 
            {
              CPP.Absyn.Exp RESULT = null;
		Integer p_1 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.EInt(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*Exp15*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // Stm ::= _SYMB_13 _SYMB_0 Exp _SYMB_1 Stm _SYMB_12 Stm 
            {
              CPP.Absyn.Stm RESULT = null;
		CPP.Absyn.Exp p_3 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		CPP.Absyn.Stm p_5 = (CPP.Absyn.Stm)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		CPP.Absyn.Stm p_7 = (CPP.Absyn.Stm)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.SIfElse(p_3,p_5,p_7); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*Stm*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // Stm ::= _SYMB_2 ListStm _SYMB_3 
            {
              CPP.Absyn.Stm RESULT = null;
		CPP.Absyn.ListStm p_2 = (CPP.Absyn.ListStm)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new CPP.Absyn.SBlock(p_2); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*Stm*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // Stm ::= _SYMB_18 _SYMB_0 Exp _SYMB_1 Stm 
            {
              CPP.Absyn.Stm RESULT = null;
		CPP.Absyn.Exp p_3 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		CPP.Absyn.Stm p_5 = (CPP.Absyn.Stm)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.SWhile(p_3,p_5); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*Stm*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // Stm ::= _SYMB_15 Exp _SYMB_5 
            {
              CPP.Absyn.Stm RESULT = null;
		CPP.Absyn.Exp p_2 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new CPP.Absyn.SReturn(p_2); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*Stm*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // Stm ::= Type Id _SYMB_6 Exp _SYMB_5 
            {
              CPP.Absyn.Stm RESULT = null;
		CPP.Absyn.Type p_1 = (CPP.Absyn.Type)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		String p_2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		CPP.Absyn.Exp p_4 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new CPP.Absyn.SInit(p_1,p_2,p_4); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*Stm*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // Stm ::= Type Id _SYMB_5 
            {
              CPP.Absyn.Stm RESULT = null;
		CPP.Absyn.Type p_1 = (CPP.Absyn.Type)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		String p_2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new CPP.Absyn.SDecl(p_1,p_2); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*Stm*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // Stm ::= Exp _SYMB_5 
            {
              CPP.Absyn.Stm RESULT = null;
		CPP.Absyn.Exp p_1 = (CPP.Absyn.Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new CPP.Absyn.SExp(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*Stm*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // Arg ::= Type Id 
            {
              CPP.Absyn.Arg RESULT = null;
		CPP.Absyn.Type p_1 = (CPP.Absyn.Type)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		String p_2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.ADecl(p_1,p_2); 
              CUP$parser$result = new java_cup.runtime.Symbol(6/*Arg*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // ListStm ::= ListStm Stm 
            {
              CPP.Absyn.ListStm RESULT = null;
		CPP.Absyn.ListStm p_1 = (CPP.Absyn.ListStm)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		CPP.Absyn.Stm p_2 = (CPP.Absyn.Stm)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; p_1.addLast(p_2); 
              CUP$parser$result = new java_cup.runtime.Symbol(5/*ListStm*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // ListStm ::= 
            {
              CPP.Absyn.ListStm RESULT = null;
		 RESULT = new CPP.Absyn.ListStm(); 
              CUP$parser$result = new java_cup.runtime.Symbol(5/*ListStm*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ListArg ::= Arg _SYMB_4 ListArg 
            {
              CPP.Absyn.ListArg RESULT = null;
		CPP.Absyn.Arg p_1 = (CPP.Absyn.Arg)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		CPP.Absyn.ListArg p_3 = (CPP.Absyn.ListArg)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_3; p_3.addFirst(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(4/*ListArg*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // ListArg ::= Arg 
            {
              CPP.Absyn.ListArg RESULT = null;
		CPP.Absyn.Arg p_1 = (CPP.Absyn.Arg)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.ListArg(); RESULT.addLast(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(4/*ListArg*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // ListArg ::= 
            {
              CPP.Absyn.ListArg RESULT = null;
		 RESULT = new CPP.Absyn.ListArg(); 
              CUP$parser$result = new java_cup.runtime.Symbol(4/*ListArg*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Def ::= Type Id _SYMB_0 ListArg _SYMB_1 _SYMB_2 ListStm _SYMB_3 
            {
              CPP.Absyn.Def RESULT = null;
		CPP.Absyn.Type p_1 = (CPP.Absyn.Type)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-7)).value;
		String p_2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		CPP.Absyn.ListArg p_4 = (CPP.Absyn.ListArg)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		CPP.Absyn.ListStm p_7 = (CPP.Absyn.ListStm)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new CPP.Absyn.DFun(p_1,p_2,p_4,p_7); 
              CUP$parser$result = new java_cup.runtime.Symbol(3/*Def*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // ListDef ::= ListDef Def 
            {
              CPP.Absyn.ListDef RESULT = null;
		CPP.Absyn.ListDef p_1 = (CPP.Absyn.ListDef)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		CPP.Absyn.Def p_2 = (CPP.Absyn.Def)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = p_1; p_1.addLast(p_2); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*ListDef*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // ListDef ::= 
            {
              CPP.Absyn.ListDef RESULT = null;
		 RESULT = new CPP.Absyn.ListDef(); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*ListDef*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // Program ::= ListDef 
            {
              CPP.Absyn.Program RESULT = null;
		CPP.Absyn.ListDef p_1 = (CPP.Absyn.ListDef)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new CPP.Absyn.Prog(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(1/*Program*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= Program EOF 
            {
              Object RESULT = null;
		CPP.Absyn.Program start_val = (CPP.Absyn.Program)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
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

