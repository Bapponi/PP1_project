// generated with ast extension for cup
// version 0.8
// 2/0/2024 18:49:30


package rs.ac.bg.etf.pp1.ast;

public class StatementForeach extends Statement {

    private Designator Designator;
    private Foreach Foreach;
    private String foreachName;
    private Statement Statement;

    public StatementForeach (Designator Designator, Foreach Foreach, String foreachName, Statement Statement) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.Foreach=Foreach;
        if(Foreach!=null) Foreach.setParent(this);
        this.foreachName=foreachName;
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public Foreach getForeach() {
        return Foreach;
    }

    public void setForeach(Foreach Foreach) {
        this.Foreach=Foreach;
    }

    public String getForeachName() {
        return foreachName;
    }

    public void setForeachName(String foreachName) {
        this.foreachName=foreachName;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(Foreach!=null) Foreach.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(Foreach!=null) Foreach.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(Foreach!=null) Foreach.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementForeach(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Foreach!=null)
            buffer.append(Foreach.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+foreachName);
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementForeach]");
        return buffer.toString();
    }
}
