package learn.test;

public class TestException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a =5;
		int b=0;
		
		try{
			int c = a/b;
			System.out.println("Value of C : "+c);
		}catch(Exception e){
			System.out.println("Exception boss "+e.getMessage());
		}

	}

}
