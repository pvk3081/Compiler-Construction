public class FieldDeclare implements Token {
    
    boolean isFinal = false;
    String type;
    String ID;
    Expression opExpr;
    int length;
    int cond;

    public FieldDeclare(boolean isFinal, String type, String ID, Expression opExpr){
        this.isFinal = isFinal;
        this.type = type; 
        this.ID = ID;
        this.opExpr = opExpr;
        cond = 1;
    }

    public FieldDeclare(String type, String ID, int length){
        this.type = type; 
        this.ID = ID;
        this.length = length;
        cond = 2;
    }

    public String toString(int t){
        String tabs = "";
        for (int i = 0; i < t; ++i) tabs += "\t";
        if (cond == 1)
            return tabs + (isFinal ? "final " : "") + type + " " + ID + (opExpr == null ? "" : " = " + opExpr.toString(t)) + ";\n";

        return tabs + type + " " + ID + "[" + length + "]" + ";\n";

    }
}
