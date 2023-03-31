public class FieldDeclarations implements Token{
    FieldDeclarations fd1;
    FieldDeclare fd2;

    public FieldDeclarations(){
        this.fd1 = null;
    }

    public FieldDeclarations(FieldDeclare fd, FieldDeclarations fds){
        this.fd1 = fds;
        this.fd2 = fd;
    }
    public String toString(int t) 
    {
        if (fd1 == null && fd2 == null)
            return "";
            return fd2.toString(t) + (fd1 == null ? "" : fd1.toString(t));
        //return fielddecl.toString(t) + (fielddecls == null ? "" : fielddecls.toString(t));
        // if (fielddecls != null)
        //     return fielddecl.toString(t) + fielddecls.toString(t);
        // else
        //     return fielddecl.toString(t);

    }
}
