package learn.others;
/**
 *
 * @author Akshay
 *
 */
public class IncrementNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int originalNumber=12;
		int convertedNumber=0;
		int multiplier=1;
		
		System.out.println("Original : "+originalNumber);
		while(originalNumber!=0){
			//System.out.println("Step o : "+originalNumber);
			int remainder = originalNumber%10;
			remainder++;
			originalNumber=originalNumber/10;
			
			convertedNumber=convertedNumber+(remainder*multiplier);
			multiplier=multiplier*10;
			if(remainder==10)
				multiplier=multiplier*10;
			//System.out.println(" Step c: "+convertedNumber);
		}
		System.out.println("Converted : "+convertedNumber);

	}

}
