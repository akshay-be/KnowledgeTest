package akshay.java8.string;

/**
 * 
 * @author eshak01
 *
 */
public class StringTest {

   /**
    * @param args
    */
   public static void main(String[] args) {
      String a = new String("hello");
      String b = new String("hello");
      
      String c = new String(a);
      System.out.println(a==b);
      System.out.println(a==c);
      
      String d = "a";
      String e = "a";
      System.out.println(d==e);
   }
}


