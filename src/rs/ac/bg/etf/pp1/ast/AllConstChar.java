// generated with ast extension for cup
// version 0.8
// 2/0/2024 16:15:34


package rs.ac.bg.etf.pp1.ast;

public class AllConstChar extends AllConst {

    private Char Char;

    public AllConstChar (Char Char) {
        this.Char=Char;
        if(Char!=null) Char.setParent(this);
    }

    public Char getChar() {
        return Char;
    }

    public void setChar(Char Char) {
        this.Char=Char;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Char!=null) Char.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Char!=null) Char.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Char!=null) Char.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllConstChar(\n");

        if(Char!=null)
            buffer.append(Char.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllConstChar]");
        return buffer.toString();
    }
}
