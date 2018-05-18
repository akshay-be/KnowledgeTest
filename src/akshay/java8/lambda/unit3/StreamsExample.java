package akshay.java8.lambda.unit3;

import java.util.Arrays;
import java.util.List;

import akshay.java8.lambda.unit1.Person;

/**
 * 
 * @author eshak01
 *
 */
public class StreamsExample {

   public static void main(String[] args) {

      List<Person> people = Arrays.asList(
                              new Person("akshay", "be", 31), 
                              new Person("chiranth", "arun", 5), 
                              new Person("charith", "akshay", 2),
                              new Person("sihi", "arun", 1), 
                              new Person("ridhu", "sridhar", 10));

      people.stream()
      .filter(p -> p.getFirstName().startsWith("c"))
      .forEach(p -> System.out.println(p.getFirstName()));
      
      
      long count =  people.stream()
                    .filter(p -> p.getFirstName().startsWith("c"))
                    .count();
      System.out.println(count);
      
      Runnable run = new Runnable() {
         
         @Override
         public void run() {
            // TODO Auto-generated method stub
            
         }
      };
   }

}
