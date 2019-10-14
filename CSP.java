import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CSP {
	
	public CSP(ArrayList<Variable> variables, Set<Constraint> constraints) {
		super();
		this.variables = variables;
		//this.domains = domains;
		this.constraints = constraints;
		for(Variable i: variables) {
			//this.assignments.put(i, null);
			unassignedVar.add(i); 
		}
		
	}
	ArrayList<Variable> variables= new ArrayList<Variable>();
	//Set<String> domains= new HashSet<String>();
	Set<Constraint> constraints=new HashSet<Constraint>();
	HashMap<Variable,String> assignments= new HashMap<Variable,String>();
	ArrayList<Variable> unassignedVar=new ArrayList<Variable>();
	ArrayList<Arcs> arcs=new ArrayList<Arcs>();
}
