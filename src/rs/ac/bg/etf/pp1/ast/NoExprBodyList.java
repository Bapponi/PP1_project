// generated with ast extension for cup
// version 0.8
// 2/0/2024 18:49:30


package rs.ac.bg.etf.pp1.ast;

public class NoExprBodyList extends ExprBodyList {

    public NoExprBodyList () {
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
        buffer.append("NoExprBodyList(\n");

        buffer.append(tab);
        buffer.append(") [NoExprBodyList]");
        return buffer.toString();
    }
}
