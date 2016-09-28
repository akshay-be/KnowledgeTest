
public class Hello {

	public static void main(String[] args) {
		System.out.println("Hi....");
		String str1 = new String("gabbar");
		String str2 = new String("gabbar");
		String str3 = "gabbar";

		System.out.println( str1 == str1.intern() );
		System.out.println( str3 == str1.intern() );
		System.out.println( str2.intern() == str1.intern() );
	}
}
