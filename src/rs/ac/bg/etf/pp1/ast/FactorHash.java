// generated with ast extension for cup
// version 0.8
// 2/0/2024 16:15:35


package rs.ac.bg.etf.pp1.ast;

public class FactorHash extends Factor {

    private Integer valueH;

    public FactorHash (Integer valueH) {
        this.valueH=valueH;
    }

    public Integer getValueH() {
        return valueH;
    }

    public void setValueH(Integer valueH) {
        this.valueH=valueH;
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
        buffer.append("FactorHash(\n");

        buffer.append(" "+tab+valueH);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorHash]");
        return buffer.toString();
    }
}
