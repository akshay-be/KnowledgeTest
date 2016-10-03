package interview.adobe;

public class TryCatchFinallyTest {

	public static int value = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TryCatchFinallyTest t1 = new TryCatchFinallyTest();
		System.out.println("Value : " + t1.getNumber());
		System.out.println("Value1 : " + value);
		System.out.println("Value2 : " + t1.value);
	}

	int getNumber() {

		try {
			value = value + 1;
			return value;
		} catch (Exception e) {
			return 0;
		} finally {
			value = value + 1;
			//return value; //updated value 3 will be return.
		}
		//return value; // Unreachable code
	}

}
