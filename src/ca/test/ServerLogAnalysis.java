package ca.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ServerLogAnalysis {

   public static void main(String[] args) throws IOException {
      System.out.println("Hello");
      Map<String,Double> mapData = new HashMap<String,Double>();
      Map<String,String> mapLogLines = new LinkedHashMap<String,String>();
      int count=0;
      String filePath = "C:\\Work\\LoadMachine\\Sprint2_Logs\\Run5\\";
      try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath+"acs-server.log")));
            BufferedWriter  bw = new BufferedWriter(new FileWriter(new File(filePath+"Temp-server.log")))) {
         String line;
         while ((line = br.readLine()) != null) {
            count++;
            if(line.contains("Total Execution time [")){
               String time = line.substring(22+line.indexOf("Total Execution time ["), line.lastIndexOf("]"));
               Double value = Double.valueOf(time.trim());
               String key = line.substring("[AccessControlServerRSImpl] - ".length()+line.indexOf("[AccessControlServerRSImpl] - "), line.lastIndexOf("- AReq END"));
               bw.write(line+"\n");
               mapData.put(key.trim(), value);
               mapLogLines.put(key.trim(), line);
            }else if(line.contains("*********** BEGIN TXNID ***********")){
               bw.write(line+"\n");
            }
         }
     }
      mapData = sortByValue(mapData);
      try (BufferedWriter  bw = new BufferedWriter(new FileWriter(new File(filePath+"Time-server.log")));
            ) {
         Set<Map.Entry<String, Double>> entrySet = mapData.entrySet();
         for (Entry<String, Double> entry : entrySet) {
            bw.write(entry.getKey()+" "+entry.getValue()+"\n");
         }
      }
      try(BufferedWriter  bwLine = new BufferedWriter(new FileWriter(new File(filePath+"Time-serverLine.log")))){
         Set<Map.Entry<String, String>> entrySet = mapLogLines.entrySet();
         for (Entry<String, String> entry : entrySet) {
            bwLine.write(mapLogLines.get(entry.getKey())+"\n");
         }
      }
      System.out.println("Done"+count);
   }
   
   public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
      return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }

}
