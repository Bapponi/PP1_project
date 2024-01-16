// generated with ast extension for cup
// version 0.8
// 16/0/2024 20:44:56


package rs.ac.bg.etf.pp1.ast;

public class FormParsBody implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private FormParsBodyType FormParsBodyType;
    private String parName;
    private BracketsList BracketsList;

    public FormParsBody (FormParsBodyType FormParsBodyType, String parName, BracketsList BracketsList) {
        this.FormParsBodyType=FormParsBodyType;
        if(FormParsBodyType!=null) FormParsBodyType.setParent(this);
        this.parName=parName;
        this.BracketsList=BracketsList;
        if(BracketsList!=null) BracketsList.setParent(this);
    }

    public FormParsBodyType getFormParsBodyType() {
        return FormParsBodyType;
    }

    public void setFormParsBodyType(FormParsBodyType FormParsBodyType) {
        this.FormParsBodyType=FormParsBodyType;
    }

    public String getParName() {
        return parName;
    }

    public void setParName(String parName) {
        this.parName=parName;
    }

    public BracketsList getBracketsList() {
        return BracketsList;
    }

    public void setBracketsList(BracketsList BracketsList) {
        this.BracketsList=BracketsList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsBodyType!=null) FormParsBodyType.accept(visitor);
        if(BracketsList!=null) BracketsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsBodyType!=null) FormParsBodyType.traverseTopDown(visitor);
        if(BracketsList!=null) BracketsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsBodyType!=null) FormParsBodyType.traverseBottomUp(visitor);
        if(BracketsList!=null) BracketsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsBody(\n");

        if(FormParsBodyType!=null)
            buffer.append(FormParsBodyType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+parName);
        buffer.append("\n");

        if(BracketsList!=null)
            buffer.append(BracketsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsBody]");
        return buffer.toString();
    }
}
