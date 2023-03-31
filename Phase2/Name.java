public class Name implements Token {
    String idd;
    Expression exp;

    public Name(String id){
        this.idd = id;
        this.exp = null;
    }

    public Name(String id, Expression e){
        this.idd = id;
        this.exp = e;
    }

    public String toString(int t)
    {
      return idd + ( exp == null ? "" : "[" + exp.toString(t) + "]");
    }
}
