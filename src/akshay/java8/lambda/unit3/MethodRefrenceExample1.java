package akshay.java8.lambda.unit3;

/**
 * 
 * @author eshak01
 *
 */
public class MethodRefrenceExample1 {
   public static void main(String[] args) {
      printMessage();
      
     new Thread(new Runnable() {
         
         @Override
         public void run() {
            printMessage();
         }
      }).start();
   
     Thread lambda = new Thread(()-> printMessage());
     lambda.start();
     
     Thread methodRefernce = new Thread(MethodRefrenceExample1::printMessage);
     methodRefernce.start();
   }
   
   public static void printMessage() {
      System.out.println("Hello");
   }
}
