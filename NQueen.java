import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NQueen {

	public Assignments NQueen(int n) {
		ArrayList<Object> domains=new ArrayList<Object>();
		ArrayList<Variable> variables=new ArrayList<Variable>();
		Set<Constraint> constraints=new HashSet<Constraint>();
		Assignments result=new Assignments();
		CSP csp=new CSP(variables,constraints);
		for(int i=1; i<=n;i++) {
			domains.add(i);
		}
		String s;
		for(int i=1;i<=n;i++) {
			s=Integer.toString(i);
			Variable a=new Variable(i,domains);
			csp.variables.add(a);
			csp.constraints.add(new nQueenConstraint(a,n));
			}	
		System.out.print("Variables: ");
		for(Variable x: csp.variables) {
			System.out.print(x.value+ " ");
		}
		System.out.println();
		System.out.print("Domains: ");
		for(Object x: domains) {
			System.out.print(x+ " ");
		}
		
		System.out.println();
		
		System.out.println("\n");
		System.out.println("Solution: ");
		Backtracking_Search bk=new Backtracking_Search();
		Assignments assignments=new Assignments();
		result=bk.backtrack(assignments, csp);
		return result;
		
	}
}
