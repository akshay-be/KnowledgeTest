package hackerrank.algorithm.warmup;

import java.util.Scanner;

public class PrintStairCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
		for(int i=0;i<n;i++){
			int spaceCount = 0;
			for(int j =n-i-1 ; j>0;j--){
				System.out.print(" ");
				spaceCount++;
			}
			
			for(int k = 0 ; k<n-spaceCount;k++){
				System.out.print("#");
			}
			System.out.println();
		}
		
		System.out.println("Done");

	}

}
