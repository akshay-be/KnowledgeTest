package ca.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class LogTimeCaluculation {

   public static void main(String[] args) throws FileNotFoundException, IOException {

      int count = 0;
     
      //for(int i=11;i<12;i++){
      //  String index=""+i;
      //   if(i<10){
      //      index="0"+i;
      //   }
         Map<String,String> transactionStart = new HashMap<String,String>();
         Map<String,Integer> transactionTime = new HashMap<String,Integer>();
         Map<String,Integer> multiCryptoTime = new HashMap<String,Integer>();
         Map<String,Integer> encryptTime = new HashMap<String,Integer>();
         
            
      try (BufferedReader br = new BufferedReader(
            new FileReader(new File("C:\\Work\\LoadMachine\\Sprint2_Logs\\17-03-2017\\10k\\acs-server.log")))) {
         String line;
         while ((line = br.readLine()) != null) {
             //System.out.println(line);
            if (null != line && !line.trim().isEmpty() && line.contains("*********** BEGIN TXNID ***********")) {
               String transactionID = line.substring(1+line.lastIndexOf("-"));
               String time = line.substring(0,line.indexOf("["));
               transactionStart.put(transactionID, time);
              // System.out.println(transactionID + "," + time);
            }
            if (null != line && !line.trim().isEmpty() && line.contains("AReq END *********** Total Execution time")) {
               String transactionID = line.substring(30 + line.indexOf("[AccessControlServerRSImpl] - "), line.indexOf(" - AReq END ***********"));
               String timeInSeconds = line.substring(1 + line.lastIndexOf("["), line.lastIndexOf("]"));
               Double time = Double.parseDouble(timeInSeconds)*1000;
              // System.out.println(transactionID + "," + time.intValue());
               transactionTime.put(transactionID, time.intValue());
               count++;
            } else if (null != line && !line.trim().isEmpty() && line.contains("After MultiCrypto Encrypt Request Total time")) {
               String transactionID = line.substring(26 + line.indexOf("[RemoteHardwareCrypter] - "), line.indexOf(" - After MultiCrypto"));
               String timeInMilliSeconds = line.substring(1 + line.lastIndexOf("["), line.lastIndexOf("]")).replaceAll(",","");
               // System.out.println(transactionID + "," + timeInMilliSeconds);
               if(multiCryptoTime.containsKey(transactionID)){
                  Integer oldTime = multiCryptoTime.get(transactionID);
                  multiCryptoTime.put(transactionID, oldTime+Integer.parseInt(timeInMilliSeconds));
               }else{
                  multiCryptoTime.put(transactionID, Integer.parseInt(timeInMilliSeconds));
               }
            } else if (null != line && !line.trim().isEmpty() && line.contains("After Encrypt Request Total time")) {
               String transactionID = line.substring(26 + line.indexOf("[RemoteHardwareCrypter] - "), line.indexOf(" - After Encrypt"));
               String timeInMilliSeconds = line.substring(1 + line.lastIndexOf("["), line.lastIndexOf("]")).replaceAll(",","");
                //System.out.println(transactionID + "," + timeInMilliSeconds);
               if(encryptTime.containsKey(transactionID)){
                  Integer oldTime = encryptTime.get(transactionID);
                  encryptTime.put(transactionID, oldTime+Integer.parseInt(timeInMilliSeconds));
               }else{
                  encryptTime.put(transactionID, Integer.parseInt(timeInMilliSeconds));
               }
               
            }
         }
         System.out.println(" : "+count);
      }
      transactionTime = sortByValue(transactionTime);
            
      double fiftyPercentTET=0;
      double sixtySixPercentTET=0;
      double seventyFivePercentTET=0;
      double eightyPercentTET=0;
      double nintyPercentTET=0;
      double nintyFivePercentTET=0;
      double nintyEightPercentTET=0;
      double nintyNinePercentTET=0;
      double hundredPercentTET=0;
      double fiftyPercentEncrypt=0;
      double sixtySixPercentEncrypt=0;
      double seventyFivePercentEncrypt=0;
      double eightyPercentEncrypt=0;
      double nintyPercentEncrypt=0;
      double nintyFivePercentEncrypt=0;
      double nintyEightPercentEncrypt=0;
      double nintyNinePercentEncrypt=0;
      double hundredPercentEncrypt=0;
      double fiftyPercentMultiCrypto=0;
      double sixtySixPercentMultiCrypto=0;
      double seventyFivePercentMultiCrypto=0;
      double eightyPercentMultiCrypto=0;
      double nintyPercentMultiCrypto=0;
      double nintyFivePercentMultiCrypto=0;
      double nintyEightPercentMultiCrypto=0;
      double nintyNinePercentMultiCrypto=0;
      double hundredPercentMultiCrypto=0;
        
      
         try (BufferedWriter bw = new BufferedWriter(new FileWriter(
               new File("C:\\Work\\LoadMachine\\Sprint2_Logs\\17-03-2017\\Time-Total-MultiCrypto-Encrypt-acs-server-2017-03-17-12.log")))) {
            Iterator<Entry<String, Integer>> iterator = transactionTime.entrySet().iterator();
            while (iterator.hasNext()) {
               Entry<String, Integer> entry = iterator.next();
               String transactionID = entry.getKey();
               Integer totalTransTime = entry.getValue();
               Integer transEncryptTime = encryptTime.get(transactionID);
               Integer transMultiCryptoTime = multiCryptoTime.get(transactionID);
               if (transEncryptTime != null && transMultiCryptoTime != null) {
                  bw.write(transactionStart.get(transactionID) + " ; " + transactionID + " ; " + totalTransTime + " ; " + transEncryptTime + " ; "
                        + transMultiCryptoTime + "\n");
               } else {
                  //transactionTime.remove(transactionID);
                  iterator.remove();
                  if (encryptTime.containsKey(transactionID)) {
                     encryptTime.remove(encryptTime);
                  }
                  if (multiCryptoTime.containsKey(transactionID)) {
                     multiCryptoTime.remove(transactionID);
                  }
               }
            }
         }
         
         int totalsizeCount = transactionTime.size();
         int tenPercentCount = (int) (totalsizeCount * 0.1);
         int twentyPercentCount = (int) (totalsizeCount * 0.2);
         int thirtyPercentCount = (int) (totalsizeCount * 0.3);
         int fortyPercentCount = (int) (totalsizeCount * 0.4);
         int fiftyPercentCount = (int) (totalsizeCount * 0.5);
         int sixtySixPercentCount = (int) (totalsizeCount * 0.66);
         int seventyFivePercentCount = (int) (totalsizeCount * 0.75);
         int eightyPercentCount = (int) (totalsizeCount * 0.8);
         int nintyPercentCount = (int) (totalsizeCount * 0.9);
         int nintyFivePercentCount = (int) (totalsizeCount * 0.95);
         int nintyEightPercentCount = (int) (totalsizeCount * 0.98);
         int nintyNinePercentCount = (int) (totalsizeCount * 0.99);
         
         Set<Map.Entry<String, Integer>> entrySet = transactionTime.entrySet();
         int tranCount=0;
         int intCount=1;
         System.out.println("Percentage,TransCount,TotalTime, Encrypt, MultiCrypto");
         for (Entry<String, Integer> entry : entrySet) {
            tranCount++;
            String key = entry.getKey();
            Integer value = entry.getValue();
           // System.out.println(""+key+" , "+value+","+encryptTime.get(key)+","+multiCryptoTime.get(key));
            if (tranCount == tenPercentCount || tranCount == twentyPercentCount || tranCount == thirtyPercentCount || tranCount == fortyPercentCount) {
               //System.out.println("*****************");
               System.out.println(intCount+"0%"+","+tranCount+","+value+","+encryptTime.get(key)+","+multiCryptoTime.get(key));
               intCount++;
              // break;
            }
            
            if (tranCount == fiftyPercentCount) {
               fiftyPercentTET = value;
               fiftyPercentEncrypt = encryptTime.get(key);
               fiftyPercentMultiCrypto = multiCryptoTime.get(key);
            }

            if (tranCount == sixtySixPercentCount) {
               sixtySixPercentTET = value;
               sixtySixPercentEncrypt =  encryptTime.get(key);
               sixtySixPercentMultiCrypto = multiCryptoTime.get(key);
            }

            if (tranCount == seventyFivePercentCount) {
               seventyFivePercentTET = value;
               seventyFivePercentEncrypt =  encryptTime.get(key);
               seventyFivePercentMultiCrypto = multiCryptoTime.get(key);
            }

            if (tranCount == eightyPercentCount) {
               eightyPercentTET = value;
               eightyPercentEncrypt = encryptTime.get(key);
               eightyPercentMultiCrypto = multiCryptoTime.get(key);
            }
            if (tranCount == nintyPercentCount) {
               nintyPercentTET = value;
               nintyPercentEncrypt =  encryptTime.get(key);
               nintyPercentMultiCrypto = multiCryptoTime.get(key);
            }

            if (tranCount == nintyFivePercentCount) {
               nintyFivePercentTET = value;
               nintyFivePercentEncrypt =  encryptTime.get(key);
               nintyFivePercentMultiCrypto = multiCryptoTime.get(key);
            }

            if (tranCount == nintyEightPercentCount) {
               nintyEightPercentTET = value;
               nintyEightPercentEncrypt =  encryptTime.get(key);
               nintyEightPercentMultiCrypto = multiCryptoTime.get(key);
            }

            if (tranCount == nintyNinePercentCount) {
               nintyNinePercentTET = value;
               nintyNinePercentEncrypt =  encryptTime.get(key);
               nintyNinePercentMultiCrypto = multiCryptoTime.get(key);
            }
            
            if (tranCount == totalsizeCount) {
               hundredPercentTET = value;
               hundredPercentEncrypt =  encryptTime.get(key);
               hundredPercentMultiCrypto = multiCryptoTime.get(key);
            }
         }
         
        
         System.out.println("50%"+","+fiftyPercentCount+","+fiftyPercentTET+","+fiftyPercentEncrypt+","+fiftyPercentMultiCrypto);
         System.out.println("66%"+","+sixtySixPercentCount+","+sixtySixPercentTET+","+sixtySixPercentEncrypt+","+sixtySixPercentMultiCrypto);
         System.out.println("75%"+","+seventyFivePercentCount+","+seventyFivePercentTET+","+seventyFivePercentEncrypt+","+seventyFivePercentMultiCrypto);
         System.out.println("80%"+","+eightyPercentCount+","+eightyPercentTET+","+eightyPercentEncrypt+","+eightyPercentMultiCrypto);
         System.out.println("90%"+","+nintyPercentCount+","+nintyPercentTET+","+nintyPercentEncrypt+","+nintyPercentMultiCrypto);
         System.out.println("95%"+","+nintyFivePercentCount+","+nintyFivePercentTET+","+nintyFivePercentEncrypt+","+nintyFivePercentMultiCrypto);
         System.out.println("98%"+","+nintyEightPercentCount+","+nintyEightPercentTET+","+nintyEightPercentEncrypt+","+nintyEightPercentMultiCrypto);
         System.out.println("99%"+","+nintyNinePercentCount+","+nintyNinePercentTET+","+nintyNinePercentEncrypt+","+nintyNinePercentMultiCrypto);
         System.out.println("100%"+","+totalsizeCount+","+hundredPercentTET+","+hundredPercentEncrypt+","+hundredPercentMultiCrypto);
         System.out.println("Done....!"+totalsizeCount);
    //  }
      System.out.println("Done....!"+count);
   }

   public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
      return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
   }

}










