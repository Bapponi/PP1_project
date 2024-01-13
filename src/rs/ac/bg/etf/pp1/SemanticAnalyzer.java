package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;


public class SemanticAnalyzer extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	int constDeclCount = 0;
	int classDeclCount = 0;
	int namespaceDeclCount = 0;
	List<String> classNames = new ArrayList<String>();
	List<String> varNames = new ArrayList<String>();
	List<String> namespaceNames = new ArrayList<String>();
	boolean brackets = false;
	int methodCount = 0;
	Obj currentMethod = null;
	Obj currentClass = null;
	Obj currentNamespace = null;
	String currentNamespaceName = "";
	String currentDesName = "nemaDesName";
	boolean returnFound = false;
	boolean errorDetected = false;
	int nVars;
	boolean firstAdd = true;
	Struct t1 = null;
	Struct t2 = null;
	
	Type currentType = null;
	String currentConst = "nista";
	Struct currentMethodStruct = null;
	boolean classArrayRelop = false;
	String methodTName = "nema";
	boolean whileForeach = false;
	boolean minus = false;
	boolean inTBL = false;
	boolean isActPars = false;
	boolean main = false;
	
	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public Term getTerm(Expr e) {
		if (e.getClass()==ExprMinus.class)
			return ((ExprMinus)e).getTerm();
		return ((ExprPlus)e).getTerm();

	}
	
	public void visit(VarDecl varDecl){
		varDeclCount++;
		varNames.add(varDecl.getVarName());
		report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
		
		brackets = (varDecl.getBracketsList().getClass()==SingleBrackets.class);
		if(brackets) {
			Struct array = new Struct(Struct.Array);
			array.setElementType(currentType.struct);
			if(currentNamespaceName.equals("")) {
				Tab.insert(Obj.Var, varDecl.getVarName(), array);
			}else {
				String name = currentNamespaceName + "::" + varDecl.getVarName();
				Tab.insert(Obj.Var, name, array);
			}
		}else {
			Obj typeNode = Tab.find(currentType.getTypeName());
			if (typeNode!=Tab.noObj)
				if(currentNamespaceName.equals("")) {
					Tab.insert(Obj.Var, varDecl.getVarName(), typeNode.getType());
				}else {
					String name = currentNamespaceName + "::" + varDecl.getVarName();
					Tab.insert(Obj.Var, name, typeNode.getType());
				}
		}
	}
	
	public void visit(VarDeclTypeName varDeclTypeName) {
		currentType = varDeclTypeName.getType();
	}
	
	public void visit(VarDeclBody varDeclBody){
		varDeclCount++;
		varNames.add(varDeclBody.getVarBodyName());
		report_info("Deklarisana promenljiva "+ varDeclBody.getVarBodyName(), varDeclBody);

		if(brackets) {
			System.out.println("Niz: " + varDeclBody.getVarBodyName());
			Struct array = new Struct(Struct.Array);
			array.setElementType(currentType.struct);
			if(currentNamespaceName.equals("")) {
				Tab.insert(Obj.Var, varDeclBody.getVarBodyName(), array);
			}else {
				String name = currentNamespaceName + "::" + varDeclBody.getVarBodyName();
				Tab.insert(Obj.Var, name, array);
			}
		}else {
			System.out.println("Promenljiva: " + varDeclBody.getVarBodyName());
			Obj typeNode = Tab.find(currentType.getTypeName());
			if (typeNode!=Tab.noObj) {
				if(currentNamespaceName.equals("")) {
					Tab.insert(Obj.Var, varDeclBody.getVarBodyName(), typeNode.getType());
				}else {
					String name = currentNamespaceName + "::" + varDeclBody.getVarBodyName();
					Tab.insert(Obj.Var, name, typeNode.getType());
				}
			}
		}
		
	}
	
	public void visit(SingleBrackets sb) {
		brackets = true;
	}
	
	public void visit(NoBrackets sb) {
		brackets = false;
	}
	
	public void visit(AllConstChar c) {
		currentConst = "char";
	}
	
	public void visit(AllConstBool b) {
		currentConst = "bool";
	} 
	
	public void visit(AllConstNum n) {
		currentConst = "int";
	} 
	
	public void visit(ConstDecl constDecl){
		if(currentType.getTypeName().equalsIgnoreCase(currentConst)) {
			constDeclCount++;
			
			report_info("Deklarisana konstanta "+ constDecl.getConstName(), constDecl);
			Obj constNode = null;
			if(currentNamespaceName.equals("")) {
				constNode = Tab.insert(Obj.Con, constDecl.getConstName(), currentType.struct);
			}else {
				String name = currentNamespaceName + "::" + constDecl.getConstName();
				constNode = Tab.insert(Obj.Con, name, currentType.struct);
			}
			
			if(currentConst == "int") {
				int intN = ((AllConstNum)constDecl.getAllConst()).getNum().getN1();
				constNode.setAdr(intN);
			} 
			if(currentConst == "char") {
				String str = ((AllConstChar)constDecl.getAllConst()).getChar().getC1();
				int intC = str.charAt(0);
				constNode.setAdr(intC);
			}
			if(currentConst == "bool") {
				int intB = 0;
		    	if(((AllConstBool)constDecl.getAllConst()).getBool().getB1() == "true") {
		    		intB = 1;
		    	}
				constNode.setAdr(intB);
			}
			
		} else {
			report_error("Semanticka greska na liniji " + constDecl.getLine() + ": deklarisanoj konstanti " + constDecl.getConstName() + " je pridruzen pogresan tip!", null);
		}
	}
	
	public void visit(ConstDeclTypeName constDeclTypeName) {
		currentType = constDeclTypeName.getType();
	}
	
	public void visit(ConstDeclBody constDeclBody){
		if(currentType.getTypeName().equalsIgnoreCase(currentConst)) {
			constDeclCount++;
			report_info("Deklarisana konstanta "+ constDeclBody.getConstBodyName(), constDeclBody);
			Obj constNode = null;
			if(currentNamespaceName.equals("")) {
				constNode = Tab.insert(Obj.Var, constDeclBody.getConstBodyName(), currentType.struct);
			}else {
				String name = currentNamespaceName + "::" + constDeclBody.getConstBodyName();
				constNode = Tab.insert(Obj.Var, name, currentType.struct);
			}
			
			if(currentConst == "int") {
				int intN = ((AllConstNum)constDeclBody.getAllConst()).getNum().getN1();
				constNode.setAdr(intN);
			}
			if(currentConst == "char") {
				String str = ((AllConstChar)constDeclBody.getAllConst()).getChar().getC1();
				int intC = str.charAt(0);
				constNode.setAdr(intC);
			}
			if(currentConst == "bool") {
				int intB = 0;
		    	if(((AllConstBool)constDeclBody.getAllConst()).getBool().getB1() == "true") {
		    		intB = 1;
		    	}
				constNode.setAdr(intB);
			}
		} else {
			report_error("Semanticka greska na liniji " + constDeclBody.getLine() + ": deklarisanoj konstanti " + constDeclBody.getConstBodyName() + " je pridruzen pogresan tip!", null);
		}
		
	}
	
	public void visit(ClassDecl classDecl){
		Tab.chainLocalSymbols(currentClass);
		Tab.closeScope();
		
		currentClass = null;
	}
	
	public void visit(ClassName className) {
		classNames.add(className.getClassName());
		classDeclCount++;
		
		report_info("Deklarisana klasa "+ className.getClassName(), className);
		currentClass = Tab.insert(Struct.Class, className.getClassName(), Tab.noType);
		Tab.openScope();
	}
	
	public void visit(Namespace nmsp){
		currentNamespace = null;
		currentNamespaceName = "";
	}
	
	public void visit(NamespaceName nmspName) {
		namespaceNames.add(nmspName.getNamespaceName());
		namespaceDeclCount++;
		
		currentNamespaceName = nmspName.getNamespaceName();
		
		report_info("Deklarisan namespace "+ nmspName.getNamespaceName(), nmspName);
	}
	
	public void visit(SingleExtendsType set) {
		
		for(int i = 0; i < classNames.size(); i++) {
    		if(classNames.get(i).equals(set.getType().getTypeName())) {
    			return;
    		}
    	}
		report_error("Semanticka greska na liniji " + set.getLine() + ": unutrašnja klasa " + set.getType().getTypeName() + " ne postoji!", null);

	}
	
	public void visit(FormParsBody formParsBody) {
		varDeclCount++;
		String name;
		if(currentNamespaceName.equals("")) {
			name = formParsBody.getParName();
		}else {
			name = currentNamespaceName + "::" + formParsBody.getParName();
			
		}
		Tab.insert(Obj.Var, name, currentType.struct);
		varNames.add(formParsBody.getParName());
		report_info("Deklarisan parametar funkcije "+ formParsBody.getParName(), formParsBody);
	}
	
	public void visit(FormParsBodyType formParsBodyType) {
		currentType = formParsBodyType.getType();
	}
    
    public void visit(ProgName progName){
		Tab.insert(Obj.Type, "bool", new Struct(5));
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program) { 
    	nVars = Tab.currentScope.getnVars(); //ovaj deo je za generisanje koda
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }
    
    public void visit(Type type) {
    	
    	for(int i = 0; i < classNames.size(); i++) {
    		if(classNames.get(i).equals(type.getTypeName())) {
    			return;
    		}
    	}
    	    	
    	if(!type.getTypeName().equals("bool") 
    		&& !type.getTypeName().equals("char") 
    		&& !type.getTypeName().equals("int"))
				report_error("Semanticka greska na liniji " + type.getLine() + ": tip " + type.getTypeName() + " ne postoji!", null);
    	
    	Obj typeNode = Tab.find(type.getTypeName());
    	if(typeNode == Tab.noObj) {
    		
    		if(!type.getTypeName().equalsIgnoreCase("bool"))
    			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
    		
    		type.struct = Tab.noType;
    	}else {
    		if(Obj.Type == typeNode.getKind()){
    			type.struct = typeNode.getType();
    		}else{
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.struct = Tab.noType;
    		}
    	}
    }
    
    public void visit(MethodTypeName methodTypeName){
    	methodCount++;
    	String methodName;
    	if(!currentNamespaceName.equals("")) {
        	methodName = currentNamespaceName + "::" + methodTypeName.getMethodName();
    	}else {
    		methodName = methodTypeName.getMethodName();
    	}
       	
    	currentMethod = Tab.insert(Obj.Meth, methodName, currentMethodStruct);
    	methodTypeName.obj = currentMethod;
    	Tab.openScope();
		report_info("Obradjuje se funkcija " + methodName, methodTypeName);
    
		if(currentMethod.getName().equals("main") && currentMethodStruct == Tab.noType) {
			main = true;
		}
    }
    
    public void visit(TypePart typePart) {
    	currentMethodStruct = typePart.getType().struct;
    }
    
    public void visit(VoidPart voidPart) {
    	currentMethodStruct = Tab.noType;
    }
    
    public void visit(MethodDecl methodDecl){
    	if(!returnFound && currentMethod.getType() != Tab.noType){
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", null);
    	}
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	
    	returnFound = false;
    	currentMethod = null;
    }
    
    public void visit(DesignatorStatementAssign dsa) {
    	
    	String desName = dsa.getDesignator().getDesignatorName().getDesName();
    	boolean isClass = false;
    	for(int i = 0; i < classNames.size(); i++) {
    		if(classNames.get(i).equals(desName)) {
        		isClass = true;
    		}
    	}
    	    	
    	Obj obj = Tab.find(desName);
    	if(obj.getKind() == Obj.Var || isClass){
    		report_info("Designator je promenljiva ili klasa: " + desName, dsa);
    		if(!isClass) {
    			int kindDes = obj.getType().getKind();
    			while(kindDes == Struct.Array) {
    				kindDes = obj.getType().getElemType().getKind();
    			}
    			
    			int kindExp = getTerm(dsa.getExpr()).getFactor().obj.getType().getKind();
    			while(kindExp == Struct.Array) {
    				kindExp = getTerm(dsa.getExpr()).getFactor().obj.getType().getElemType().getKind();
    			}
    			
    			if(kindDes == kindExp) {
    				report_info("Expr je istog tipa kao i designator. ", dsa);
    			}
    			else report_error("Semantička greška na liniji " + dsa.getLine()+ ": expr nije istog tipa kao i designator: " + desName, null);
    		}
    	}
    	else 
    		report_error("Semantička greška na liniji " + dsa.getLine()+ " : designator " + desName + " nije promenljiva niti klasa! ", null);
    
    }
    
    public void visit(DesignatorStatementInc dsi) {
    	String desName = dsi.getDesignator().getDesignatorName().getDesName();
    	Obj obj = Tab.find(desName);
    	if(obj.getType() == Tab.intType){
    		report_info("Obradjuje se inkrement nad integer-om: " + desName, dsi);
    	}
    	else 
    		report_error("Semantička greška na liniji " + dsi.getLine()+ " : designator " + desName + " nije int! ", null);
    }
    
    public void visit(DesignatorStatementDec dsd) {
    	String desName = dsd.getDesignator().getDesignatorName().getDesName();
    	Obj obj = Tab.find(desName);
    	if(obj.getType() == Tab.intType){
    		report_info("Obradjuje se dekrement nad integer-om: " + desName, dsd);
    	}
    	else 
    		report_error("Semantička greška na liniji " + dsd.getLine()+ " : designator " + desName + " nije int! ", null);
    }
    
    public void visit(DesignatorStatementAct dsa) {
    	String desName = dsa.getDesignator().getDesignatorName().getDesName();
    	Obj obj = Tab.find(desName);
    	if(obj.getKind() == Obj.Meth){
    		report_info("Obradjuje se funkcija: " + desName, dsa);
    	}
    	else 
    		report_error("Semantička greška na liniji " + dsa.getLine()+ " : designator " + desName + " nije funkcija! ", null);
    }
    
    public void visit(While w) {
    	whileForeach = true;
    }
    
    public void visit(Foreach f) {
    	whileForeach = true;
    }
    
    public void visit(For f) {
    	whileForeach = true;
    }
    
    public void visit(StatementWhile sw) {
    	whileForeach = false;
    }
    
    public void visit(StatementForeach sf) {
    	whileForeach = false;
    }
    
    public void visit(StatementFor sf) {
    	whileForeach = false;
    }
    
    public void visit(StatementBreak sbr) {
    	if(whileForeach)
			report_info("Break je u while ili foreach petlji " , sbr);
    	else
			report_error("Semanticka greska na liniji " + sbr.getLine() + " : break nije u while ili foreach petlji!", null);
    }
    
    public void visit(StatementContinue sco) {
    	if(whileForeach)
			report_info("Continue je u while ili foreach petlji " , sco);
    	else
			report_error("Semanticka greska na liniji " + sco.getLine() + " : continue nije u while ili foreach petlji!", null);
    }
    
    public void visit(StatementRead sre) {
    	String desName = sre.getDesignator().getDesignatorName().getDesName();
    	Obj obj = Tab.find(desName);
    	if(obj.getKind() == Obj.Var && obj != Tab.noObj) {
    		report_info("Čita se promenljiva: " + desName, sre);
    	}
    	else 
    		report_error("Semantička greška na liniji " + sre.getLine()+ " : designator " + desName + " nije postojeca promenljiva! ", null);
    }
    
    public void visit(StatementPrint spr) {
    	
    	int kind = getTerm(spr.getExpr()).getFactor().obj.getType().getKind();
    	while(kind == Struct.Array) {
    		kind = getTerm(spr.getExpr()).getFactor().obj.getType().getElemType().getKind();
    	}
    	
    	printCallCount++;
		if(Struct.Int == kind || Struct.Char == kind || Struct.Bool == kind) { 
			report_info("Expr je tipa int, char ili bool. ", spr);
		}
		else report_error("Semantička greška na liniji " + spr.getLine()+ " : expr nije int, char ili bool tipa! ", null);
    }
    
    public void visit(StatementReturn sre) {
		if(currentMethod != null) { 
			report_info("Return je u funkciji", sre);
		}else 
			report_error("Semantička greška na liniji " + sre.getLine()+ " : return se ne nalazi u metodi! ", null);
    }
    
    public void visit(SingleExprListB se) {
    	returnFound = true;
    	Struct currMethType = currentMethod.getType();

    	if(!(currMethType.getKind() == getTerm(se.getExpr()).getFactor().obj.getType().getKind())){
			report_error("Greska na liniji " + se.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    	}else 
    		report_info("Tip izraza u return naredbi se slaze sa tipom povratne vrednosti funkcije", se);
    }
    
    public void visit(NoExprListB ne) {
    	Struct currMethType = currentMethod.getType();

    	if(!currMethType.compatibleWith(Tab.noType)){
			report_error("Greska na liniji " + ne.getLine() + " : " + " trenutna metoda: " + currentMethod.getName() + " nije void tipa", null);
    	}else 
    		report_info("Trenutna metoda jeste void tipa te return naredba ne mora da ima expr", ne);
    }
    
    public void visit(StatementFindAny sfa) {
    	String des1 = sfa.getDesignator().getDesignatorName().getDesName();
    	String des2 = sfa.getDesignator1().getDesignatorName().getDesName();
    	Obj desObj1 = Tab.find(des1);
    	Obj desObj2 = Tab.find(des2);
    	
    	if(desObj1.getType().getKind() == Struct.Bool) {
    		report_info("Prvi designator: " + des1 + " je bool tipa", sfa);
    	}else {
    		report_error("Greska na liniji " + sfa.getLine() + " : " + "prvi designator: " + des1 + " nije bool tipa", null);
    	}
    	
    	if(desObj2.getType().getKind() == Struct.Array) {
    		report_info("Drugi designator: " + des2 + " je jednodimenzioni niz", sfa);
    	}else {
    		report_error("Greska na liniji " + sfa.getLine() + " : " + "drugi designator: " + des2 + " nije jednodimenzioni niz", null);
    	}
    }
    
    public void visit(ActPars ap) {
    	
    }
    
    public void visit(DoubleCondFact dcf) {
    	if(getTerm(dcf.getExpr()).getFactor().obj.getType().getKind() == getTerm(dcf.getExpr()).getFactor().obj.getType().getKind()) {
    		report_info("Expr-i su istog tipa u relacionom izrazu", dcf);
 		Obj obj = Tab.find(currentDesName);
        	
        	if((obj.getType().getKind()!= Struct.Bool || 
        		obj.getType().getKind()!= Struct.Int ||
        		obj.getType().getKind()!= Struct.Char) && 
        		(classNames.contains(currentDesName) || obj.getType().getKind() == Struct.Array)) {
    			if(classArrayRelop)
    	    		report_info("Ispravan operand za poredjenje klasa ili nizova", dcf);
    	    	else
    	    		report_error("Greska na liniji " + dcf.getLine() + " : " + " nisu korisceni dobri operandi za poredjenje klasa ili nizova!", null);
    		}
        	classArrayRelop = false;
    	}else 
    		report_error("Greska na liniji " + dcf.getLine() + " : " + " expr: " + 
    				getTerm(dcf.getExpr()).getFactor().obj.getType().getKind() + " i expr: " +
    				getTerm(dcf.getExpr()).getFactor().obj.getType().getKind() +
    				" nisu istog tipa u relacionom izrazu", null);    	
    	
    	dcf.obj = new Obj(Obj.Con, "", new Struct(5), 0, 1);
    }
    
    public void visit(RelopNoeqv rne) {
    	classArrayRelop = true;
    }
    
    public void visit(RelopEqv rne) {
    	classArrayRelop = true;
    }
    
    public void visit(CondTerm ct) {
    	ct.obj = new Obj(Obj.Con, "", new Struct(5), 0, 1);
    }
    
    public void visit(Condition cond) {
    	cond.obj = new Obj(Obj.Con, "", new Struct(5), 0, 1);
    }
    
    public void visit(ExprMinus exm) {
    	if(exm.getTerm().getFactor().obj.getType().getKind() == Struct.Int) {
    		report_info("Minus je ispred int-a sto je ok", exm);
    	}else
    		report_error("Greska na liniji " + exm.getLine() + " : " + " term nije int tipa nakon minusa!", null);
    	minus = false;
	}
    
    public void visit(ExprBody eb) {
    	if(eb.getTerm().getFactor().obj.getType().getKind() == Struct.Int) {
    		report_info("Addop-uju se int-ovi sto je ok", eb);
    	}else
    		report_error("Greska na liniji " + eb.getLine() + ": " + "term: " + eb.getTerm().getFactor().obj.getName() + " nije int tipa prilikom addop-a!", null);
    }
    
    public void visit(Designator designator) {
    	String name;
    	if(currentNamespaceName.equals("")) {
    		name = designator.getDesignatorName().getDesName();
    	}else {
    		name = currentNamespaceName + "::" + designator.getDesignatorName().getDesName();
    	}
    	Obj obj = Tab.find(name);
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getDesignatorName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    }
    
    public void visit(DesignatorName dn) {
    	currentDesName = dn.getDesName();
    	
    }
    
    public void visit(DesignatorBody dbt) {
    	int kind = getTerm(dbt.getExpr()).getFactor().obj.getType().getKind(); 
    	while(kind == Struct.Array) {
    		kind = getTerm(dbt.getExpr()).getFactor().obj.getType().getElemType().getKind();
    	}
    	if(kind == Struct.Int) {
    		report_info("Expr je int tipa u nizu", dbt);
    	}else
    		report_error("Greska na liniji " + dbt.getLine() + " : " + " expr nije tipa int u nizu!", null);
    }
    
    public void visit(AllTermBodyList atbl) {
    	inTBL = true;
    }
    
    public void visit(Term term) {
    	
    	int kind = term.getFactor().obj.getType().getKind();
    	while(kind == Struct.Array) {
    		kind = term.getFactor().obj.getType().getElemType().getKind();
    	}
    	
    	if(inTBL) {
    		if(kind == Struct.Int) {
        		report_info("Mulop-uju se int-ovi sto je ok", term);
        	}else
        		report_error("Greska na liniji " + term.getLine() + " : " + " prvi factor nije int tipa prilikom mulop-a!", null);
    		inTBL = false;
    	}
    }
    
    public void visit(FactorDesignatorAll fda) {
    	Obj fdaObj = fda.getDesignator().obj;
    	if(isActPars) {
        	if(Obj.Meth == fdaObj.getKind()){
        		//deo vezan za code generator
        		if(Tab.noType == fdaObj.getType()) {
        			report_error("Greska na liniji " + fda.getLine()+" : ime " + fdaObj.getName() + " ne moze se koristiti jer nema povratnu vrednost!", null);
        		}
    			report_info("Pronadjen poziv funkcije " + fdaObj.getName() + " na liniji " + fda.getLine(), null);
    			fda.obj = new Obj(Obj.Meth, fda.getDesignator().getDesignatorName().getDesName(), Tab.intType, 0, 1);
        	}else{
    			report_error("Greska na liniji " + fda.getLine()+" : ime " + fdaObj.getName() + " nije funkcija!", null);
    			fda.obj = new Obj(Obj.Meth, fda.getDesignator().getDesignatorName().getDesName(), Tab.noType, 0, 1);

        	}
    	}else {
    		if(Obj.Var == fdaObj.getKind()) {
        		fda.obj = new Obj(fdaObj.getKind(), fda.getDesignator().getDesignatorName().getDesName(), fdaObj.getType(), fdaObj.getAdr(), fdaObj.getLevel());
    		} else if(Struct.Class == fdaObj.getKind()) {
    			fda.obj = new Obj(Struct.Class, fda.getDesignator().getDesignatorName().getDesName(), Tab.noType, 0, 1);
	    	} else if(0 == fdaObj.getKind())
				fda.obj = new Obj(0, fda.getDesignator().getDesignatorName().getDesName(), fdaObj.getType(), fdaObj.getAdr(), fdaObj.getLevel());
	    	}
    	isActPars = false;
    }
    
    public void visit(FactorDesignatorBody fdb) {
    	isActPars = true;
    }
    
    public void visit(FactorNew fn) {
    	
    	String name = fn.getType().getTypeName();
    	
    	if(!(name.equals("int") || name.equals("char") || name.equals("bool")))
    		report_error("Sledeće ime nije tip: " + name, null);
    	
    	if(name.equals("int")) {
    		fn.obj = new Obj(Obj.Con, "", new Struct(1), 0, 0);
    	}
    	if(name.equals("char")) {
    		fn.obj = new Obj(Obj.Con, "", new Struct(2), 0, 0);
    	}
    	if(name.equals("bool")) {
    		fn.obj = new Obj(Obj.Con, "", new Struct(5), 0, 0);
    	}
    }
    
    public void visit(FactorExpr fe) {
    	fe.obj = getTerm(fe.getExpr()).getFactor().obj;
    }
    
    public void visit(NewTypeBodyOne ntbo) {
    	if(getTerm(ntbo.getExpr()).getFactor().obj.getType().getKind() == Struct.Int) {
    		report_info("Expr je tipa int za new sekciju", ntbo);
    		((FactorNew)ntbo.getParent()).obj=getTerm(ntbo.getExpr()).getFactor().obj;
    	}else
    		report_error("Greska na liniji " + ntbo.getLine() + " : " + " expr nije tipa int u new sekciji!", null);		
    }
    
    public void visit(FactorNum cnst) {
    	cnst.obj = new Obj(Obj.Con, "", new Struct(1), cnst.getValueN(), 0);
    }
    
    public void visit(FactorChar chr){
    	String str = chr.getValueC();
		int intC = str.charAt(0);
    	chr.obj = new Obj(Obj.Con, "", new Struct(2), intC, 0);
    }
    
    public void visit(FactorBool cb){
    	int b = 0;
    	if(cb.getValueB() == "true") {
    		b = 1;
    	}
    	cb.obj = new Obj(Obj.Con, "", new Struct(5), b, 0);
    }
    
//    public void visit(FactorHash cnst) {
//    	cnst.obj = new Obj(Obj.Con, "", new Struct(1), cnst.getValueH(), 0);
//    }
//    
//    public void visit(FactorHashDes fda) {
//    	Obj fdaObj = fda.getDesignator().obj;
//    	if(isActPars) {
//        	if(Obj.Meth == fdaObj.getKind()){
//        		//deo vezan za code generator
//        		if(Tab.noType == fdaObj.getType()) {
//        			report_error("Greska na liniji " + fda.getLine()+" : ime " + fdaObj.getName() + " ne moze se koristiti jer nema povratnu vrednost!", null);
//        		}
//    			report_info("Pronadjen poziv funkcije " + fdaObj.getName() + " na liniji " + fda.getLine(), null);
//    			fda.obj = new Obj(Obj.Meth, fda.getDesignator().getDesignatorName().getDesName(), Tab.intType, 0, 1);
//        	}else{
//    			report_error("Greska na liniji " + fda.getLine()+" : ime " + fdaObj.getName() + " nije funkcija!", null);
//    			fda.obj = new Obj(Obj.Meth, fda.getDesignator().getDesignatorName().getDesName(), Tab.noType, 0, 1);
//
//        	}
//    	}else {
//    		if(Obj.Var == fdaObj.getKind()) {
//        		fda.obj = new Obj(fdaObj.getKind(), fda.getDesignator().getDesignatorName().getDesName(), fdaObj.getType(), fdaObj.getAdr(), fdaObj.getLevel());
//    		} else if(Struct.Class == fdaObj.getKind()) {
//    			fda.obj = new Obj(Struct.Class, fda.getDesignator().getDesignatorName().getDesName(), Tab.noType, 0, 1);
//	    	} else if(0 == fdaObj.getKind())
//				fda.obj = new Obj(0, fda.getDesignator().getDesignatorName().getDesName(), fdaObj.getType(), fdaObj.getAdr(), fdaObj.getLevel());
//	    	}
//    	isActPars = false;
//    }
        
    public boolean passed(){
    	return !errorDetected;
    }
    
}
