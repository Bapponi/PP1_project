// generated with ast extension for cup
// version 0.8
// 2/0/2024 16:15:34


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclBody implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String constBodyName;
    private AllConst AllConst;

    public ConstDeclBody (String constBodyName, AllConst AllConst) {
        this.constBodyName=constBodyName;
        this.AllConst=AllConst;
        if(AllConst!=null) AllConst.setParent(this);
    }

    public String getConstBodyName() {
        return constBodyName;
    }

    public void setConstBodyName(String constBodyName) {
        this.constBodyName=constBodyName;
    }

    public AllConst getAllConst() {
        return AllConst;
    }

    public void setAllConst(AllConst AllConst) {
        this.AllConst=AllConst;
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
        if(AllConst!=null) AllConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AllConst!=null) AllConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AllConst!=null) AllConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclBody(\n");

        buffer.append(" "+tab+constBodyName);
        buffer.append("\n");

        if(AllConst!=null)
            buffer.append(AllConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclBody]");
        return buffer.toString();
    }
}
