package verifone.emv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import test1.CardBean;


public class Track2EquivalentData {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sample sheet");
        
		//String path = "C:\\Programs Collis\\Collis\\Collis Brand Test Tool 4.9.2\\Application\\Suites\\Images\\";
		//String strPath = path+"Visa\\Contact\\Visa Host Test Cards";
        String strPath ="D:\\EMV\\NTS\\trackData\\FromCollies\\contact";
		String xlsx="D:\\EMV\\NTS\\trackData\\ContactTrackDataFilteredDFName.xlsx";

		File file = new File(strPath);
		BufferedReader br=null;
		//Set<String> trackData = new TreeSet<String>();
		//Set<String> aid = new TreeSet<String>();
		
		ArrayList<CardBean> cardTableEntries = new ArrayList<CardBean>();
		
		System.out.println(""+file.isDirectory());
		File[] filesIndeirectory = file.listFiles();
		
		int rownum = 0;
		for(File f : filesIndeirectory){
			br = new BufferedReader(new FileReader(f.getPath()));
			String line = br.readLine();
			String applicationPAN ="";
			String track1 ="";
			String track2 ="";
			String AID = null;
			String applicationLable = null;
			String applicationPreferredName= null;
			String DFName= null;
			System.out.println(""+f.getName());
			
			while (line != null) {

				try {
					
					if(line.contains("<!-- Note: If you change <AID>, also change") || line.trim().contains("<!-- this points to <ApplicationLabel> below -->")
							|| line.trim().contains("ApplicationLabel_AliasAID") || line.trim().contains("<!--ApplicationLabel>")
							|| line.trim().contains("<ApplicationPANSeqno>") || line.trim().contains("<ApplicationPANSeqno/>") 
							|| line.trim().contains("<!--ApplicationPreferredName>")){
						line = br.readLine();
						continue;
					}
					
					if (line.contains("ApplicationPAN") && !line.trim().equals("<ApplicationPAN/>")) {
						//applicationPAN = line.substring(line.indexOf(">") + 1,line.lastIndexOf("</ApplicationPAN>")).replace(" ", "");
						
						//System.out.println("" + applicationPAN);
						//trackData.add(track);
					}
					
					if (line.contains("Track1DiscretionaryData") && !line.trim().equals("<Track1DiscretionaryData/>")) {
						track1 = line.substring(line.indexOf(">") + 1,line.lastIndexOf("<")).replace(" ", "");
						
						System.out.println("" + track1);
						//trackData.add(track);
					}
					
					if (line.contains("Track2EquivalentData") && !line.trim().equals("<Track2EquivalentData/>")) {
						track2 = line.substring(line.indexOf(">") + 1,line.lastIndexOf("<")).replace(" ", "");
						
						System.out.println("" + track2);
						applicationPAN = track2.substring(0,track2.indexOf("D"));
						//trackData.add(track);
					}

					if (line.contains("<AID>") && !line.trim().equals("<AID/>") && !line.trim().equals("<AliasAID/>") ) {
						AID = line.substring(line.indexOf(">") + 1,line.lastIndexOf("</AID>")).replace(" ", "");
						System.out.println("" + AID);
						//aid.add(AID);
					}

					if (line.contains("ApplicationLabel") && !line.trim().equals("<ApplicationLabel/>") ) {
						applicationLable = convertHexToAscii(line.substring(line.indexOf(">") + 1, line.lastIndexOf("</ApplicationLabel>")).replace(" ", ""));
						System.out.println("" + applicationLable);
					}
					
					if(line.contains("ApplicationPreferredName") && !line.trim().equals("<ApplicationPreferredName/>") ){
						applicationPreferredName = convertHexToAscii(line.substring(line.indexOf(">") + 1, line.lastIndexOf("</ApplicationPreferredName>")).replace(" ", ""));
					}
					
					if(line.contains("DFName") && !line.trim().equals("<DFName/>") ){
						DFName = (line.substring(line.indexOf(">") + 1, line.lastIndexOf("</DFName>")).replace(" ", ""));
					}
					

					line = br.readLine();
				} catch (StringIndexOutOfBoundsException e) {
					System.out.println("Error in reading : " + line);
				}
			}

			if(applicationPAN!=null && AID!=null){
				
				
				CardBean bean = new CardBean(applicationLable,AID,applicationPAN,applicationPAN.length());
				if(!cardTableEntries.contains(bean)){
					Row row = sheet.createRow(rownum++);
					cardTableEntries.add(bean);
					int colnum = 0;
					Cell cell0 = row.createCell(colnum++);
	        		cell0.setCellValue(applicationLable);
	        		
	        		Cell cell8 = row.createCell(colnum++);
	        		cell8.setCellValue(applicationPreferredName);
	        		
	        		Cell cell1 = row.createCell(colnum++);
	        		cell1.setCellValue("Contact");
	        		
					Cell cell2 = row.createCell(colnum++);
	        		cell2.setCellValue(AID);
	        		
					Cell cell3 = row.createCell(colnum++);
	        		cell3.setCellValue(applicationPAN);
	        		
	        		Cell cell4 = row.createCell(colnum++);
	        		cell4.setCellValue(applicationPAN.length());
	        		
	        		Cell cell5 = row.createCell(colnum++);
	        		cell5.setCellValue(track1);
	        		
	        		Cell cell6 = row.createCell(colnum++);
	        		cell6.setCellValue(track2);
	        		
	        		Cell cell7 = row.createCell(colnum++);
	        		cell7.setCellValue(f.getName());
	        		
	        		Cell cell9 = row.createCell(colnum++);
	        		cell9.setCellValue(DFName);
	        		
				}else{
					System.out.println("Duplicate Entry : "+applicationLable+" : "+AID+" : "+applicationPAN);
				}
			}
			
			br.close();
			
		}
		
		FileOutputStream out = new FileOutputStream(new File(xlsx));
        workbook.write(out);
        out.close();
		System.out.println("I am Done! "+rownum);
		
	}
	
	public static String convertHexToAscii(String hex) {
		if(hex.contains("<!--")){
			return "";
		}
		System.out.println(" Hex : "+hex);
		 StringBuilder output = new StringBuilder();
		    for (int i = 0; i < hex.length(); i+=2) {
		        String str = hex.substring(i, i+2);
		        output.append((char)Integer.parseInt(str, 16));
		    }
			return output.toString();
		
	}

}
