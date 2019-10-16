import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Assignments result=new Assignments();
		AustraliaMapCSP aus=new AustraliaMapCSP();
		NQueen nq=new NQueen();
		JobScheduling js=new JobScheduling();
		Y_XSquare xy=new Y_XSquare();
		Mackworth mw=new Mackworth();
		
		//result=aus.AustraliaMapCSP();

		long start = new Date().getTime();
		//result=nq.NQueen(5);
		//result=js.JobScheduling();
		//result=mw.Mackworth();
		result=xy.Y_XSquare();
		long end = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end-start)/1000.0);
		if(result==null) {
			System.out.println("Not possible");
		}else {
			printMap(result.map);
		}
		//System.out.println(result.map.size());
		//System.out.println("Complete");
		//Backtracking_Search bk=new Backtracking_Search();
		//bk.backtrack(assignments, csp)
		

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
