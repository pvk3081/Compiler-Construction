JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
		$(JAVAC) -cp $(CP) $*.java

FILE=    Lexer.java      parser.java    sym.java \
		ScannerTest.java Program.java Token.java   Statement.java ClassMembers.java Statements.java FieldDeclarations.java FieldDeclare.java Name.java  Args.java  ReadList.java 	PrintList.java	Printlinelist.java  Expression.java  BinaryOper.java ArgDecs.java ArgDec.java Member_declarations.java Method_declarations.java Returntype.java Method_declarations_plu.java ArgdecList.java \

run: abc.txt

abc.txt: all
		$(JAVA) -cp $(CP) ScannerTest abc.txt > abc-output.txt
		cat -n abc-output.txt

all: Lexer.java parser.java $(FILE:java=class)

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup
