// generated with ast extension for cup
// version 0.8
// 16/0/2024 16:43:44


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStarBody implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private DesignatorStarList DesignatorStarList;
    private Mulop Mulop;
    private Designator Designator;

    public DesignatorStarBody (DesignatorStarList DesignatorStarList, Mulop Mulop, Designator Designator) {
        this.DesignatorStarList=DesignatorStarList;
        if(DesignatorStarList!=null) DesignatorStarList.setParent(this);
        this.Mulop=Mulop;
        if(Mulop!=null) Mulop.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public DesignatorStarList getDesignatorStarList() {
        return DesignatorStarList;
    }

    public void setDesignatorStarList(DesignatorStarList DesignatorStarList) {
        this.DesignatorStarList=DesignatorStarList;
    }

    public Mulop getMulop() {
        return Mulop;
    }

    public void setMulop(Mulop Mulop) {
        this.Mulop=Mulop;
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
        if(Mulop!=null) Mulop.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStarList!=null) DesignatorStarList.traverseTopDown(visitor);
        if(Mulop!=null) Mulop.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStarList!=null) DesignatorStarList.traverseBottomUp(visitor);
        if(Mulop!=null) Mulop.traverseBottomUp(visitor);
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

        if(Mulop!=null)
            buffer.append(Mulop.toString("  "+tab));
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
