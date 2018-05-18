package ca.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author eshak01
 *
 */
public class TemplateFolder {
   public static void main(String[] args) {
      getAvilableResurceMap("C:\\Work\\ACS_home\\TDS2_HOME\\system-templates");
   }
   
   public static Map<String, Map<String, Map<String, String>>> getAvilableResurceMap(String directoryName) {
      Map<String, Map<String, Map<String, String>>> localeResMap = new HashMap<String, Map<String, Map<String, String>>>();
      File directory = new File(directoryName);
      File[] fList = directory.listFiles();
      for (File file : fList) {
         if (file.isDirectory()) {
            File[] versionDirectory = file.listFiles();
            Map<String, Map<String, String>> themeResMap = new HashMap<String, Map<String, String>>();
            for (File verFile : versionDirectory) {
               if (verFile.isDirectory()) {
                  File[] avileVersion = verFile.listFiles();
                  Map<String, String> versionFilePath = new HashMap<String, String>();
                  for (File verFile1 : avileVersion) {
                     versionFilePath.put(verFile1.getName().trim(), verFile1.getAbsolutePath());
                  }
                  themeResMap.put(verFile.getName().trim(), versionFilePath);
               }
            }
            localeResMap.put(file.getName().trim(), themeResMap);
         }
      }
      return localeResMap;
   }
}


