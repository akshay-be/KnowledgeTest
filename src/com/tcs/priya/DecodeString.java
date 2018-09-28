package com.tcs.priya;

import java.util.HashMap;

/**
 * 
 * @author eshak01
 *
 */
public class DecodeString {

   public static void main(String[] args) {
      String data = "akshay&amp;yyyyyyy&lt;ggggg&gt;";
      String decodedText = decode(data);
      System.out.println("Data: "+data);
      System.out.println("Deco: "+decodedText);
   }
   
   public static String decode(String data) {
      HashMap<String,String> map  = new HashMap<String,String>();
      map.put("&amp;", "&");
      map.put("&lt;", "<");
      map.put("&gt;", ">");
      int i=0;
      String decodedText = "";
      while(i<data.length()) {
         char ch = data.charAt(i);
         if(ch=='&') {
            int index = data.indexOf(";", i);
            String key = data.substring(i, index+1);
            //System.out.println(key);
            decodedText +=map.get(key);
            i +=key.length();
         }else {
            decodedText +=ch;
         }
         i++;
      }
      
      //System.out.println(""+decodedText);
      return decodedText;
   }
}


