public class Args implements Token {
    Expression exp;
    Args arg;

    public Args(Expression expr, Args arg)
    {
        this.exp = expr;
        this.arg = arg;
    }
 
    public Args(Expression e){
        this.exp = e;
        this.arg = null;
    }

    public Args(){
        this.exp = null;
        this.arg = null;
    }

    public String toString(int t)
    {
        if (arg == null && exp == null){
            return "";
        }
        return exp.toString(t) + (arg == null ? "" : (", " + arg.toString(t)));
    }
    
}
