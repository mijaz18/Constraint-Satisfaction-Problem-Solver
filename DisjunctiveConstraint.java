import java.util.HashMap;

public class DisjunctiveConstraint extends Constraint {
	
	public DisjunctiveConstraint(Variable a, Variable b) {
		super.a=a;
		super.b=b;
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean consistencyCheck(Object value, Constraint x, Variable var, HashMap<Variable, Object> assignments, CSP csp) {
		if(!a.equals(var) && !b.equals(var)) {
			return true;
		}else {
			int val=(int) value;
			if(x.a.equals(var) && !(assignments.containsKey(x.b))) {
				return true;
			}else if(x.a.equals(var) && (assignments.containsKey(x.b))) {
				if(assignments.containsKey(x.b) &&
						((val + x.a.time<= (int)assignments.get(x.b) || (int) assignments.get(x.b) + x.b.time <= val))){
					
					return true;
				}
			}else if(x.b.equals(var) && !(assignments.containsKey(x.a))) {
				return true;
			}else if(x.b.equals(var) && (assignments.containsKey(x.a))) {
				if(assignments.containsKey(x.a) &&
						((val + x.b.time<= (int)assignments.get(x.a) || (int)assignments.get(x.a)+ x.a.time <= val))){
					return true;
				}
			}
			return false;
			}
	}
}
