package hackerrank.algorithm.warmup;

import java.util.Scanner;

public class PlusMinus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        double positiveCount=0,negativeCount=0,zeroCount=0;
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
            if( arr[i] < 0){
                negativeCount++;
            }else if(arr[i] > 0) {
                positiveCount++;
            }else {
                zeroCount++;
            }
        }
        
        System.out.println(positiveCount/n);
        System.out.println(negativeCount/n);
        System.out.println(zeroCount/n);
	}

}
