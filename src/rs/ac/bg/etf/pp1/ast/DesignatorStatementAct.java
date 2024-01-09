// generated with ast extension for cup
// version 0.8
// 9/0/2024 17:41:17


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementAct extends DesignatorStatement {

    private Designator Designator;
    private ActParsListB ActParsListB;

    public DesignatorStatementAct (Designator Designator, ActParsListB ActParsListB) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsListB=ActParsListB;
        if(ActParsListB!=null) ActParsListB.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsListB getActParsListB() {
        return ActParsListB;
    }

    public void setActParsListB(ActParsListB ActParsListB) {
        this.ActParsListB=ActParsListB;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsListB!=null) ActParsListB.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsListB!=null) ActParsListB.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsListB!=null) ActParsListB.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementAct(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsListB!=null)
            buffer.append(ActParsListB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementAct]");
        return buffer.toString();
    }
}
