package rs.ac.bg.etf.pp1;

import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.CounterVisitor.*;
import rs.ac.bg.etf.pp1.ast.*;

public class CodeGenerator extends VisitorAdaptor {


	private int mainPC;
	private String currentAddop = "";
	private String currentMulop = "";
	private String currentRelop = "";
	private String preAddop = "";
	private String preMulop = "";
	List<Obj> designators = new ArrayList<Obj>();
//	Stack<Integer> stack = new Stack<Integer>();
	
	public int getMainPC() {
		return mainPC;
	}
	
	public Term getTerm(Expr e) {
		if (e.getClass()==ExprMinus.class)
			return ((ExprMinus)e).getTerm();
		return ((ExprPlus)e).getTerm();

	}
	
	public void visit(MethodTypeName mtn) {
		if(mtn.getMethodName().equals("main")) {
			mainPC = Code.pc;
		}
		mtn.obj.setAdr(Code.pc);
		
		SyntaxNode methodNode = mtn.getParent();
		
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		VarBodyCounter varBodyCnt = new VarBodyCounter();
		methodNode.traverseTopDown(varBodyCnt);
		
		FormParamCounter formCnt = new FormParamCounter();
		methodNode.traverseTopDown(formCnt);
		
		Code.put(Code.enter);
		Code.put(formCnt.getCount());
		Code.put(formCnt.getCount() + varCnt.getCount() + varBodyCnt.getCount());
	}
	
	public void visit(MethodDecl md) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(DesignatorStatementAssign dsa) {

		if(dsa.getDesignator().obj.getType().getKind() == Struct.Array) {

			Term term = getTerm(dsa.getExpr());

			if (term.getFactor().getClass() == FactorNew.class)
				Code.store(dsa.getDesignator().obj);
			else
				Code.put(Code.astore);
		}else {
			Code.store(dsa.getDesignator().obj);
		}
	}
	
	public void visit(DesignatorStatementInc dsi) {
		
		//posto se samo ovo koristi u for-u na testu
		if(dsi.getParent().getClass() != SingleDesignatorStmListB.class) {
			Obj con = new Obj(Obj.Con, "$", Tab.intType);
			con.setAdr(1);
			con.setLevel(0);
			
			Code.load(con);
			Code.put(Code.add);
			
			Code.store(dsi.getDesignator().obj);
		}else {
			Code.put(Code.pop);
		}
		
	}
	
	public void visit(DesignatorStatementDec dsd) {
		Obj con = new Obj(Obj.Con, "$", Tab.intType);
		con.setAdr(1);
		con.setLevel(0);
		
		Code.load(con);
		Code.put(Code.sub);
		
		Code.store(dsd.getDesignator().obj);
	}
	
	public void visit(Designator des) {
		SyntaxNode parent = des.getParent();
		
		if(DesignatorStatementAssign.class != parent.getClass() 
				&& FactorDesignatorAll.class != parent.getClass()
				&& FactorHashDes.class != parent.getClass()
				&& StatementRead.class != parent.getClass()
				&& StatementFindAny.class != parent.getClass()
				&& StatementArray.class != parent.getClass()
				&& StatementArray2.class != parent.getClass()) {
			Code.load(des.obj);
			
			if(des.obj.getType().getKind() == Struct.Array) {
				Code.put(Code.dup_x1);
				Code.put(Code.pop);
				Code.put(Code.aload);
			}
		}else	if(DesignatorStatementAssign.class == parent.getClass())  {
			Term term = getTerm(((DesignatorStatementAssign)des.getParent()).getExpr());
			
			if((term.getFactor().getClass() != FactorNew.class)&&
			(des.obj.getType().getKind() == Struct.Array)) {
				Code.load(des.obj);
				Code.put(Code.dup_x1);
				Code.put(Code.pop);
			}
		}
	}
	
