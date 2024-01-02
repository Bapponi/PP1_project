// generated with ast extension for cup
// version 0.8
// 2/0/2024 21:45:0


package rs.ac.bg.etf.pp1.ast;

public class NoNamespaceList extends NamespaceList {

    public NoNamespaceList () {
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
        buffer.append("NoNamespaceList(\n");

        buffer.append(tab);
        buffer.append(") [NoNamespaceList]");
        return buffer.toString();
    }
}
