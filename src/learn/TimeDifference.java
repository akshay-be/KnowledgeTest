package learn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class TimeDifference {
	public static void main(String[] args) {

		String fileName = "C:\\Documents and Settings\\t_AkshayB1\\Desktop\\Betasite\\cridit slow\\Sorted.txt";
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String line = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MMM	dd	HH:mm:ss");
		//String priviousString="Dec 26 07:00:13";Dec	12	8:02:16
		ArrayList<String> threadIDList = new ArrayList<String>();
		File file = new File("C:\\Documents and Settings\\t_AkshayB1\\Desktop\\Betasite\\cridit slow\\TimeDiferenceStartEnd30.txt");
		FileWriter fw =null;
		BufferedWriter bw=null;
		
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			System.out.println("Start ");
			 fw = new FileWriter(file.getAbsoluteFile());
			 bw = new BufferedWriter(fw);
			while ((line = bufferedReader.readLine()) != null) {
				String threadID1 = line.substring(34, line.indexOf("00:02:6B:0D:1C:96"));
				
				String line2 = bufferedReader.readLine();
				String threadID2 = line2.substring(34, line2.indexOf("00:02:6B:0D:1C:96"));
				String priviousString = line2.substring(15,line.indexOf("PMC"));
				
				
				String parsed = line.substring(15,line.indexOf("PMC"));
				
				//System.out.println(parsed.trim()+" : "+priviousString.trim());
				Date date1 = formatter.parse(parsed.trim());
				Date date2 = formatter.parse(priviousString.trim());
				
				String result = threadID1.trim()+" Thread Start "+parsed +" End "+priviousString+" Execution Time : "+((date2.getTime()-date1.getTime())/1000);
				System.out.println(result);
				if((date2.getTime()-date1.getTime())/1000>=30){
					threadIDList.add(threadID1);
					bw.write(result+"\n");
					bw.flush();
				}
				
			}
			//bw.close();
			//fw.close();
			bufferedReader.close();
			System.out.println("END "+threadIDList.size());
			System.out.println("END "+threadIDList);
			bw.write("Number of threads : "+threadIDList.size()+" \n "+threadIDList+"\n\n\n");
			bw.flush();
			
			 String completeLogName = "C:\\Documents and Settings\\t_AkshayB1\\Desktop\\Betasite\\cridit slow\\CompleteLog.txt";
			 FileReader fileReaderCLN =  new FileReader(completeLogName);
			 String completeLine=null;
			 BufferedReader bufferedReaderCLN =  new BufferedReader(fileReaderCLN);
			 int i=0;
			 bw.write("\n SwipeAhead re-started threads \n");
			 bw.flush();
			 while((completeLine = bufferedReaderCLN.readLine()) != null) 
	         {
				 //System.out.println("111 "+completeLine);
				 if(completeLine.contains("SwipeAhead re-started")) {
					 for(String Tid:threadIDList){ 
						 //System.out.println("111 "+id);
						 if(completeLine.contains(Tid.trim())){
							 i++;
							//System.out.println("Check : "+Tid);
							bw.write(Tid+", ");
							bw.flush();
						 }
					 }
				 }
	         }
			 System.out.println("Number of threads having SH : "+i);
			 bufferedReaderCLN.close();
			 bw.write("\n Number of threads having SH : "+i);
			 bw.flush();
			 bw.close();
			 fw.close();
			 System.out.println("End of looping ");
		}catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		catch(ParseException p){
			p.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.out.println("End of File....!!");
			 try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}

		
	}
}
