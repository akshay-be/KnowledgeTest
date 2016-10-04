package newshunt;

import java.util.Map;
import java.util.TreeMap;

public class NewshuntTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String line = "asdbiuasfbuioasdfaaaa";
		Map<String,Integer> hm = new TreeMap<String,Integer>();
		for(int i =0;i<line.length();i++){
			Character key = line.charAt(i);
			//key.is
			if(hm.containsKey(key)){
				//hm.put(key,hm.get(key));
			}
			
		}
		
		for(int j=65;j<91;j++){
			
			String s = ""+(char)j;
			System.out.println(s);
			
		}

	}

}
