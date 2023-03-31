public class Statements implements Token {
    Statement s1;
    Statements s2;
    public Statements(Statement s1, Statements s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    public Statements(){
        this.s1 = null;
        this.s2 = null;
    }

    public String toString(int t){
        return (s1 == null ? "" : s1.toString(t)) + (s2 == null ? "" : s2.toString(t));
        // return (st.toString() + sts.toString());
    }
}
