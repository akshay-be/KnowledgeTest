package test.practice;

public class SumOfDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SumOfDigits s = new SumOfDigits();
		System.out.println(" "+s.sumOfDigits(199999));

	}
	
	public int sumOfDigits(int num){
		if(num<=9){
				return num;
		}else{
			return (num%10+ sumOfDigits(num/10));
		}
	}

}
