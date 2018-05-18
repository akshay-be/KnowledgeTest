package akshay.java8.lambda.unit1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author eshak01
 *
 */
public class Exercise {
   public static void main(String[] args) {
      List<Person> peoples = Arrays.asList(new Person("akshay", "be", 31), new Person("chiranth", "arun", 5), new Person("charith", "akshay", 2),
            new Person("sihi", "arun", 1), new Person("ridhu", "sridhar", 10));

      // Step 1 : Sort List by Names.
      // Step 2 : create a method that print all elements in list
      // Step 3 : create a methos that print all names start with A in last name
      new Comparator<Person>() {

         @Override
         public int compare(Person o1, Person o2) {
            // TODO Auto-generated method stub
            return 0;
         }
      };

   }

}
