import java.util.HashMap;
import java.util.Map.Entry;

public class nQueenConstraint extends Constraint {
	int n;
	public nQueenConstraint(Variable a, int n) {
		super.a=a;
		this.n=n;
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean consistencyCheck(Object value, Constraint x, Variable var, HashMap<Variable, Object> assignments, CSP csp) {
		int row= (Integer)var.value;
		int column= (Integer) value;
		for (Entry<Variable, Object> entry : assignments.entrySet()) {
		    Variable key = entry.getKey();
		    int same_row= (Integer)key.value;
		    int same_column = (Integer)entry.getValue();
		    if(same_column==column || same_row==row) {
		    	return false;
		    }else {
		    	for(int j=0; j<=n; j++) {
		    		int r_1= row+j; //i+1
		    		int c_1=  column+j; //j+1
		    		int r_2= row-j; //i-1
			    	int c_2= column-j; //j-1
			    	if(r_1==same_row && c_1==same_column) {
			    		return false;
			    	}else if(r_2==same_row && c_2==same_column) {
			    		return false;
			    	}else if(r_1==same_row && c_2==same_column) {
			    		return false;
			    	}else if(r_2==same_row && c_1==same_column) {
			    		return false;
			    	}
			    }
			}
		}
			   return true;
	}
	
	public static void printMap(HashMap<Variable,Object> assignments) {
		for (Entry<Variable, Object> entry : assignments.entrySet()) {
		    Variable key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println("Variable: "+key.value+" "+"Value: "+value);
		}
	}


}
