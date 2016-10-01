package interview.appmat;

/** What is the result of the attempting to compile and run the following program */
class Extender extends Thread{
	public Extender(){}
	public Extender(Runnable runnable){ super(runnable); }
	public void run() {System.out.println("| Extender |");	}
}
class Implementer implements Runnable{
	public void run() {System.out.println("| Implementer |");	}
}
public class QuestionThreads1  {

	public static void main(String[] args) {
		new Extender(new Implementer()).start();
		new Extender().start();
		new Thread(new Implementer()).start();

	}

}
