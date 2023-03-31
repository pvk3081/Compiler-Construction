public class Returntype implements Token{
    String type;

    public Returntype(){
        this.type = null;
    }

    public Returntype(String t){
        this.type = t;
    }

    public String toString(int t){
        if(type == null){
            return "";
        }
        return type;
    }
    
}
