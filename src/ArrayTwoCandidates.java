import java.util.Arrays;


public class ArrayTwoCandidates {

	public static void main(String[] args) {
		int data[] = {10,8,0,16,25};
		int sum = 16;
		
		System.out.print("Before : ");
		for (int i : data) {
			System.out.print(" "+i);
		}
		Arrays.sort(data);
		System.out.println(" ");
		System.out.print("After : ");
		for (int i : data) {
			System.out.print(" "+i);
		}
		System.out.println(" ");
		int i=0;
		int r = data.length-1;
		
		while(i<r){
			int temp = data[i]+data[r];
			//System.out.println(temp);
			if(temp==sum){
				System.out.println(data[i]+","+data[r]);
				break;
			}else if(temp>sum){
				r--;
			}else{
				i++;
			}
		}
		
		System.out.println("done..");
	}
}
