package learn.others;

public class StringTest {

	public static void main(String[] args){
		String a = "newspaper";
		a = a.substring(5,7);
		System.out.println(a);
		System.out.println("Hiii");
		char b = a.charAt(1);
		a = a + b;
		System.out.println(a);
	}
}
