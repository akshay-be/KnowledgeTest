package com.tcs.priya;

import java.util.HashMap;
import java.util.UUID;

/**
 * 
 * @author eshak01
 *
 */
public class EncryptionKeyGenerator {

   private static HashMap<String, String> encrypionKeyMap = new HashMap<String, String>(200);

   public static String generateKey() {
      String id = String.valueOf(UUID.randomUUID());
      String encrypionKey = String.valueOf(UUID.randomUUID());
      System.out.println("generateKey id : "+id);
      System.out.println("generateKey encrypionKey : "+encrypionKey);
      encrypionKeyMap.put(id, encrypionKey);

      return id + ":" + encrypionKey;
   }

   public static String getEncryptionKey(String id) {
      if (id != null) {
         if (encrypionKeyMap.containsKey(id)) {
            return encrypionKeyMap.get(id);
         }
      }
      return null;
   }

   public static void main(String[] args) {
      String id = generateKey();
      System.out.println("iD : "+id);
      System.out.println(getEncryptionKey(id.substring(0, id.indexOf(":"))));
   }

}
