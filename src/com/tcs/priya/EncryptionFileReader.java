package com.tcs.priya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * @author eshak01
 *
 */
public class EncryptionFileReader {

   static Logger log = Logger.getLogger(EncryptionKeyValue.class.getName());
   static Properties prop = new Properties();

   static {
      BufferedReader bufferedReader = null;
      try {
         log.info("Static block reading the file.  ");
         File file = new File("C:\\Users\\ESHAK01\\Desktop\\encryption.properties");

         if (file.exists() && file.isFile()) {
            System.out.println("File avilable..");
            bufferedReader = new BufferedReader(new FileReader(file));
         } else {
            System.out.println("properties file of encryption not loaded. FileName >> " + file.getAbsolutePath());
            log.info("properties file of encryption not loaded. FileName >> " + file.getAbsolutePath());
         }
         prop.load(bufferedReader);
         log.info("properties file of encrption properties loaded.");

      } catch (Exception ex) {
         log.error("Exception in reading a file." + ex.getMessage());
      } finally {
         if (bufferedReader != null) {
            try {
               bufferedReader.close();
            } catch (Exception e) {
               log.error("Exception in closing the resource." + e.getMessage());
               e.getMessage();
            }
         }
      }
   }

   public static String getValue(String key) {
      String value = prop.getProperty(key);
      log.info("value >> " + value + "key >>   " + key);
      return value;
   }

   public static void main(String[] args) {
      System.out.println("" + EncryptionKeyValue.getValue("SecretKey"));
      System.out.println("" + EncryptionKeyValue.getValue("IvParameter"));
   }

}
