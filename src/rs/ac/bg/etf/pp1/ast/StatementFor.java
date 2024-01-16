// generated with ast extension for cup
// version 0.8
// 16/0/2024 20:44:56


package rs.ac.bg.etf.pp1.ast;

public class StatementFor extends Statement {

    private For For;
    private ForBody ForBody;
    private Statement Statement;
    private EndFor EndFor;

    public StatementFor (For For, ForBody ForBody, Statement Statement, EndFor EndFor) {
        this.For=For;
        if(For!=null) For.setParent(this);
        this.ForBody=ForBody;
        if(ForBody!=null) ForBody.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.EndFor=EndFor;
        if(EndFor!=null) EndFor.setParent(this);
    }

    public For getFor() {
        return For;
    }

    public void setFor(For For) {
        this.For=For;
    }

    public ForBody getForBody() {
        return ForBody;
    }

    public void setForBody(ForBody ForBody) {
        this.ForBody=ForBody;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public EndFor getEndFor() {
        return EndFor;
    }

    public void setEndFor(EndFor EndFor) {
        this.EndFor=EndFor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(For!=null) For.accept(visitor);
        if(ForBody!=null) ForBody.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(EndFor!=null) EndFor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(For!=null) For.traverseTopDown(visitor);
        if(ForBody!=null) ForBody.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(EndFor!=null) EndFor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(For!=null) For.traverseBottomUp(visitor);
        if(ForBody!=null) ForBody.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(EndFor!=null) EndFor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementFor(\n");

        if(For!=null)
            buffer.append(For.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForBody!=null)
            buffer.append(ForBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EndFor!=null)
            buffer.append(EndFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementFor]");
        return buffer.toString();
    }
}
