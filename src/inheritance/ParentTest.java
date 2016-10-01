package inheritance;

public class ParentTest {

	public static void main(String[] args){
		Parent p = new Child();
		p.myMethod(new String());
	}

}

class Parent {

	public Object myMethod(Object ob){
		System.out.println("Parent...1");
		return new Object();
	}

}

class Child extends Parent {
	
	public String myMethod(Object sb){
		System.out.println("Child...2");
		return new String();
	}
	
}