/*if (tranCount == fiftyPercentCount) {
   fiftyPercentTET = hundredPercentTET / fiftyPercentCount;
   fiftyPercentEncrypt = hundredPercentEncrypt / fiftyPercentCount;
   fiftyPercentMultiCrypto = hundredPercentMultiCrypto / fiftyPercentCount;
}

if (tranCount == sixtySixPercentCount) {
   sixtySixPercentTET = hundredPercentTET / sixtySixPercentCount;
   sixtySixPercentEncrypt = hundredPercentEncrypt / sixtySixPercentCount;
   sixtySixPercentMultiCrypto = hundredPercentMultiCrypto / sixtySixPercentCount;
}

if (tranCount == seventyFivePercentCount) {
   seventyFivePercentTET = hundredPercentTET / seventyFivePercentCount;
   seventyFivePercentEncrypt = hundredPercentEncrypt / seventyFivePercentCount;
   seventyFivePercentMultiCrypto = hundredPercentMultiCrypto / seventyFivePercentCount;
}

if (tranCount == eightyPercentCount) {
   eightyPercentTET = hundredPercentTET / eightyPercentCount;
   eightyPercentEncrypt = hundredPercentEncrypt / eightyPercentCount;
   eightyPercentMultiCrypto = hundredPercentMultiCrypto / eightyPercentCount;
}
if (tranCount == nintyPercentCount) {
   nintyPercentTET = hundredPercentTET / nintyPercentCount;
   nintyPercentEncrypt = hundredPercentEncrypt / nintyPercentCount;
   nintyPercentMultiCrypto = hundredPercentMultiCrypto / nintyPercentCount;
}

if (tranCount == nintyFivePercentCount) {
   nintyFivePercentTET = hundredPercentTET / nintyFivePercentCount;
   nintyFivePercentEncrypt = hundredPercentEncrypt / nintyFivePercentCount;
   nintyFivePercentMultiCrypto = hundredPercentMultiCrypto / nintyFivePercentCount;
}

if (tranCount == nintyEightPercentCount) {
   nintyEightPercentTET = hundredPercentTET / nintyEightPercentCount;
   nintyEightPercentEncrypt = hundredPercentEncrypt / nintyEightPercentCount;
   nintyEightPercentMultiCrypto = hundredPercentMultiCrypto / nintyEightPercentCount;
}

if (tranCount == nintyNinePercentCount) {
   nintyNinePercentTET = hundredPercentTET / nintyNinePercentCount;
   nintyNinePercentEncrypt = hundredPercentEncrypt / nintyNinePercentCount;
   nintyNinePercentMultiCrypto = hundredPercentMultiCrypto / nintyNinePercentCount;
}
*/