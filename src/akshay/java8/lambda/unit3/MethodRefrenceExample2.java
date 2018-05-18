package akshay.java8.lambda.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import akshay.java8.lambda.unit1.Person;

/**
 * 
 * @author eshak01
 *
 */
public class MethodRefrenceExample2 {

   public static void main(String[] args) {
      List<Person> people = Arrays.asList(new Person("akshay", "be", 31), new Person("chiranth", "arun", 5), new Person("charith", "akshay", 2),
            new Person("sihi", "arun", 1), new Person("ridhu", "sridhar", 10));
      
      
      System.out.println("Perform All");
      performConditionally(people, (p) -> true, p -> System.out.println(p));

      performConditionally(people, (p) -> true, System.out::println);
   }
   
   
   private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
      for (Person person : people) {
         if (predicate.test(person)) {
            consumer.accept(person);
         }
      }
   }
}


