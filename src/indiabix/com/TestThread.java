package indiabix.com;

public class TestThread {

	public static void main(String[] args) {
		new MyThread().start(); 
        new MyThread(new MyRunnable()).start(); 

	}

}


class MyThread extends Thread 
{ 
    MyThread() {} 
    
    MyThread(Runnable r) {super(r); } 
    public void run() 
    { 
    	super.run();
        System.out.println("Inside Thread ");
    } 
} 

class MyRunnable implements Runnable 
{ 
    public void run() 
    { 
        System.out.println(" Inside Runnable"); 
    } 
}
