// generated with ast extension for cup
// version 0.8
// 2/0/2024 16:15:34


package rs.ac.bg.etf.pp1.ast;

public class AllDeclarationsList extends AllDeclList {

    private AllDeclList AllDeclList;
    private AllDecl AllDecl;

    public AllDeclarationsList (AllDeclList AllDeclList, AllDecl AllDecl) {
        this.AllDeclList=AllDeclList;
        if(AllDeclList!=null) AllDeclList.setParent(this);
        this.AllDecl=AllDecl;
        if(AllDecl!=null) AllDecl.setParent(this);
    }

    public AllDeclList getAllDeclList() {
        return AllDeclList;
    }

    public void setAllDeclList(AllDeclList AllDeclList) {
        this.AllDeclList=AllDeclList;
    }

    public AllDecl getAllDecl() {
        return AllDecl;
    }

    public void setAllDecl(AllDecl AllDecl) {
        this.AllDecl=AllDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AllDeclList!=null) AllDeclList.accept(visitor);
        if(AllDecl!=null) AllDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AllDeclList!=null) AllDeclList.traverseTopDown(visitor);
        if(AllDecl!=null) AllDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AllDeclList!=null) AllDeclList.traverseBottomUp(visitor);
        if(AllDecl!=null) AllDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllDeclarationsList(\n");

        if(AllDeclList!=null)
            buffer.append(AllDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AllDecl!=null)
            buffer.append(AllDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllDeclarationsList]");
        return buffer.toString();
    }
}
