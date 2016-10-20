package learn.others;

public class RevesreNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int number=1234;
		int reversedNum=0;
		while(number!=0){
			reversedNum = reversedNum*10;
			reversedNum = reversedNum+(number%10);
			number=number/10;
		}
		System.out.println(""+reversedNum);
	}

}
