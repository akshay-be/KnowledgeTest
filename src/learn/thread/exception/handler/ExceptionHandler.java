package learn.thread.exception.handler;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 
 * @author eshak01
 *
 */
public class ExceptionHandler implements UncaughtExceptionHandler {
   
   public void uncaughtException(Thread thread,Throwable throwable) {
      System.out.println("Exception has been captured");
      System.out.println("Thread id : "+thread.getId());
      System.out.printf("Exception %s : %s \n",throwable.getClass().getName(),throwable.getMessage());
      System.err.println("Thread state : "+thread.getState());
   }

}


