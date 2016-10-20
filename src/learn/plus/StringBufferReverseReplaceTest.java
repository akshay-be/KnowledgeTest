package learn.plus;

public class StringBufferReverseReplaceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer("ABCD");
		buffer.reverse();
		System.out.println(""+buffer);
		buffer.replace(1, 3, "A");
		System.out.println(""+buffer);
		buffer.reverse();
		System.out.println(""+buffer);
		buffer.replace(1, 3, "A");
		System.out.println(buffer);
	
	
		StringBuffer buffer1 = new StringBuffer("ABCDEFGH");
		buffer1.replace(1, 15, "A");
		System.out.println("Hello : "+buffer1);
		
		//StringBuilder bu = new St
		
		StringBuffer stringBuffer = new StringBuffer(buffer);
	
	}

}
