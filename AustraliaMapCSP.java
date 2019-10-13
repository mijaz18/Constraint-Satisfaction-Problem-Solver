import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AustraliaMapCSP {

	public static Assignments AustraliaMapCSP() {
		Set<Object> domains=new HashSet<Object>();
		ArrayList<Variable> variables=new ArrayList<Variable>();
		Set<Constraint> constraints=new HashSet<Constraint>();
		Assignments result=new Assignments();
		CSP csp=new CSP(variables,constraints);
		domains.add("Red");
		domains.add("Blue");
		domains.add("Green");
		Variable WA = new Variable("WA",domains);
		Variable NT = new Variable("NT",domains);
		Variable Q = new Variable("Q",domains);
		Variable NSW = new Variable("NSW",domains);
		Variable V = new Variable("V",domains);
		Variable SA = new Variable("SA",domains);
		Variable T = new Variable("T",domains);
		csp.variables.add(WA);
		csp.variables.add(NT);
		csp.variables.add(Q);
		csp.variables.add(NSW);
		csp.variables.add(V);
		csp.variables.add(SA);
		csp.variables.add(T);
		csp.constraints.add(new ColorConstraint(SA,WA));
		csp.constraints.add(new ColorConstraint(SA,NT));
		csp.constraints.add(new ColorConstraint(SA,Q));
		csp.constraints.add(new ColorConstraint(SA,NSW));
		csp.constraints.add(new ColorConstraint(SA,V));
		csp.constraints.add(new ColorConstraint(WA,NT));
		csp.constraints.add(new ColorConstraint(NT,Q));
		csp.constraints.add(new ColorConstraint(Q,NSW));
		csp.constraints.add(new ColorConstraint(NSW,V));
		Backtracking_Search bk=new Backtracking_Search();
		Assignments assignments=new Assignments();
		result=bk.backtrack(assignments, csp);
		return result;
	}
}
