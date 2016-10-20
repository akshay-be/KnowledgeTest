package learn.others;

public class InterfaceVariableTest {

	public  final  int y;
	
	static{
		//y=0;
	}
	public InterfaceVariableTest(){
		y=1;
		sety(3);
	}
	
	public InterfaceVariableTest(int x){
		//any one statement below is manadatory..
		//y=2;
		this();
		sety(4);
	}
	
	public void sety(int x){
		//y=x;
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
