package learn;
public class NumberUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(10));
		listOfStrongNumbers(1,99999);

	}
	
	public static int revesreNumber(int number){
		int reversedNum=0;
		System.out.println("Input Number : "+number);
		while(number!=0){
			reversedNum = reversedNum*10;
			reversedNum = reversedNum+(number%10);
			number=number/10;
		}
		System.out.println("Reversed Number : "+reversedNum);
		return reversedNum;
	}

	public static  void listOfAmstrongNumbers(int min,int max){
		for(int i=min;i<=max;i++){
			amstrongNumber(i);
		}
	}
	
	public static boolean amstrongNumber(int number){
		int sum=0;
		int temp=number;
		while(temp!=0){
			int remainder = temp%10;
			sum = sum+(remainder*remainder*remainder);
			temp=temp/10;
		}
		if(number==sum){
			System.out.println(number+" is  amstrong Number");
			return true;
		}else
			return false;
	}
	
	public static  void listOfStrongNumbers(int min,int max){
		for(int i=min;i<=max;i++){
			strongNumber(i);
		}
	}
	public static boolean strongNumber(int number){
		int sum=0;
		int temp = number;
		while(temp!=0){
			int remainder = temp%10;
			sum = sum + factorial(remainder);
			temp = temp/10;
		}
		 if(sum==number){
			 System.out.println(number+" Number is strong");
			 return true;
		 }else{
			 return false;
		 }	 
	}
	public static int factorial(int number){
		if(number==0)
			return 1;
		else
			number = number*factorial(--number);
		return number;
	}
}
