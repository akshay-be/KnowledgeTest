package hackerrank.java;

import java.security.MessageDigest;
import java.util.Scanner;

public class JavaSHA256 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
			// return bytesToHex(md.digest
			byte[] digest = md.digest();
			for (byte b : digest) {
				System.out.printf("%02x", b);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}

}
