public class Member_declarations implements Token {
    ClassMembers classMembers;

    public Member_declarations(ClassMembers classMembers){
        this.classMembers = classMembers;
    }

    public String toString(int t){
        return classMembers.toString(t);
    }

}
