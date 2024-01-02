// generated with ast extension for cup
// version 0.8
// 2/0/2024 17:16:14


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignatorAll extends Factor {

    private Designator Designator;
    private FactorDesignatorBodyListB FactorDesignatorBodyListB;

    public FactorDesignatorAll (Designator Designator, FactorDesignatorBodyListB FactorDesignatorBodyListB) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.FactorDesignatorBodyListB=FactorDesignatorBodyListB;
        if(FactorDesignatorBodyListB!=null) FactorDesignatorBodyListB.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public FactorDesignatorBodyListB getFactorDesignatorBodyListB() {
        return FactorDesignatorBodyListB;
    }

    public void setFactorDesignatorBodyListB(FactorDesignatorBodyListB FactorDesignatorBodyListB) {
        this.FactorDesignatorBodyListB=FactorDesignatorBodyListB;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(FactorDesignatorBodyListB!=null) FactorDesignatorBodyListB.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(FactorDesignatorBodyListB!=null) FactorDesignatorBodyListB.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(FactorDesignatorBodyListB!=null) FactorDesignatorBodyListB.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignatorAll(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorDesignatorBodyListB!=null)
            buffer.append(FactorDesignatorBodyListB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignatorAll]");
        return buffer.toString();
    }
}
