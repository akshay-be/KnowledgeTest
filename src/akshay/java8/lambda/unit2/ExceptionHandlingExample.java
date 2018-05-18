package akshay.java8.lambda.unit2;

import java.util.function.BiConsumer;

/**
 * 
 * @author eshak01
 *
 */
public class ExceptionHandlingExample {

   public static void main(String[] args) {

      int[] someNumbers = { 1, 2, 3, 4 };
      int key = 0;

      /*process(someNumbers, key, (v, k) -> System.out.println(v + k));

      process(someNumbers, key, (v, k) -> {
         try {
            System.out.println(v / k);
         } catch (ArithmeticException e) {
            System.out.println("ArithmeticException  : " + e.getMessage());
         }
      });*/
      
      process(someNumbers, key, wrapperLamda((v, k) -> System.out.println(v / k)));
   }

   private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
      for (int i : someNumbers) {
        // System.out.println("Exucting process");
         biConsumer.accept(i, key);
      }
   }
   
   private static BiConsumer<Integer, Integer> wrapperLamda(BiConsumer<Integer, Integer> biConsumer) {
      return (v,k) -> {
         try {
            biConsumer.accept(v, k);
         } catch (ArithmeticException e) {
            System.out.println("ArithmeticException  : " + e.getMessage());
         }        
      };
   }
}
