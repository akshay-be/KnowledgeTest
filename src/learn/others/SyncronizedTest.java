package learn.others;

public class SyncronizedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		Thread t = new Thread(thread1);
		t.start();
		t = new Thread(thread2);
		t.start();
		
		Runnable r1 = new Thread1();
		r1.run();

		Thread.dumpStack();
	}

}

class Thread1 implements Runnable{
	@Override
	public void run() {
		System.out.println("Run 1"+Thread.currentThread().getName());
		
	}
}

class Thread2 implements Runnable{
	@Override
	public void run() {
		System.out.println("Run 2"+Thread.currentThread().getName());
		
	}
}
