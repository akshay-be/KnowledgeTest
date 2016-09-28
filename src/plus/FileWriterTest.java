package plus;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		
		try{
			String str = "friends";
			FileWriter fw = new FileWriter("D:\\Java_Ex\\a.txt",true);
			fw.write(str);
			fw.flush();
			fw.close();
		}catch(IOException e){
			System.out.println("Eception");
		}
		System.out.println("done boss");
	}
}
