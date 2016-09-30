package jpmchase;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetTest {

	public static void main(String[] args) {
		/*HashSet set = new HashSet();
		for(short s=0;s<3;s++){
			set.add(s);
			//System.out.println(s-1);
			short temp = 1;
			short temp1 = (short) (s-temp);
			Integer n =null;
			Float f1=null;
			
			set.remove(temp1);
		}
		
		for (Object object : set) {
			System.out.println(object instanceof Short);
			System.out.println(object instanceof Integer);
		}*/
		
		
		TreeSet<String> set = new TreeSet<String>();
		set.add("1");
		set.add("2");
		set.add("10");
		set.add("One");
		
		System.out.println(set);
	}
}
