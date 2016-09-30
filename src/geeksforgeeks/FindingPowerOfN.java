package geeksforgeeks;

public class FindingPowerOfN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(powerOfN(2, 3));

	}

	/** 
	 * Time Complexity of optimized solution: O(logn)
	 * @param a
	 * @param n
	 * @return
	 */
	public static int powerOfN(int a, int n) {

		if (n == 0) {
			return 1;
		}

		int temp = powerOfN(a, n / 2);

		if (n % 2 == 0) {
			return temp * temp;
		} else {
			return a * temp * temp;
		}
	}
	
	
	/** 
	 * Time Complexity of optimized solution: O(n)
	 * @param a
	 * @param n
	 * @return
	 */
	public static int powerOfNTimeComplexityN(int a, int n) {

		if (n == 0) {
			return 1;
		}
		
		if (n % 2 == 0) {
			return powerOfN(a, n / 2) * powerOfN(a, n / 2);
		} else {
			return a * powerOfN(a, n / 2) * powerOfN(a, n / 2);
		}
	}
}
