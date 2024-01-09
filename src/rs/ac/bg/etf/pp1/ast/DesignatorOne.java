// generated with ast extension for cup
// version 0.8
// 9/0/2024 15:28:5


package rs.ac.bg.etf.pp1.ast;

public class DesignatorOne extends Designator {

    private DesignatorName DesignatorName;
    private DesignatorBodyList DesignatorBodyList;

    public DesignatorOne (DesignatorName DesignatorName, DesignatorBodyList DesignatorBodyList) {
        this.DesignatorName=DesignatorName;
        if(DesignatorName!=null) DesignatorName.setParent(this);
        this.DesignatorBodyList=DesignatorBodyList;
        if(DesignatorBodyList!=null) DesignatorBodyList.setParent(this);
    }

    public DesignatorName getDesignatorName() {
        return DesignatorName;
    }

    public void setDesignatorName(DesignatorName DesignatorName) {
        this.DesignatorName=DesignatorName;
    }

    public DesignatorBodyList getDesignatorBodyList() {
        return DesignatorBodyList;
    }

    public void setDesignatorBodyList(DesignatorBodyList DesignatorBodyList) {
        this.DesignatorBodyList=DesignatorBodyList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorName!=null) DesignatorName.accept(visitor);
        if(DesignatorBodyList!=null) DesignatorBodyList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorName!=null) DesignatorName.traverseTopDown(visitor);
        if(DesignatorBodyList!=null) DesignatorBodyList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorName!=null) DesignatorName.traverseBottomUp(visitor);
        if(DesignatorBodyList!=null) DesignatorBodyList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorOne(\n");

        if(DesignatorName!=null)
            buffer.append(DesignatorName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorBodyList!=null)
            buffer.append(DesignatorBodyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorOne]");
        return buffer.toString();
    }
}
