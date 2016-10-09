package interview.wissen;

public class Q1SyncronizedTest {
	private String name;

	public Q1SyncronizedTest(String name) {
		this.name = name;
	}

	public static synchronized void synchronizedStaticMethod() {
		System.out.print("SM1 ");
		System.out.print("SM2 ");

	}

	public synchronized void synchronizedMethod() {
		System.out.print(name + " M1 ");
		System.out.print(name + " M2 ");

	}

	/**
	 *  O1 M1 O1 M2 SM1 SM2 O1 M1 O1 M2 
		O1 M1 O1 M2 O1 M1 O1 M2 SM1 SM2 
		O1 M1 O1 M2 O1 M1 O1 M2 SM1 SM2 
		O1 M1 O1 M2 O1 M1 O1 M2 SM1 SM2 
		O1 M1 O1 M2 SM1 SM2 O1 M1 O1 M2 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		final Q1SyncronizedTest sm1 = new Q1SyncronizedTest("O1");

		Thread t1 = new Thread() {
			@Override
			public void run() {
				sm1.synchronizedMethod();
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				sm1.synchronizedMethod();
			}
		};

		Thread t3 = new Thread() {
			@Override
			public void run() {
				synchronizedStaticMethod();
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
	}
}
