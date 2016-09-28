package verifone.emv;

public class HexConversion {

	public static void main(String[] args) {
		byte[] value = {56,48}; //80
		//byte[] value = {52,48}; //40
		//byte[] value = {48,48}; //00
		
		int crypt = Integer.parseInt(bytesToString(value));
		String s = bytesToString(value);
		System.out.println("int : "+crypt);
		String tagData=Integer.toBinaryString(Integer.decode("0x"+s));
		 while (tagData.length() < 8){
			 tagData = "0"+tagData;
		 }
		System.out.println("tagdata : "+tagData);
		System.out.println("length : "+tagData.length());
	}

	
	public static String bytesToString(byte[] data){
		String convertedString=null; 
		
			if(data!=null){
				convertedString = new String(data);
			}

		
		System.out.println(convertedString);
		return convertedString;
	}
}
