// generated with ast extension for cup
// version 0.8
// 9/0/2024 17:41:17


package rs.ac.bg.etf.pp1.ast;

public class MethodTypeName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private VoidOrType VoidOrType;
    private String methodName;

    public MethodTypeName (VoidOrType VoidOrType, String methodName) {
        this.VoidOrType=VoidOrType;
        if(VoidOrType!=null) VoidOrType.setParent(this);
        this.methodName=methodName;
    }

    public VoidOrType getVoidOrType() {
        return VoidOrType;
    }

    public void setVoidOrType(VoidOrType VoidOrType) {
        this.VoidOrType=VoidOrType;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName=methodName;
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
        if(VoidOrType!=null) VoidOrType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VoidOrType!=null) VoidOrType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VoidOrType!=null) VoidOrType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodTypeName(\n");

        if(VoidOrType!=null)
            buffer.append(VoidOrType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+methodName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodTypeName]");
        return buffer.toString();
    }
}
