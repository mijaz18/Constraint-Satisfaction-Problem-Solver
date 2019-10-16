import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Y_XSquare {
	
	public Assignments Y_XSquare() {
		ArrayList<Object> domainx=new ArrayList<Object>();
		ArrayList<Object> domainy=new ArrayList<Object>();
		//ArrayList<Object> domainx=new ArrayList<Object>();
		//Set<Object> domainy=new HashSet<Object>();
		ArrayList<Variable> variables=new ArrayList<Variable>();
		Set<Constraint> constraints=new HashSet<Constraint>();
		Assignments result=new Assignments();
		CSP csp=new CSP(variables,constraints);
		for(int i=0;i<=9;i++) {
			domainx.add(i);
			domainy.add(i);
		}
		Variable X=new Variable("X",domainx);
		Variable Y=new Variable("Y",domainy);
		csp.variables.add(X);
		csp.variables.add(Y);
		Arcs ar=new XYsquareArcX(X,Y);
		Arcs ar1=new XYsquareArcY(Y,X);
		//Arcs ar2=new Arcs(X,Y);
		csp.arcs.add(ar);
		csp.arcs.add(ar1);
		//csp.arcs.add(ar2);
		csp.constraints.add(new XSquareConstraint(X,Y));
		AC3 ac3=new AC3();
		Assignments assignments=new Assignments();
		result=ac3.backtrack(assignments, csp);
		return result;
	}

}
