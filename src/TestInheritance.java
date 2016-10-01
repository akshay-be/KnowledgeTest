

class Parent{
	
}
class Child extends Parent{
	
}
public class TestInheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Parent p1 = new Parent();
		Parent p2 = new Child();
		Child c1 = new Child();
		//Child c2 = new Parent();
		
		Child c3 = (Child)new Parent();
	}

}
