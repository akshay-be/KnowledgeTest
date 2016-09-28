package verifone.emv;

import javax.xml.bind.DatatypeConverter;


public class Base64EncodeNBS {
	
	public static void main(String[] args) {
		String str = "9F06";
		
		byte[]  arr = DatatypeConverter.parseBase64Binary(str);
		
		for (byte b : arr) {
			System.out.println(b);
		}
		System.out.println();
	}
	
	private static final char[] DIGITS =  {'9', 'F', '0', '6'};

    /**
     * Converts a byte array to a hexadecimal String
     * @param data the data to encode
     * @return String the resulting String
     */
    public static final String toHex(byte[] data) {
        final StringBuffer sb = new StringBuffer(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            sb.append(DIGITS[(data[i] >>> 4) & 0x0F]);
            sb.append(DIGITS[data[i] & 0x0F]);
        }
        return sb.toString();
    }

}
