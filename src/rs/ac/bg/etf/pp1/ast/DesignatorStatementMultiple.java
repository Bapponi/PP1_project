// generated with ast extension for cup
// version 0.8
// 2/0/2024 17:16:14


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementMultiple implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private DesignatorListB DesignatorListB;
    private ExprListB2 ExprListB2;

    public DesignatorStatementMultiple (DesignatorListB DesignatorListB, ExprListB2 ExprListB2) {
        this.DesignatorListB=DesignatorListB;
        if(DesignatorListB!=null) DesignatorListB.setParent(this);
        this.ExprListB2=ExprListB2;
        if(ExprListB2!=null) ExprListB2.setParent(this);
    }

    public DesignatorListB getDesignatorListB() {
        return DesignatorListB;
    }

    public void setDesignatorListB(DesignatorListB DesignatorListB) {
        this.DesignatorListB=DesignatorListB;
    }

    public ExprListB2 getExprListB2() {
        return ExprListB2;
    }

    public void setExprListB2(ExprListB2 ExprListB2) {
        this.ExprListB2=ExprListB2;
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
        if(DesignatorListB!=null) DesignatorListB.accept(visitor);
        if(ExprListB2!=null) ExprListB2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorListB!=null) DesignatorListB.traverseTopDown(visitor);
        if(ExprListB2!=null) ExprListB2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorListB!=null) DesignatorListB.traverseBottomUp(visitor);
        if(ExprListB2!=null) ExprListB2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementMultiple(\n");

        if(DesignatorListB!=null)
            buffer.append(DesignatorListB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprListB2!=null)
            buffer.append(ExprListB2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementMultiple]");
        return buffer.toString();
    }
}
