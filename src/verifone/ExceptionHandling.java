package verifone;

public class ExceptionHandling {
	
	private ExceptionHandling(){
		System.out.println("Default constructer");
	}

	private int myUselessMethod(){
		return 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class fis = null;
		Object obj = null;
		try {
			System.out.println("Before");
			fis = Class.forName("verifone.ExceptionHandling");
			obj = fis.newInstance();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e){
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		ExceptionHandling ex = (ExceptionHandling) obj;
		int value =ex.myUselessMethod();
		System.out.println("After : "+value);
	}

}
