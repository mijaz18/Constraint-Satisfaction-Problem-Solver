import java.util.HashSet;
import java.util.Set;

public class Constraint {
	
	public Constraint(Scope scope, Set<Rel> rels) {
		super();
		this.scope = scope;
		this.rels = rels;
	}
	Scope scope;
	Set<Rel> rels=new HashSet<Rel>();
	
	
}
