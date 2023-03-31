public class PrintList implements Token{
    Expression expr;
    PrintList pp;
    public PrintList(Expression e){
        this.expr = e;
        this.pp = null;
    }
    public PrintList(Expression e, PrintList pl){
        this.expr = e;
        this.pp = pl;
    }
    public String toString(int t){
        if(pp == null){
            return expr.toString(t);
        }
        return expr.toString(t) + ", " + pp.toString(t);
    }
}
