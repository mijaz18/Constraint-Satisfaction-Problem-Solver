import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Variable {
	
	Object value;
	ArrayList<Object> domains= new ArrayList<Object>();
	int time;
	
	Variable(Object value,ArrayList<Object> domain) {
		this.value=value;
		this.domains=domain;
		
	}
}
