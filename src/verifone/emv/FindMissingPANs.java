package verifone.emv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class FindMissingPANs {

	public static void main(String[] args) {
		
		File file = new File("D:\\EMV\\NTS\\trackData\\TrackDetails.txt");
		BufferedReader br=null;
		
		try {
			br = new BufferedReader(new FileReader(file.getPath()));
			String line =null;
			
			while ((line=br.readLine()) != null) {
				//System.out.println(""+line);
				String[] arrElemetns = line.split(";");
				String lable = arrElemetns[0];
				String aid = arrElemetns[2];
				String pan = arrElemetns[3];
				String length = arrElemetns[4];
				
				if(aid!=null && aid.trim().startsWith("A000")){
					//System.out.println(""+aid);
				}else{
					System.out.println(lable+" : "+pan);
				}
			}
			br.close();
		}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}

