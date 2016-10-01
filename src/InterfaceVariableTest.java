
public class InterfaceVariableTest {

	public final  int y;
	
	static{
		//y=0;
	}
	public InterfaceVariableTest(){
		//y=1;
		sety(3);
	}
	
	public InterfaceVariableTest(int x){
		//y=2;
		sety(4);
	}
	
	public void sety(int x){
		y=x;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//	ExInterface.x=15;
		//y=1;
		//InterfaceVariableTest ex = new InterfaceVariableTest();
		//ex.y=15;

	}

}
