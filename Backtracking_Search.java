import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;

import javax.swing.SpringLayout.Constraints;


public class Backtracking_Search {
	
	HashMap<Variable,String> a=new HashMap<Variable,String>();
	
	public Assignments backtrackingSearch(CSP csp) {
		return backtrack(new Assignments(),csp);
		
	}
	
	
	public Assignments backtrack(Assignments assignments,CSP csp){
		int cons=0;
		Assignments result=new Assignments();
		if(isComplete(assignments.map,csp)==true) {
			
			return assignments;
		}else {
			//System.out.println("ffffffff");
			csp.unassignedVar=setAssigned(assignments.map,csp);
			Variable var= csp.unassignedVar.get(0);
			
			//System.out.println(var.value);
			for(Object i:var.domains) {
				System.out.println("Domain " +i);
				cons=0;
				long start = new Date().getTime();
				for(Constraint x: csp.constraints) {
					System.out.println(x.a.value);
					System.out.println(x.b.value);
					System.out.println();
					if(x.consistencyCheck(i,x,var,assignments.map,csp)) {
						cons++;
					}else {
						cons=0;
					}
					
				}
				long end = new Date().getTime();
				//System.out.format("time: %.3f secs\n", (end-start)/1000.0);
				if(cons==csp.constraints.size()) {
					System.out.println("Variable chosen "+ var.value);
					assignments.map.put(var, i);
					printMap(assignments.map);
					System.out.println();
					result=backtrack(assignments,csp);
					if(!(result==null)) {
						return result;
					}else {
						assignments.map.remove(var,i);		
				}
					
				}
			}
		}
			return null;		
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
