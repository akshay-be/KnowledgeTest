package learn.thread.exception.handler;

/**
 * 
 * @author eshak01
 *
 */
public class TaskHandler implements Runnable {

   public void run() {
      Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
      System.out.println(Integer.parseInt("123"));
      System.out.println(Integer.parseInt("234"));
      System.out.println(Integer.parseInt("345"));
      System.out.println(Integer.parseInt("xyz"));
      System.out.println(Integer.parseInt("999"));
   }
}


