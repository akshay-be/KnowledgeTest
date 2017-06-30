package ca.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ServerLogTimeAnalysis {

   public static void main(String[] args) throws IOException, ParseException {
      System.out.println("Hello");
      Map<String,Double> mapData = new HashMap<String,Double>();
      Map<String,Integer> mapDataLineCount = new HashMap<String,Integer>();
      Map<String,String[]> mapDataDate = new HashMap<String,String[]>();
      
      
      
      try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Work\\LoadMachine\\logs\\Run3\\acs-server.log")));
            BufferedWriter  bw = new BufferedWriter(new FileWriter(new File("C:\\Work\\LoadMachine\\logs\\Run3\\Temp-server.log")))) {
         String line;
         while ((line = br.readLine()) != null) {
            
            if(null!=line && !line.trim().isEmpty() && !line.contains("*********** BEGIN TXNID ***********")){
               //System.out.println(line);
               int index = line.indexOf("] - ");
               String masterKey = line.substring(index+4,index+16);
               String time = line.substring(0, line.indexOf("["));
                System.out.println(masterKey);
               if(mapDataLineCount.containsKey(masterKey)){
                  Integer count = mapDataLineCount.get(masterKey);
                  String[] data = mapDataDate.get(masterKey);
                  data[count++] = time.trim();
                  mapDataLineCount.put(masterKey, count);
                  mapDataDate.put(masterKey, data);
               }else{
                  Integer count = new Integer(0);
                  String[] data = new String[50];
                  data[count] = time.trim();
                  mapDataLineCount.put(masterKey, count);
                  mapDataDate.put(masterKey, data);
               }
            }
            
           /* if(line.contains("Total Execution time [")){
               String time = line.substring(22+line.indexOf("Total Execution time ["), line.lastIndexOf("]"));
               Double value = Double.valueOf(time.trim());
               String key = line.substring("[AccessControlServerRSImpl] - ".length()+line.indexOf("[AccessControlServerRSImpl] - "), line.lastIndexOf("- AReq END"));
               bw.write(line+"\n");
               mapData.put(key.trim(), value);
            }*/
            
           
         }
     }
      mapData = sortByValue(mapData);
     /* try (BufferedWriter  bw = new BufferedWriter(new FileWriter(new File("C:\\Work\\LoadMachine\\logs\\Run\\Time-server.log")))) {
         Set<Map.Entry<String, Double>> entrySet = mapData.entrySet();
         for (Entry<String, Double> entry : entrySet) {
            bw.write(entry.getKey()+" "+entry.getValue()+"\n");
         }
      }*/
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
      Set<Map.Entry<String, Integer>> entrySet = mapDataLineCount.entrySet();
      long[]  averageTime = new long[46];
      for (Entry<String, Integer> entry : entrySet) {
         System.out.println(entry.getKey() + " " + entry.getValue() + "\n");
         String[] data = mapDataDate.get(entry.getKey());
         for (int i = 0; i < data.length - 1; i++) {

            long d1 = simpleDateFormat.parse(data[i]).getTime();
            long d2 = simpleDateFormat.parse(data[i + 1]).getTime();
            averageTime[i] = averageTime[i] + Math.abs(d1 - d2);

         }

      }
      for (int j = 0; j < averageTime.length; j++) {
         System.out.println(averageTime[j]);
      }
      System.out.println("Done");
   }
   
   public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
      return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }

}
