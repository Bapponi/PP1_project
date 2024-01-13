// generated with ast extension for cup
// version 0.8
// 13/0/2024 18:53:15


package rs.ac.bg.etf.pp1.ast;

public class AllDesignatorBodyList extends DesignatorBodyList {

    private DesignatorBodyList DesignatorBodyList;
    private DesignatorBody DesignatorBody;

    public AllDesignatorBodyList (DesignatorBodyList DesignatorBodyList, DesignatorBody DesignatorBody) {
        this.DesignatorBodyList=DesignatorBodyList;
        if(DesignatorBodyList!=null) DesignatorBodyList.setParent(this);
        this.DesignatorBody=DesignatorBody;
        if(DesignatorBody!=null) DesignatorBody.setParent(this);
    }

    public DesignatorBodyList getDesignatorBodyList() {
        return DesignatorBodyList;
    }

    public void setDesignatorBodyList(DesignatorBodyList DesignatorBodyList) {
        this.DesignatorBodyList=DesignatorBodyList;
    }

    public DesignatorBody getDesignatorBody() {
        return DesignatorBody;
    }

    public void setDesignatorBody(DesignatorBody DesignatorBody) {
        this.DesignatorBody=DesignatorBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorBodyList!=null) DesignatorBodyList.accept(visitor);
        if(DesignatorBody!=null) DesignatorBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorBodyList!=null) DesignatorBodyList.traverseTopDown(visitor);
        if(DesignatorBody!=null) DesignatorBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorBodyList!=null) DesignatorBodyList.traverseBottomUp(visitor);
        if(DesignatorBody!=null) DesignatorBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllDesignatorBodyList(\n");

        if(DesignatorBodyList!=null)
            buffer.append(DesignatorBodyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorBody!=null)
            buffer.append(DesignatorBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllDesignatorBodyList]");
        return buffer.toString();
    }
}
