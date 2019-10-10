import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CSP {
	
	public CSP(Set<Variable> variables, Set<Constraint> constraints) {
		super();
		this.variables = variables;
		//this.domains = domains;
		this.constraints = constraints;
		for(Variable i: variables) {
			this.assignments.put(i, null);
			unassignedVar.add(i); 
		}
		
	}
	Set<Variable> variables= new HashSet<Variable>();
	//Set<String> domains= new HashSet<String>();
	Set<Constraint> constraints=new HashSet<Constraint>();
	HashMap<Variable,String> assignments= new HashMap<Variable,String>();
	Stack<Variable> unassignedVar=new Stack<Variable>();
}
