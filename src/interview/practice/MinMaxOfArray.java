package interview.practice;

/**
 * 
 * @author eshak01
 *
 */
public class MinMaxOfArray {

   public static void main(String[] args) {
      int numbers[] = { 2, 1, 4, 5, 6, 7, 12, 19, 18, 17, 16 };
      int min = numbers[0];
      int max = numbers[0];

      for (int i = 1; i < numbers.length; i++) {
         if (numbers[i] < min) {
            min = numbers[i];
         }
         if (numbers[i] > max) {
            max = numbers[i];
         }
      }
      System.out.println("Min : " + min);
      System.out.println("Max : " + max);
   }
}
