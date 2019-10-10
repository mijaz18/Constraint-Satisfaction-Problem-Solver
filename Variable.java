import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Variable {
	
	String name;
	Set<String> domains= new HashSet<String>();
	
	Variable(String name,Set<String> domain) {
		this.name=name;
		this.domains=domain;
		
	}
}
