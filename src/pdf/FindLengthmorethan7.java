package pdf;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FindLengthmorethan7 {
	public static void main(String[] args) throws IOException {

		System.out.println("Started");
		File file = new File("D:\\Profiles\\t_akshayb1\\Desktop\\cet\\2016\\engg_cutoff_gen.txt");
		File fileWr = new File("D:\\Profiles\\t_akshayb1\\Desktop\\cet\\2016\\engg_cutoff_gen_2016_genProcessed.txt");
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader(file.getPath()));
			bw = new BufferedWriter(new FileWriter(fileWr.getPath()));
			String line = null;
			String collegeName = null;
			while ((line = br.readLine()) != null) {

				// System.out.println(""+line);
				if (line != null && !line.isEmpty() && line.length() > 2) {
					String[] arrElemetns = line.split(" ");
					if (arrElemetns.length > 23 ) {
						for (int i=3;i<arrElemetns.length;i++) {
							String string = arrElemetns[i];
							if(string.length()>8){
								line= line.replaceAll(string, string.substring(0, 6)+" "+string.substring(6));
							}
						}
					}
				}
				bw.write(line);
				bw.write("\n");
			}
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Finished");

	}
}
