// generated with ast extension for cup
// version 0.8
// 2/0/2024 16:15:35


package rs.ac.bg.etf.pp1.ast;

public class ExprPlus extends Expr {

    private Term Term;
    private ExprBodyList ExprBodyList;

    public ExprPlus (Term Term, ExprBodyList ExprBodyList) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.ExprBodyList=ExprBodyList;
        if(ExprBodyList!=null) ExprBodyList.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public ExprBodyList getExprBodyList() {
        return ExprBodyList;
    }

    public void setExprBodyList(ExprBodyList ExprBodyList) {
        this.ExprBodyList=ExprBodyList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(ExprBodyList!=null) ExprBodyList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(ExprBodyList!=null) ExprBodyList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(ExprBodyList!=null) ExprBodyList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprPlus(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprBodyList!=null)
            buffer.append(ExprBodyList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprPlus]");
        return buffer.toString();
    }
}
