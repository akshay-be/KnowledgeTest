package hackerrank.algorithm.warmup;

public class SumOfDiagonalElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[][] = {
				{1,1,1},
				{3,2,2},
				{9,1,1},
		};
		
		int size = array.length;
		System.out.println(size);
		int diag1=0,diag2 =0;		
		for(int i=0;i<size;i++){
			diag1+=array[i][i];
			diag2+=array[i][size-i-1];
		}

		System.out.println("diag1 : "+diag1);
		System.out.println("diag2 : "+diag2);
		
		System.out.println("Diff : "+Math.abs(diag1-diag2));
		
		
	}

}
