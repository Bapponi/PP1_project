// generated with ast extension for cup
// version 0.8
// 2/0/2024 18:49:30


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ClassName ClassName;
    private ExtendsTypeListB ExtendsTypeListB;
    private VarDeclList VarDeclList;
    private ClassDeclBody ClassDeclBody;

    public ClassDecl (ClassName ClassName, ExtendsTypeListB ExtendsTypeListB, VarDeclList VarDeclList, ClassDeclBody ClassDeclBody) {
        this.ClassName=ClassName;
        if(ClassName!=null) ClassName.setParent(this);
        this.ExtendsTypeListB=ExtendsTypeListB;
        if(ExtendsTypeListB!=null) ExtendsTypeListB.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.ClassDeclBody=ClassDeclBody;
        if(ClassDeclBody!=null) ClassDeclBody.setParent(this);
    }

    public ClassName getClassName() {
        return ClassName;
    }

    public void setClassName(ClassName ClassName) {
        this.ClassName=ClassName;
    }

    public ExtendsTypeListB getExtendsTypeListB() {
        return ExtendsTypeListB;
    }

    public void setExtendsTypeListB(ExtendsTypeListB ExtendsTypeListB) {
        this.ExtendsTypeListB=ExtendsTypeListB;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public ClassDeclBody getClassDeclBody() {
        return ClassDeclBody;
    }

    public void setClassDeclBody(ClassDeclBody ClassDeclBody) {
        this.ClassDeclBody=ClassDeclBody;
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
        if(ClassName!=null) ClassName.accept(visitor);
        if(ExtendsTypeListB!=null) ExtendsTypeListB.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(ClassDeclBody!=null) ClassDeclBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassName!=null) ClassName.traverseTopDown(visitor);
        if(ExtendsTypeListB!=null) ExtendsTypeListB.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(ClassDeclBody!=null) ClassDeclBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassName!=null) ClassName.traverseBottomUp(visitor);
        if(ExtendsTypeListB!=null) ExtendsTypeListB.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(ClassDeclBody!=null) ClassDeclBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        if(ClassName!=null)
            buffer.append(ClassName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExtendsTypeListB!=null)
            buffer.append(ExtendsTypeListB.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDeclBody!=null)
            buffer.append(ClassDeclBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
