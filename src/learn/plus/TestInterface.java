package learn.plus;

public class TestInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A(){
			public void printValue(){
				System.out.println("inside print value");
			}
		};
		
		a.printValue();
	}

}

interface A {
	public void printValue();
}