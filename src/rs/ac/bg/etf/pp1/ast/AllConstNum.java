// generated with ast extension for cup
// version 0.8
// 16/0/2024 20:44:56


package rs.ac.bg.etf.pp1.ast;

public class AllConstNum extends AllConst {

    private Num Num;

    public AllConstNum (Num Num) {
        this.Num=Num;
        if(Num!=null) Num.setParent(this);
    }

    public Num getNum() {
        return Num;
    }

    public void setNum(Num Num) {
        this.Num=Num;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Num!=null) Num.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Num!=null) Num.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Num!=null) Num.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllConstNum(\n");

        if(Num!=null)
            buffer.append(Num.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllConstNum]");
        return buffer.toString();
    }
}
