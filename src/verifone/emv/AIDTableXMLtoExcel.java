package verifone.emv;
import java.io.BufferedReader;
import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class AIDTableXMLtoExcel {

	public static void main(String[] args) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sample sheet");
        String strPath ="D:\\EMV\\NTS\\trackData\\FromCollies\\contact";
		String xlsx="D:\\EMV\\NTS\\trackData\\ContactTrackDataFilteredDFName.xlsx";
		
		File file = new File(strPath);
		BufferedReader br=null;
		
		System.out.println("I am done....!");
	}

}
