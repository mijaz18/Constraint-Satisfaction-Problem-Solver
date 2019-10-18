import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Y_XSquare {
	
	public Assignments Y_XSquare() {
		ArrayList<Object> domainx=new ArrayList<Object>();
		ArrayList<Object> domainy=new ArrayList<Object>();
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
		csp.arcs.add(ar);
		csp.arcs.add(ar1);
		csp.constraints.add(new XSquareConstraint(X,Y));
		System.out.print("Variables: ");
		for(Variable x: csp.variables) {
			System.out.print(x.value+ " ");
		}
		System.out.println();
		System.out.print("Domain X: ");
		for(Object x: domainx) {
			System.out.print(x+ " ");
		}
		System.out.println();
		System.out.print("Domain Y: ");
		for(Object x: domainy) {
			System.out.print(x+ " ");
		}
		
		System.out.println();
		System.out.print("Constraints: ");
		for(Constraint x: csp.constraints) {
			System.out.print("{" +x.a.value+ ","+ x.b.value+ "}"+ " ");
		}
		
		System.out.println("\n");
		System.out.println("Solution: ");
		AC3 ac3=new AC3();
		Assignments assignments=new Assignments();
		result=ac3.backtrack(assignments, csp);
		return result;
	}

}
