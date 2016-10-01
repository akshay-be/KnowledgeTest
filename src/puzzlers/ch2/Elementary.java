package puzzlers.ch2;

import java.util.ArrayList;
import java.util.List;

public class Elementary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//bad code
		System.out.println(12345+5432l);
		
		//better approch
		System.out.println(12345+5432L);

		
		//bad code
		List<String> l = new ArrayList<String>();
		l.add("Foo");
		System.out.println(l);
	}

}
