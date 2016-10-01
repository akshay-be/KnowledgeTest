
public class PrintString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Long x=42L;
		Long y=44L;
		System.out.print(" "+7+2+" ");
		System.out.print(foo() +x + 5);
		System.out.println(foo()+x + y+" ");

	}
	public static String  foo(){
		return "foo";
	}
}
