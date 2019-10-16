
public class Mackworth_IncArc extends Arcs {

	public Mackworth_IncArc(Variable a, Variable b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean consistencyCheck(Object a, Variable b, CSP csp) {
		
		for(Object c: b.domains) {
			System.out.println("a: "+a+ "b: "+ c);
			for(Constraint x: csp.constraints) {
				if(a.equals(x.a) && c.equals(x.b)) {
					if(a.equals("a") && (c.equals("b")|| c.equals("c"))){
						return true;
					}else if(a.equals("b") && (c.equals("c"))){
						return true;
					}
				}else if(a.equals(x.b) && c.equals(x.a)) {
					if(a.equals("b")&& c.equals("a")) {
						return true;
					}
				}
			}
			
		}
		return false;
	}

}
