public class BinaryOper implements Token {
    Expression n1;
    Expression n2;
    String op;
    
    public BinaryOper(Expression num1,Expression num2, String oper){
        this.n1 = num1;
        this.n2 = num2;
        this.op = oper;
    }

    public String toString(int t){
        return "(" + n1.toString(t) + " " + op + " " + n2.toString(t) + ")";
    }
}