	public void visit(StatementRead sr) {
		
		Obj stmObj = sr.getDesignator().obj;
		Struct type = stmObj.getType();
		
		int kind = type.getKind();
		if(kind == Struct.Int || 
			(kind == Struct.Array && type.getElemType().getKind() == Struct.Int)
		  ) {
			Code.put(Code.read);
		} else {
			Code.put(Code.bread);
		}
		Code.store(stmObj);			
	}
	
	public void visit(StatementPrint spr) {
		
		Struct type = getTerm(spr.getExpr()).getFactor().obj.getType();
		int kind = type.getKind();
		
		if( kind == Struct.Int ||
		    kind == Struct.Bool || 
		   (kind == Struct.Array && type.getElemType().getKind() == Struct.Int)
		  ) {
			Code.loadConst(5);
			Code.put(Code.print);
		}else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(StatementReturn sr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(StatementFindAny sfa) {
		
		Obj br = new Obj(Obj.Var, "$", Tab.intType);
		
		Code.loadConst(0);
		Code.store(br);
		
		int whileBegin = Code.pc;
		
		Code.load(br);
		
		Code.load(sfa.getDesignator1().obj); 
		Code.put(Code.arraylength);
		
		Code.putFalseJump(Code.lt, 0); 
		int arrayEnd = Code.pc - 2;
				
		Code.put(Code.dup); 
			
		Code.load(br);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(br);
			
		Code.load(sfa.getDesignator1().obj);
		Code.load(br);
		
		Code.loadConst(1);
		
		Code.put(Code.sub);
		Code.put(Code.aload);
			
		Code.putFalseJump(Code.eq, 0); 
			
		int notEqual = Code.pc - 2;
		//do ovde je isto
				 
		Code.loadConst(1);     //return 1
			
		Code.loadConst(0);
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, 0);
		
		int equal = Code.pc - 2;
		
		//isto
		Code.fixup(notEqual);   
		Code.putJump(whileBegin);
		Code.fixup(arrayEnd);  
		//isto
		
		//ovoga nema
		Code.loadConst(0);     //return 0
		
		Code.fixup(equal); 
		//do ovde
		
		Code.store(sfa.getDesignator().obj); 
		Code.put(Code.pop);
	}
	
	public void visit(AllExprBodyList allExprB) {
		if(currentAddop.equals("plus"))
			Code.put(Code.add);
		else if(currentAddop.equals("minus"))
			Code.put(Code.sub);
	}
	
	public void visit(AddopPlus ap) {
		currentAddop = "plus";
	}
	
	public void visit(AddopMinus am) {
		currentAddop = "minus";
	}
	
	public void visit(Term term) {
		if (term.getParent().getClass()==ExprMinus.class) {
			Code.loadConst(-1);
			Code.put(Code.mul);
		}
	}
	
	public void visit(AllTermBodyList allTermB) {
		if(currentMulop.equals("mul"))
			Code.put(Code.mul);
		else if(currentMulop.equals("div"))
			Code.put(Code.div);
		else if(currentMulop.equals("mod"))
			Code.put(Code.rem);
	}
	
	public void visit(MulopMul mm) {
		currentMulop = "mul";
	}
	
	public void visit(MulopDiv md) {
		currentMulop = "div";
	}
	
	public void visit(MulopMod mm) {
		currentMulop = "mod";
	}
	
	public void visit(Lparen lp) {
		preAddop = currentAddop;
		preMulop = currentMulop;
	}
	
	public void visit(Rparen rp) {
		currentAddop = preAddop;
		currentMulop = preMulop;
	}
	
	public void visit(FactorDesignatorAll fda) {
		Obj con = fda.getDesignator().obj;
		
		//ovde pravi problem za Factor vrv zbog onig izmena kod designatora
		Code.load(con);
		if (con.getType().getKind() == Struct.Array) {
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			Code.put(Code.aload);
		}
	}
	
	public void visit(FactorNum fn) {
		Obj con = Tab.insert(Obj.Con, "$", fn.obj.getType()); 
		
		con.setLevel(0);
		con.setAdr(fn.getValueN());
		
		Code.load(con);
	}
	
	public void visit(FactorChar fc) {
		Obj con = Tab.insert(Obj.Con, "$", fc.obj.getType()); 
		
		con.setLevel(0);
		String str = fc.getValueC();
		int intC = str.charAt(1);
		con.setAdr(intC);
		
		Code.load(con);	
	}

	public void visit(FactorBool fb) {
		Obj con = Tab.insert(Obj.Con, "$", fb.obj.getType()); 
		
		con.setLevel(0);
		if(fb.getValueB() == "true") {
			con.setAdr(1);
		}else {
			con.setAdr(0);
		}
		
		Code.load(con);	
	}
	
	public void visit(FactorNew fn){
		Code.put(Code.newarray);
		Code.put(1);
	}
	
	public void visit(FactorHash fh) {
		Obj con = Tab.insert(Obj.Con, "$", fh.obj.getType()); 
		
		con.setLevel(0);
		
		int value = fh.getValueH();
		if(value % 2 == 0) {
			value = value * value;
		}else {
			value = value * value * value;
		}
		
		con.setAdr(value);
		
		Code.load(con);
	}
	
	public void visit(FactorHashDes fda) {
		Obj con = fda.getDesignator().obj;
		
		Code.load(con);
		Code.load(con); //dupliram zbog provera
		Code.loadConst(2);
		Code.put(Code.rem);
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, 0);
		int nonpair = Code.pc - 2;
		Code.load(con);
		Code.load(con);
		Code.put(Code.mul);
		Code.put(Code.mul);
		Code.loadConst(1);
		Code.loadConst(1);
		Code.putFalseJump(Code.ne, 0);
		int endIf = Code.pc - 2;
		
		Code.fixup(nonpair);
		Code.load(con);
		Code.put(Code.mul);
		Code.fixup(endIf);
		if (con.getType().getKind() == Struct.Array) {
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			Code.put(Code.aload);
		}
	}
	
public void visit(DesignatorStatementMultiple dsm) {
	for(int i = 0, j = designators.size() - 1; i < designators.size(); i++, j--) {
		Code.store(designators.get(j));
	}
}
	
public void visit(AllDesignatorListB adlb) {
	Code.put(Code.pop);
	designators.add(adlb.getDesignator().obj);
}

public void visit(SingleDesignatorListB sdlb) {
	Code.put(Code.pop);
	designators.add(sdlb.getDesignator().obj);
}

int jumpEnd = 0;
int jumpElse = 0;
int jumpEndElse = 0;

public void visit(EndIf ei) {
	System.out.println("Banana if: " + jumpEnd);
	Code.fixup(jumpEnd);
}

public void visit(Else ei) {
	Code.loadConst(1);
	Code.loadConst(1);
	Code.putFalseJump(Code.ne, 0);
	jumpEndElse = Code.pc - 2;
	
	System.out.println("Banana else: " + jumpElse);
	Code.fixup(jumpElse);
}

public void visit(EndElse ee) {
	System.out.println("Banana end else: " + jumpEndElse);
	Code.fixup(jumpEndElse);
}

//trebam da ga povezem da dobro funkcionisu skokovi sa jednog visit-a na drugi

//moze da je i = i - 1 na pocetku zbog i++ a
public void visit(StatementFor sf) {
	visit(sf.getForBody().getDesignatorStatementListB());
	
	int jumpCond = Code.pc;
	visit(sf.getForBody().getMaybeCondFact()); //ovde treba dohvatiti doubleCondFact
	
	//ovde vec treba da stoji 1 ili nula od condFact-a
	Code.loadConst(1);
	Code.putFalseJump(Code.eq, 0);
	int jumpEnd = Code.pc - 2;
	
	visit(sf.getStatement());
	visit(sf.getForBody().getDesignatorStatementListB1());
	
	Code.putJump(jumpCond);
	Code.fixup(jumpEnd);
}

public void visit(YesCondFact cf) {
	if(currentRelop.equals("eqv")) {
		Code.putFalseJump(Code.ne, 0);
	}else if(currentRelop.equals("noeqv")) {
		Code.putFalseJump(Code.eq, 0);
	}else if(currentRelop.equals("more")) {
		Code.putFalseJump(Code.le, 0);	
	}else if(currentRelop.equals("moreeqv")) {
		Code.putFalseJump(Code.lt, 0);	
	}else if(currentRelop.equals("less")) {
		Code.putFalseJump(Code.ge, 0);	
	}else if(currentRelop.equals("lesseqv")) {
		Code.putFalseJump(Code.gt, 0);	
	}
	int jumpEqv = Code.pc - 2;
	Code.loadConst(0);
	Code.loadConst(1);
	Code.loadConst(1);
	Code.putFalseJump(Code.ne, 0);
	int jumpEqvNo = Code.pc - 2;
	Code.fixup(jumpEqv);
	Code.loadConst(1);
	Code.fixup(jumpEqvNo);
	
}

//public void visit(ConditionSingle cond) {
//	Code.loadConst(1);
//	Code.putFalseJump(Code.eq, 0);
//	jumpEnd = Code.pc - 2;
//}

public void visit(ConditionAll ca) {
	Code.put(Code.add);
	Code.loadConst(1);
	Code.putFalseJump(Code.lt, 0);
	int jumpAnd = Code.pc - 2;
	Code.loadConst(0);
	Code.loadConst(1);
	Code.loadConst(1);
	Code.putFalseJump(Code.ne, 0);
	int jumpAndNo = Code.pc - 2;
	Code.fixup(jumpAnd);
	Code.loadConst(1);
	Code.fixup(jumpAndNo);
	
//	Code.loadConst(1);
//	Code.putFalseJump(Code.eq, 0);
//	if(ca.getParent().getClass() == StatementIf.class) {
//		jumpEnd = Code.pc - 2;
//	}
//	if(ca.getParent().getClass() == StatementElse.class){
//		jumpElse = Code.pc - 2;
//	}
	
}

public void visit(CondTermAll cta) {
	Code.put(Code.add);
	Code.loadConst(2);
	Code.putFalseJump(Code.ne, 0);
	int jumpAnd = Code.pc - 2;
	Code.loadConst(0);
	Code.loadConst(1);
	Code.loadConst(1);
	Code.putFalseJump(Code.ne, 0);
	int jumpAndNo = Code.pc - 2;
	Code.fixup(jumpAnd);
	Code.loadConst(1);
	Code.fixup(jumpAndNo);
	
//	Code.loadConst(1);
//	Code.putFalseJump(Code.eq, 0);
//	if(cta.getParent().getParent().getClass() == StatementIf.class) {
//		jumpEnd = Code.pc - 2;
//	}
//	if(cta.getParent().getParent().getClass() == StatementElse.class){
//		jumpElse = Code.pc - 2;
//	}
}

public void visit(DoubleCondFact dcf) {
		
	if(dcf.getParent().getClass() != YesCondFact.class) {
		if(currentRelop.equals("eqv")) {
			Code.putFalseJump(Code.ne, 0);
		}else if(currentRelop.equals("noeqv")) {
			Code.putFalseJump(Code.eq, 0);
		}else if(currentRelop.equals("more")) {
			Code.putFalseJump(Code.le, 0);	
		}else if(currentRelop.equals("moreeqv")) {
			Code.putFalseJump(Code.lt, 0);	
		}else if(currentRelop.equals("less")) {
			Code.putFalseJump(Code.ge, 0);	
		}else if(currentRelop.equals("lesseqv")) {
			Code.putFalseJump(Code.gt, 0);	
		}
		int jumpEqv = Code.pc - 2;
		Code.loadConst(0);
		Code.loadConst(1);
		Code.loadConst(1);
		Code.putFalseJump(Code.ne, 0);
		int jumpEqvNo = Code.pc - 2;
		Code.fixup(jumpEqv);
		Code.loadConst(1);
		Code.fixup(jumpEqvNo);
		
//		System.out.println("Roditelj: " + dcf.getParent().getClass());
//		if(dcf.getParent().getClass() != CondTermSingle.class) {
			Code.loadConst(1);
			Code.putFalseJump(Code.eq, 0);

			if(dcf.getParent().getParent().getParent().getClass() == StatementIf.class){
				jumpEnd = Code.pc - 2;
			}
			if(dcf.getParent().getParent().getParent().getClass() == StatementElse.class){
				jumpElse = Code.pc - 2;
			}
//		}
	}
}

public void visit(RelopEqv rel) {
	currentRelop = "eqv";
}

public void visit(RelopNoeqv rel) {
	currentRelop = "noeqv";
}

public void visit(RelopMore rel) {
	currentRelop = "more";
}

public void visit(RelopMoreeqv rel) {
	currentRelop = "moreeqv";
}

public void visit(RelopLess rel) {
	currentRelop = "less";
}

public void visit(RelopLesseqv rel) {
	currentRelop = "lesseqv";
}

//nek bude trazenje maksimuma
public void visit(StatementArray sa) {
	Obj br = new Obj(Obj.Var, "$", Tab.intType);
	
	Code.loadConst(0);
	Code.store(br);
	Code.loadConst(0); //pocetni max
	
	int whileBegin = Code.pc;
	
	Code.load(br);
	
	Code.load(sa.getDesignator().obj); 
	Code.put(Code.arraylength);
	
	Code.putFalseJump(Code.lt, 0); 
	int arrayEnd = Code.pc - 2;
			
//	Code.put(Code.dup); // neki element koji je ubacen u funkciju
		
	Code.load(br);
	Code.loadConst(1);
	Code.put(Code.add);
	Code.store(br);
		
	Code.load(sa.getDesignator().obj);
	Code.load(br);
	
	Code.loadConst(1); //da se dohvati dobar indeks
	
	Code.put(Code.sub);
	Code.put(Code.aload);
	Code.put(Code.dup2); //moraju da se dupliraju da znamo koja da ostane
		
	Code.putFalseJump(Code.ge, 0); 	//ovde menjati
	int notMax = Code.pc - 2;
	//menjaj
	Code.put(Code.pop);		 
	//do ovde	
	Code.loadConst(1);
	Code.loadConst(1);
	Code.putFalseJump(Code.ne, 0);
	int isNewMax = Code.pc - 2;
	
	Code.fixup(notMax);
	//menjaj
	Code.put(Code.dup_x1);
	Code.put(Code.pop);
	Code.put(Code.pop);
	//do ovde
	Code.fixup(isNewMax);
	Code.putJump(whileBegin);
	Code.fixup(arrayEnd);  
}

//pronalazak broja ponavljanja nekog broja
public void visit(StatementArray2 sa) {
	Obj br = new Obj(Obj.Var, "$", Tab.intType);
	
	Code.loadConst(0);
	Code.store(br);
	Code.loadConst(6); //broj koji tražimo
	
	int whileBegin = Code.pc;
	
	Code.load(br);
	
	Code.load(sa.getDesignator().obj); 
	Code.put(Code.arraylength);
	
	Code.putFalseJump(Code.lt, 0); 
	int arrayEnd = Code.pc - 2;
			
	Code.put(Code.dup); // neki element koji je ubacen u funkciju
		
	Code.load(br);
	Code.loadConst(1);
	Code.put(Code.add);
	Code.store(br);
		
	Code.load(sa.getDesignator().obj);
	Code.load(br);
	
	Code.loadConst(1); //da se dohvati dobar indeks
	
	Code.put(Code.sub);
	Code.put(Code.aload);
		
	Code.putFalseJump(Code.ne, 0); 	
	int notEqual = Code.pc - 2;
	//menjaj

	//do ovde	
	Code.loadConst(1);
	Code.loadConst(1);
	Code.putFalseJump(Code.ne, 0);
	int equal = Code.pc - 2;
	
	Code.fixup(notEqual);
	//menjaj
	
	//do ovde
	Code.fixup(equal);
	Code.putJump(whileBegin);
	Code.fixup(arrayEnd); 
}
	
}
