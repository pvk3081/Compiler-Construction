public class Expression implements Token {
int intliteral;
int flag = 0;
BinaryOper boo;
Name name;
Args args;
String strch;
String strr;
String pr_op;
float floatlit;
boolean bool;
Expression expr_list[];
String type;
Expression eround;
Expression eone;
Expression etwo;
public Expression(int intlit){
    flag = 4;
    this.intliteral = intlit;
    
}

public Expression(Name name){
    flag = 1;
    this.name = name;
    
}

public Expression(float fll){
    flag = 7;
    this.floatlit = fll;
    
}

public Expression(boolean bll){
    flag = 8;
    this.bool = bll;
    
}

public Expression(String strr , Args args){
    if(args == null){
        flag = 2;
    }
    else{
        flag = 3;
    }
    this.strr = strr;
    this.args = args;
    
}

public Expression(String s1, String s2){
    if("characters".equals(s2)){
        flag = 5;
        this.strch = s1;
    }
    else{
        flag = 6;
        this.strch = s1;
    }
}

public Expression(Expression e1, String s2){
    if("Expr_inround".equals(s2)){
        flag = 9;
        this.eround = e1;
    }
    else if ("~".equals(s2) || "-".equals(s2) || "+".equals(s2)) {
        this.pr_op = s2;
        this.eround = e1;
        flag = 10;
    }
}


public Expression(String tt, Expression e){
    flag = 11;
    this.type = tt;
    eround = e;
}

public Expression(BinaryOper binaryOp){
    this.boo = binaryOp;
    flag = 12;
}

public Expression(Expression e1, BinaryOper binaryOp, Expression e2){
    this.boo = binaryOp;
    this.eone = e1;
    this.etwo = e2;
    flag = 14;
}

public Expression(Expression e1, Expression e2, Expression e3){
    this.expr_list = new Expression[]{e1, e2, e3};
    flag = 13;
}


public String toString(int t){
  
    if(flag == 4){
    return "" + intliteral;
    }
    else if(flag == 12){
        return boo.toString(t);
    }
    else if(flag == 1){
        return name.toString(t);
    }
    else if(flag == 2){
        return strr + "()";
    }
    else if(flag == 3){
        return strr + "(" + args.toString(t) + ")";
    }
    else if(flag == 5 || flag == 6){
        return strch;
    }
    else if(flag == 7){
        return "" + floatlit;
    }
    else if(flag == 8){
        if(bool){
            return "true";
        }
        else{
            return "false";
        }
    }
    else if(flag == 9){
        return "(" + eround.toString(t) + ")";
    }
    else if(flag == 10){
        return "(" + pr_op + " " + eround.toString(t) + ")";
    }
    else if(flag == 11){
        return "(" + type + ")" + eround.toString(t);
    }
    else if(flag == 13){
        return "(" + expr_list[0].toString(t) + " ? " + expr_list[1].toString(t) + " : " + expr_list[2].toString(t) + ")";
    }
    else if(flag == 14){
        return "(" + eone.toString(t) + boo.toString(t) +  etwo.toString(t) + ")";
    }

    else{
    return "";
    }
}
}
