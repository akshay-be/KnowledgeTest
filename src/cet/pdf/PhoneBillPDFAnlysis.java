package cet.pdf;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


public class PhoneBillPDFAnlysis {

	public static void main(String[] args) throws IOException {
		     
		System.out.println("Started");
		
		File file = new File("D:\\Personal\\anlysis\\bill");
		File[] arrFile = file.listFiles();
		if(file.exists()){
			System.out.println("i am their..."+file.isDirectory());
			
			for (File file2 : arrFile) {
				System.out.println(file2.getAbsolutePath());
			}
		}
       // FileOutputStream fstream = new FileOutputStream("D:\\Personal\\anlysis\\bill.txt");
		PrintWriter writer = new PrintWriter("D:\\Personal\\anlysis\\bill.txt");
		
		for (File file2 : arrFile) {
			String absolutePath = file2.getAbsolutePath();
				if(absolutePath.contains(".pdf")){
			        PdfReader reader = new PdfReader(absolutePath);
			        System.out.println(absolutePath+" this PDF has "+reader.getNumberOfPages()+" pages.");
			        
			        int size = reader.getNumberOfPages();
			        for(int i=0;i<size;i++){
			        	 String page = PdfTextExtractor.getTextFromPage(reader, i+1);
			        	 if(page.contains("Your Itemised Statement")){
			        		// System.out.println("Page Content:\n\n"+page+"\n\n");
			        		 writer.println(page);
			        	 }
			        }
			        reader.close();
			}
		}
        writer.close();
       // System.out.println("Is this document tampered: "+reader.isTampered());
      //  System.out.println("Is this document encrypted: "+reader.isEncrypted());


        System.out.println("I am done!");
        
        
        
        // Open the file
        FileInputStream fstream = new FileInputStream("D:\\Personal\\anlysis\\bill.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        List<String> list = new ArrayList<String>();
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
        	
        	if(strLine.contains("airtelgprs") || strLine.contains("Number") || strLine.contains("Mobile")){
        		continue;
        	}
        	
        	String formatedText = null;
        	String[] lineSplit = strLine.split(" ");
        	if(lineSplit.length==7){
        		list.add(strLine);
        	}
        	else if(lineSplit.length == 14){
        		formatedText = lineSplit[0]+" "+lineSplit[1]+" "+lineSplit[2]+" "+lineSplit[3]+" "+lineSplit[4]+" "+lineSplit[5]+" "+lineSplit[6];
        		list.add(formatedText);
        		formatedText = lineSplit[7]+" "+lineSplit[8]+" "+lineSplit[9]+" "+lineSplit[10]+" "+lineSplit[11]+" "+lineSplit[12]+" "+lineSplit[13];
        		list.add(formatedText);
        	}else{
        		System.out.println("Check : "+strLine);
        	}
        }

        PrintWriter write2 = new PrintWriter("D:\\Personal\\anlysis\\Filterbill.txt");
        for (String string : list) {
        	 write2.println(string);
		}
        write2.close();
        
        HashMap<String,Integer> hm = new HashMap<String, Integer>(); 
        for (String string : list) {
        	String[] lineSplit = string.split(" ");
        	if(!hm.containsKey(lineSplit[3])){
        		hm.put(lineSplit[3], Integer.parseInt(lineSplit[5]));
        	}else{
        		Integer temp = hm.get(lineSplit[3]) + Integer.parseInt(lineSplit[5]);
        		hm.put(lineSplit[3], temp);
        	}
		}
        System.out.println(hm);
        
        PrintWriter write3 = new PrintWriter("D:\\Personal\\anlysis\\Summarybill.txt");
        
        for (String key : hm.keySet()) {
        	System.out.println("key: " + key + " value: " + hm.get(key));
        	write3.println(key+" "+ hm.get(key));
        }
        write3.close();
        //Close the input stream
        br.close();
        
        
        List<Entry<String, Integer>> list1 = new ArrayList<Entry<String, Integer>>(hm.entrySet());
		Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

        System.out.println("Sorted :: ");
        for (Entry<String, Integer> entry : list1) {
            System.out.println(entry);

        }

    
	}

}
