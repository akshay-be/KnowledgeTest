package ca.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

public class CreqLogTimeAnalysis {

   public static void main(String[] args) {
       
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
      LinkedHashMap< String, Integer> aReqCount = new LinkedHashMap<>();
      Map<String,String> logFileName = new HashMap<String,String>();
      
      Map<String,String> aReqStart = new HashMap<String,String>();
      Map<String,Integer> aReqEncryptTime1 = new HashMap<String,Integer>();
      Map<String,Integer> aReqEncryptTime2 = new HashMap<String,Integer>();
      Map<String,Integer> aReqMultiCryptoTime = new HashMap<String,Integer>();
      Map<String,String> aReqEnd = new HashMap<String,String>();
      Map<String,String> aReqTLPersistedTime = new HashMap<String,String>();
      Map<String,Integer> aReqACSTime = new HashMap<String,Integer>();
      
      Map<String,String> cReq1Start = new HashMap<String,String>();
      Map<String,Integer> cReq1EncryptTime1 = new HashMap<String,Integer>();
      Map<String,Integer> cReq1EncryptTime2 = new HashMap<String,Integer>();
      Map<String,Integer> cReq1MultiCryptoTime = new HashMap<String,Integer>();
      Map<String,Integer> cReq1DecryptTime = new HashMap<String,Integer>();
      Map<String,Integer> cReq1MultiDeCryptoTime = new HashMap<String,Integer>();
      Map<String,String> cReq1End = new HashMap<String,String>();
      Map<String,String> cReq1TLBuiltTime = new HashMap<String,String>();
      Map<String,String> cReq1TLPersistedTime = new HashMap<String,String>();
      Map<String,String> cReq1OTPGenStart = new HashMap<String,String>();
      Map<String,String> cReq1OTPGenEnd = new HashMap<String,String>();
      
      Map<String,String> cReq2Start = new HashMap<String,String>();
      Map<String,Integer> cReq2EncryptTime1 = new HashMap<String,Integer>();
      Map<String,Integer> cReq2EncryptTime2 = new HashMap<String,Integer>();
      Map<String,Integer> cReq2MultiCryptoTime = new HashMap<String,Integer>();
      Map<String,Integer> cReq2DecryptTime = new HashMap<String,Integer>();
      Map<String,Integer> cReq2MultiDeCryptoTime = new HashMap<String,Integer>();
      Map<String,String> cReq2End = new HashMap<String,String>();
      Map<String,String> cReq2TLBuiltTime = new HashMap<String,String>();
      Map<String,String> cReq2TLPersistedTime = new HashMap<String,String>();
      Map<String,String> cReq2OTPGenStart = new HashMap<String,String>();
      Map<String,String> cReq2OTPGenEnd = new HashMap<String,String>();
      
      //acs-server.log 
      
      //C:\Work\LoadMachine\PI3-Sprint3\Logs\SoftwareSetup\run2
      String filePath = "C:\\Work\\LoadMachine\\PI3-Sprint3\\Logs\\SoftwareSetup\\multipleruns\\";
      File dir = new File(filePath);
      File[] directoryListing = dir.listFiles();
      Arrays.sort(directoryListing, new Comparator<File>() {
         public int compare(File f1, File f2) {
            return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
         }
      });
      if (directoryListing != null) {
         for (File file : directoryListing) {
           System.out.println(file.getName()+" : "+file.getAbsolutePath());
           String fileName = file.getName();
           if(fileName.startsWith("acs-server") && fileName.endsWith(".log")){
              System.out.println("Processing log file : "+fileName);
              
              try (BufferedReader br = new BufferedReader(new FileReader(new File(file.getAbsolutePath())))) {
                 String line;
                
                 while ((line = br.readLine()) != null) {
                    //System.out.println(line);
                    
                    if (null != line && !line.trim().isEmpty() && line.contains("Parsing received areqJson")) {
                       String transactionID = line.substring(3 + line.indexOf("] -"), line.lastIndexOf("-")).trim();
                       String time = line.substring(0, line.indexOf("[")).trim();
                    //   System.out.println("Areq start"+transactionID+" : "+time);
                       aReqStart.put(transactionID, time);
                       logFileName.put(transactionID, fileName);
                    } else if (null != line && !line.trim().isEmpty() && line.contains("After Encrypt Request Total time")) {
                       String transactionID = line.substring(3 + line.indexOf("] - "), line.indexOf(" - After Encrypt")).trim();
                       Integer timeInMilliSeconds = Integer.parseInt(line.substring(1 + line.lastIndexOf("["), line.lastIndexOf("]")).replaceAll(",", "").trim());
                       //System.out.println("Encrypt : "+transactionID+" : "+timeInMilliSeconds);
                       
                       if (!aReqEncryptTime1.containsKey(transactionID)) {
                          aReqEncryptTime1.put(transactionID, timeInMilliSeconds);
                       } else if (!aReqEncryptTime2.containsKey(transactionID)) {
                          aReqEncryptTime2.put(transactionID, timeInMilliSeconds);
                       }else if (!cReq1EncryptTime1.containsKey(transactionID)) {
                          cReq1EncryptTime1.put(transactionID, timeInMilliSeconds);
                       }else if (!cReq1EncryptTime2.containsKey(transactionID)) {
                          cReq1EncryptTime2.put(transactionID, timeInMilliSeconds);
                       }else if (!cReq2EncryptTime1.containsKey(transactionID)) {
                          cReq2EncryptTime1.put(transactionID, timeInMilliSeconds);
                       }else if (!cReq2EncryptTime2.containsKey(transactionID)) {
                          cReq2EncryptTime2.put(transactionID, timeInMilliSeconds);
                       }else{
                          System.out.println("1 Something seriously wrong in this program.... check ur self : "+transactionID);
                       }

                    } else if (null != line && !line.trim().isEmpty() && line.contains("After Decrypt Request Total time")) {
                       String transactionID = line.substring(3 + line.indexOf("] - "), line.indexOf(" - After Decrypt")).trim();
                       Integer timeInMilliSeconds = Integer.parseInt(line.substring(1 + line.lastIndexOf("["), line.lastIndexOf("]")).replaceAll(",", "").trim());
                     //  System.out.println("Decrypt : "+transactionID+" : "+timeInMilliSeconds);
                       if (!cReq1DecryptTime.containsKey(transactionID)) {
                          cReq1DecryptTime.put(transactionID, timeInMilliSeconds);
                       }else if (!cReq2DecryptTime.containsKey(transactionID)) {
                          cReq2DecryptTime.put(transactionID, timeInMilliSeconds);
                       }else{
                          System.out.println("2 Something seriously wrong in this program.... check ur self : "+transactionID);
                       }
                    }else if (null != line && !line.trim().isEmpty() && line.contains("MultiCrypto Encrypt Total time")) {
                       String transactionID = line.substring(3 + line.indexOf("] - "), line.lastIndexOf("-")).trim();
                       Double timeInMilliSeconds =  Double.parseDouble(line.substring(1 + line.lastIndexOf("["), line.lastIndexOf("]")).replaceAll(",","").trim());
                     //  System.out.println("MultiCrypto Encrypt : "+transactionID+" : "+timeInMilliSeconds);
                       if (!aReqMultiCryptoTime.containsKey(transactionID)) {
                          aReqMultiCryptoTime.put(transactionID, timeInMilliSeconds.intValue());
                       } else if (!cReq1MultiCryptoTime.containsKey(transactionID)) {
                          cReq1MultiCryptoTime.put(transactionID, timeInMilliSeconds.intValue());
                       } else if (!cReq2MultiCryptoTime.containsKey(transactionID)) {
                          cReq2MultiCryptoTime.put(transactionID, timeInMilliSeconds.intValue());
                       }else{
                          System.out.println("3 Something seriously wrong in this program.... check ur self : "+transactionID);
                       }
                    }  else if(null != line && !line.trim().isEmpty() && line.contains("AReq END ***********")){
                       String transactionID = line.substring(3 + line.indexOf("] -"), line.lastIndexOf("-")).trim();
                       String time = line.substring(0, line.indexOf("[")).trim();
                     //  System.out.println("AReq END : "+transactionID+" : "+time);
                       aReqEnd.put(transactionID, time);
                       String timeInSeconds = line.substring(1 + line.lastIndexOf("["), line.lastIndexOf("]"));
                       Double acsCaTime = Double.parseDouble(timeInSeconds)*1000;
                       aReqACSTime.put(transactionID, acsCaTime.intValue());
                    }else if(null != line && !line.trim().isEmpty() && line.contains("Retrieving Transaction corrosponding to CReq")){
                       String transactionID = line.substring(3 + line.indexOf("] -"), line.lastIndexOf("-")).trim();
                       String time = line.substring(0, line.indexOf("[")).trim();
                     //  System.out.println("CReq start : "+transactionID+" : "+time);
                       if(!cReq1Start.containsKey(transactionID)){
                          cReq1Start.put(transactionID, time);
                       }else if(!cReq2Start.containsKey(transactionID)){
                          cReq2Start.put(transactionID, time);
                       }else{
                          System.out.println("4 Something seriously wrong in this program.... check ur self : "+transactionID);
                       }
                    }else if(null != line && !line.trim().isEmpty() && line.contains("MultiCrypto Decrypt Total time")){
                       String transactionID = line.substring(3 + line.indexOf("] - "), line.lastIndexOf("-")).trim();
                       Double timeInMilliSeconds =  Double.parseDouble(line.substring(1 + line.lastIndexOf("["), line.lastIndexOf("]")).replaceAll(",","").trim());
                     //  System.out.println("MultiCrypto Decrypt : "+transactionID+" : "+timeInMilliSeconds);
                       if(!cReq1MultiDeCryptoTime.containsKey(transactionID)){
                          cReq1MultiDeCryptoTime.put(transactionID.trim(), timeInMilliSeconds.intValue());
                       }else if(!cReq2MultiDeCryptoTime.containsKey(transactionID)){
                          cReq2MultiDeCryptoTime.put(transactionID.trim(), timeInMilliSeconds.intValue());
                       }else{
                          System.out.println("5 Something seriously wrong in this program.... check ur self : "+transactionID);
                       }
                    }else if(null != line && !line.trim().isEmpty() && line.contains("CReq processing completed")){
                       String transactionID = line.substring(3 + line.indexOf("] -"), line.lastIndexOf("-")).trim();
                       String time = line.substring(0, line.indexOf("[")).trim();
                    //   System.out.println("CReq End :"+transactionID+" : "+time);
                       if(!cReq1End.containsKey(transactionID)){
                          cReq1End.put(transactionID.trim(), time);
                       }else if(!cReq2End.containsKey(transactionID)){
                          cReq2End.put(transactionID.trim(), time);
                       }else{
                          System.out.println("6 Something seriously wrong in this program.... check ur self : "+transactionID);
                       }
                    }else if (null != line && !line.trim().isEmpty() && line.contains("********* ActiveAReqCount")) { 
                       int num = Integer.parseInt(line.substring(1+line.lastIndexOf("["),line.lastIndexOf("]")).trim());
                       String key = line.substring(0,line.indexOf(","));
                       if(aReqCount.containsKey(key)){
                          Integer value= aReqCount.get(key);
                          aReqCount.put(key, (value+num)/2);
                       }else{
                          aReqCount.put(key, num);
                       }
                     } else if (null != line && !line.trim().isEmpty() && line.contains("Persisted transaction successfully")) {
                        String transactionID = line.substring(3 + line.indexOf("] -"), line.lastIndexOf("-")).trim();
                        String time = line.substring(0, line.indexOf("[")).trim();

                        if (!aReqTLPersistedTime.containsKey(transactionID)) {
                           aReqTLPersistedTime.put(transactionID, time);
                        } else if (!cReq1TLPersistedTime.containsKey(transactionID)) {
                           cReq1TLPersistedTime.put(transactionID, time);
                        } else if (!cReq2TLPersistedTime.containsKey(transactionID)) {
                           cReq2TLPersistedTime.put(transactionID, time);
                        }

                     } else if (null != line && !line.trim().isEmpty() && line.contains("Built challenge log")) {
                        String transactionID = line.substring(3 + line.indexOf("] -"), line.lastIndexOf("-")).trim();
                        String time = line.substring(0, line.indexOf("[")).trim();
                        if (!cReq1TLBuiltTime.containsKey(transactionID)) {
                           cReq1TLBuiltTime.put(transactionID, time);
                        } else if (!cReq2TLBuiltTime.containsKey(transactionID)) {
                           cReq2TLBuiltTime.put(transactionID, time);
                        }
                     } else if (null != line && !line.trim().isEmpty() && line.contains("Received OTP generation request")) {
                        String transactionID = line.substring(1+line.lastIndexOf("-")).trim();
                        String time = line.substring(0, line.indexOf("[")).trim();
                        if (!cReq1OTPGenStart.containsKey(transactionID)) {
                          // System.out.println(" OTP start : "+transactionID);
                           cReq1OTPGenStart.put(transactionID, time);
                        } else if (!cReq2OTPGenStart.containsKey(transactionID)) {
                           cReq2OTPGenStart.put(transactionID, time);
                        }
                     } else if (null != line && !line.trim().isEmpty() && line.contains("Doing HTTP Client")) {
                        String transactionID = line.substring(3 + line.indexOf("] -"), line.lastIndexOf("-")).trim();
                        String time = line.substring(0, line.indexOf("[")).trim();
                        if (cReq1OTPGenStart.containsKey(transactionID) && !cReq1OTPGenEnd.containsKey(transactionID)) {
                          // System.out.println(" OTP finish : "+transactionID);
                           cReq1OTPGenEnd.put(transactionID, time);
                        } else if (cReq2OTPGenStart.containsKey(transactionID) && !cReq2OTPGenEnd.containsKey(transactionID)) {
                           cReq2OTPGenEnd.put(transactionID, time);
                        }
                     }
                 }
              } catch (IOException e) {
                 e.printStackTrace();
              }
           }else{
              
           }
         }
      }
      int count2000cReq1=0;
      int count500cReq1=0;
      int count400cReq1=0;
      int count300cReq1=0;
      int count200cReq1=0;
      int count100cReq1=0;
      int count90cReq1=0;
      int count80cReq1=0;
      int count70cReq1=0;
      int count60cReq1=0;
      int count50cReq1=0;
      int count40cReq1=0;
      int count30cReq1=0;
      int count20cReq1=0;
      int count10cReq1=0;
      int count0cReq1=0;
      int count2000cReq2=0;
      int count500cReq2=0;
      int count400cReq2=0;
      int count300cReq2=0;
      int count200cReq2=0;
      int count100cReq2=0;
      int count90cReq2=0;
      int count80cReq2=0;
      int count70cReq2=0;
      int count60cReq2=0;
      int count50cReq2=0;
      int count40cReq2=0;
      int count30cReq2=0;
      int count20cReq2=0;
      int count10cReq2=0;
      int count0cReq2=0;
     //System.out.println(""+aReqEncryptTime1);
      //aReqStart.entrySet().retainAll(cReq2End.entrySet());
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath + "Time-Details1.csv")))) {
         Collection<String> intersectiontemp = CollectionUtils.union(aReqStart.keySet(), cReq1Start.keySet());
         Collection<String> intersection = CollectionUtils.union(intersectiontemp, cReq2Start.keySet());
         Iterator<String> iterator = intersection.iterator();
         String header = "TransID , AreqStart , AreqFinish ,AACount, AreqSTime , AreqLTime , AEncrypt1 , AEncrypt2 , AMultiEncrypt , " 
               + "Creq1Start , Creq1Finish , Creq1Total , C1Encrypt1 , C1Encrypt2 , C1Decrypt , C1MultiDecrypt, C1TLPersist,c1OTPGen, " 
               + "Creq2Start , Creq2Finish , Creq2Total , C2Encrypt2 , C2Decrypt , C2MultiDecrypt, C2TLPersist, c2OTPGen, "
               + "LogFileName";
         bw.write(header+"\n");
        // System.out.println(header);
         int ignoreCount=0;
         while (iterator.hasNext()) {
            String key = iterator.next();
             System.out.println(key+" : "+aReqEncryptTime1.get(key));
            if ((aReqStart.containsKey(key) && aReqEnd.containsKey(key)) || (cReq1Start.containsKey(key) && cReq1End.containsKey(key))
                  || (cReq2Start.containsKey(key) && cReq2End.containsKey(key))) {
               // System.out.println("Successs..........................................!");
               String aReqTtransactionTime = "";
               if (aReqStart.containsKey(key) && aReqEnd.containsKey(key)) {
                  aReqTtransactionTime =""+ Math.abs((simpleDateFormat.parse(aReqEnd.get(key)).getTime()) - (simpleDateFormat.parse(aReqStart.get(key)).getTime()));
               }
               String cReq1TtransactionTime ="";
               if (cReq1End.containsKey(key) && cReq1Start.containsKey(key)) {
                cReq1TtransactionTime =""+ Math.abs((simpleDateFormat.parse(cReq1End.get(key)).getTime()) - (simpleDateFormat.parse(cReq1Start.get(key)).getTime()));
               }
               String cReq2TtransactionTime = "";
               if (cReq2End.containsKey(key) && cReq2Start.containsKey(key)) {
                  cReq2TtransactionTime =""+ Math.abs((simpleDateFormat.parse(cReq2End.get(key)).getTime()) - (simpleDateFormat.parse(cReq2Start.get(key)).getTime()));
               }
               
               String cReq1TLPersistTime ="";
               if (cReq1TLPersistedTime.containsKey(key) && cReq1TLBuiltTime.containsKey(key)) {
                  cReq1TLPersistTime =""+ Math.abs((simpleDateFormat.parse(cReq1TLPersistedTime.get(key)).getTime()) - (simpleDateFormat.parse(cReq1TLBuiltTime.get(key)).getTime()));
                 
                  if(!cReq1TLPersistTime.trim().isEmpty()){
                     int time = Integer.parseInt(cReq1TLPersistTime);
                     if(time>2000){
                        count2000cReq1++;
                     }else if(time<=2000 && time>500){
                        count500cReq1++;
                     }else if(time<=500 && time>400){
                        count400cReq1++;
                     }else if(time<=400 && time>300){
                        count300cReq1++;
                     }else if(time<=300 && time>200){
                        count200cReq1++;
                     }else if(time<=200 && time>100){
                        count100cReq1++;
                     }else if(time<=100 && time>90){
                        count90cReq1++;
                     }else if(time<=90 && time>80){
                        count80cReq1++;
                     }else if(time<=80 && time>70){
                        count70cReq1++;
                     }else if(time<=70 && time>60){
                        count60cReq1++;
                     }else if(time<=60 && time>50){
                        count50cReq1++;
                     }else if(time<=50 && time>40){
                        count40cReq1++;
                     }else if(time<=40 && time>30){
                        count30cReq1++;
                     }else if(time<=30 && time>20){
                        count20cReq1++;
                     }else if(time<=20 && time>10){
                        count10cReq1++;
                     }else if(time<=10 && time>0){
                        count0cReq1++;
                     }
                     
                  }
               }
               String cReq2TLPersistTime = "";
               if (cReq2TLPersistedTime.containsKey(key) && cReq2TLBuiltTime.containsKey(key)) {
                  cReq2TLPersistTime =""+ Math.abs((simpleDateFormat.parse(cReq2TLPersistedTime.get(key)).getTime()) - (simpleDateFormat.parse(cReq2TLBuiltTime.get(key)).getTime()));
                  
                  if(!cReq2TLPersistTime.trim().isEmpty()){
                     int time = Integer.parseInt(cReq2TLPersistTime);
                     if(time>2000){
                        count2000cReq2++;
                     }else if(time<=2000 && time>500){
                        count500cReq2++;
                     }else if(time<=500 && time>400){
                        count400cReq2++;
                     }else if(time<=400 && time>300){
                        count300cReq2++;
                     }else if(time<=300 && time>200){
                        count200cReq2++;
                     }else if(time<=200 && time>100){
                        count100cReq2++;
                     }else if(time<=100 && time>90){
                        count90cReq2++;
                     }else if(time<=90 && time>80){
                        count80cReq2++;
                     }else if(time<=80 && time>70){
                        count70cReq2++;
                     }else if(time<=70 && time>60){
                        count60cReq2++;
                     }else if(time<=60 && time>50){
                        count50cReq2++;
                     }else if(time<=50 && time>40){
                        count40cReq2++;
                     }else if(time<=40 && time>30){
                        count30cReq2++;
                     }else if(time<=30 && time>20){
                        count20cReq2++;
                     }else if(time<=20 && time>10){
                        count10cReq2++;
                     }else if(time<=10 && time>0){
                        count0cReq2++;
                     }
                  }
               }
               //cReq1OTPGenStart
               
               String cReq1OTPGenTime ="";
               if (cReq1OTPGenStart.containsKey(key) && cReq1OTPGenEnd.containsKey(key)) {
                  cReq1OTPGenTime =""+ Math.abs((simpleDateFormat.parse(cReq1OTPGenStart.get(key)).getTime()) - (simpleDateFormat.parse(cReq1OTPGenEnd.get(key)).getTime()));
               }
               String cReq2OTPGenTime = "";
               if (cReq2OTPGenStart.containsKey(key) && cReq2OTPGenEnd.containsKey(key)) {
                  cReq2OTPGenTime =""+ Math.abs((simpleDateFormat.parse(cReq2OTPGenStart.get(key)).getTime()) - (simpleDateFormat.parse(cReq2OTPGenEnd.get(key)).getTime()));
               }
               
            String aReqStartTime = aReqStart.containsKey(key) ? aReqStart.get(key).replace(",", "-") : "";
            String aReqEndTime = aReqEnd.containsKey(key) ? aReqEnd.get(key).replace(",", "-") : "";
            //System.out.println(key+" : "+aReqStart.get(key));
            String aReqCountStr =   "" ; 
            if(aReqStart.containsKey(key)){
               String time = aReqStart.get(key).substring(0, aReqStart.get(key).lastIndexOf(","));
               if(aReqCount.containsKey(time)){
                  aReqCountStr =""+ aReqCount.get(time);
               }
            }
            String cReq1StartTime = cReq1Start.containsKey(key) ? cReq1Start.get(key).replace(",", "-") : "";
            String cReq1EndTime = cReq1End.containsKey(key) ? cReq1End.get(key).replace(",", "-") : "";
            String cReq2StartTime = cReq2Start.containsKey(key) ? cReq2Start.get(key).replace(",", "-") : "";
            String cReq2EndTime = cReq2End.containsKey(key) ? cReq2End.get(key).replace(",", "-") : "";
              // System.out.println("Time : "+aReqStart.get(key).substring(0, aReqStart.get(key).lastIndexOf(",")));
               //System.out.println("Map"+aReqCount);
               String result = key + " , " + aReqStartTime + " , " + aReqEndTime +"," + aReqCountStr + " , " + aReqACSTime.get(key) + " , " + aReqTtransactionTime + " , "+ aReqEncryptTime1.get(key) + " , " + aReqEncryptTime2.get(key) + " , " + aReqMultiCryptoTime.get(key) + " , "
                     + cReq1StartTime + " , "+ cReq1EndTime + " , "+ cReq1TtransactionTime + " , " + cReq1EncryptTime1.get(key) + " , "+ cReq1EncryptTime2.get(key)+" , "+ cReq1DecryptTime.get(key) + " , "+ cReq1MultiDeCryptoTime.get(key) + " , " +cReq1TLPersistTime+" , " +cReq1OTPGenTime+" , "
                     + cReq2StartTime + " , " + cReq2EndTime +" , "+ cReq2TtransactionTime + " , " + cReq2EncryptTime1.get(key) + " , "+ cReq2EncryptTime2.get(key) + " , "+ cReq2MultiDeCryptoTime.get(key) + " , " +cReq2TLPersistTime+" , " +cReq2OTPGenTime+" , "
                     + logFileName.get(key) + ",";
               //System.out.println(result);
               bw.write(result+"\n");
               //break;
            } else {
               System.out.println("Ignored "+key);
               ignoreCount++;
            }
         }
     
      System.out.println("Size : "+intersection.size());
      System.out.println("Ignore : "+ignoreCount);
      System.out.println("aReqStart "+aReqStart.size());
      System.out.println("***************");
      System.out.println("aReqEncryptTime1 : "+aReqEncryptTime1.size());
      System.out.println("***************");
      System.out.println("aReqEncryptTime2  : "+aReqEncryptTime2.size());
      System.out.println("***************");
      System.out.println("aReqMultiCryptoTime  : "+aReqMultiCryptoTime.size());
      System.out.println("***************");
      System.out.println("aReqEnd  : "+aReqEnd.size());
      System.out.println("***************");
      System.out.println("aReqACSTime  : "+aReqACSTime.size());
      System.out.println("***************");
      System.out.println("cReq1Start  : "+cReq1Start.size());
      System.out.println("***************");
      System.out.println("cReq1EncryptTime1  : "+cReq1EncryptTime1.size());
      System.out.println("***************");
      System.out.println("cReq1EncryptTime2  : "+cReq1EncryptTime2.size());
      System.out.println("***************");
      System.out.println("cReq1MultiCryptoTime  : "+cReq1MultiCryptoTime.size());
      System.out.println("***************");
      System.out.println("cReq1DecryptTime  : "+cReq1DecryptTime.size());
      System.out.println("***************");
      System.out.println("cReq1MultiDeCryptoTime  : "+cReq1MultiDeCryptoTime.size());
      System.out.println("***************");
      System.out.println("cReq1End  : "+cReq1End.size());
      System.out.println("***************");
      System.out.println("cReq2Start  : "+cReq2Start.size());
      System.out.println("***************");
      System.out.println("cReq2EncryptTime1  : "+cReq2EncryptTime1.size());
      System.out.println("***************");
      System.out.println("cReq2EncryptTime2  : "+cReq2EncryptTime2.size());
      System.out.println("***************");
      System.out.println("cReq2MultiCryptoTime  : "+cReq2MultiCryptoTime.size());
      System.out.println("***************");
      System.out.println("cReq2DecryptTime  : "+cReq2DecryptTime.size());
      System.out.println("***************");
      System.out.println("cReq2MultiDeCryptoTime  : "+cReq2MultiDeCryptoTime.size());
      System.out.println("***************");
      System.out.println("cReq2End  : "+cReq2End.size());
      
      System.out.println("*********Persist time **********");
      System.out.println(">2000 , "+count2000cReq1+" , "+count2000cReq2+" , ");
      System.out.println("501-2000 , "+count500cReq1+" , "+count500cReq2+" , ");
      System.out.println("401-500 , "+count400cReq1+" , "+count400cReq2+" , ");
      System.out.println("301-400 , "+count300cReq1+" , "+count300cReq2+" , ");
      System.out.println("201-300 , "+count200cReq1+" , "+count200cReq2+" , ");
      System.out.println("101-200 , "+count100cReq1+" , "+count100cReq2+" , ");
      System.out.println("91-100 , "+count90cReq1+" , "+count90cReq2+" , ");
      System.out.println("81-90 , "+count80cReq1+" , "+count80cReq2+" , ");
      System.out.println("71-80 , "+count70cReq1+" , "+count70cReq2+" , ");
      System.out.println("61-70 , "+count60cReq1+" , "+count60cReq2+" , ");
      System.out.println("51-60 , "+count50cReq1+" , "+count50cReq2+" , ");
      System.out.println("41-50 , "+count40cReq1+" , "+count40cReq2+" , ");
      System.out.println("31-40 , "+count30cReq1+" , "+count30cReq2+" , ");
      System.out.println("21-30 , "+count20cReq1+" , "+count20cReq2+" , ");
      System.out.println("11-20 , "+count10cReq1+" , "+count10cReq2+" , ");
      System.out.println("1-10 , "+count0cReq1+" , "+count0cReq2+" , ");
      } catch (IOException | ParseException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}
