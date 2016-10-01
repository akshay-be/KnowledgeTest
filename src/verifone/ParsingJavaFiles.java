package verifone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ParsingJavaFiles {

	public static List<String> listOfFiles = new ArrayList<String>();
	public static void main(String[] args) {
		String filePath = "N:\\Verifone\\ConfigClient\\CR0582.01\\CR0582.01\\petroApps\\viper\\core\\app\\src";
		searchFile(filePath);
		System.out.println("Size of Files : "+listOfFiles.size());
	
		for (String file : listOfFiles) {
			List<String> importPkg = buildMapping(file);
			if(importPkg.size()>1){
				String className = (file.substring(file.indexOf("src")+4, file.lastIndexOf(".java"))).replace("\\", ".");
				System.out.print(className + " : ");
				System.out.print(importPkg);
				System.out.println("");
			}
			
			
		}
	}
	
	public static List<String> buildMapping(String filePath){
	
		List<String> listOfImport = new ArrayList<String>();
		FileInputStream fis=null;
		BufferedReader br =null;
		try {
			fis = new FileInputStream(new File(filePath));
			//Construct BufferedReader from InputStreamReader
			br = new BufferedReader(new InputStreamReader(fis));
		 
			String line = null;
			while ((line = br.readLine()) != null) {
				//System.out.println(line);  
				if(line.contains("import ") 
						&& !line.contains("org.slf4j") && !line.contains("org.apache.log4j") 
						&& !line.contains("java.") && !line.contains("javax.xml")){
					listOfImport.add(line.substring(line.indexOf("import ")+7,line.lastIndexOf(";")));
				}
			}
		 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		return listOfImport;
	}
	public static void searchFile(String filePath){
		File[] faFiles = new File(filePath).listFiles();

		for(File file: faFiles){
		    if(file.getName().endsWith(".java")){
		    	listOfFiles.add(file.getAbsolutePath());
		    }
		    if(file.isDirectory()){
		    	searchFile(file.getAbsolutePath());
		    }
		  }
	}
}
