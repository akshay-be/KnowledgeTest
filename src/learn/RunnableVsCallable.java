package learn;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class RunnableVsCallable implements Runnable , Callable<String> {

	@Override
	public void run() {
		System.out.println("Run..");

	}

	public static void main(String[] args) {
		
		Runnable r  = new RunnableVsCallable();
		Callable<String> c = new RunnableVsCallable();
		
		RunnableVsCallable runnableVsCallable = new RunnableVsCallable();
		ExecutorService ex = Executors.newCachedThreadPool();
		//ex.submit(runnableVsCallable);
		
		
		
		ex.submit(r);
		ex.submit(c);

	}

	@Override
	public String call() throws Exception {
		System.out.println("Call...");
		return null;
	}

}
