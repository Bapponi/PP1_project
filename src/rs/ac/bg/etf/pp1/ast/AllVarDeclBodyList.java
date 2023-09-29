// generated with ast extension for cup
// version 0.8
// 14/8/2023 20:3:49


package rs.ac.bg.etf.pp1.ast;

public class AllVarDeclBodyList extends VarDeclBodyList {

    private VarDeclBodyList VarDeclBodyList;
    private VarDeclBody VarDeclBody;

    public AllVarDeclBodyList (VarDeclBodyList VarDeclBodyList, VarDeclBody VarDeclBody) {
        this.VarDeclBodyList=VarDeclBodyList;
        if(VarDeclBodyList!=null) VarDeclBodyList.setParent(this);
        this.VarDeclBody=VarDeclBody;
        if(VarDeclBody!=null) VarDeclBody.setParent(this);
    }

    public VarDeclBodyList getVarDeclBodyList() {
        return VarDeclBodyList;
    }

    public void setVarDeclBodyList(VarDeclBodyList VarDeclBodyList) {
        this.VarDeclBodyList=VarDeclBodyList;
    }

    public VarDeclBody getVarDeclBody() {
        return VarDeclBody;
    }

    public void setVarDeclBody(VarDeclBody VarDeclBody) {
        this.VarDeclBody=VarDeclBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclBodyList!=null) VarDeclBodyList.accept(visitor);
        if(VarDeclBody!=null) VarDeclBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclBodyList!=null) VarDeclBodyList.traverseTopDown(visitor);
        if(VarDeclBody!=null) VarDeclBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclBodyList!=null) VarDeclBodyList.traverseBottomUp(visitor);
        if(VarDeclBody!=null) VarDeclBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllVarDeclBodyList(\n");

        if(VarDeclBodyList!=null)
            buffer.append(VarDeclBodyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclBody!=null)
            buffer.append(VarDeclBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllVarDeclBodyList]");
        return buffer.toString();
    }
}
