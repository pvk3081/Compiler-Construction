public class Method_declarations_plu implements Token {
    
    Method_declarations md;
    Method_declarations_plu mdp;
    public Method_declarations_plu(Method_declarations md, Method_declarations_plu mdp){
        this.md = md;
        this.mdp = mdp;
    }

    public Method_declarations_plu(Method_declarations md){
        this.md = md;
        
    }

    public Method_declarations_plu(){
        this.md = null;
        this.mdp = null;
    }

    public String toString(int t){
        return (md == null ? "" : md.toString(t)) + (mdp == null ? "" : mdp.toString(t));
    }
}
