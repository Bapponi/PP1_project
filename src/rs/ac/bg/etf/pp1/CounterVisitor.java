package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {
	
	protected int count;
	
	public int getCount() {
		return count;
	}

	public static class FormParamCounter extends CounterVisitor{
		
		public void visit(FormParsBody fp) {
			count++;
		}
	}
	
	public static class VarCounter extends CounterVisitor{
		
		public void visit(VarDecl vd) {
			count++;
		}
	}
	
	public static class VarBodyCounter extends CounterVisitor{
		
		public void visit(VarDeclBody vdb) {
			count++;
		}
	}
}