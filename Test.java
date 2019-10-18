import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Assignments result=new Assignments();
		AustraliaMapCSP aus=new AustraliaMapCSP();
		NQueen nq=new NQueen();
		JobScheduling js=new JobScheduling();
		Y_XSquare xy=new Y_XSquare();
		Mackworth mw=new Mackworth();
		
		System.out.println("The Australia Map Coloring problem.");
		long start = new Date().getTime();
		result=aus.AustraliaMapCSP();
		long end = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end-start)/1000.0);
		
		if(result==null) {
			System.out.println("Not possible");
		}else {
			printMap(result.map);
		}
		
		System.out.println("------------------------------------------------\n");
		
		System.out.println("The Job Shop Scheduling problem.");
		long start1 = new Date().getTime();
		result=js.JobScheduling();
		long end1 = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end1-start1)/1000.0);
		
		if(result==null) {
			System.out.println("Not possible");
		}else {
			printMap(result.map);
		}
		
		System.out.println("------------------------------------------------\n");
		
		System.out.println("The n-Queens problem.");
		long start2 = new Date().getTime();
		System.out.println("Enter the number of queens you want to use: ");
		Scanner in= new Scanner(System.in);
		int n=in.nextInt();
		result=nq.NQueen(n);
		long end2 = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end2-start2)/1000.0);
		
		if(result==null) {
			System.out.println("Not possible");
		}else {
			printMap(result.map);
		}
		
		System.out.println("------------------------------------------------\n");
		
		System.out.println("AC3 for Y=X^2");
		long start3 = new Date().getTime();
		result=xy.Y_XSquare();
		long end3 = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end3-start3)/1000.0);
		
		if(result==null) {
			System.out.println("Not possible");
		}else {
			printMap(result.map);
		}
		
		System.out.println("------------------------------------------------\n");
		
		System.out.println("AC3 for Mackworth.");
		long start4 = new Date().getTime();
		result=mw.Mackworth();
		long end4 = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end4-start4)/1000.0);
		
		if(result==null) {
			System.out.println("Not possible");
		}else {
			printMap(result.map);
		}
		
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
