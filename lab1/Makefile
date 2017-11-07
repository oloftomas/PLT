JAVAC=javac
JAVAC_FLAGS=-sourcepath .
JAVA=java
JAVA_FLAGS=
PARSER=${JAVA} ${JAVA_FLAGS} java_cup.Main
PARSER_FLAGS=-nopositions -expect 100
LEXER=${JAVA} ${JAVA_FLAGS} JLex.Main
LEXER_FLAGS=
all: test

test: absyn CPP/Yylex.class CPP/PrettyPrinter.class CPP/Test.class CPP/ComposVisitor.class CPP/AbstractVisitor.class CPP/FoldVisitor.class CPP/AllVisitor.class CPP/parser.class CPP/sym.class CPP/Test.class

.PHONY: absyn

%.class: %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn: CPP/Absyn/Program.java CPP/Absyn/PDefs.java CPP/Absyn/ListDef.java CPP/Absyn/Def.java CPP/Absyn/DFun.java CPP/Absyn/ListArg.java CPP/Absyn/ListStm.java CPP/Absyn/Arg.java CPP/Absyn/ADecl.java CPP/Absyn/Stm.java CPP/Absyn/SExp.java CPP/Absyn/SDecl.java CPP/Absyn/SInit.java CPP/Absyn/SReturn.java CPP/Absyn/SWhile.java CPP/Absyn/SBlock.java CPP/Absyn/SIfElse.java CPP/Absyn/Exp.java CPP/Absyn/ListExp.java CPP/Absyn/Type.java CPP/Absyn/Tbool.java CPP/Absyn/Tdouble.java CPP/Absyn/Tint.java CPP/Absyn/Tvoid.java
	${JAVAC} ${JAVAC_FLAGS} $^

CPP/Yylex.java: CPP/Yylex
	${LEXER} ${LEXER_FLAGS} CPP/Yylex

CPP/parser.java CPP/sym.java: CPP/_cup.cup
	${PARSER} ${PARSER_FLAGS} CPP/_cup.cup
	mv parser.java sym.java CPP/

CPP/Yylex.class: CPP/Yylex.java CPP/parser.java CPP/sym.java

CPP/sym.class: CPP/sym.java

CPP/parser.class: CPP/parser.java CPP/sym.java

CPP/PrettyPrinter.class: CPP/PrettyPrinter.java

clean:
	rm -f CPP/Absyn/*.class CPP/*.class

distclean: vclean

vclean:
	 rm -f CPP/Absyn/Program.java CPP/Absyn/PDefs.java CPP/Absyn/ListDef.java CPP/Absyn/Def.java CPP/Absyn/DFun.java CPP/Absyn/ListArg.java CPP/Absyn/ListStm.java CPP/Absyn/Arg.java CPP/Absyn/ADecl.java CPP/Absyn/Stm.java CPP/Absyn/SExp.java CPP/Absyn/SDecl.java CPP/Absyn/SInit.java CPP/Absyn/SReturn.java CPP/Absyn/SWhile.java CPP/Absyn/SBlock.java CPP/Absyn/SIfElse.java CPP/Absyn/Exp.java CPP/Absyn/ListExp.java CPP/Absyn/Type.java CPP/Absyn/Tbool.java CPP/Absyn/Tdouble.java CPP/Absyn/Tint.java CPP/Absyn/Tvoid.java CPP/Absyn/Program.class CPP/Absyn/PDefs.class CPP/Absyn/ListDef.class CPP/Absyn/Def.class CPP/Absyn/DFun.class CPP/Absyn/ListArg.class CPP/Absyn/ListStm.class CPP/Absyn/Arg.class CPP/Absyn/ADecl.class CPP/Absyn/Stm.class CPP/Absyn/SExp.class CPP/Absyn/SDecl.class CPP/Absyn/SInit.class CPP/Absyn/SReturn.class CPP/Absyn/SWhile.class CPP/Absyn/SBlock.class CPP/Absyn/SIfElse.class CPP/Absyn/Exp.class CPP/Absyn/ListExp.class CPP/Absyn/Type.class CPP/Absyn/Tbool.class CPP/Absyn/Tdouble.class CPP/Absyn/Tint.class CPP/Absyn/Tvoid.class
	 rm -f CPP/Absyn/*.class
	 rmdir CPP/Absyn/
	 rm -f CPP/Yylex CPP/_cup.cup CPP/Yylex.java CPP/VisitSkel.java CPP/ComposVisitor.java CPP/AbstractVisitor.java CPP/FoldVisitor.java CPP/AllVisitor.java CPP/PrettyPrinter.java CPP/Skeleton.java CPP/Test.java CPP/parser.java CPP/sym.java CPP/*.class
	 rm -f Makefile
	 rmdir -p CPP/
