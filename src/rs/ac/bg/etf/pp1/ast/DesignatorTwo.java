// generated with ast extension for cup
// version 0.8
// 2/0/2024 21:45:0


package rs.ac.bg.etf.pp1.ast;

public class DesignatorTwo extends Designator {

    private NamespaceDots NamespaceDots;
    private DesignatorName DesignatorName;
    private DesignatorBodyList DesignatorBodyList;

    public DesignatorTwo (NamespaceDots NamespaceDots, DesignatorName DesignatorName, DesignatorBodyList DesignatorBodyList) {
        this.NamespaceDots=NamespaceDots;
        if(NamespaceDots!=null) NamespaceDots.setParent(this);
        this.DesignatorName=DesignatorName;
        if(DesignatorName!=null) DesignatorName.setParent(this);
        this.DesignatorBodyList=DesignatorBodyList;
        if(DesignatorBodyList!=null) DesignatorBodyList.setParent(this);
    }

    public NamespaceDots getNamespaceDots() {
        return NamespaceDots;
    }

    public void setNamespaceDots(NamespaceDots NamespaceDots) {
        this.NamespaceDots=NamespaceDots;
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
        if(NamespaceDots!=null) NamespaceDots.accept(visitor);
        if(DesignatorName!=null) DesignatorName.accept(visitor);
        if(DesignatorBodyList!=null) DesignatorBodyList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NamespaceDots!=null) NamespaceDots.traverseTopDown(visitor);
        if(DesignatorName!=null) DesignatorName.traverseTopDown(visitor);
        if(DesignatorBodyList!=null) DesignatorBodyList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NamespaceDots!=null) NamespaceDots.traverseBottomUp(visitor);
        if(DesignatorName!=null) DesignatorName.traverseBottomUp(visitor);
        if(DesignatorBodyList!=null) DesignatorBodyList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorTwo(\n");

        if(NamespaceDots!=null)
            buffer.append(NamespaceDots.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [DesignatorTwo]");
        return buffer.toString();
    }
}
