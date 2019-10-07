import java.util.HashMap;
import java.util.Iterator;


public class Backtracking_Search {
	
	public HashMap<Variable,String> backtrackingSearch(CSP csp) {
		int check=0;
		for(String domain: csp.assignments.values()) {
			if(domain==null) {
				check++;
			}
		}
		if(check==0) {
			return csp.assignments;
		}else {
			
		}
		return null;
		
	}
}
