package akshay.java8.lambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author eshak01
 *
 */
public class ExerciseJava8 {

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
   }

   private static void printConditionally(List<Person> people, Condition condition) {
      for (Person person : people) {
         if (condition.test(person)) {
            System.out.println(person);
         }
      }
   }

}
