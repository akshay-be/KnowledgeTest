package plus;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExceptionTest {

	public static void main(String[] args) throws IOException {
		FileOutputStream fileOutputStream = null;
		
		try{
			fileOutputStream = new FileOutputStream("nothing.txt");
			fileOutputStream.write(123);
		}catch(IOException e){
			System.out.println("inside io exceoption");
		}
		finally{
			fileOutputStream.close();
		}

	}

}
