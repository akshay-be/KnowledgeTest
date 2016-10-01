package hackerrank.algorithm.warmup;

import java.math.BigInteger;
import java.util.Scanner;

public class AVeryBigSumProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        
        BigInteger sum = BigInteger.ZERO;
        
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            sum =sum.add(new BigInteger(Integer.toString(arr[arr_i])));    
        }
        System.out.println(sum);
    }
}
