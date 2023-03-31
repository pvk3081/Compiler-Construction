public class Method_declarations implements Token {
    String rt;
    String s1;
    ArgDecs ads;
    FieldDeclarations fd;
    Statements s;
    boolean flag;

    public Method_declarations( String rt,String s1, ArgDecs ads,FieldDeclarations fd, Statements s2, boolean flag){
        this.rt = rt;
        this.s1 = s1;
        this.ads = ads;
        this.fd = fd;
        this.s = s2;
        this.flag = flag;
    }


    public String toString(int t)
    {
        if(rt == null && s1 == null && ads == null){
            return "";
        }
        String tab_space= "";
        for(int i=0;i<t;++i)
        {
            tab_space += "\t";
        }
        
        return tab_space  + rt + " " + s1 + "(" + ads.toString(t) +")\n"+ tab_space + "{\n" + fd.toString(t+1) + s.toString(t+1) + tab_space + "}" + ( flag ? ";" : "" ) + "\n\n";
    }


    
}
