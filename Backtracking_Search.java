import java.util.HashMap;
import java.util.Iterator;


public class Backtracking_Search {
	
	public HashMap<Variable,String> backtrackingSearch(CSP csp) {
		return backtrack(csp.assignments,csp);
	}
	public HashMap<Variable,String> backtrack(HashMap<Variable,String> assignments,CSP csp){
		int check=0;
		for(String domain: assignments.values()) {
			if(domain==null) {
				check++;
			}
		}
		if(check==0) {
			return assignments;
		}else {
		Variable var=csp.unassignedVar.peek();
		csp.unassignedVar.pop();
		for(String i:csp.domains) {
			for(Constraint x: csp.constraints) {
				if(x.a.equals(var) && (!x.b.domain.equals(i))) {
						csp.assignments.put(var, i);
						return backtrack(assignments,csp);
				}else {
					assignments.remove(var, i);
				}
			}
		}
		
	}
		return null;
		
	}
}
