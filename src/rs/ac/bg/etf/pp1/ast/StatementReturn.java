// generated with ast extension for cup
// version 0.8
// 13/0/2024 18:53:15


package rs.ac.bg.etf.pp1.ast;

public class StatementReturn extends Statement {

    private ExprListB ExprListB;

    public StatementReturn (ExprListB ExprListB) {
        this.ExprListB=ExprListB;
        if(ExprListB!=null) ExprListB.setParent(this);
    }

    public ExprListB getExprListB() {
        return ExprListB;
    }

    public void setExprListB(ExprListB ExprListB) {
        this.ExprListB=ExprListB;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprListB!=null) ExprListB.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprListB!=null) ExprListB.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprListB!=null) ExprListB.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementReturn(\n");

        if(ExprListB!=null)
            buffer.append(ExprListB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementReturn]");
        return buffer.toString();
    }
}
