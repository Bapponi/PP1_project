// generated with ast extension for cup
// version 0.8
// 2/0/2024 21:45:0


package rs.ac.bg.etf.pp1.ast;

public class TypeTwo extends Type {

    private NamespaceDots NamespaceDots;
    private TypeName TypeName;

    public TypeTwo (NamespaceDots NamespaceDots, TypeName TypeName) {
        this.NamespaceDots=NamespaceDots;
        if(NamespaceDots!=null) NamespaceDots.setParent(this);
        this.TypeName=TypeName;
        if(TypeName!=null) TypeName.setParent(this);
    }

    public NamespaceDots getNamespaceDots() {
        return NamespaceDots;
    }

    public void setNamespaceDots(NamespaceDots NamespaceDots) {
        this.NamespaceDots=NamespaceDots;
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
        if(NamespaceDots!=null) NamespaceDots.accept(visitor);
        if(TypeName!=null) TypeName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NamespaceDots!=null) NamespaceDots.traverseTopDown(visitor);
        if(TypeName!=null) TypeName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NamespaceDots!=null) NamespaceDots.traverseBottomUp(visitor);
        if(TypeName!=null) TypeName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TypeTwo(\n");

        if(NamespaceDots!=null)
            buffer.append(NamespaceDots.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TypeName!=null)
            buffer.append(TypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TypeTwo]");
        return buffer.toString();
    }
}
