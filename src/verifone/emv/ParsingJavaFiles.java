package verifone.emv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class ParsingJavaFiles {

	public static List<String> listOfFiles = new ArrayList<String>();
	public static void main(String[] args) {
		String filePath = "D:\\githome\\Working_Branch\\petroApps\\viper\\core\\app\\src";
		searchFile(filePath);
		System.out.println("Size of Files : "+listOfFiles.size());
	
		/*File file1 = new File("D:\\githome\\Working_Branch\\out.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file1);
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);
			System.out.println("This goes to out.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		
		
		for (String file : listOfFiles) {
			List<String> importPkg = buildMapping(file);
			for (String string : importPkg) {
				if(string.contains("fullserviceattendant") || string.contains("hps") || string.contains("incomm") 
						|| string.contains("linq3") || string.contains("loyalty") || string.contains("propfleet")
						|| string.contains("velocity") || string.contains("nbs") || string.contains("worldpay")
						|| string.contains("pcats")){
					//if(importPkg.size()>1){
						
						String dependecy = getDepndency(string);
						String className = (file.substring(file.indexOf("src")+4, file.lastIndexOf(".java"))).replace("\\", ".");
						if(!className.contains(dependecy)){
							System.out.print("Dependency : " +dependecy+" ");
							System.out.print(className + " : ");
							System.out.print(importPkg);
							System.out.println("");
							break;
						}
						
					//}
				}
			}
			
			
			
		}
		
		System.out.println();
	}
	
	private static String getDepndency(String string) {
		if(string.contains("fullserviceattendant")){
			return "fullserviceattendant";
		}
		if(string.contains("hps")){
			return "hps";
		}
		if(string.contains("incomm")){
			return "incomm";
		}
		if(string.contains("linq3")){
			return "linq3";
		}
		if(string.contains("loyalty")){
			return "loyalty";
		}
		if(string.contains("propfleet")){
			return "propfleet";
		}
		if(string.contains("velocity")){
			return "velocity";
		}
		if(string.contains("nbs")){
			return "nbs";
		}
		if(string.contains("worldpay")){
			return "worldpay";
		}
		if(string.contains("pcats")){
			return "pcats";
		}
		return null;
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
