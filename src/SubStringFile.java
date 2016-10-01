import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class SubStringFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "C:\\Documents and Settings\\t_AkshayB1\\Desktop\\Betasite\\cridit slow\\FilteredComplete.txt";
		FileReader fileReader = null;
		FileReader fileReaderFiltred = null;
		BufferedReader bufferedReader = null;
		BufferedReader bufferedReaderFiltred = null;
		String line = null;
		List<String> listThreadID = new ArrayList<String>();
		List<String> filtredThreadID = new ArrayList<String>();
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				if(line.contains("00:02:6B:0D:1C:96")){
					String threadID = line.substring(35, 42);
					System.out.println(""+threadID);
					listThreadID.add(threadID);
				}
				
				}
			
			Set<String> unique = new HashSet<String>(listThreadID);
			for (String key : unique) {
			    System.out.println(key + ": " + Collections.frequency(listThreadID, key));
			   if(Collections.frequency(listThreadID, key)>1)
			    filtredThreadID.add(key);
			}
			System.out.println("Total Threads : "+listThreadID.size());
			System.out.println("Filtred Threads : "+filtredThreadID.size());
			bufferedReader.close();
			fileReader.close();
			
			fileReaderFiltred = new FileReader(fileName);
			bufferedReaderFiltred = new BufferedReader(fileReaderFiltred);
			String filtredLine=null;
			
			File file = new File("C:\\Documents and Settings\\t_AkshayB1\\Desktop\\Betasite\\cridit slow\\FilteredThreads.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
 			BufferedWriter bw = new BufferedWriter(fw);
 			
			while ((filtredLine = bufferedReaderFiltred.readLine()) != null) {
				for(String id:filtredThreadID){
					if(filtredLine.contains(id)){
						bw.write(filtredLine+"\n");
						bw.flush();
					}
				}
			}
			 bw.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.out.println("End of File....!!");
				
		}
	}

}
