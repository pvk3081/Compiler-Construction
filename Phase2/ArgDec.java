public class ArgDec implements Token {
    String s1;
    String s2;
    boolean s3;

    public ArgDec(String s1, String s2, boolean s3){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    
    public String toString(int t){
        return s1 + " " + s2 + (s3 ? "[]" : "");
    }
    
}
