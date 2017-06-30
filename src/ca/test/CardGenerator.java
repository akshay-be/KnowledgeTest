package ca.test;

import java.util.Random;

/**
 * 
 * @author eshak01
 *
 */
public class CardGenerator {

   public String generate(String bin, int length) {

      // The number of random digits that we need to generate is equal to the
      // total length of the card number minus the start digits given by the
      // user, minus the check digit at the end.
      int randomNumberLength = length - (bin.length() + 1);
      int digit = 0;
      StringBuilder builder = new StringBuilder(bin);
      for (int i = 0; i < randomNumberLength; i++) {
         System.out.println(digit);
         builder.append(digit);
         digit++;
      }

      // Do the Luhn algorithm to generate the check digit.
      int checkDigit = this.getCheckDigit(builder.toString());
      builder.append(checkDigit);

      return builder.toString();
   }

   private int getCheckDigit(String number) {

      // Get the sum of all the digits, however we need to replace the value
      // of the first digit, and every other digit, with the same digit
      // multiplied by 2. If this multiplication yields a number greater
      // than 9, then add the two digits together to get a single digit
      // number.
      //
      // The digits we need to replace will be those in an even position for
      // card numbers whose length is an even number, or those is an odd
      // position for card numbers whose length is an odd number. This is
      // because the Luhn algorithm reverses the card number, and doubles
      // every other number starting from the second number from the last
      // position.
      int sum = 0;
      for (int i = 0; i < number.length(); i++) {

         // Get the digit at the current position.
         int digit = Integer.parseInt(number.substring(i, (i + 1)));

         if ((i % 2) == 0) {
            digit = digit * 2;
            if (digit > 9) {
               digit = (digit / 10) + (digit % 10);
            }
         }
         sum += digit;
      }

      // The check digit is the number required to make the sum a multiple of
      // 10.
      int mod = sum % 10;
      return ((mod == 0) ? 0 : 10 - mod);
   }
   
   public static void main(String[] args) {
      CardGenerator cardGenerator  = new CardGenerator();
      String cardNumber = cardGenerator.generate("5100000000000000", 16);
      System.out.println(""+cardNumber);
   }
}
