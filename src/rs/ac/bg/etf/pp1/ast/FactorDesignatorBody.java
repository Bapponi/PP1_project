// generated with ast extension for cup
// version 0.8
// 16/0/2024 20:44:56


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignatorBody implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ActParsListB ActParsListB;

    public FactorDesignatorBody (ActParsListB ActParsListB) {
        this.ActParsListB=ActParsListB;
        if(ActParsListB!=null) ActParsListB.setParent(this);
    }

    public ActParsListB getActParsListB() {
        return ActParsListB;
    }

    public void setActParsListB(ActParsListB ActParsListB) {
        this.ActParsListB=ActParsListB;
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
        if(ActParsListB!=null) ActParsListB.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsListB!=null) ActParsListB.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsListB!=null) ActParsListB.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignatorBody(\n");

        if(ActParsListB!=null)
            buffer.append(ActParsListB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignatorBody]");
        return buffer.toString();
    }
}
