import java.util.HashMap;

public class ColorConstraint extends Constraint {

	public ColorConstraint(Variable a, Variable b) {
		//super(a, b);
		super.a=a;
		super.b=b;
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean consistencyCheck(Object value, Constraint x, Variable var, HashMap<Variable, Object> assignments, CSP csp) {
		if((x.a.equals(var)) && (!assignments.containsKey(x.b))) {
			return true;
	}else if((x.a.equals(var)) && (assignments.containsKey(x.b))){
		if(!assignments.get(x.b).equals(value)) {
			return true;
		}else {
			return false;
		}
	}else if((x.b.equals(var)) && (!assignments.containsKey(x.a))) {
		return true;
	}else if((x.b.equals(var)) && (assignments.containsKey(x.a))){
		if(!assignments.get(x.a).equals(value)) {
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
