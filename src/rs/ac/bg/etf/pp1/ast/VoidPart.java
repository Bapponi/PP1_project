// generated with ast extension for cup
// version 0.8
// 3/0/2024 21:15:7


package rs.ac.bg.etf.pp1.ast;

public class VoidPart extends VoidOrType {

    public VoidPart () {
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
        buffer.append("VoidPart(\n");

        buffer.append(tab);
        buffer.append(") [VoidPart]");
        return buffer.toString();
    }
}
