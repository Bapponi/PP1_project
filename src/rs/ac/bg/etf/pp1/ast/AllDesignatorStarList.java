// generated with ast extension for cup
// version 0.8
// 13/0/2024 18:53:15


package rs.ac.bg.etf.pp1.ast;

public class AllDesignatorStarList extends DesignatorStarList {

    private DesignatorStarList DesignatorStarList;
    private MaybeDesignator MaybeDesignator;

    public AllDesignatorStarList (DesignatorStarList DesignatorStarList, MaybeDesignator MaybeDesignator) {
        this.DesignatorStarList=DesignatorStarList;
        if(DesignatorStarList!=null) DesignatorStarList.setParent(this);
        this.MaybeDesignator=MaybeDesignator;
        if(MaybeDesignator!=null) MaybeDesignator.setParent(this);
    }

    public DesignatorStarList getDesignatorStarList() {
        return DesignatorStarList;
    }

    public void setDesignatorStarList(DesignatorStarList DesignatorStarList) {
        this.DesignatorStarList=DesignatorStarList;
    }

    public MaybeDesignator getMaybeDesignator() {
        return MaybeDesignator;
    }

    public void setMaybeDesignator(MaybeDesignator MaybeDesignator) {
        this.MaybeDesignator=MaybeDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStarList!=null) DesignatorStarList.accept(visitor);
        if(MaybeDesignator!=null) MaybeDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStarList!=null) DesignatorStarList.traverseTopDown(visitor);
        if(MaybeDesignator!=null) MaybeDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStarList!=null) DesignatorStarList.traverseBottomUp(visitor);
        if(MaybeDesignator!=null) MaybeDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllDesignatorStarList(\n");

        if(DesignatorStarList!=null)
            buffer.append(DesignatorStarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeDesignator!=null)
            buffer.append(MaybeDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllDesignatorStarList]");
        return buffer.toString();
    }
}
