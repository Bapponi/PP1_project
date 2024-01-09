// generated with ast extension for cup
// version 0.8
// 9/0/2024 15:28:5


package rs.ac.bg.etf.pp1.ast;

public class VarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private VarDeclTypeName VarDeclTypeName;
    private String varName;
    private BracketsList BracketsList;
    private VarDeclBodyList VarDeclBodyList;

    public VarDecl (VarDeclTypeName VarDeclTypeName, String varName, BracketsList BracketsList, VarDeclBodyList VarDeclBodyList) {
        this.VarDeclTypeName=VarDeclTypeName;
        if(VarDeclTypeName!=null) VarDeclTypeName.setParent(this);
        this.varName=varName;
        this.BracketsList=BracketsList;
        if(BracketsList!=null) BracketsList.setParent(this);
        this.VarDeclBodyList=VarDeclBodyList;
        if(VarDeclBodyList!=null) VarDeclBodyList.setParent(this);
    }

    public VarDeclTypeName getVarDeclTypeName() {
        return VarDeclTypeName;
    }

    public void setVarDeclTypeName(VarDeclTypeName VarDeclTypeName) {
        this.VarDeclTypeName=VarDeclTypeName;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public BracketsList getBracketsList() {
        return BracketsList;
    }

    public void setBracketsList(BracketsList BracketsList) {
        this.BracketsList=BracketsList;
    }

    public VarDeclBodyList getVarDeclBodyList() {
        return VarDeclBodyList;
    }

    public void setVarDeclBodyList(VarDeclBodyList VarDeclBodyList) {
        this.VarDeclBodyList=VarDeclBodyList;
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
        if(VarDeclTypeName!=null) VarDeclTypeName.accept(visitor);
        if(BracketsList!=null) BracketsList.accept(visitor);
        if(VarDeclBodyList!=null) VarDeclBodyList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclTypeName!=null) VarDeclTypeName.traverseTopDown(visitor);
        if(BracketsList!=null) BracketsList.traverseTopDown(visitor);
        if(VarDeclBodyList!=null) VarDeclBodyList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclTypeName!=null) VarDeclTypeName.traverseBottomUp(visitor);
        if(BracketsList!=null) BracketsList.traverseBottomUp(visitor);
        if(VarDeclBodyList!=null) VarDeclBodyList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl(\n");

        if(VarDeclTypeName!=null)
            buffer.append(VarDeclTypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(BracketsList!=null)
            buffer.append(BracketsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclBodyList!=null)
            buffer.append(VarDeclBodyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl]");
        return buffer.toString();
    }
}
