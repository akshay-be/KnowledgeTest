import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadCountryInfo {
	
	
	public static void main(String[] args) {

		Scanner scan;
		try {
			scan = new Scanner(new File(
					"D:\\Profiles\\t_akshayb1\\Downloads\\US.txt"));

			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				line = line.replaceAll(" ", ";").replaceAll("\\s\\s", ";").replaceAll("	", ";");
				String[] arr=line.split(";");
				System.out.println(arr.length);
				System.out.println(line);
				/*for (String string : arr) {
					
				}*/
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
