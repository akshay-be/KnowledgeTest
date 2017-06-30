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

public class ActiveAreqCount {

   public static void main(String[] args) {
      LinkedHashMap< String, Integer> mapData = new LinkedHashMap<>();
      int transactioncount=0;
      int minAreqCount=Integer.MAX_VALUE;
      int maxAreqCount =Integer.MIN_VALUE;
      String filePath = "C:\\Work\\LoadMachine\\Sprint2_Logs\\06-Mar-2017\\200threads\\";
      try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath+"acs-server.log.004")));
            BufferedWriter  bw = new BufferedWriter(new FileWriter(new File(filePath+"ActiveAreqCount.log")))){
         String line;
        
         while ((line = br.readLine()) != null) {

            if (null != line && !line.trim().isEmpty() && line.contains("******Active AReq count***")) {
               
               int num = Integer.parseInt(line.substring(1+line.lastIndexOf(":")).trim());
               bw.write(line+"\n");
               if(num<minAreqCount){
                  minAreqCount = num;
               }
               if(num>maxAreqCount){
                  maxAreqCount= num;
               }
               transactioncount++;
               String key = line.substring(0,line.lastIndexOf(","));
               //System.out.println(key);
               if(mapData.containsKey(key)){
                  Integer value= mapData.get(key);
                  mapData.put(key, (value+num)/2);
               }else{
                  mapData.put(key, num);
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
      
      try (BufferedWriter  bw = new BufferedWriter(new FileWriter(new File(filePath+"ActiveAreqPerSecondCount.log")));
            ) {
         Set<Map.Entry<String, Integer>> entrySet = mapData.entrySet();
         for (Entry<String, Integer> entry : entrySet) {
            bw.write(entry.getKey()+" ; "+entry.getValue()+"\n");
         }
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("Transaction count : "+transactioncount);
      System.out.println("Min Areq Count : "+minAreqCount);
      System.out.println("Max Areq Count :: "+maxAreqCount);
   }

}
