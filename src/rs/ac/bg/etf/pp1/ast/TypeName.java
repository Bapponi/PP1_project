// generated with ast extension for cup
// version 0.8
// 9/0/2024 15:28:5


package rs.ac.bg.etf.pp1.ast;

public class TypeName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String typeNameStr;

    public TypeName (String typeNameStr) {
        this.typeNameStr=typeNameStr;
    }

    public String getTypeNameStr() {
        return typeNameStr;
    }

    public void setTypeNameStr(String typeNameStr) {
        this.typeNameStr=typeNameStr;
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
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TypeName(\n");

        buffer.append(" "+tab+typeNameStr);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TypeName]");
        return buffer.toString();
    }
}
