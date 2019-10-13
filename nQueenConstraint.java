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
		
		//System.out.println("Row "+ row+ "Column "+ column); 
		
		for (Entry<Variable, Object> entry : assignments.entrySet()) {
		    Variable key = entry.getKey();
		    int same_row= (Integer)key.value;
		    int same_column = (Integer)entry.getValue();
		    if(same_column==column || same_row==row) {
		    	//System.out.println("A WORKS");
		    	return false;
		    }else {
		    	//System.out.println("B WORKS");
		    	for(int j=0; j<=n; j++) {
		    		//System.out.println(j);
		    		int r_1= row+j; //i+1
		    		int c_1=  column+j; //j+1
		    		int r_2= row-j; //i-1
			    	int c_2= column-j; //j-1
			    	//printMap(assignments);
			    	/*
			    	System.out.println("R1: "+r_1+ "Assignments R1: "+same_row);
			    	System.out.println("C1: "+c_1+ "Assignments C1: "+same_column);
			    	System.out.println("R2: "+r_2+ "Assignments R2: "+same_row);
			    	System.out.println("C2: "+c_2+ "Assignments C2: "+same_column);*/
			    	//System.out.println();
			    	if(r_1==same_row && c_1==same_column) {
			    		//System.out.println("B1 WORKS");
			    		return false;
			    	}else if(r_2==same_row && c_2==same_column) {
			    		//System.out.println("B3 WORKS");
			    		return false;
			    	}else if(r_1==same_row && c_2==same_column) {
			    		//System.out.println("B4 WORKS");
			    		return false;
			    	}else if(r_2==same_row && c_1==same_column) {
			    		//System.out.println("B5 WORKS");
			    		return false;
			    	}
			    }
			}
		}
			//System.out.println("C WORKS");
			    return true;
	}
	
	public static void printMap(HashMap<Variable,Object> assignments) {
		//System.out.println(assignments.size());
		for (Entry<Variable, Object> entry : assignments.entrySet()) {
		    Variable key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println("Variable: "+key.value+" "+"Value: "+value);
		}
	}


}
