/**
 * 
 */
package other;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author akshay
 *
 */
public class TestArryList {
	
	static{

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> a1 = new ArrayList<String>();
		
		a1.add("a1");
		a1.add("a1");
		a1.add("a1");
		a1.add("B1");
		a1.add("a1");
		a1.add("a1");
		a1.add("a1");
		
		
		System.out.println(" ArrayList Before : "+a1);
		
		a1.remove("a1");
		//a1.re
		//System.out.println(" ArrayList After : "+a1);
		
		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("a1");
		
		//List a4 =null;
		//a4.
		
		StringBuffer sb = new StringBuffer("h1");
		StringBuffer sb2 = new StringBuffer("h1");
		System.out.println(sb.equals(sb2));
		
		Package[] packages= Package.getPackages();
		
		for (Package package1 : packages) {
			System.out.println(package1.isSealed()+package1.getImplementationVendor()+" : "+package1.getName());
			//package1.
		}
		
		
	}

}
