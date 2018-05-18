package akshay.java8.lambda;

/**
 * 
 * @author eshak01
 *
 */
public class Greeter {
   
   public void greete(Greeting greeting) {
      greeting.perform();
   }
   public static void main(String[] args) {
      Greeter greeter = new Greeter();
      Greeting helloWorldGreeting = new HelloWorldGreeting();
           
      Greeting myLambdaFunction = () -> System.out.println("Hellow world..! from Lambda Expression....");
      
      Greeting innerClassGreeting  = new Greeting() {
         public void perform() {
            System.out.println("Hellow world..! from InnerClass....");
         }
      };
      
      
      greeter.greete(helloWorldGreeting);
      greeter.greete(myLambdaFunction);
      greeter.greete(innerClassGreeting);
   }

}



