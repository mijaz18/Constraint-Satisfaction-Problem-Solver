

public class XYsquareArcX extends Arcs {

	public XYsquareArcX(Variable a, Variable b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean consistencyCheck(Object a, Variable b, CSP csp) {
				int X= (int)a;
				for(Object y: b.domains) {
					int Y= (int) y;
					//System.out.println("X: "+ X+ "Y: "+ Y);
					if(Math.pow(X, 2)==Y) {
						System.out.println("X: "+ X+ "Y: "+ Y);
						System.out.println("true");
						return true;
					}
				}
				//System.out.println("X: "+ X+ "Y: "+ Y);
				System.out.println("false");
			return false;
		}
	
	
	

}