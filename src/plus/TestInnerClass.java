package plus;

public class TestInnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestInnerA a = new TestInnerA();
		TestInnerA.TestInnerA1 a1 = a.new TestInnerA1() ;
		a1.printVlaue();

	}

}

class TestInnerA {
	class TestInnerA1{
		void printVlaue(){
			System.out.println("A A1");
		}
	}
}
