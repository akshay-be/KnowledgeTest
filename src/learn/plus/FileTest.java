package learn.plus;

import java.io.File;
import java.io.Serializable;

public class FileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("akshay.txt");
		
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.isHidden());
		System.out.println(file.isAbsolute());

		if("s" instanceof Serializable){
			System.out.println("instance of serializable");
		}
	}

}
