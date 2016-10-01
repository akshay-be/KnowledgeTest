package test;

public class TestException2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			System.out.println("Next line");
			
		}
		
		System.out.println("Between");
		catch(Exception e){
			System.out.println("Excepion "+e.getMessage());
		}

	}

}
