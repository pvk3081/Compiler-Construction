public class Statement implements Token {
    Expression exp;
    Statement st;
    Statement st2;
    PrintList pll;
    Printlinelist print_ll;
    ReadList rll;
    String id;
    Name name;
    int flag = 0;
    int cond;
    Args args;
    String op;
    Expression ee1;
    Expression ee2;
    Expression ee3;
    Statement st3;
    Boolean optionalsemi;
    FieldDeclarations fd;

    public Statement(){
        flag = 9;
        cond = 9;
    }
    public Statement(Expression e1, Statement s1, Statement s2){
        this.exp  =e1;
        this.st = s1;
        this.st2 = s2;
        flag = 1;
        cond = 1;
    }

    public Statement(Expression e1, Statement s1){
        this.exp = e1;
        this.st = s1;
        flag = 2;
        cond = 2;
    }

    public Statement(Name n1, Expression e1){
        this.name = n1;
        this.exp = e1;
        flag = 3;
        cond = 3;
    }

    public Statement(PrintList pll){
        this.pll = pll;
        flag = 4;
        cond = 4;
    }

    public Statement(ReadList rll){
        this.rll = rll;
        flag = 5;
        cond = 5;
    }

    public Statement(Printlinelist pll){
        this.print_ll = pll;
        flag = 6;
        cond = 6;
    }

    public Statement(String idd){
        this.id = idd;
        flag = 7;
        cond = 7;
    }

    public Statement(String strr,Args arr){
        this.id = strr;
        this.args = arr;
        flag = 8;
        cond = 8;
    }

    public Statement(Expression expr){
        this.exp = expr;
        flag = 10;
        cond = 10;
    }

    public Statement(Name nn, String ss){
        this.name = nn;
        this.op = ss;
        flag = 11;
        cond = 11;
    }
    
    public Statement(FieldDeclarations f1, Statement s1, Boolean b1){
        this.fd = f1;
        this.st3 = s1;
        this.optionalsemi = b1;
        flag = 12;
        cond = 12;
    }
    

    public String toString(int t){
        String tabs = "";
        for (int i = 0; i < t; ++i) {
            tabs += "\t";
        }

        String ret = "";
        if(flag == 1){
            ret = tabs + "if (" + exp.toString(t) + ")\n" +
                        (st.cond == 12 ? st.toString(t) : tabs + "{\n" + st.toString(t+1) + tabs + "}\n") +
                        ((st2 == null ? "" : tabs + "else\n" + ( st2.cond == 12 ? st2.toString(t) : tabs + "{\n" + st2.toString(t+1) + tabs + "}\n")));
                return ret;
        }

        else if(flag == 2){
            return tabs + "while (" + exp.toString(t) + ")\n" + (st.cond == 12 ? st.toString(t) : tabs + "{\n" + st.toString(t+1) + tabs + "}\n");
        }
        else if(flag == 3){
            return tabs + name.toString(t) + " = " + exp.toString(t) + ";\n";
        }

        else if(flag == 4){
            return  tabs + "print(" + pll.toString(t) + ");\n";
        }
        else if(flag == 5){
            return  tabs + "read(" + rll.toString(t) + ");\n";
        }
        else if(flag == 6){
            return tabs + "printline(" + print_ll.toString(t) + ");\n";
        }
        else if(flag == 7){
            return tabs + id + "();\n";
        }
        else if (flag == 8){
            return tabs + id + "(" + args.toString(t) + ");\n";
        }
        else if(flag == 9){
            return tabs + "return;\n";
        }
        else if(flag == 10){
            return tabs + "return " + exp.toString(t) + ";\n";
        }
        else if(flag == 11){
            return tabs + name.toString(t) + op + ";\n";
        }
        else if(flag == 12){
            ret = tabs + "{\n";
            ret += fd.toString(t+1);
            ret += st3.toString(t+1);
            ret += tabs;
            ret += "}";
            ret += (optionalsemi == false ? "\n" : ";\n");
            return ret;
        }
        return "";

    }

}
