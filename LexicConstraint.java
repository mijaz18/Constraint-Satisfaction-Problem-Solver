import java.util.HashMap;

public class LexicConstraint extends Constraint {
	
	public LexicConstraint(Variable a, Variable b) {
		//super(a, b);
		super.a=a;
		super.b=b;
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean consistencyCheck(Object value, Constraint x, Variable var, HashMap<Variable, Object> assignments, CSP csp) {
		if(x.a.equals(var) && !assignments.containsKey(x.b)) {
			return true;
		}else if(x.a.equals(var) && assignments.containsKey(x.b)) {
			String value_b= (String)assignments.get(x.b);
			if(value_b.equals("b") && value.equals("a")) {
				return true;
			}else if(value_b.equals("c") && (value.equals("a") || value.equals("c"))){
				return true;
			}
		}else if(x.b.equals(var) && !assignments.containsKey(x.a)) {
			return true;
		}else if(x.b.equals(var) && assignments.containsKey(x.a)) {
			String value_a= (String)assignments.get(x.a);
			if(value_a.equals("b") && value.equals("a")) {
				return true;
			}else if(value_a.equals("c") && (value.equals("a") || value.equals("c"))){
				return true;
			}
		}
		return false;
	}

}
