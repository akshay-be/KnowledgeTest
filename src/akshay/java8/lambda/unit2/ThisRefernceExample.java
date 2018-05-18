package akshay.java8.lambda.unit2;

/**
 * 
 * @author eshak01
 *
 */
public class ThisRefernceExample {

   public static void main(String[] args) {

      ThisRefernceExample  thisRefernceExample = new ThisRefernceExample();
      
      thisRefernceExample.doProcess(10, new Process() {
         
         @Override
         public void process(int i) {
            System.out.println("Value of i : "+i);
            System.out.println(this);
         }
         
         @Override
         public String toString() {
            return "This is the anonymous inner class.";
         }
      });
      
      thisRefernceExample.doProcess(20, i -> {
         System.out.println(i);
         //System.out.println(this);
      });
   }
   
   public void excute() {
      doProcess(20, i -> {
         System.out.println(i);
         System.out.println(this);
      });
   }
   
   public void doProcess(int i, Process p) {
      p.process(i);
   }

}


