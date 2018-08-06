package learn.thread.exception.handler;

/**
 * 
 * @author eshak01
 *
 */
public class DemoThreadExample {

   public static void main(String[] args) {
      TaskNoHandler taskNoHandler = new TaskNoHandler();
      Thread thread = new Thread(taskNoHandler);
     // thread.start();
      
      TaskHandler taskHandler = new TaskHandler();
      Thread thredTaskHandler = new Thread(taskHandler);
      thredTaskHandler.start();
   }

}


