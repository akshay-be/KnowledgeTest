package com.tcs.priya;

import java.util.HashMap;
import java.util.UUID;

/**
 * 
 * @author eshak01
 *
 */
public class TokenIDValidation {

   private static HashMap<String, String> tokenIDMap = new HashMap<String, String>(200);

   public static String createTokenID(String userName) {
      String tokenId = null;
      try {
         tokenId = String.valueOf(UUID.randomUUID());
         tokenIDMap.put(userName, tokenId);
         // log.info(" session MAP>> " + session.toString());
      } catch (Exception e) {
         // log.error(" Exception in createSessionID java Class " + e);
      }
      return tokenId;
   }

   public static boolean validateTokenID(String userName, String tokenID) {
      if (userName != null && tokenID != null) {
         if (tokenIDMap.containsKey(userName)) {
            String tokenFromMap = tokenIDMap.get(userName);
            if (tokenFromMap.equals(tokenID.trim())) {
               return true;
            }
         }
      }
      return false;
   }
   public static void main(String[] args) {
      String tokenID = createTokenID("akshay");
      System.out.println(validateTokenID("akshay", tokenID));
   }
   
}
