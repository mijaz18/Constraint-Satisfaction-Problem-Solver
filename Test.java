import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		HashMap<Variable,String> result=new HashMap<Variable,String>();
		result=AustraliaMapCSP();
		printMap(result);
		//Backtracking_Search bk=new Backtracking_Search();
		//bk.backtrack(assignments, csp)
		

	}
	
	public static HashMap<Variable,String> AustraliaMapCSP() {
		Set<String> domains=new HashSet<String>();
		Set<Variable> variables=new HashSet<Variable>();
		Set<Constraint> constraints=new HashSet<Constraint>();
		HashMap<Variable,String> result=new HashMap<Variable,String>();
		CSP csp=new CSP(variables,constraints);
		domains.add("Red");
		domains.add("Blue");
		domains.add("Green");
		Variable WA = new Variable("WA",domains);
		Variable NT = new Variable("NT",domains);
		Variable Q = new Variable("Q",domains);
		Variable NSW = new Variable("NSW",domains);
		Variable V = new Variable("V",domains);
		Variable SA = new Variable("SA",domains);
		Variable T = new Variable("T",domains);
		csp.variables.add(WA);
		csp.variables.add(NT);
		csp.variables.add(Q);
		csp.variables.add(NSW);
		csp.variables.add(V);
		csp.variables.add(SA);
		csp.variables.add(T);
		for(Variable i: csp.variables) {
			csp.unassignedVar.add(i);
		}
		csp.constraints.add(new Constraint(SA,WA));
		csp.constraints.add(new Constraint(SA,NT));
		csp.constraints.add(new Constraint(SA,Q));
		csp.constraints.add(new Constraint(SA,NSW));
		csp.constraints.add(new Constraint(SA,V));
		csp.constraints.add(new Constraint(SA,NT));
		csp.constraints.add(new Constraint(SA,Q));
		csp.constraints.add(new Constraint(Q,NSW));
		csp.constraints.add(new Constraint(NSW,V));
		Backtracking_Search bk=new Backtracking_Search();
		result=bk.backtrack(csp.assignments, csp);
		return result;
	}
	
	public static void printMap(HashMap<Variable,String> assignments) {
		for (Entry<Variable, String> entry : assignments.entrySet()) {
		    Variable key = entry.getKey();
		    String value = entry.getValue();
		    System.out.println("Variable: "+key.name+" "+"Value: "+value);
		    // ...
		}
	}

}
