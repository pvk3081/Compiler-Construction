public class Program implements Token {
  Member_declarations numer;
  String strr;
  
  //Constructor
//public Program(Statement e) {
//    this.numer = e;
//  }

  public Program(String s1, Member_declarations md){
    this.strr = s1;
    this.numer = md;
  }


  public String toString(int t) {
    return "class " + strr + " {\n" + numer.toString(t+1) + "}\n";
  }

}

