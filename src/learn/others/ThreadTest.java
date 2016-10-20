package learn.others;

public class ThreadTest {

	public static void main(String[] args) {
		Thread.currentThread().suspend();
		Thread.currentThread().destroy();
	}
}
