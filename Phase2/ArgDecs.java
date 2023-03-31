public class ArgDecs implements Token {
    ArgdecList al;

    public ArgDecs(){
        this.al = null;
    }

   public ArgDecs( ArgdecList al){
    this.al = al;
   }

   public String toString(int t){
        
    if (al == null)
        return "";
    return al.toString(t);
}

}
