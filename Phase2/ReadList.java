public class ReadList implements Token {
    Name n;
    ReadList rL;

    public ReadList(Name n, ReadList rL) {
        this.n = n;
        this.rL = rL;
    }

    public ReadList(Name n) {
        this.n = n;
        this.rL = null;
    }

    public String toString(int t) {
        if (rL == null)
            return n.toString(t);
        return n.toString(t) + ", " + rL.toString(t);
    }
    
}
