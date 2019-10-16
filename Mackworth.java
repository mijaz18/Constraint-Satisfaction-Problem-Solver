import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Mackworth {

	public Assignments Mackworth() {
		ArrayList<Object> domain12=new ArrayList<Object>();
		ArrayList<Object> domain35=new ArrayList<Object>();
		ArrayList<Variable> variables=new ArrayList<Variable>();
		Set<Constraint> constraints=new HashSet<Constraint>();
		Assignments result=new Assignments();
		CSP csp=new CSP(variables,constraints);
		domain12.add("a");
		domain12.add("b");
		domain12.add("c");
		domain35.add("a");
		domain35.add("b");
		Variable X1=new Variable("X1",domain12);
		Variable X2=new Variable("X2",domain12);
		Variable X3=new Variable("X3",domain35);
		Variable X4=new Variable("X4",domain35);
		Variable X5=new Variable("X5",domain35);
		csp.variables.add(X1);
		csp.variables.add(X2);
		csp.variables.add(X3);
		csp.variables.add(X4);
		csp.variables.add(X5);
		csp.constraints.add(new LexicConstraint(X1,X3));
		csp.constraints.add(new LexicConstraint(X2,X3));
		csp.constraints.add(new LexicConstraint(X4,X3));
		csp.constraints.add(new LexicConstraint(X5,X3));
		csp.constraints.add(new LexicConstraint(X4,X5));
		AC3 ac3=new AC3();
		Assignments assignments=new Assignments();
		result=ac3.backtrack(assignments, csp);
		return result;
	}
}
