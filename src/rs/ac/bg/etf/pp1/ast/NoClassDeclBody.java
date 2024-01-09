// generated with ast extension for cup
// version 0.8
// 9/0/2024 17:41:17


package rs.ac.bg.etf.pp1.ast;

public class NoClassDeclBody extends ClassDeclBody {

    public NoClassDeclBody () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoClassDeclBody(\n");

        buffer.append(tab);
        buffer.append(") [NoClassDeclBody]");
        return buffer.toString();
    }
}
