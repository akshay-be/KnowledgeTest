package learn.test.practice;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		String s1 = "test";
		String s2 = "test";
		String s3 = new String("test");
		
		if (s1 == s2) {
			System.out.println("s1 == s2");
		}
		
		if (s1 == s3) {
			System.out.println("s1 == s3");
		}

		if (s3 == s2) {
			System.out.println("s3 == s2");
		}

		if (s3.equals(s1)) {
			System.out.println("s3 equals s1");
		}

		if (s2.equals(s1)) {
			System.out.println("s2 equals s1");
		}
		
		if (s2.equals(s3)) {
			System.out.println("s2 equals s3");
		}*/
		
		if("String".replace("t", "T") == "String".replace("t", "T")){
			System.out.println("Equal");
		}else{
			System.out.println("Not Equal");
		}
		
		if("String".replace("t", "T").equals("String".replace("t", "T"))){
			System.out.println("Equal");
		}else{
			System.out.println("Not Equal");
		}
	
	}

}
