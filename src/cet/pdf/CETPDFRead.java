package cet.pdf;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


public class CETPDFRead {

	public static void main(String[] args) throws IOException {
	     
		System.out.println("Started");
		
		File file = new File("D:\\Profiles\\t_akshayb1\\Desktop\\cet\\2016\\engg_cutoff_gen.pdf");

		String absolutePath = file.getAbsolutePath();
		
		PdfReader reader = new PdfReader(absolutePath);
        System.out.println(absolutePath+" this PDF has "+reader.getNumberOfPages()+" pages.");
        
        PrintWriter writer = new PrintWriter("D:\\Profiles\\t_akshayb1\\Desktop\\cet\\2016\\engg_cutoff_gen.txt");
        
        int size = reader.getNumberOfPages();
        String collegeName = null;
        for(int i=0;i<size;i++){
        	 String page = PdfTextExtractor.getTextFromPage(reader, i+1);	
        		System.out.println("Page Content:\n\n"+page+"\n\n");
        		writer.println(page);
        }
        reader.close();
        
        System.out.println("Completed Boss");
	}
}
