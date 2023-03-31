public class Printlinelist implements Token {
    PrintList pl;
    public Printlinelist(PrintList pl){
        this.pl = pl;
    }

    public Printlinelist(){
        this.pl = null;
    }

    public String toString(int t){
        if (pl == null){
        return "" ;
        }
    return pl.toString(t); 
    }
    
}
