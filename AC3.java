import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map.Entry;

public class AC3 {
	
	public Assignments backtrackingSearch(CSP csp) {
		return backtrack(new Assignments(),csp);
		
	}
	
	
	public Assignments backtrack(Assignments assignments,CSP csp){
		int cons=0;
		boolean inferences;
		Assignments result=new Assignments();
		if(isComplete(assignments.map,csp)==true) {
			//System.out.println("Stop");
			return assignments;
		}else {
			csp.unassignedVar=setAssigned(assignments.map,csp);
			Variable var= csp.unassignedVar.get(0);
			
			System.out.println(var.value);
			for(Object i:var.domains) {
				cons=0;
				long start = new Date().getTime();
				for(Constraint x: csp.constraints) {
					
					if(x.consistencyCheck(i,x,var,assignments.map,csp)) {
						cons++;
					}else {
						cons=0;
					}
					
				}
				long end = new Date().getTime();
				//System.out.format("time: %.3f secs\n", (end-start)/1000.0);
				if(cons==csp.constraints.size()) {
					assignments.map.put(var, i);
					printMap(assignments.map);
					inferences= AC_3(csp);
					if(inferences==true) {
						result=backtrack(assignments,csp);
						if(!(result==null)) {
							return result;
						}
					}
					printMap(assignments.map);
					System.out.println();
					/*result=backtrack(assignments,csp);
					if(!(result==null)) {
						return result;
					}else {*/
					assignments.map.remove(var,i);		
				//}
					
				}
			}
		}
			return null;		
	}
	
	public static boolean AC_3(CSP csp) {
		Queue<Arcs> q=new LinkedList<Arcs>();
		for(Arcs b: csp.arcs) {
			q.add(b);
		}
		
		while(!q.isEmpty()) {
			Arcs ar=q.poll();
			csp.arcs.remove(ar);
			if(Revise(csp,ar.a,ar.b)) {
				if(ar.a.domains.size()==0) {
					return false;
				}
				for(Arcs x: csp.arcs) {
					if(ar.a.equals(x.a)) {
						q.add(x);
					}else if(ar.a.equals(x.b)) {
						q.add(x);
					}
				}
			}
			
		}
		return true;
	}
	
	public static boolean Revise(CSP csp, Variable a, Variable b) {
		boolean revised=false;
		boolean check=false;
		for(Object x: a.domains) {
			for(Object y: b.domains) {
				if(Satisfy(x,y)) {
					check=true;
				}
			}
			if(check==false) {
				//System.out.println(x);
				a.domains.remove(x);
				revised=true;
				check=false;
			}
		}
		return revised;
	}
	
	public static boolean Satisfy(Object x, Object y) {
		boolean check=false;
		int x_i=(int)x;
		int y_j=(int)y;
		if(Math.pow(x_i, 2)==y_j) {
			check=true;
		}
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
						//System.out.println("UUUUUUUUUU");
					check=false;	
					}
				}
				if(check==true) {
					//System.out.println("UUUUUUUUUU");
					s.add(y);
				}
			}
			return s;
		
	}
	
	public static void printMap(HashMap<Variable,Object> assignments) {
		//System.out.println(assignments.size());
		for (Entry<Variable, Object> entry : assignments.entrySet()) {
		    Variable key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println("Variable: "+key.value+" "+"Value: "+value);
		}
	}

}
