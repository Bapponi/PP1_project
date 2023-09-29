// generated with ast extension for cup
// version 0.8
// 14/8/2023 20:3:49


package rs.ac.bg.etf.pp1.ast;

public class AllExprBodyList extends ExprBodyList {

    private ExprBodyList ExprBodyList;
    private ExprBody ExprBody;

    public AllExprBodyList (ExprBodyList ExprBodyList, ExprBody ExprBody) {
        this.ExprBodyList=ExprBodyList;
        if(ExprBodyList!=null) ExprBodyList.setParent(this);
        this.ExprBody=ExprBody;
        if(ExprBody!=null) ExprBody.setParent(this);
    }

    public ExprBodyList getExprBodyList() {
        return ExprBodyList;
    }

    public void setExprBodyList(ExprBodyList ExprBodyList) {
        this.ExprBodyList=ExprBodyList;
    }

    public ExprBody getExprBody() {
        return ExprBody;
    }

    public void setExprBody(ExprBody ExprBody) {
        this.ExprBody=ExprBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprBodyList!=null) ExprBodyList.accept(visitor);
        if(ExprBody!=null) ExprBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprBodyList!=null) ExprBodyList.traverseTopDown(visitor);
        if(ExprBody!=null) ExprBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprBodyList!=null) ExprBodyList.traverseBottomUp(visitor);
        if(ExprBody!=null) ExprBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllExprBodyList(\n");

        if(ExprBodyList!=null)
            buffer.append(ExprBodyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprBody!=null)
            buffer.append(ExprBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllExprBodyList]");
        return buffer.toString();
    }
}
