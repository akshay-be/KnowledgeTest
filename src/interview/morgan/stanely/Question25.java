package interview.morgan.stanely;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Question25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map m = new HashMap<String,String>();
		m.put("1", "Akshay");
		m.put("2", "Ridhi");
		m.put("3", "Arun");


		Collection c = m.values();
		System.out.println(""+c);
		
	
	
		
		System.out.println("Map before : "+m);
		Set s= m.keySet();
		System.out.println("Set before : "+s);
		s.remove("1");
		//s.add("4");
		System.out.println("Set After : "+s);
		System.out.println("Map After : "+m);
	}

}
