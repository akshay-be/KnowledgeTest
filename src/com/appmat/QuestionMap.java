package com.appmat;

import java.util.Map;
import java.util.HashMap;

public class QuestionMap {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		
		map.put(1, "Value 1");
		map.put(2, "Value 2");
		map.put(null, "Value 3");
		map.put(1, "Value 4");

		for (int i : map.keySet()) {
			System.out.println(map.get(i));
		}
	}

}
/* Answer:
	1. Value 1, Value 2, Value 3, Value 4
	2. Value 1, Value 2, Value 3
	3. Value 1, Value 2, Value 4
	4. Compile time error.
	5. Run time exception.
*/