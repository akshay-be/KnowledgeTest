package ca.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 
 * @author eshak01
 *
 */
public class StringSplitOnLength {

   public static void main(String[] args) {

      String str = "                                                                          ";
      System.out.println(str.length());
      //List<String> list = splitString8(str,40);
      int size = 40;
      String list[] = str.split("(?<=\\G.{"+size+"})");
      for (String string : list) {
         System.out.print(string);
      }
      System.out.print("End");
   }

   public static List<String> splitString(String input, int splitSize) {
      //Matcher matcher = Pattern.compile("(?:(.{" + splitSize + "}))+?").matcher(input);
      Matcher matcher = Pattern.compile("/.{1," + splitSize + "}/g").matcher(input);
      ///.{1,500}/g
      return matcher.results().map(MatchResult::group).collect(Collectors.toList());
   }
   public static List<String> splitString8(String input, int splitSize) {
      List<String> result =  new ArrayList<String>();
     // Matcher matcher = Pattern.compile("(?:(.{" + splitSize + "}))+?").matcher(input);
      Matcher matcher = Pattern.compile("(?<=\\G.{" + splitSize + "})").matcher(input);
      while(matcher.find()) {
         result.add(input.substring(matcher.start(), matcher.end()));
      }
      return result;
   }
   
   public static List<String> splitStringOnClode(String input, int splitSize) {
      /*
       * In Java 9 we can use the below code, no need to iterate over the matcher. <br> Matcher matcher = Pattern.compile("(?:(.{" + splitSize +
       * "}))+?").matcher(input); return matcher.results().map(MatchResult::group).collect(Collectors.toList());
       */
      List<String> result = new ArrayList<String>();
      if (input != null) {
         if (input.length() < splitSize) {
            result.add(input);
         } else {
            Matcher matcher = Pattern.compile("(?:(.{" + splitSize + "}))+?").matcher(input);
            while (matcher.find()) {
               result.add(input.substring(matcher.start(), matcher.end()));
            }
         }
      }

      return result;
   }
}
