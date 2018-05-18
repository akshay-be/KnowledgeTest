package akshay.java8.lambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author eshak01
 *
 */
public class ExerciseJava7 {
   public static void main(String[] args) {
      List<Person> people = Arrays.asList(new Person("akshay", "be", 31), new Person("chiranth", "arun", 5), new Person("charith", "akshay", 2),
            new Person("sihi", "arun", 1), new Person("ridhu", "sridhar", 10));

      // Step 1 : Sort List by Names.
      // Step 2 : create a method that print all elements in list
      // Step 3 : create a methos that print all names start with A in last name
      System.out.println("Before Sort :");
      printAll(people);
      Collections.sort(people, new Comparator<Person>() {

         @Override
         public int compare(Person o1, Person o2) {
            return o1.getLastName().compareTo(o2.getLastName());
         }
      });
      System.out.println("After Sort :");
      printAll(people);

      System.out.println("After filter :");
      printLastNameWithC(people);

      System.out.println("After filter : LastName start with a");
      printConditionally(people, new Condition() {
         @Override
         public boolean test(Person person) {
            if (person.getLastName().startsWith("a")) {
               return true;
            }
            return false;
         }
      });
      
      System.out.println("After filter : FirstName start with a");
      printConditionally(people, new Condition() {
         @Override
         public boolean test(Person person) {
            if (person.getFirstName().startsWith("a")) {
               return true;
            }
            return false;
         }
      });
   }

   private static void printConditionally(List<Person> people, Condition condition) {
      for (Person person : people) {
         if (condition.test(person)) {
            System.out.println(person);
         }
      }

   }

   private static void printLastNameWithC(List<Person> people) {
      for (Person person : people) {
         if (person.getLastName().startsWith("a"))
            System.out.println(person);
      }

   }

   private static void printAll(List<Person> people) {
      for (Person person : people) {
         System.out.println(person);
      }
   }
}

interface Condition {
   boolean test(Person p);
}
