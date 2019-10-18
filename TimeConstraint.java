import java.util.HashMap;

public class TimeConstraint extends Constraint {

	public TimeConstraint(Variable a, Variable b) {
		//super(a, b);
		super.a=a;
		super.b=b;
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	boolean consistencyCheck(Object value, Constraint x, Variable var, HashMap<Variable, Object> assignments, CSP csp) {
		int val= (int)value;
		if((x.a.equals(var)) && (!assignments.containsKey(x.b))) {
			return true;
		}else if((x.a.equals(var)) && (assignments.containsKey(x.b))){
			int val2=(int)assignments.get(x.b);
			if((val+ x.a.time<= val2)) {
				return true;
			}
		}else if((x.b.equals(var)) && (!assignments.containsKey(x.a))) {
			return true;
		}else if((x.b.equals(var)) && (assignments.containsKey(x.a))){
				if((int)assignments.get(x.a)+ x.a.time <= val) {
					return true;
				}else {
					return false;
				}
		}else if(!x.a.equals(var) && !x.b.equals(var)) {
				return true;
			}
		return false;
		}
	}
