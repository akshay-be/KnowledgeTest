package learn.tricky;

public class IntegerTest {

	public static void main(String[] args) {
		
		/**
		 * Per the Java spec, integer values -128 through 127 are cached (as
		 * Integer objects).
		 * 
		 * Since those values are cached, the representation of 127 will always
		 * point to the same object which makes the first i1 == i2 comparison
		 * true.
		 * 
		 * New objects are created for 128 which will not be the same, causing
		 * the second i1 == i2 comparison to be false.
		 */
		
		Integer i1 = 127;
		Integer i2 = 127;
		System.out.println(i1 == i2);

		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(i3 == i4);
	}

}
