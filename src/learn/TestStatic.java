package learn;

public class TestStatic {

	public static int a = 10;
	
	public static void maina()  {
		int a = 5;
		int b =1;
		
		
		a+=a+b;
		a++;

		//System.out.println(a);
	}
	public static void main(String[] args) {
		maina();
		System.out.println(a);
	}

}
