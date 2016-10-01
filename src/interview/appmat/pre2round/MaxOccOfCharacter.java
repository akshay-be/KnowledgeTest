package am.pre2round;

import java.util.HashMap;
import java.util.Map;

public class MaxOccOfCharacter {

	public static void main(String[] args) {
		String data = "asdfghjajauaienfagherttuuuuuuuuuuuuuuuuuuuuuuuuaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		char[] dataArr =  data.toCharArray();
		
		for (char c : dataArr) {
			Character temp = c;
			Integer count = 1;
			if(map.containsKey(temp)){
				count = map.get(temp);
				count++;
			}
			map.put(temp, count);
		}
		
		Map.Entry<Character, Integer> max = null;
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			if( max==null || entry.getValue().compareTo(max.getValue())>0){
				max= entry;
			}
		}
		System.out.println(max.getKey()+""+max.getValue());
		
 	}
}
