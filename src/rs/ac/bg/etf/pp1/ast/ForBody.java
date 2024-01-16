// generated with ast extension for cup
// version 0.8
// 16/0/2024 20:44:56


package rs.ac.bg.etf.pp1.ast;

public class ForBody implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private DesignatorStatementListB DesignatorStatementListB;
    private CondStart CondStart;
    private MaybeCondFact MaybeCondFact;
    private DesignatorStatementListB DesignatorStatementListB1;

    public ForBody (DesignatorStatementListB DesignatorStatementListB, CondStart CondStart, MaybeCondFact MaybeCondFact, DesignatorStatementListB DesignatorStatementListB1) {
        this.DesignatorStatementListB=DesignatorStatementListB;
        if(DesignatorStatementListB!=null) DesignatorStatementListB.setParent(this);
        this.CondStart=CondStart;
        if(CondStart!=null) CondStart.setParent(this);
        this.MaybeCondFact=MaybeCondFact;
        if(MaybeCondFact!=null) MaybeCondFact.setParent(this);
        this.DesignatorStatementListB1=DesignatorStatementListB1;
        if(DesignatorStatementListB1!=null) DesignatorStatementListB1.setParent(this);
    }

    public DesignatorStatementListB getDesignatorStatementListB() {
        return DesignatorStatementListB;
    }

    public void setDesignatorStatementListB(DesignatorStatementListB DesignatorStatementListB) {
        this.DesignatorStatementListB=DesignatorStatementListB;
    }

    public CondStart getCondStart() {
        return CondStart;
    }

    public void setCondStart(CondStart CondStart) {
        this.CondStart=CondStart;
    }

    public MaybeCondFact getMaybeCondFact() {
        return MaybeCondFact;
    }

    public void setMaybeCondFact(MaybeCondFact MaybeCondFact) {
        this.MaybeCondFact=MaybeCondFact;
    }

    public DesignatorStatementListB getDesignatorStatementListB1() {
        return DesignatorStatementListB1;
    }

    public void setDesignatorStatementListB1(DesignatorStatementListB DesignatorStatementListB1) {
        this.DesignatorStatementListB1=DesignatorStatementListB1;
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
        if(DesignatorStatementListB!=null) DesignatorStatementListB.accept(visitor);
        if(CondStart!=null) CondStart.accept(visitor);
        if(MaybeCondFact!=null) MaybeCondFact.accept(visitor);
        if(DesignatorStatementListB1!=null) DesignatorStatementListB1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementListB!=null) DesignatorStatementListB.traverseTopDown(visitor);
        if(CondStart!=null) CondStart.traverseTopDown(visitor);
        if(MaybeCondFact!=null) MaybeCondFact.traverseTopDown(visitor);
        if(DesignatorStatementListB1!=null) DesignatorStatementListB1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementListB!=null) DesignatorStatementListB.traverseBottomUp(visitor);
        if(CondStart!=null) CondStart.traverseBottomUp(visitor);
        if(MaybeCondFact!=null) MaybeCondFact.traverseBottomUp(visitor);
        if(DesignatorStatementListB1!=null) DesignatorStatementListB1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForBody(\n");

        if(DesignatorStatementListB!=null)
            buffer.append(DesignatorStatementListB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondStart!=null)
            buffer.append(CondStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeCondFact!=null)
            buffer.append(MaybeCondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementListB1!=null)
            buffer.append(DesignatorStatementListB1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForBody]");
        return buffer.toString();
    }
}
