import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JobScheduling {

	public Assignments JobScheduling() {
		Set<Object> domains=new HashSet<Object>();
		ArrayList<Variable> variables=new ArrayList<Variable>();
		Set<Constraint> constraints=new HashSet<Constraint>();
		Assignments result=new Assignments();
		CSP csp=new CSP(variables,constraints);
		for(int i=1; i<=27;i++) {
			domains.add(i);
		}
		Variable Axle_f= new Variable("Axle_f",domains);
		Variable Axle_b= new Variable("Axle_b",domains);
		Variable Wheel_rf= new Variable("Wheel_rf",domains);
		Variable Wheel_lf= new Variable("Wheel_lf",domains);
		Variable Wheel_rb= new Variable("Wheel_rb",domains);
		Variable Wheel_lb= new Variable("Wheel_lb",domains);
		Variable Nuts_rf= new Variable("Nuts_rf",domains);
		Variable Nuts_lf= new Variable("Nuts_lf",domains);
		Variable Nuts_rb= new Variable("Nuts_rb",domains);
		Variable Nuts_lb= new Variable("Nuts_lb",domains);
		Variable Cap_rf= new Variable("Cap_rf",domains);
		Variable Cap_lf= new Variable("Cap_lf",domains);
		Variable Cap_rb= new Variable("Cap_rb",domains);
		Variable Cap_lb= new Variable("Cap_lb",domains);
		Variable Inspect= new Variable("Inspect",domains);
		Axle_f.time=10;
		Axle_b.time=10;
		Wheel_rf.time=1;
		Wheel_lf.time=1;
		Wheel_rb.time=1;
		Wheel_lb.time=1;
		Nuts_rf.time=2;
		Nuts_lf.time=2;
		Nuts_rb.time=2;
		Nuts_lb.time=2;
		Cap_rf.time=1;
		Cap_lf.time=1;
		Cap_rb.time=1;
		Cap_lb.time=1;
		Inspect.time=3;
		csp.variables.add(Axle_f);
		csp.variables.add(Axle_b);
		csp.variables.add(Wheel_rf);
		csp.variables.add(Wheel_lf);
		csp.variables.add(Wheel_rb);
		csp.variables.add(Wheel_lb);
		csp.variables.add(Nuts_rf);
		csp.variables.add(Nuts_lf);
		csp.variables.add(Nuts_rb);
		csp.variables.add(Nuts_lb);
		csp.variables.add(Cap_rf);
		csp.variables.add(Cap_lf);
		csp.variables.add(Cap_rb);
		csp.variables.add(Cap_lb);
		csp.variables.add(Inspect);
		csp.constraints.add(new TimeConstraint(Axle_f,Wheel_rf));
		csp.constraints.add(new TimeConstraint(Axle_f,Wheel_lf));
		csp.constraints.add(new TimeConstraint(Axle_b,Wheel_rb));
		csp.constraints.add(new TimeConstraint(Axle_b,Wheel_lb));
		csp.constraints.add(new TimeConstraint(Wheel_rf,Nuts_rf));
		csp.constraints.add(new TimeConstraint(Wheel_lf,Nuts_lf));
		csp.constraints.add(new TimeConstraint(Wheel_rb,Nuts_rb));
		csp.constraints.add(new TimeConstraint(Wheel_lb,Nuts_lb));
		csp.constraints.add(new TimeConstraint(Nuts_rf,Cap_rf));
		csp.constraints.add(new TimeConstraint(Nuts_lf,Cap_lf));
		csp.constraints.add(new TimeConstraint(Nuts_rb,Cap_rb));
		csp.constraints.add(new TimeConstraint(Nuts_lb,Cap_lb));
		csp.constraints.add(new TimeConstraint(Cap_lb,Inspect));
		csp.constraints.add(new TimeConstraint(Cap_rb,Inspect));
		csp.constraints.add(new TimeConstraint(Cap_lf,Inspect));
		csp.constraints.add(new TimeConstraint(Cap_rf,Inspect));
		//csp.constraints.add(new TimeConstraint(Nuts_rf,Inspect));
		//csp.constraints.add(new TimeConstraint(Nuts_lf,Inspect));
		//csp.constraints.add(new TimeConstraint(Nuts_rb,Inspect));
		//csp.constraints.add(new TimeConstraint(Nuts_lb,Inspect));
		//csp.constraints.add(new TimeConstraint(Wheel_rf,Inspect));
		//csp.constraints.add(new TimeConstraint(Wheel_lf,Inspect));
		//csp.constraints.add(new TimeConstraint(Wheel_rb,Inspect));
		//csp.constraints.add(new TimeConstraint(Wheel_lb,Inspect));
		//csp.constraints.add(new TimeConstraint(Axle_f,Inspect));
		//csp.constraints.add(new TimeConstraint(Axle_b,Inspect));
		//csp.constraints.add(new TimeConstraint(Axle_f,Axle_b));
		//csp.constraints.add(new TimeConstraint(Axle_b,Axle_f));
		
		Backtracking_Search bk=new Backtracking_Search();
		Assignments assignments=new Assignments();
		result=bk.backtrack(assignments, csp);
		return result;
	}
}
