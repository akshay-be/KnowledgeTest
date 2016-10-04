package interview.appmat.pre2round;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileReadWrite {

	public static void main(String[] args) {
		File input = new File("D:\\Personal\\Java_Ex\\input.txt");
		File output = new File("D:\\Personal\\Java_Ex\\output.txt");
		
		Scanner sc=null;
		PrintWriter pw=null;
		
		try {
			sc = new Scanner(input);
			pw = new PrintWriter(output);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				line = line.replaceAll("[aeiouAEIOU]", "*");
				pw.write(line+" \n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception : "+e);
		}finally{
			sc.close();
			pw.close();
		}
		System.out.println("Completed.....");
	}
}
