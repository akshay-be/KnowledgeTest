package accolite;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CollectionsQ5 {

	public static void main(String[] args) {

		Set<B> set = new HashSet<B>();
		System.out.println("Contains : "+set.contains(new B()));
		
		for(int i=0;i<10;i++){
			boolean state =set.add(new B());
			System.out.println("add : "+state);
		}
		
		System.out.println("Contains : "+set.contains(new B()));
		
		System.out.println("Size : "+set.size());
	
	}

}


class B {

	@Override
	public int hashCode() {
		Random rand = new Random();
		return rand.nextInt();

	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("eq");
		return true;
	}
	
}