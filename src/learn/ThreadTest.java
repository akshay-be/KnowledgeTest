package learn;

public class ThreadTest {

	public static void main(String[] args) {
		Thread.currentThread().suspend();
		Thread.currentThread().destroy();
	}
}
