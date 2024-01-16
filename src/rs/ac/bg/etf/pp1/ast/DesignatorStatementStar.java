// generated with ast extension for cup
// version 0.8
// 16/0/2024 20:44:56


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementStar extends DesignatorStatement {

    private DesignatorStarBody DesignatorStarBody;
    private Designator Designator;

    public DesignatorStatementStar (DesignatorStarBody DesignatorStarBody, Designator Designator) {
        this.DesignatorStarBody=DesignatorStarBody;
        if(DesignatorStarBody!=null) DesignatorStarBody.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public DesignatorStarBody getDesignatorStarBody() {
        return DesignatorStarBody;
    }

    public void setDesignatorStarBody(DesignatorStarBody DesignatorStarBody) {
        this.DesignatorStarBody=DesignatorStarBody;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStarBody!=null) DesignatorStarBody.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStarBody!=null) DesignatorStarBody.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStarBody!=null) DesignatorStarBody.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementStar(\n");

        if(DesignatorStarBody!=null)
            buffer.append(DesignatorStarBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementStar]");
        return buffer.toString();
    }
}
