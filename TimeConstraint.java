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
		//System.out.println("Variable "+ var.value);
		if(a.equals(var) || b.equals(var)) {
			if((x.a.equals(var)) && (!assignments.containsKey(x.b))) {
				return true;
				
			} if((x.a.equals(var)) && (assignments.containsKey(x.b))){
				int val2=(int)assignments.get(x.b);
				if((val+ x.a.time<= val2)) {
					return true;
				}
				
			}else if((x.b.equals(var)) && (!assignments.containsKey(x.a))) {
				return true;
				
			} if((x.b.equals(var)) && (assignments.containsKey(x.a))){
				int val1=(int)assignments.get(x.a);
				if((val+ x.b.time<= val1)) {
					return true;
				}
			}else if(!x.a.equals(var) && !x.b.equals(var)) {
				return true;
			} 
			return false;
		}
		return true;
	}

}
