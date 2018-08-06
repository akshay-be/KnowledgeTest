package interview.practice;

/**
 * 
 * @author eshak01
 *
 */
public class NumberOfSquaresChessboard {

   public static void main(String[] args) {
      int size = 2;
      int squares = 0;
      for (int i = 1; i <= size; i++) {
         squares = squares + (i * i);
      }
      System.out.println("Number of Squares : " + squares);
   }
}
