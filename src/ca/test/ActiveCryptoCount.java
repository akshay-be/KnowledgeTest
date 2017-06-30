package ca.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ActiveCryptoCount {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      //Recieved 3DS encrypt request. ActiveCount :
      
      int transactioncount=0;

      LinkedHashMap< String, Integer> mapEncryptData = new LinkedHashMap<>();
      int minEncryptCount=Integer.MAX_VALUE;
      int maxEncryptCount =Integer.MIN_VALUE;
      
      LinkedHashMap< String, Integer> mapDecryptData = new LinkedHashMap<>();
      int minDecryptCount=Integer.MAX_VALUE;
      int maxDecryptCount =Integer.MIN_VALUE;
      
      String filePath = "C:\\Work\\LoadMachine\\Sprint2_Logs\\06-Mar-2017\\200threads\\";
      try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath+"crypto-service.log")));
            BufferedWriter  bw = new BufferedWriter(new FileWriter(new File(filePath+"ActiveEncryptCount.log")))){
         String line;
        
         while ((line = br.readLine()) != null) {

            if (null != line && !line.trim().isEmpty() && line.contains("Recieved 3DS encrypt request. ActiveCount")) {
               
               int num = Integer.parseInt(line.substring(1+line.lastIndexOf(":")).trim());
               bw.write(line+"\n");
               if(num<minEncryptCount){
                  minEncryptCount = num;
               }
               if(num>maxEncryptCount){
                  maxEncryptCount= num;
               }
               transactioncount++;
               String key = line.substring(0,line.lastIndexOf(","));
               //System.out.println(key);
               if(mapEncryptData.containsKey(key)){
                  Integer value= mapEncryptData.get(key);
                  mapEncryptData.put(key, (value+num)/2);
               }else{
                  mapEncryptData.put(key, num);
               }
            }
            
            if(null != line && !line.trim().isEmpty() && line.contains("Recieved 3DS decrypt request. ActiveCount")){
               int num = Integer.parseInt(line.substring(1+line.lastIndexOf(":")).trim());
              System.out.println(line);
               bw.write(line+"\n");
               if(num<minDecryptCount){
                  minDecryptCount = num;
               }
               if(num>maxDecryptCount){
                  maxDecryptCount= num;
               }
               transactioncount++;
               String key = line.substring(0,line.lastIndexOf(","));
               System.out.println(key);
               if(mapDecryptData.containsKey(key)){
                  Integer value= mapDecryptData.get(key);
                  mapDecryptData.put(key, (value+num)/2);
               }else{
                  mapDecryptData.put(key, num);
               }
            
            }

         }
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      try (BufferedWriter  bw = new BufferedWriter(new FileWriter(new File(filePath+"ActiveCryptoPerSecondCount.log")));) {
         Set<Map.Entry<String, Integer>> entrySet = mapEncryptData.entrySet();
         for (Entry<String, Integer> entry : entrySet) {
            Integer decryptCount = mapDecryptData.get(entry.getKey());
            if(null == decryptCount){
               decryptCount = 0;
            }
            bw.write(entry.getKey()+" ; "+entry.getValue()+" ; "+decryptCount+"\n");
         }
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("Transaction count : "+transactioncount);
      System.out.println("Min Encrypt Count : "+minEncryptCount);
      System.out.println("Max Encrypt Count :: "+maxEncryptCount);
      System.out.println("Min Decrypt Count : "+minDecryptCount);
      System.out.println("Max Decrypt Count :: "+maxDecryptCount);
   

   }

}
