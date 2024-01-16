// generated with ast extension for cup
// version 0.8
// 16/0/2024 20:44:56


package rs.ac.bg.etf.pp1.ast;

public class FactorNum extends Factor {

    private Integer valueN;

    public FactorNum (Integer valueN) {
        this.valueN=valueN;
    }

    public Integer getValueN() {
        return valueN;
    }

    public void setValueN(Integer valueN) {
        this.valueN=valueN;
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
        buffer.append("FactorNum(\n");

        buffer.append(" "+tab+valueN);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNum]");
        return buffer.toString();
    }
}
