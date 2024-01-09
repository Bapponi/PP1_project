// generated with ast extension for cup
// version 0.8
// 3/0/2024 21:15:7


package rs.ac.bg.etf.pp1.ast;

public class SingleFormPars extends FormPars {

    private FormParsBody FormParsBody;

    public SingleFormPars (FormParsBody FormParsBody) {
        this.FormParsBody=FormParsBody;
        if(FormParsBody!=null) FormParsBody.setParent(this);
    }

    public FormParsBody getFormParsBody() {
        return FormParsBody;
    }

    public void setFormParsBody(FormParsBody FormParsBody) {
        this.FormParsBody=FormParsBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsBody!=null) FormParsBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsBody!=null) FormParsBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsBody!=null) FormParsBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleFormPars(\n");

        if(FormParsBody!=null)
            buffer.append(FormParsBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleFormPars]");
        return buffer.toString();
    }
}
