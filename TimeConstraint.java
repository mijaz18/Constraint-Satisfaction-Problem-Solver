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
		//System.out.println("Variable "+var.value);
		System.out.println("Variable: "+var.value+" Constraint a "+ x.a.value+ " Constraint b "+ x.b.value);
			if((x.a.equals(var)) && (!assignments.containsKey(x.b))) {
				System.out.println("true\n");
				return true;
				
			}else if((x.a.equals(var)) && (assignments.containsKey(x.b))){
				int val2=(int)assignments.get(x.b);
				if((val+ x.a.time<= val2)) {
					System.out.println("true\n");
					return true;
				}
				
			}else if((x.b.equals(var)) && (!assignments.containsKey(x.a))) {
				System.out.println("true\n");
				return true;
				
			}else if((x.b.equals(var)) && (assignments.containsKey(x.a))){
				int val1=(int)assignments.get(x.a);
				if((int)assignments.get(x.a)+ x.a.time <= val) {
					System.out.println("true\n");
					return true;
				}else {
					return false;
				}
			}else if(!x.a.equals(var) && !x.b.equals(var)) {
				System.out.println("true\n");
				return true;
			}
			System.out.println("false\n");
			return false;
		}
	}
