// generated with ast extension for cup
// version 0.8
// 2/0/2024 18:23:9


package rs.ac.bg.etf.pp1.ast;

public class NoActParsListB extends ActParsListB {

    public NoActParsListB () {
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
        buffer.append("NoActParsListB(\n");

        buffer.append(tab);
        buffer.append(") [NoActParsListB]");
        return buffer.toString();
    }
}
