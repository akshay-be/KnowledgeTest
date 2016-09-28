
public class CheckThreadTrace {

	public static void main(String[] args) {
		
		 main1();
	}
	
	public static void main1(){
		 main2();
	}
	
	public static void main2(){
		
		 main3();
	}
	
	public static void main3(){
		
		 main4();
	}
	
	public static void main4()
	{
		
		 StackTraceElement[]  stackTraceElement = Thread.currentThread().getStackTrace();
		 for (StackTraceElement stackTraceElement2 : stackTraceElement) {
			 System.out.println(stackTraceElement2);
		}
		
		
	}
}
