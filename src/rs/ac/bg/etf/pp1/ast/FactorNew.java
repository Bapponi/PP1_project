// generated with ast extension for cup
// version 0.8
// 9/0/2024 17:41:17


package rs.ac.bg.etf.pp1.ast;

public class FactorNew extends Factor {

    private Type Type;
    private NewTypeBody NewTypeBody;

    public FactorNew (Type Type, NewTypeBody NewTypeBody) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.NewTypeBody=NewTypeBody;
        if(NewTypeBody!=null) NewTypeBody.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public NewTypeBody getNewTypeBody() {
        return NewTypeBody;
    }

    public void setNewTypeBody(NewTypeBody NewTypeBody) {
        this.NewTypeBody=NewTypeBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(NewTypeBody!=null) NewTypeBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(NewTypeBody!=null) NewTypeBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(NewTypeBody!=null) NewTypeBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNew(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NewTypeBody!=null)
            buffer.append(NewTypeBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNew]");
        return buffer.toString();
    }
}
