// generated with ast extension for cup
// version 0.8
// 3/0/2024 21:15:7


package rs.ac.bg.etf.pp1.ast;

public class SingleFactorDesignatorBodyListB extends FactorDesignatorBodyListB {

    private FactorDesignatorBody FactorDesignatorBody;

    public SingleFactorDesignatorBodyListB (FactorDesignatorBody FactorDesignatorBody) {
        this.FactorDesignatorBody=FactorDesignatorBody;
        if(FactorDesignatorBody!=null) FactorDesignatorBody.setParent(this);
    }

    public FactorDesignatorBody getFactorDesignatorBody() {
        return FactorDesignatorBody;
    }

    public void setFactorDesignatorBody(FactorDesignatorBody FactorDesignatorBody) {
        this.FactorDesignatorBody=FactorDesignatorBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactorDesignatorBody!=null) FactorDesignatorBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorDesignatorBody!=null) FactorDesignatorBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorDesignatorBody!=null) FactorDesignatorBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleFactorDesignatorBodyListB(\n");

        if(FactorDesignatorBody!=null)
            buffer.append(FactorDesignatorBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleFactorDesignatorBodyListB]");
        return buffer.toString();
    }
}
