package verifone.emv;

import java.io.UnsupportedEncodingException;


public class CyralicTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/*String hex = "B2D8E1D020B4D5D1D5E22031";
		
		StringBuilder output = new StringBuilder();
	    for (int i = 0; i < hex.length(); i+=2) {
	        String str = hex.substring(i, i+2);
	        output.append(Integer.parseInt(str, 16));
	        System.out.println(" Hi "+Integer.parseInt(str, 16));
	    }
		
	    System.out.println(output.toString());
	  //  System.out.println(output.toString().getBytes("UTF-8"));
	    byte[] converted  = output.toString().getBytes("UTF-8");
		
		for (byte b : converted) {
			System.out.println(b);
		}
		
		System.out.println(new String(converted,"UTF-8"));*/
		
		
		String ru = "Русский язык";
       // PrintStream ps = new PrintStream(System.out, true, "UTF-8");
        System.out.println(ru.length());
        System.out.println(ru);
        //ps.println(ru);
        
        String hex = "B2D8E1D020B4D5D1D5E22031";
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hex.length(); i+=2) {
	        String str = hex.substring(i, i+2);
	        output.append(Integer.parseInt(str, 16));
	        String strAsciiTab = Character.toString((char) Integer.parseInt(str, 16));
	        System.out.print(strAsciiTab);
	    }
        
        //System.out.println(output.toString());
	}

}
