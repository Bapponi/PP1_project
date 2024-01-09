// generated with ast extension for cup
// version 0.8
// 9/0/2024 17:41:17


package rs.ac.bg.etf.pp1.ast;

public class AllFormPars extends FormPars {

    private FormPars FormPars;
    private FormParsBody FormParsBody;

    public AllFormPars (FormPars FormPars, FormParsBody FormParsBody) {
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.FormParsBody=FormParsBody;
        if(FormParsBody!=null) FormParsBody.setParent(this);
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
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
        if(FormPars!=null) FormPars.accept(visitor);
        if(FormParsBody!=null) FormParsBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(FormParsBody!=null) FormParsBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(FormParsBody!=null) FormParsBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllFormPars(\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsBody!=null)
            buffer.append(FormParsBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllFormPars]");
        return buffer.toString();
    }
}
