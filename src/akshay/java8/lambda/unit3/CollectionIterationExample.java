package akshay.java8.lambda.unit3;

import java.util.Arrays;
import java.util.List;

import akshay.java8.lambda.unit1.Person;

/**
 * 
 * @author eshak01
 *
 */
public class CollectionIterationExample {

   public static void main(String[] args) {
      List<Person> people = Arrays.asList(new Person("akshay", "be", 31), new Person("chiranth", "arun", 5), new Person("charith", "akshay", 2),
            new Person("sihi", "arun", 1), new Person("ridhu", "sridhar", 10));
      
      System.out.println("Using for loop");
      for (int i = 0; i < people.size(); i++) {
         System.out.println(people.get(i));
      }
      
      System.out.println("Using for in loop");
      for(Person p : people) {
         System.out.println(p);
      }

      System.out.println("Using for each lambda");
      //people.forEach(p -> System.out.println(p));
      people.forEach(System.out::println);
   }

}
