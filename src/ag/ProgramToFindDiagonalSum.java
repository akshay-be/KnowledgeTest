package ag;

public class ProgramToFindDiagonalSum {

	public static void main(String[] args) {
		
		//int[][] input = { {1,2},{3,4}};
		int[][] input = { {1,2,3},{4,5,6},{7,8,9}};
		//int[][] input = {	{1,2,3,4},{5,6,7,8},{1,2,3,4},{5,6,7,8}};
		changedMatrix1(input);
	}
	
		
	public static void changedMatrix1(int[][] input) {
		
		int rowCount = input.length;
		int colCount = input[0].length;
		int[][] output = new int[rowCount][colCount];
		
		//int total = 0;
		for (int i = 0; i < rowCount; i++){
			for (int j = 0; j < colCount; j++){
				output[i][j] = getNum(input,i,j);
			}
		}
		
		for (int i = 0; i < rowCount; i++){
			for (int j = 0; j < colCount; j++){
				System.out.print(" "+output[i][j]+", ");
			}
			System.out.println();
		}
		
	}
	
	static int  getNum(int[][] input,int m, int n){
		int total = 0;
		for (int i = 0; i <= m; i++){
			for (int j = 0; j <= n; j++){
				total += input[i][j];
			}
		}
		return total;
	}
	
	
}
