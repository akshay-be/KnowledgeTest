package Integer;


public class CheckedExceptionTest {
	
	public static void main(String[] args){
		System.out.println("Hii");
		
		try{
			System.out.println("Hello");
		}catch(NullPointerException e){
			System.out.println("idiot");
		}
	}

}
