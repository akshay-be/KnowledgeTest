package plus;

import java.io.File;
import java.io.IOException;

public class TestFileExists {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("J://aksh.txt");
		System.out.println(file.exists());
		
		System.out.println(file.createNewFile());
	}

}
