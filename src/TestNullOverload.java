
public class TestNullOverload {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test1 test1 = new Test1();
		test1.testApplication(new Parent());

		TestInheritance inter = new TestInheritance();
		inter.method(null);
	}

}

class Parent{
	
}

class Child extends Parent {
	
}

class TestInheritance {
	
	void method(){
		System.out.println("method NoArgument");
	}
	void method(Object ob){
		System.out.println("method Object");
	}
	void method(Parent ob){
		System.out.println("method Parent");
	}
	/*void method(Child ob){
		System.out.println("method Child");
	}*/
}
class Test1{
	TestInheritance inte = new TestInheritance();
	void testApplication(Object ob){
		Parent p = (Parent) ob;
		inte.method(p);
	}
}
