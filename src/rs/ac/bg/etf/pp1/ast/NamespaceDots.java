// generated with ast extension for cup
// version 0.8
// 2/0/2024 21:45:0


package rs.ac.bg.etf.pp1.ast;

public class NamespaceDots implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String nsName;

    public NamespaceDots (String nsName) {
        this.nsName=nsName;
    }

    public String getNsName() {
        return nsName;
    }

    public void setNsName(String nsName) {
        this.nsName=nsName;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
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
        buffer.append("NamespaceDots(\n");

        buffer.append(" "+tab+nsName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NamespaceDots]");
        return buffer.toString();
    }
}
