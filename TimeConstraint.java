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
		boolean check=true;
		if((x.a.equals(var)) && (!assignments.containsKey(x.b))) {
			return true;
		}else if((x.a.equals(var)) && (assignments.containsKey(x.b))){
			int val2=(Integer)assignments.get(x.b);
			if(((Integer)value+ x.a.time<= val2)) {
				return true;
			}else {
				return false;
			}
		}else if((x.b.equals(var)) && (!assignments.containsKey(x.a))) {
			return true;
		}else if((x.b.equals(var)) && (assignments.containsKey(x.a))){
			int val2=(Integer)assignments.get(x.a);
			if(((Integer)value+ x.b.time<= val2)) {
				return true;
			}else {
				return false;
			}
		}else if(!x.a.equals(var) && !x.b.equals(var)) {
			return true;
		}else {
			return false;
		}
	}

}
