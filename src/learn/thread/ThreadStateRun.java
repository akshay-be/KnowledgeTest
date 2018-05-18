package learn.thread;

/**
 * 
 * @author eshak01
 *
 */
public class ThreadStateRun {

   public static void main(String[] args) {
      Runnable runnble = new Runnable() {

         @Override
         public void run() {
            for (int i = 0; i < 1000; i++) {
               System.out.println("hiii");
            }
         }
      };
      Thread t = new Thread();
      System.out.println(t.getState());
      t.run();
      t.start();
      System.out.println();
   }
}
