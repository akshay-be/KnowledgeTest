package learn.thread;

public class JoinExample extends Object {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomThread customThread1 = new CustomThread("first");
		CustomThread customThread2 = new CustomThread("second");
		CustomThread customThread3 = new CustomThread("third");
		CustomThread customThread4 = new CustomThread("fourth");
		
		try {
			System.out.println("Before first join");
			customThread1.join();
			System.out.println("Before second join");
			customThread2.join();
			System.out.println("Before third join");
			customThread3.join();
			System.out.println("Before fourth join");
			customThread4.join();
			System.out.println("After All join");
		} catch (InterruptedException e) {
			System.out.println("Something is wrong go and check.");
			e.printStackTrace();
		}

	}

}

class CustomThread extends Thread{
	public CustomThread(String name) {
		super(name);
		start();
	}
	
	public void run(){
		System.out.println("run started "+Thread.currentThread().getName());
		
		try {
			for (int i = 0; i < 1000; i++) {
				//System.out.println(i + " thread "+ Thread.currentThread().getName());
				Thread.sleep(2);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("run completed "+Thread.currentThread().getName());
	}
}
