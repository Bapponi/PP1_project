// generated with ast extension for cup
// version 0.8
// 2/0/2024 18:23:9


package rs.ac.bg.etf.pp1.ast;

public class AllConstDeclBodyList extends ConstDeclBodyList {

    private ConstDeclBodyList ConstDeclBodyList;
    private ConstDeclBody ConstDeclBody;

    public AllConstDeclBodyList (ConstDeclBodyList ConstDeclBodyList, ConstDeclBody ConstDeclBody) {
        this.ConstDeclBodyList=ConstDeclBodyList;
        if(ConstDeclBodyList!=null) ConstDeclBodyList.setParent(this);
        this.ConstDeclBody=ConstDeclBody;
        if(ConstDeclBody!=null) ConstDeclBody.setParent(this);
    }

    public ConstDeclBodyList getConstDeclBodyList() {
        return ConstDeclBodyList;
    }

    public void setConstDeclBodyList(ConstDeclBodyList ConstDeclBodyList) {
        this.ConstDeclBodyList=ConstDeclBodyList;
    }

    public ConstDeclBody getConstDeclBody() {
        return ConstDeclBody;
    }

    public void setConstDeclBody(ConstDeclBody ConstDeclBody) {
        this.ConstDeclBody=ConstDeclBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclBodyList!=null) ConstDeclBodyList.accept(visitor);
        if(ConstDeclBody!=null) ConstDeclBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclBodyList!=null) ConstDeclBodyList.traverseTopDown(visitor);
        if(ConstDeclBody!=null) ConstDeclBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclBodyList!=null) ConstDeclBodyList.traverseBottomUp(visitor);
        if(ConstDeclBody!=null) ConstDeclBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllConstDeclBodyList(\n");

        if(ConstDeclBodyList!=null)
            buffer.append(ConstDeclBodyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclBody!=null)
            buffer.append(ConstDeclBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllConstDeclBodyList]");
        return buffer.toString();
    }
}
