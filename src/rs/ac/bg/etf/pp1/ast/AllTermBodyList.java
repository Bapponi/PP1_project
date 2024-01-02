// generated with ast extension for cup
// version 0.8
// 2/0/2024 18:49:30


package rs.ac.bg.etf.pp1.ast;

public class AllTermBodyList extends TermBodyList {

    private TermBodyList TermBodyList;
    private TermBody TermBody;

    public AllTermBodyList (TermBodyList TermBodyList, TermBody TermBody) {
        this.TermBodyList=TermBodyList;
        if(TermBodyList!=null) TermBodyList.setParent(this);
        this.TermBody=TermBody;
        if(TermBody!=null) TermBody.setParent(this);
    }

    public TermBodyList getTermBodyList() {
        return TermBodyList;
    }

    public void setTermBodyList(TermBodyList TermBodyList) {
        this.TermBodyList=TermBodyList;
    }

    public TermBody getTermBody() {
        return TermBody;
    }

    public void setTermBody(TermBody TermBody) {
        this.TermBody=TermBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermBodyList!=null) TermBodyList.accept(visitor);
        if(TermBody!=null) TermBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermBodyList!=null) TermBodyList.traverseTopDown(visitor);
        if(TermBody!=null) TermBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermBodyList!=null) TermBodyList.traverseBottomUp(visitor);
        if(TermBody!=null) TermBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllTermBodyList(\n");

        if(TermBodyList!=null)
            buffer.append(TermBodyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TermBody!=null)
            buffer.append(TermBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllTermBodyList]");
        return buffer.toString();
    }
}
