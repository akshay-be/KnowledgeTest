package learn.enums;

public class EnumExample1 {
	
	enum Season {
		WINTER,SUMMER,SPRING
	}

	public static void main(String[] args) {
		for(Season e : Season.values()){
			System.out.println(e);
		}
	}

}
