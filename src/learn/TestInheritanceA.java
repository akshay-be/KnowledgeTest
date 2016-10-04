package learn;


class ParentA{
	
}
class ChildA extends ParentA{
	
}
public class TestInheritanceA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ParentA p1 = new ParentA();
		ParentA p2 = new ChildA();
		ChildA c1 = new ChildA();
		//Child c2 = new Parent();
		
		ChildA c3 = (ChildA)new ParentA();
	}

}
