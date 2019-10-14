import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Y_XSquare {
	
	public Assignments Y_XSquare() {
		Set<Object> domains=new HashSet<Object>();
		Set<Object> domainx=new HashSet<Object>();
		Set<Object> domainy=new HashSet<Object>();
		ArrayList<Variable> variables=new ArrayList<Variable>();
		Set<Constraint> constraints=new HashSet<Constraint>();
		Assignments result=new Assignments();
		CSP csp=new CSP(variables,constraints);
		for(int i=4;i<=16;i++) {
			domains.add(i);
		}
		Variable X=new Variable("X",domains);
		Variable Y=new Variable("Y",domains);
		csp.variables.add(X);
		csp.variables.add(Y);
		Arcs ar=new Arcs(X,Y);
		Arcs ar1=new Arcs(Y,X);
		csp.arcs.add(ar);
		csp.arcs.add(ar1);
		csp.constraints.add(new XSquareConstraint(X,Y));
		AC3 ac3=new AC3();
		Assignments assignments=new Assignments();
		result=ac3.backtrack(assignments, csp);
		return result;
	}

}
