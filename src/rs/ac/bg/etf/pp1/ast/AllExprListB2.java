// generated with ast extension for cup
// version 0.8
// 2/0/2024 18:49:30


package rs.ac.bg.etf.pp1.ast;

public class AllExprListB2 extends ExprListB2 {

    private ExprListB2 ExprListB2;
    private Expr Expr;

    public AllExprListB2 (ExprListB2 ExprListB2, Expr Expr) {
        this.ExprListB2=ExprListB2;
        if(ExprListB2!=null) ExprListB2.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ExprListB2 getExprListB2() {
        return ExprListB2;
    }

    public void setExprListB2(ExprListB2 ExprListB2) {
        this.ExprListB2=ExprListB2;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprListB2!=null) ExprListB2.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprListB2!=null) ExprListB2.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprListB2!=null) ExprListB2.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllExprListB2(\n");

        if(ExprListB2!=null)
            buffer.append(ExprListB2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllExprListB2]");
        return buffer.toString();
    }
}
