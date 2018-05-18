package akshay.java8.lambda.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import akshay.java8.lambda.unit1.Person;

/**
 * 
 * @author eshak01
 *
 */
public class StandardFunctionalInterface {

   public static void main(String[] args) {
      List<Person> people = Arrays.asList(new Person("akshay", "be", 31), new Person("chiranth", "arun", 5), new Person("charith", "akshay", 2),
            new Person("sihi", "arun", 1), new Person("ridhu", "sridhar", 10));

      // Step 1 : Sort List by Names.
      // Step 2 : create a method that print all elements in list
      // Step 3 : create a methos that print all names start with A in last name
      System.out.println("Before Sort :");
      System.out.println(people);
      Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
      System.out.println("After Sort :");
      System.out.println(people);

      System.out.println("After filter : LastName start with a");
      printConditionally(people, (p) -> p.getLastName().startsWith("a"));
      System.out.println("After filter : FirstName start with a");
      printConditionally(people, (p) -> p.getFirstName().startsWith("a"));

      System.out.println("Print All");
      printConditionally(people, (p) -> true);
      
      
      System.out.println("Perform All");
      performConditionally(people, (p) -> true, p ->  System.out.println(p));
   }

   private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
      for (Person person : people) {
         if (predicate.test(person)) {
            System.out.println(person);
         }
      }
   }
   
   private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
      for (Person person : people) {
         if (predicate.test(person)) {
            consumer.accept(person);
         }
      }
   }

}


