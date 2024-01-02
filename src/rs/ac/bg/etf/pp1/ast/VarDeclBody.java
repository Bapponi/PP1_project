// generated with ast extension for cup
// version 0.8
// 2/0/2024 16:15:34


package rs.ac.bg.etf.pp1.ast;

public class VarDeclBody implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String varBodyName;
    private BracketsList BracketsList;

    public VarDeclBody (String varBodyName, BracketsList BracketsList) {
        this.varBodyName=varBodyName;
        this.BracketsList=BracketsList;
        if(BracketsList!=null) BracketsList.setParent(this);
    }

    public String getVarBodyName() {
        return varBodyName;
    }

    public void setVarBodyName(String varBodyName) {
        this.varBodyName=varBodyName;
    }

    public BracketsList getBracketsList() {
        return BracketsList;
    }

    public void setBracketsList(BracketsList BracketsList) {
        this.BracketsList=BracketsList;
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
        if(BracketsList!=null) BracketsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BracketsList!=null) BracketsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BracketsList!=null) BracketsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclBody(\n");

        buffer.append(" "+tab+varBodyName);
        buffer.append("\n");

        if(BracketsList!=null)
            buffer.append(BracketsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclBody]");
        return buffer.toString();
    }
}
