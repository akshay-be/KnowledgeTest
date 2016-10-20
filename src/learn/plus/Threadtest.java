package learn.plus;

public class Threadtest extends Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Threadtest threadtest = new Threadtest();
		threadtest.run();
		threadtest.start();

	}
	
	@Override
	public void run() {
		System.out.println("Run");
	}

}
