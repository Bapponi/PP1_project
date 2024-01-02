// generated with ast extension for cup
// version 0.8
// 2/0/2024 17:16:14


package rs.ac.bg.etf.pp1.ast;

public class StatementPrint extends Statement {

    private Expr Expr;
    private NumConstListB NumConstListB;

    public StatementPrint (Expr Expr, NumConstListB NumConstListB) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.NumConstListB=NumConstListB;
        if(NumConstListB!=null) NumConstListB.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public NumConstListB getNumConstListB() {
        return NumConstListB;
    }

    public void setNumConstListB(NumConstListB NumConstListB) {
        this.NumConstListB=NumConstListB;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(NumConstListB!=null) NumConstListB.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(NumConstListB!=null) NumConstListB.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(NumConstListB!=null) NumConstListB.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementPrint(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NumConstListB!=null)
            buffer.append(NumConstListB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementPrint]");
        return buffer.toString();
    }
}
