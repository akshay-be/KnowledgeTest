package learn.others;


public class SyncronizedNullTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SyncronizedNullTest syncronizedNullTest = null;
		
		synchronized (syncronizedNullTest) {
			System.out.println("Hi......");
		}

	}

}
