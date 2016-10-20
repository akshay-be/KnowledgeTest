package learn.thread;

public class ThreadRunException implements Runnable{

	public final static  String name="Akshay";
		
	public void run()  {
		System.out.println("Hello");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadRunException tr = new ThreadRunException();
		
		Thread t1 = new Thread(tr);
		t1.start();
		System.out.println(ThreadRunException.name);


		System.out.println(ThreadRunException.name);
	}

}

class Thread1 extends Thread {
	
	public static  String name = "Akshay";
	public void run()  {
		System.out.println("Hello 1 ");
	}
	
}
