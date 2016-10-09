package interview.wissen;

public class Q6SyncronizedTest {

	private String name;
	
	public Q6SyncronizedTest(String str){
		name = str;
	}
	public synchronized void syncMethod(){
		System.out.print(name+" M1 ");
		System.out.print(name+" M2 ");
	}
	
	/*
	 *  Sample output. 
	 *  O2 M1 O2 M2 O1 M1 O1 M2 
		O1 M1 O2 M1 O1 M2 O2 M2 
		O1 M1 O2 M1 O1 M2 O2 M2 
	 */
	public static void main(String[] args) throws InterruptedException {
		final Q6SyncronizedTest obj1 = new Q6SyncronizedTest("O1");
		final Q6SyncronizedTest obj2 = new Q6SyncronizedTest("O2");

		Thread t1 = new Thread(){
			@Override
			public void run(){
				obj1.syncMethod();
			}
		};

	
		Thread t2 = new Thread(){
			@Override
			public void run(){
				obj2.syncMethod();
			}
		};
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		
	}

}
