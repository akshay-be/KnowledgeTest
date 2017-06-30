package ca.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ServerLogAnlysisMultiCrypto {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // After MultiCrypto Encrypt Request Total time
      int count = 0;
     long num=0;
      try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Work\\LoadMachine\\Sprint2_Logs\\AUTHRESULTKEYIN_SW\\Run5\\acs-server.log")))) {
         String line;
         while ((line = br.readLine()) != null) {

            if (null != line && !line.trim().isEmpty() && line.contains("After MultiCrypto Encrypt Request Total time")) {
                String time = line.substring(6+line.indexOf("time ["), line.lastIndexOf("]"));
               //System.out.println(time);
               num+=Integer.parseInt(time.replace(",", ""));
               count++;
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
      System.out.println("Num : "+num);
      System.out.println("Average time : "+(num/count));
   }
}
