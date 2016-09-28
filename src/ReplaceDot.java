
public class ReplaceDot {

	public static void main(String[] args) {
		System.out.println("Hello i am replace test");
		String original = "24.28";
		System.out.println(""+original.replaceAll("\\.", ""));
		System.out.println(""+original);
	}
}
