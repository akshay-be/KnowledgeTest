package interview.accolite;

import java.util.HashSet;
import java.util.Set;

public class CollectionsQ1 {

	public static void main(String[] args) {
		Set<A> set = new HashSet<A>();
		for(int i=0;i<10;i++){
			set.add(new A());
		}
		
		System.out.println(set.size());
	}

}

class A {

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("eq");
		return false;
	}
	
}