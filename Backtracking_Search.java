import java.util.HashMap;
import java.util.Iterator;


public class Backtracking_Search {
	
	public HashMap<Variable,String> backtrackingSearch(CSP csp) {
		return backtrack(csp.assignments,csp);
	}
	public HashMap<Variable,String> backtrack(HashMap<Variable,String> assignments,CSP csp){
		int check=0;
		for(String i: assignments.values()) {
			if(i.equals("")) {
			check++;
		}
		}if(check==0){
			return assignments;
		}else {
			//System.out.println("Reached here");
			Variable var=csp.unassignedVar.peek();
			System.out.println(var.name);
			csp.unassignedVar.pop();
			for(String i:var.domains) {
				System.out.println(i);
				for(Constraint x: csp.constraints) {
					System.out.println("Checking a "+ x.a.name +" "+"Variable b: "+x.b.name+" Variable var "+ var.name);
					System.out.println("Checking b "+ assignments.get(x.b) +" "+"Value of i "+ i);
					//System.out.println(assignments.size());
					//System.out.println(assignments.get(x.b));
					if((x.a.equals(var) && !assignments.get(x.b).equals(i)) || (x.b.equals(var) && !assignments.get(x.a).equals(i)) ) {
							System.out.println("Variable value "+ var.name);
							System.out.println("Value of variable "+ i);
							csp.assignments.put(var, i);
							return backtrack(assignments,csp);
					}else {
						//assignments.remove(var, i);
					}
				}
			}
			
		}
			return null;
			
		}
	}
