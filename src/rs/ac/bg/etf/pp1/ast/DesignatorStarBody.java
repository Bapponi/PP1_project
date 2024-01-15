// generated with ast extension for cup
// version 0.8
// 14/0/2024 18:32:14


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStarBody implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private DesignatorStarList DesignatorStarList;
    private Designator Designator;

    public DesignatorStarBody (DesignatorStarList DesignatorStarList, Designator Designator) {
        this.DesignatorStarList=DesignatorStarList;
        if(DesignatorStarList!=null) DesignatorStarList.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public DesignatorStarList getDesignatorStarList() {
        return DesignatorStarList;
    }

    public void setDesignatorStarList(DesignatorStarList DesignatorStarList) {
        this.DesignatorStarList=DesignatorStarList;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
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
        if(DesignatorStarList!=null) DesignatorStarList.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStarList!=null) DesignatorStarList.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStarList!=null) DesignatorStarList.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStarBody(\n");

        if(DesignatorStarList!=null)
            buffer.append(DesignatorStarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStarBody]");
        return buffer.toString();
    }
}
