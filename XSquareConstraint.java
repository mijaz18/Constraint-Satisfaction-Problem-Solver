import java.util.HashMap;

public class XSquareConstraint extends Constraint {
	
	public XSquareConstraint(Variable a, Variable b) {
		//super(a, b);
		super.a=a;
		super.b=b;
		// TODO Auto-generated constructor stub
		
	}

	@Override
	boolean consistencyCheck(Object value, Constraint x, Variable var, HashMap<Variable, Object> assignments, CSP csp) {
		boolean check=false;
		int val=(int)value;
		if(x.a.equals(var) && !assignments.containsKey(x.b)) {
			return true;
		}else if(x.a.equals(var) && !assignments.containsKey(x.b)) {
			if((int)assignments.get(x.b)== Math.pow(val, 2)) {
				return true;
			}
		}else if(x.b.equals(var) && !assignments.containsKey(x.a)) {
			return true;
		}else if(x.b.equals(var) && assignments.containsKey(x.a)) {
			if(val== Math.pow((int)assignments.get(x.a), 2)) {
				return true;
			}
		}
		return false;
	}
}
