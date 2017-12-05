# Makefile for lab3 in java

JAVAC = javac
JAVAC_FLAGS = -sourcepath .

JAVA = java

.PHONY: lab3 

all: lab3 TypeChecker Compiler

lab3:
	${JAVAC} ${JAVAC_FLAGS} lab3.java 
	chmod a+x lab3

TypeChecker:
	${JAVAC} ${JAVAC_FLAGS} TypeChecker.java 

Compiler:
	${JAVAC} ${JAVAC_FLAGS} Compiler.java

# EOF
