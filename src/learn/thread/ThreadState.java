package learn.thread;

/**
 * 
 * @author eshak01
 *
 */
public class ThreadState {

   public static void main(String[] args) throws InterruptedException {
      System.out.println("ThreadState test main method....");
      Runnable newState = new NewState();
      Thread thread = new Thread(newState);
      System.out.println("Thread State Before start : " + thread.getState());
      thread.start();
      System.out.println("Thread State after start : " + thread.getState());
      Thread.sleep(100);
      System.out.println("Thread State after sleep : " + thread.getState());

      /** BlockedState example */
      Thread thread1 = new Thread(new BlockedDemoThread());
      Thread thread2 = new Thread(new BlockedDemoThread());
      thread1.start();
      thread2.start();
      Thread.sleep(200);
      System.out.println("BlockedDemoThread State Thread1 : " + thread1.getState());
      System.out.println("BlockedDemoThread State Thread2 : " + thread2.getState());

   }
}

class NewState implements Runnable {
   public void run() {
      System.out.println("NewState thread running....!");
   }
}

class BlockedDemoThread implements Runnable {
   public void run() {
      commonResource();
   }

   public static synchronized void commonResource() {
      while (true) {
         // Thread acquired a lock and not released because infinite loop.
      }
   }
}
