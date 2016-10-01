package plus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializable {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SerializableB serializableB = new SerializableB();
		
		ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("datafile"));
		save.writeObject(serializableB);
		save.flush();
		
		ObjectInputStream restore = new ObjectInputStream(new FileInputStream("datafile"));
		
		SerializableB SerializableZ = (SerializableB) restore.readObject();

	}

}
