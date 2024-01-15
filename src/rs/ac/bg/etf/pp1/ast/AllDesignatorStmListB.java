// generated with ast extension for cup
// version 0.8
// 14/0/2024 18:32:14


package rs.ac.bg.etf.pp1.ast;

public class AllDesignatorStmListB extends DesignatorStatementListB {

    private DesignatorStatementListB DesignatorStatementListB;
    private DesignatorStatement DesignatorStatement;

    public AllDesignatorStmListB (DesignatorStatementListB DesignatorStatementListB, DesignatorStatement DesignatorStatement) {
        this.DesignatorStatementListB=DesignatorStatementListB;
        if(DesignatorStatementListB!=null) DesignatorStatementListB.setParent(this);
        this.DesignatorStatement=DesignatorStatement;
        if(DesignatorStatement!=null) DesignatorStatement.setParent(this);
    }

    public DesignatorStatementListB getDesignatorStatementListB() {
        return DesignatorStatementListB;
    }

    public void setDesignatorStatementListB(DesignatorStatementListB DesignatorStatementListB) {
        this.DesignatorStatementListB=DesignatorStatementListB;
    }

    public DesignatorStatement getDesignatorStatement() {
        return DesignatorStatement;
    }

    public void setDesignatorStatement(DesignatorStatement DesignatorStatement) {
        this.DesignatorStatement=DesignatorStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementListB!=null) DesignatorStatementListB.accept(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementListB!=null) DesignatorStatementListB.traverseTopDown(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementListB!=null) DesignatorStatementListB.traverseBottomUp(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllDesignatorStmListB(\n");

        if(DesignatorStatementListB!=null)
            buffer.append(DesignatorStatementListB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatement!=null)
            buffer.append(DesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllDesignatorStmListB]");
        return buffer.toString();
    }
}
