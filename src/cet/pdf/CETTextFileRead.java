package cet.pdf;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CETTextFileRead {
	static long lowerCutOff = 50000;
	static long upperCutOff = 255500;
	public static void main(String[] args) throws IOException {

		System.out.println("Started");

		File file = new File("D:\\Profiles\\t_akshayb1\\Desktop\\cet\\2016\\engg_cutoff_gen_2016_genProcessed.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file.getPath()));
			String line = null;
			String collegeName = null;
			while ((line = br.readLine()) != null) {
				
				 //System.out.println(""+line);
				if (line != null && !line.isEmpty() && line.length()>2) {
					String[] arrElemetns = line.split(" ");
					try{
					if (arrElemetns.length > 23 ) {
						//System.out.println(""+line);
						long gmRank=0,gmRuralRank= 0,B3GenralRank= 0,B3RuralRank = 0;
				
						if(!arrElemetns[arrElemetns.length - 9].contains("--")){
							gmRank = Integer.parseInt(arrElemetns[arrElemetns.length - 9]);
						}
						
						if(!arrElemetns[arrElemetns.length - 7].contains("--")){
							gmRuralRank = Integer.parseInt(arrElemetns[arrElemetns.length - 7]);
						}
						
						if(!arrElemetns[arrElemetns.length - 12].contains("--")){ 
							B3GenralRank = Integer.parseInt(arrElemetns[arrElemetns.length - 12]);
						}
						
						if(!arrElemetns[arrElemetns.length - 10].contains("--")){
							B3RuralRank = Integer.parseInt(arrElemetns[arrElemetns.length - 10]);
						}
							if ((gmRank != 0 && gmRank > lowerCutOff && gmRank < upperCutOff)
									|| (gmRuralRank != 0 && gmRuralRank > lowerCutOff && gmRuralRank < upperCutOff)
									|| (B3GenralRank != 0 && B3GenralRank > lowerCutOff && B3GenralRank < upperCutOff)
									|| (B3RuralRank != 0 && B3RuralRank > lowerCutOff && B3RuralRank < upperCutOff)) {
							
							//System.out.println(arrElemetns[1]);
							if(arrElemetns[1].trim().equals("CS") || arrElemetns[1].trim().equals("IE")
									|| arrElemetns[1].trim().equals("ME") || arrElemetns[1].trim().equals("CE")){
								if(collegeName!=null){
									System.out.println(""+collegeName);
									collegeName=null;
								}
								System.out.println(" "+arrElemetns[0]+" "+arrElemetns[1]+" GM : "+gmRank+" "+" GMR : "+gmRuralRank+" 3BG : "+B3GenralRank+" 3BR : "+B3RuralRank);
							}
						}
						//System.out.println(arrElemetns[0]+""+arrElemetns[1]+""+gmRank);
					} else if(arrElemetns.length > 2){
						collegeName = line;
						//System.out.println("" + line);
					}
					}catch(java.lang.NumberFormatException e){
						System.out.println("Akshay :: "+collegeName + line);
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Finished");

	}
}
class DetailsBean {
	String branch="";
	long gmRank=0,gmKannadaRank= 0,gmRuralRank= 0,B3GenralRank= 0,B3KannadaRank= 0,B3RuralRank = 0;
}


