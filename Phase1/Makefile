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
    LexerTest.java

run: abc.txt

abc.txt: all
		$(JAVA) -cp $(CP) LexerTest abc.txt > abc-output.txt
		cat -n abc-output.txt

basicTerminals.txt: all
		$(JAVA) -cp $(CP) LexerTest basicTerminals.txt > abc-output.txt
		cat -n abc-output.txt

basicRegex.txt: all
		$(JAVA) -cp $(CP) LexerTest basicRegex.txt > abc-output.txt
		cat -n abc-output.txt

basicFails.txt: all
		$(JAVA) -cp $(CP) LexerTest basicFails.txt > abc-output.txt
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
