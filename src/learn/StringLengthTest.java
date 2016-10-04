
package learn;

public class StringLengthTest {

	public static void main(String[] args) {
		String PAN = "12345678901234567";
		System.out.println("Length : "+PAN.length());
		if(PAN!=null && PAN.length()>=17){
			System.out.println("if");
			String accountNumber = PAN.substring(0, 17);
			String eighteenthDigit = PAN.substring(17,18);
			System.out.println("accountNumber : "+accountNumber);
			System.out.println("eighteenthDigit : "+eighteenthDigit);
		}else{
			System.out.println("else");
		}

	}

}
