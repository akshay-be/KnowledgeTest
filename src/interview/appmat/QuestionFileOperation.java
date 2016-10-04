package interview.appmat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class QuestionFileOperation {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream inputfile = new FileInputStream("myfile");
		FileOutputStream outputFile = new FileOutputStream("myfile");
	}

}

/**
 * Select tow correct answers.
 * 
 * i.   Statement (1) throws a FileNotFoundException if the file cannot be found, 
 * 			or is a directory or cannot be opened for some reason. 
 * ii.  Statement (1) throws an IOException  if the file cannot be found 
 * 			or is a directory or cannot be opened for some reason.
 * iii. Statement (2) throws a FileNotFoundException if the file is a directory
 * 			or cannot be opened for some reason.
 * iv.  Statement (2) throws an 
 * 
 * 
 * *****/
 