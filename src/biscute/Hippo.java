package biscute;

public class Hippo {
	
	public String name ="akshay";
	public int age =0;
	
	public Hippo(){
		
	}
	public Hippo(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public int testTryCatch(){
		try{
			age = 2;
			return 2;
		}
		/*catch(ClassNotFoundException e){
			age = 3;
			return 3;
		}*/catch(Exception e){
			age = 4;
			return 4;
		}
		finally{
			//age =5;
			return 5;
		}
		//return 6;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hippo h1 = new Hippo("Akshay",3);
		int age = h1.testTryCatch();
		System.out.println(" Age "+age);
		System.out.println(" Hippo Age "+h1.age);
	}

}
