import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

abstract class Constraint {
	
//	Scope scope;
//	Set<Rel> rels=new HashSet<Rel>();
	Variable a;
	Variable b;
	
	abstract boolean consistencyCheck(Object value, Constraint x, Variable var, HashMap<Variable,Object> assignments, CSP csp);
	
}
