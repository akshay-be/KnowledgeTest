import java.util.*;

public class ArrayListExample{
   public static void main(String args[]) {
      /*Creation of ArrayList: I'm going to add String
       *elements so I made it of string type */
	  ArrayList<String> obj = new ArrayList<String>();

	  /*This is how elements should be added to the array list*/
	  obj.add("Akshay");
	  obj.add("priya");
	

	  /* Displaying array list elements */
	  System.out.println("Currently the array list has following elements:"+obj);

	  /*Add element at the given index*/
//	  obj.add(0, "cc");
//	  obj.add(1, "ss");

	
	  obj.contains("priya");

	  System.out.println("Current array list is:"+obj);
   }
}
