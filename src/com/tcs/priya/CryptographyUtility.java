package com.tcs.priya;
import java.security.InvalidKeyException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
//import org.apache.cordova.CallbackContext;
//import org.apache.cordova.CordovaPlugin;
//import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;
//import android.util.Base64;
//import android.util.Log;

public class CryptographyUtility extends CordovaPlugin{
   CallbackContext call_back_context;  
   String encryptedData;
   String decryptedData;
   
    
   @Override
   public boolean execute(String action, String args, final CallbackContext callbackContext) 
   {
      
      call_back_context = callbackContext;
      
      int indexOfFirst = args.indexOf(",");
      String strKeySpec = args.substring(0,indexOfFirst);
      String tempData = args.substring(indexOfFirst+1);
      int indexOfSecond = tempData.indexOf(",");
      String strIvSpec = tempData.substring(0,indexOfSecond);
      args = tempData.substring(indexOfSecond+1);
      
      System.out.println("Key : "+strKeySpec);
      System.out.println("IVSpec : "+strIvSpec);
      System.out.println("Enrypt : "+args);
      
      if("encryption".equals(action)) 
       {
         
         Cipher eCipher = null ;
           try 
           {             
            SecretKeySpec keySpec = getKeySpec(strKeySpec);
              IvParameterSpec ivSpec = getIvSpec(strIvSpec);
              eCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            eCipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            //Log.d("Passed String for Encryption" , args);
            
            String dataToEncrypr = args;
            encryptedData = Base64.encodeToString(eCipher.doFinal(dataToEncrypr.getBytes("UTF-8")), Base64.NO_WRAP);
            //LOG.e("Text after Encryption",""+eCipher.doFinal(dataToEncrypr.getBytes("UTF-8"))+"");
            System.out.println(eCipher.doFinal(dataToEncrypr.getBytes()));
            //Log.d("Encoding after encryption : ",Base64.encodeToString(eCipher.doFinal(dataToEncrypr.getBytes("UTF-8")), Base64.NO_WRAP));
            
            call_back_context.success(encryptedData); 
         } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            call_back_context.error("Error Occured");
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            call_back_context.error("Error Occured");
         }
           return true;
       }
       else if("decryption".equals(action))
       {
         try
         {
             SecretKeySpec keySpec = getKeySpec(strKeySpec);
               IvParameterSpec ivSpec = getIvSpec(strIvSpec);
               Cipher dCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
               dCipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
               String dataToDecrypt = args;
               String decryptedData = new String(dCipher.doFinal(Base64.decode(dataToDecrypt.getBytes("UTF-8"),Base64.NO_WRAP)));
               //Log.d("Decoded text : ", new String(Base64.decode(dataToDecrypt.getBytes("UTF-8"),Base64.NO_WRAP),"UTF-8"));
               //Log.d("Decryption after decoding the data", new String(dCipher.doFinal(Base64.decode(dataToDecrypt.getBytes("UTF-8"),Base64.NO_WRAP))));
               decryptedData = new String(dCipher.doFinal(Base64.decode(dataToDecrypt.getBytes("UTF-8"),Base64.NO_WRAP)));
               
               call_back_context.success(decryptedData);
         }
         catch(Exception e)
         {
            call_back_context.error(e.getMessage());
         }
         return true;
       }
       return false;
   }
   
      public SecretKeySpec getKeySpec(String keyStr) throws Exception
       {
           byte[] key = keyStr.getBytes(); 
           return new SecretKeySpec(key, "AES");
       }

       public IvParameterSpec getIvSpec(String keyStr) throws Exception
       {
           byte[] iv =  keyStr.getBytes();
           return new IvParameterSpec(iv);
       } 
}
