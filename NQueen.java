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
		//System.out.println("dnwjfnwjdnw" +csp.constraints.size());
		
		Backtracking_Search bk=new Backtracking_Search();
		Assignments assignments=new Assignments();
		result=bk.backtrack(assignments, csp);
		return result;
		
	}
}
