// generated with ast extension for cup
// version 0.8
// 3/0/2024 21:15:7


package rs.ac.bg.etf.pp1.ast;

public class TypeOne extends Type {

    private TypeName TypeName;

    public TypeOne (TypeName TypeName) {
        this.TypeName=TypeName;
        if(TypeName!=null) TypeName.setParent(this);
    }

    public TypeName getTypeName() {
        return TypeName;
    }

    public void setTypeName(TypeName TypeName) {
        this.TypeName=TypeName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeName!=null) TypeName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeName!=null) TypeName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeName!=null) TypeName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TypeOne(\n");

        if(TypeName!=null)
            buffer.append(TypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TypeOne]");
        return buffer.toString();
    }
}
