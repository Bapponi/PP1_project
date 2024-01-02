// generated with ast extension for cup
// version 0.8
// 2/0/2024 16:15:35


package rs.ac.bg.etf.pp1.ast;

public class StatementDesignMultiple extends Statement {

    private DesignatorStatementMultiple DesignatorStatementMultiple;

    public StatementDesignMultiple (DesignatorStatementMultiple DesignatorStatementMultiple) {
        this.DesignatorStatementMultiple=DesignatorStatementMultiple;
        if(DesignatorStatementMultiple!=null) DesignatorStatementMultiple.setParent(this);
    }

    public DesignatorStatementMultiple getDesignatorStatementMultiple() {
        return DesignatorStatementMultiple;
    }

    public void setDesignatorStatementMultiple(DesignatorStatementMultiple DesignatorStatementMultiple) {
        this.DesignatorStatementMultiple=DesignatorStatementMultiple;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementMultiple!=null) DesignatorStatementMultiple.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementMultiple!=null) DesignatorStatementMultiple.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementMultiple!=null) DesignatorStatementMultiple.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDesignMultiple(\n");

        if(DesignatorStatementMultiple!=null)
            buffer.append(DesignatorStatementMultiple.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDesignMultiple]");
        return buffer.toString();
    }
}
