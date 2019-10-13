import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Variable {
	
	Object value;
	Set<Object> domains= new HashSet<Object>();
	int time;
	
	Variable(Object value,Set<Object> domain) {
		this.value=value;
		this.domains=domain;
		
	}
}
