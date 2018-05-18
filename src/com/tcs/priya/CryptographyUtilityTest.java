package com.tcs.priya;

/**
 * 
 * @author eshak01
 *
 */
public class CryptographyUtilityTest {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      CryptographyUtilityTest test = new CryptographyUtilityTest();
      test.execute("tataskylepanda,123456789abcdef,{data:{key:key,value:value}}");

   }
   
   
   public boolean execute(String data) 
   {
      System.out.println(data);
      int indexOfFirst = data.indexOf(",");
      String key = data.substring(0,indexOfFirst);
      String tempData = data.substring(indexOfFirst+1);
      int indexOfSecond = tempData.indexOf(",");
      String value = tempData.substring(0,indexOfSecond);
      String encryptdat = tempData.substring(indexOfSecond+1);
      
      System.out.println("Key : "+key);
      System.out.println("IVSpec : "+value);
      System.out.println("Enrypt : "+encryptdat);
      return false;
   }

}


