JAVAC=javac
JAVAC_FLAGS=-sourcepath .
JAVA=java
JAVA_FLAGS=
PARSER=${JAVA} ${JAVA_FLAGS} java_cup.Main
PARSER_FLAGS=-nopositions -expect 100
LEXER=${JAVA} ${JAVA_FLAGS} JLex.Main
LEXER_FLAGS=
all: test

test: absyn Calc/Yylex.class Calc/PrettyPrinter.class Calc/Test.class Calc/ComposVisitor.class Calc/AbstractVisitor.class Calc/FoldVisitor.class Calc/AllVisitor.class Calc/parser.class Calc/sym.class Calc/Test.class

.PHONY: absyn

%.class: %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn: Calc/Absyn/Exp.java Calc/Absyn/EAdd.java Calc/Absyn/ESub.java Calc/Absyn/EMul.java Calc/Absyn/EDiv.java Calc/Absyn/EInt.java
	${JAVAC} ${JAVAC_FLAGS} $^

Calc/Yylex.java: Calc/Yylex
	${LEXER} ${LEXER_FLAGS} Calc/Yylex

Calc/parser.java Calc/sym.java: Calc/_cup.cup
	${PARSER} ${PARSER_FLAGS} Calc/_cup.cup
	mv parser.java sym.java Calc/

Calc/Yylex.class: Calc/Yylex.java Calc/parser.java Calc/sym.java

Calc/sym.class: Calc/sym.java

Calc/parser.class: Calc/parser.java Calc/sym.java

Calc/PrettyPrinter.class: Calc/PrettyPrinter.java

clean:
	rm -f Calc/Absyn/*.class Calc/*.class

distclean: vclean

vclean:
	 rm -f Calc/Absyn/Exp.java Calc/Absyn/EAdd.java Calc/Absyn/ESub.java Calc/Absyn/EMul.java Calc/Absyn/EDiv.java Calc/Absyn/EInt.java Calc/Absyn/Exp.class Calc/Absyn/EAdd.class Calc/Absyn/ESub.class Calc/Absyn/EMul.class Calc/Absyn/EDiv.class Calc/Absyn/EInt.class
	 rm -f Calc/Absyn/*.class
	 rmdir Calc/Absyn/
	 rm -f Calc/Yylex Calc/_cup.cup Calc/Yylex.java Calc/VisitSkel.java Calc/ComposVisitor.java Calc/AbstractVisitor.java Calc/FoldVisitor.java Calc/AllVisitor.java Calc/PrettyPrinter.java Calc/Skeleton.java Calc/Test.java Calc/parser.java Calc/sym.java Calc/*.class
	 rm -f Makefile
	 rmdir -p Calc/
