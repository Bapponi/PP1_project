// generated with ast extension for cup
// version 0.8
// 9/0/2024 17:41:17


package rs.ac.bg.etf.pp1.ast;

public class AllDesignatorListB extends DesignatorListB {

    private DesignatorListB DesignatorListB;
    private Designator Designator;

    public AllDesignatorListB (DesignatorListB DesignatorListB, Designator Designator) {
        this.DesignatorListB=DesignatorListB;
        if(DesignatorListB!=null) DesignatorListB.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public DesignatorListB getDesignatorListB() {
        return DesignatorListB;
    }

    public void setDesignatorListB(DesignatorListB DesignatorListB) {
        this.DesignatorListB=DesignatorListB;
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
        if(DesignatorListB!=null) DesignatorListB.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorListB!=null) DesignatorListB.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorListB!=null) DesignatorListB.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllDesignatorListB(\n");

        if(DesignatorListB!=null)
            buffer.append(DesignatorListB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllDesignatorListB]");
        return buffer.toString();
    }
}
