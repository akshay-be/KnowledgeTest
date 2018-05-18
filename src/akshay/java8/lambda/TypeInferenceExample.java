package akshay.java8.lambda;

/**
 * 
 * @author eshak01
 *
 */
public class TypeInferenceExample {

   public static void main(String[] args) {

      StringLegthLambda myLambda = (String s)-> s.length();
      System.out.println(myLambda.getLength("Hello World...!"));
      
      StringLegthLambda myLambda1 = (s)-> s.length();
      System.out.println(myLambda1.getLength("Hello World.....!"));
      
      
      StringLegthLambda myLambda2 = s -> s.length();
      System.out.println(myLambda2.getLength("Hello World........!"));
      
      printLambda(s -> s.length());
   }
   
   public static void  printLambda(StringLegthLambda stringLegthLambda) {
      System.out.println("Hello Lambda....!");
      System.out.println(stringLegthLambda.getLength("Hello Lambda....!"));
      
   }

}

interface StringLegthLambda {
   int getLength(String str);
}


