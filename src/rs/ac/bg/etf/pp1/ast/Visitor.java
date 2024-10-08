// generated with ast extension for cup
// version 0.8
// 9/0/2024 17:41:17


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(FormPars FormPars);
    public void visit(StatementListB StatementListB);
    public void visit(NamespaceDots NamespaceDots);
    public void visit(Factor Factor);
    public void visit(Statement Statement);
    public void visit(Brackets Brackets);
    public void visit(FactorDesignatorBodyListB FactorDesignatorBodyListB);
    public void visit(ExprListB2 ExprListB2);
    public void visit(VoidOrType VoidOrType);
    public void visit(FormParsListB FormParsListB);
    public void visit(ConstDeclBodyList ConstDeclBodyList);
    public void visit(Relop Relop);
    public void visit(FormBodyList FormBodyList);
    public void visit(VarDeclBodyList VarDeclBodyList);
    public void visit(BracketsList BracketsList);
    public void visit(Expr Expr);
    public void visit(NumConstListB NumConstListB);
    public void visit(NewTypeBody NewTypeBody);
    public void visit(FormBody FormBody);
    public void visit(TypeList TypeList);
    public void visit(AllConst AllConst);
    public void visit(ActParsBodyList ActParsBodyList);
    public void visit(TermBodyList TermBodyList);
    public void visit(Condition Condition);
    public void visit(DesignatorListB DesignatorListB);
    public void visit(Mulop Mulop);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(NamespaceList NamespaceList);
    public void visit(AllDeclList AllDeclList);
    public void visit(Addop Addop);
    public void visit(StatementList StatementList);
    public void visit(ExprMP ExprMP);
    public void visit(ClassDeclBody ClassDeclBody);
    public void visit(DesignatorBodyList DesignatorBodyList);
    public void visit(ExprBodyList ExprBodyList);
    public void visit(ExprListB ExprListB);
    public void visit(CondTerm CondTerm);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(AllDecl AllDecl);
    public void visit(ExtendsTypeListB ExtendsTypeListB);
    public void visit(ActPars ActPars);
    public void visit(ActParsBody ActParsBody);
    public void visit(VarDeclList VarDeclList);
    public void visit(CondFact CondFact);
    public void visit(ActParsListB ActParsListB);
    public void visit(MinusListB MinusListB);
    public void visit(SingleCondFact SingleCondFact);
    public void visit(DoubleCondFact DoubleCondFact);
    public void visit(CondTermSingle CondTermSingle);
    public void visit(CondTermAll CondTermAll);
    public void visit(ConditionSingle ConditionSingle);
    public void visit(ConditionAll ConditionAll);
    public void visit(NoNumConstListB NoNumConstListB);
    public void visit(AllNumConstListB AllNumConstListB);
    public void visit(RelopLesseqv RelopLesseqv);
    public void visit(RelopLess RelopLess);
    public void visit(RelopMoreeqv RelopMoreeqv);
    public void visit(RelopMore RelopMore);
    public void visit(RelopNoeqv RelopNoeqv);
    public void visit(RelopEqv RelopEqv);
    public void visit(Label Label);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(SingleActPars SingleActPars);
    public void visit(AllActPars AllActPars);
    public void visit(NoActParsListB NoActParsListB);
    public void visit(SingleActParsListB SingleActParsListB);
    public void visit(NewTypeBodyTwo NewTypeBodyTwo);
    public void visit(NewTypeBodyOne NewTypeBodyOne);
    public void visit(FactorDesignatorBody FactorDesignatorBody);
    public void visit(NoFactorDesignatorBodyListB NoFactorDesignatorBodyListB);
    public void visit(SingleFactorDesignatorBodyListB SingleFactorDesignatorBodyListB);
    public void visit(Rparen Rparen);
    public void visit(Lparen Lparen);
    public void visit(FactorHashDes FactorHashDes);
    public void visit(FactorHash FactorHash);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorNew FactorNew);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNum FactorNum);
    public void visit(FactorDesignatorAll FactorDesignatorAll);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMul MulopMul);
    public void visit(TermBody TermBody);
    public void visit(NoTermBodyList NoTermBodyList);
    public void visit(AllTermBodyList AllTermBodyList);
    public void visit(Term Term);
    public void visit(ExprBody ExprBody);
    public void visit(NoExprBodyList NoExprBodyList);
    public void visit(AllExprBodyList AllExprBodyList);
    public void visit(ExprPlus ExprPlus);
    public void visit(ExprMinus ExprMinus);
    public void visit(NoExprListB NoExprListB);
    public void visit(SingleExprListB SingleExprListB);
    public void visit(Assignop Assignop);
    public void visit(DesignatorBody DesignatorBody);
    public void visit(NoDesignatorBodyList NoDesignatorBodyList);
    public void visit(AllDesignatorBodyList AllDesignatorBodyList);
    public void visit(DesignatorName DesignatorName);
    public void visit(Designator Designator);
    public void visit(SingleExprListB2 SingleExprListB2);
    public void visit(AllExprListB2 AllExprListB2);
    public void visit(SingleDesignatorListB SingleDesignatorListB);
    public void visit(AllDesignatorListB AllDesignatorListB);
    public void visit(DesignatorStatementMultiple DesignatorStatementMultiple);
    public void visit(DesignatorStatementDec DesignatorStatementDec);
    public void visit(DesignatorStatementInc DesignatorStatementInc);
    public void visit(DesignatorStatementAct DesignatorStatementAct);
    public void visit(DesignatorStatementAssign DesignatorStatementAssign);
    public void visit(Foreach Foreach);
    public void visit(While While);
    public void visit(ErrorStmt ErrorStmt);
    public void visit(StatementFindAndReplace StatementFindAndReplace);
    public void visit(StatementFindAny StatementFindAny);
    public void visit(StatementStatementList StatementStatementList);
    public void visit(StatementForeach StatementForeach);
    public void visit(StatementPrint StatementPrint);
    public void visit(StatementRead StatementRead);
    public void visit(StatementReturn StatementReturn);
    public void visit(StatementContinue StatementContinue);
    public void visit(StatementBreak StatementBreak);
    public void visit(StatementWhile StatementWhile);
    public void visit(StatementElse StatementElse);
    public void visit(StatementIf StatementIf);
    public void visit(StatementDesignMultiple StatementDesignMultiple);
    public void visit(StatementDesign StatementDesign);
    public void visit(NoStatementList NoStatementList);
    public void visit(AllStatementList AllStatementList);
    public void visit(FormParsBodyType FormParsBodyType);
    public void visit(FormParsBody FormParsBody);
    public void visit(SingleFormPars SingleFormPars);
    public void visit(AllFormPars AllFormPars);
    public void visit(NoFormParsListB NoFormParsListB);
    public void visit(SingleFormParsListB SingleFormParsListB);
    public void visit(TypePart TypePart);
    public void visit(VoidPart VoidPart);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodDeclListList NoMethodDeclListList);
    public void visit(AllMethodDeclList AllMethodDeclList);
    public void visit(NoClassDeclBody NoClassDeclBody);
    public void visit(SingleClassDeclBody SingleClassDeclBody);
    public void visit(NoVarDeclList NoVarDeclList);
    public void visit(AllVarDeclList AllVarDeclList);
    public void visit(NoExtendsType NoExtendsType);
    public void visit(SingleExtendsType SingleExtendsType);
    public void visit(ClassName ClassName);
    public void visit(ClassDecl ClassDecl);
    public void visit(VarDeclBody VarDeclBody);
    public void visit(NoVarDeclBodyList NoVarDeclBodyList);
    public void visit(AllVarDeclBodyList AllVarDeclBodyList);
    public void visit(NoBrackets NoBrackets);
    public void visit(SingleBrackets SingleBrackets);
    public void visit(VarDeclTypeName VarDeclTypeName);
    public void visit(VarDecl VarDecl);
    public void visit(ConstDeclBody ConstDeclBody);
    public void visit(NoConstDeclBodyList NoConstDeclBodyList);
    public void visit(AllConstDeclBodyList AllConstDeclBodyList);
    public void visit(Num Num);
    public void visit(Bool Bool);
    public void visit(Char Char);
    public void visit(AllConstNum AllConstNum);
    public void visit(AllConstBool AllConstBool);
    public void visit(AllConstChar AllConstChar);
    public void visit(Type Type);
    public void visit(ConstDeclTypeName ConstDeclTypeName);
    public void visit(ConstDecl ConstDecl);
    public void visit(ClassDeclarations ClassDeclarations);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ConstDeclarations ConstDeclarations);
    public void visit(NoAllDecl NoAllDecl);
    public void visit(AllDeclarationsList AllDeclarationsList);
    public void visit(ProgName ProgName);
    public void visit(NamespaceName NamespaceName);
    public void visit(Namespace Namespace);
    public void visit(NoNamespaceList NoNamespaceList);
    public void visit(AllNamespaceList AllNamespaceList);
    public void visit(ProgramBody ProgramBody);
    public void visit(Program Program);

}
