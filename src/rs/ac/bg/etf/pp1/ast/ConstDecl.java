// generated with ast extension for cup
// version 0.8
// 2/0/2024 16:15:34


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ConstDeclTypeName ConstDeclTypeName;
    private String constName;
    private AllConst AllConst;
    private ConstDeclBodyList ConstDeclBodyList;

    public ConstDecl (ConstDeclTypeName ConstDeclTypeName, String constName, AllConst AllConst, ConstDeclBodyList ConstDeclBodyList) {
        this.ConstDeclTypeName=ConstDeclTypeName;
        if(ConstDeclTypeName!=null) ConstDeclTypeName.setParent(this);
        this.constName=constName;
        this.AllConst=AllConst;
        if(AllConst!=null) AllConst.setParent(this);
        this.ConstDeclBodyList=ConstDeclBodyList;
        if(ConstDeclBodyList!=null) ConstDeclBodyList.setParent(this);
    }

    public ConstDeclTypeName getConstDeclTypeName() {
        return ConstDeclTypeName;
    }

    public void setConstDeclTypeName(ConstDeclTypeName ConstDeclTypeName) {
        this.ConstDeclTypeName=ConstDeclTypeName;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public AllConst getAllConst() {
        return AllConst;
    }

    public void setAllConst(AllConst AllConst) {
        this.AllConst=AllConst;
    }

    public ConstDeclBodyList getConstDeclBodyList() {
        return ConstDeclBodyList;
    }

    public void setConstDeclBodyList(ConstDeclBodyList ConstDeclBodyList) {
        this.ConstDeclBodyList=ConstDeclBodyList;
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
        if(ConstDeclTypeName!=null) ConstDeclTypeName.accept(visitor);
        if(AllConst!=null) AllConst.accept(visitor);
        if(ConstDeclBodyList!=null) ConstDeclBodyList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclTypeName!=null) ConstDeclTypeName.traverseTopDown(visitor);
        if(AllConst!=null) AllConst.traverseTopDown(visitor);
        if(ConstDeclBodyList!=null) ConstDeclBodyList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclTypeName!=null) ConstDeclTypeName.traverseBottomUp(visitor);
        if(AllConst!=null) AllConst.traverseBottomUp(visitor);
        if(ConstDeclBodyList!=null) ConstDeclBodyList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(ConstDeclTypeName!=null)
            buffer.append(ConstDeclTypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        if(AllConst!=null)
            buffer.append(AllConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclBodyList!=null)
            buffer.append(ConstDeclBodyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
