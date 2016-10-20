package learn.plus;

import java.io.FileNotFoundException;

public class TestException {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception  {
		TestExceptionA a = new TestExceptionB();
		a.pintName();

	}

}

class TestExceptionA {
	public void pintName() throws FileNotFoundException {
		System.out.println("Value A");
	}
}

class TestExceptionB extends TestExceptionA {
	@Override
	public void pintName() throws NullPointerException {
		System.out.println("Value B");
	}
}
