package learn.others;

public class TestStaticMain {

	public static int x=5;
	public static void main(String[] args) {
		System.out.println("before "+x);

		x=x+10;
		
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After "+x);
	}

}
