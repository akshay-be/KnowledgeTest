package puzzlers.ch2;

public class Oddity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isOdd(5));
		System.out.println(isOdd(-5));
		
		System.out.println(isOddBetterApproch(5));
		System.out.println(isOddBetterApproch(-5));

		System.out.println(isOddPerformanceApproch(5));
		System.out.println(isOddPerformanceApproch(-5));
	}
	
	public static boolean isOdd(int i) {
		return i % 2 == 1;
	}
	
	public static boolean isOddBetterApproch(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isOddPerformanceApproch(int i) {
		return (i & 1) != 0;
	}
	

}
