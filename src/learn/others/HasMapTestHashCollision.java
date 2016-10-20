package learn.others;

import java.util.HashMap;

public class HasMapTestHashCollision {

	public static void main(String[] args) {
		HashMap<A,String> hm = new HashMap<A,String>();
		System.out.println("0");
		hm.put(new A(1), "Akshay");
		System.out.println("1");
		hm.put(new A(2), "Akshay1");
		System.out.println("2");
		hm.put(new A(3), "Akshay2");
		
		System.out.println("before get");
		hm.get(new A(1));
	}
}

class A {
	int i = 0;
	
	A(int i){
		this.i = i;
	}
	
	@Override
	public String toString (){
		return ""+i;
	}
	
	@Override
	public int hashCode(){
		System.out.println("hashCode : "+i);
		return 1;
	}
	
	@Override
	public boolean equals(Object ob){
		A a = (A) ob;
		System.out.println("this : "+i+", ob :"+a.i);
		if(i==a.i){
			return true;
		}
		return false; 
	}
}
