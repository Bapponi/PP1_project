// generated with ast extension for cup
// version 0.8
// 2/0/2024 21:45:0


package rs.ac.bg.etf.pp1.ast;

public class AllConstBool extends AllConst {

    private Bool Bool;

    public AllConstBool (Bool Bool) {
        this.Bool=Bool;
        if(Bool!=null) Bool.setParent(this);
    }

    public Bool getBool() {
        return Bool;
    }

    public void setBool(Bool Bool) {
        this.Bool=Bool;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Bool!=null) Bool.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Bool!=null) Bool.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Bool!=null) Bool.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllConstBool(\n");

        if(Bool!=null)
            buffer.append(Bool.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllConstBool]");
        return buffer.toString();
    }
}
