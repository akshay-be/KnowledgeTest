package am.pre2round;

public class PrintingAlphabets5x9 {
	
	
	
	public static void main(String[] args) {
		byte prnt = (byte) 'A';
		int i;
		int j;
		int s;
		int nos = 5;

		for (i = 1; i <= 9; i = i + 2) {
			for (s = nos; s >= 1; s--) {
				System.out.print("  ");
			}
			for (j = 1; j <= i; j++) {
				System.out.print(" "+(char)prnt);
				++prnt; // Increments the alphabet
			}
			nos--;
			// for the continuation
			if (i != 9) {
				System.out.print("\n");
			}
		}

	}
}
