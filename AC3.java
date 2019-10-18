import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map.Entry;

public class AC3 {
	
	public Assignments backtrackingSearch(CSP csp) {
		return backtrack(new Assignments(),csp);
		
	}
	
	
	public Assignments backtrack(Assignments assignments,CSP csp){
		boolean inferences;
		inferences= AC_3(csp,assignments);
		int cons=0;
		Assignments result=new Assignments();
		if(isComplete(assignments.map,csp)==true) {
			return assignments;
		}else {
			if(inferences==false) {
				return null;
			}
			csp.unassignedVar=setAssigned(assignments.map,csp);
			Variable var= csp.unassignedVar.get(0);

			for(Object i:var.domains) {
				cons=0;
				for(Constraint x: csp.constraints) {
					if(x.consistencyCheck(i,x,var,assignments.map,csp)) {
						cons++;
					}else {
						cons=0;
					}
					
				}
				if(cons==csp.constraints.size()) {
					assignments.map.put(var, i);
					inferences= AC_3(csp,assignments);
					if(inferences==true) {
						result=backtrack(assignments,csp);
						if(!(result==null)) {
							return result;
						}
					}
					assignments.map.remove(var,i);		
				}
			}
		}
		return null;		
	}
	
	public static boolean AC_3(CSP csp, Assignments assignments) {
		Queue<Arcs> q=new LinkedList<Arcs>();
		for(Arcs b: csp.arcs) {
			q.add(b);
		}
		
		while(!q.isEmpty()) {
			Arcs ar=q.poll();
			csp.arcs.remove(ar);
			if(Revise(csp,ar.a,ar.b, ar)) {
				if(ar.a.domains.size()==0) {
					return false;
				}
				for(Arcs x: csp.arcs) {
					if(ar.a.equals(x.b) && !x.a.equals(ar.b)) {
						q.add(x);
					}
				}
			}
			
		}
		return true;
	}
	
	public static boolean Revise(CSP csp, Variable a, Variable b, Arcs ar) {
		boolean revised=false;
		boolean check=false;
		ArrayList<Integer> Index=new ArrayList<Integer>();
		for(int i=0; i<a.domains.size(); i++) {
			revised=false;
				if(ar.consistencyCheck(a.domains.get(i), b, csp)) {
					revised=true;
					}
					if(revised==false) {
						Object remove=a.domains.get(i);
						a.domains.set(a.domains.indexOf(remove),null);
						Index.add(i);
						check=true;
					}	
			}

		for(int i=0; i<=Index.size()-1;i++) {
			a.domains.remove(null);
		}
		System.out.println("Domains after AC3 "+a.domains);
			return check;
		}
	
	
	public static boolean isComplete(HashMap<Variable,Object> assignments,CSP csp) {
		ArrayList<Variable> v=setAssigned(assignments,csp);
			if(v.size()==0) {
				return true;
			}else {
				return false;
			}
			
		}
	
	public static ArrayList<Variable> setAssigned(HashMap<Variable,Object> assignments, CSP csp) {
		ArrayList<Variable> s=new ArrayList<Variable>();
		boolean check=true;
			for (Variable y: csp.variables) {
				check=true;
				for(Variable x: assignments.keySet()) {
					if(y.equals(x)) {
					check=false;	
					}
				}
				if(check==true) {
					s.add(y);
				}
			}
			return s;
		
	}
	
	public static void printMap(HashMap<Variable,Object> assignments) {
		for (Entry<Variable, Object> entry : assignments.entrySet()) {
		    Variable key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println("Variable: "+key.value+" "+"Value: "+value);
		}
	}

}
