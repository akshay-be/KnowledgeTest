package learn.plus;

public class TestInheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InheritanceTestA innheritanceTestA = new InheritanceTestB();
		innheritanceTestA.doNothing();
		System.out.println(innheritanceTestA.i);
	}

}
