
public class XYsquareArcY extends Arcs {

	public XYsquareArcY(Variable a, Variable b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	boolean consistencyCheck(Object a, Variable b, CSP csp) {
				int X= (int)a;
				for(Object y: b.domains) {
					int Y= (int) y;
					if(Math.pow(X, 0.5)==Y) {
						return true;
					}
				}
			return false;
		}

}
