package test1;

public class NumberRegEx {

	public static void main(String[] args) {
		String regex = "[0-9]+"; 
		String data = "a23343453"; 
		System.out.println(data.matches(regex));

	}

}
