package com.tcs.priya;

import java.util.Date;
import java.util.HashMap;

/**
 * 
 * @author eshak01
 *
 */
public class OTPValidattion {
   private static HashMap<String, Date> mapOtpTime = new HashMap<>();
   private static HashMap<String, Integer> mapCount = new HashMap<>();

   public boolean validateTimeOtp(String userName) {
      int count = 1;
      if (mapCount.containsKey(userName)) {
         count = mapCount.get(userName);
         count++;
      }
      mapCount.put(userName, count);
      if (count == 6) {
         Date validTime = new Date(System.currentTimeMillis() + 1 * 60 * 1000);
         System.out.println("Blocked untill : " + validTime);
         mapOtpTime.put(userName, validTime);
         return false;
      } else if (mapOtpTime.containsKey(userName)) {
         Date validTime = mapOtpTime.get(userName);
         Date currentTime = new Date(System.currentTimeMillis());
         if (currentTime.compareTo(validTime) < 0) {
            return false;
         } else {
            System.out.println("2 mins over remeove the blocked");
            mapOtpTime.remove(userName);
            mapCount.remove(userName);
         }
      }
      return true;
   }

   public static void main(String[] args) throws InterruptedException {
      OTPValidattion otpValidattion = new OTPValidattion();
      for (int i = 0; i < 30; i++) {
         boolean status = otpValidattion.validateTimeOtp("akshay");
         if (!status) {
            Thread.currentThread().sleep(10000);
         }
         System.out.println("Time : " + new Date(System.currentTimeMillis()));
         System.out.println(status);
      }
   }
}
