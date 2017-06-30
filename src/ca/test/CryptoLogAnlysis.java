package ca.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CryptoLogAnlysis {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // After MultiCrypto Encrypt Request Total time
      int count = 0;
     double time3DS=0;
     int count3DS = 0;
     double time=0;
      try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Work\\LoadMachine\\Sprint2_Logs\\09-03-2017\\crypto-service.log")))) {
         String line;
         while ((line = br.readLine()) != null) {

            if (null != line && !line.trim().isEmpty() && line.contains("MultiCrypto encrypt Total Execution time")) {
                String tempTime = line.substring(1+line.lastIndexOf("["), line.lastIndexOf("]"));
                //System.out.println(line);
                //System.out.println(tempTime);
                time+=Double.parseDouble(tempTime.replace(",", ""));
                //System.out.println(time);
               count++;
            }
            
            if (null != line && !line.trim().isEmpty() && line.contains("3DS encryption. Time")) {
               String tempTime = line.substring(1+line.lastIndexOf("["), line.lastIndexOf("]"));
               //System.out.println(line);
               //System.out.println(tempTime);
               time3DS+=Double.parseDouble(tempTime.replace(",", ""));
               //System.out.println(time3DS);
               count3DS++;
           }

         }
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("Count : "+count);
      System.out.println("Time : "+time);
      System.out.println("Average time : "+(time/count));
      
      System.out.println("count 3DS : "+count3DS);
      System.out.println("Time 3DS : "+time3DS);
      System.out.println("Average time : "+(time3DS/count3DS));
   }

}
