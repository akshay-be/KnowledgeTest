package hackerrank.test;

public class HourGlassProblem {

	public static void main(String[] args) {
		
		int arr[][] = new int[][]{
									{1,  1,  1,  0, 0, 0},
									{0,  1,  0,  0, 0, 0},
									{1,  1,  1,  0, 0, 0},
									{0,  9,  2, -4,-4, 0},
									{0,  0,  0, -2, 0, 0},
									{0,  0, -1, -2,-4, 0},
								};
		
		
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=0; i < 5; i++){
            for(int j=0; j < 5; j++){
                if(i>=1 && j >=1){
                    int sum =  arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1]
                              + arr[i][j] 
                              + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
                    if(maxSum<sum){
                    	maxSum = sum;
                    }
                        
                }
            }
        }
		System.out.println(maxSum);
	}
}
