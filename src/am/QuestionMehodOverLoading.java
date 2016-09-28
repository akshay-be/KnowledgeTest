package am;

public class QuestionMehodOverLoading {

	public long sum(long a, long b) { return a+b; }
	public int  sum(int a,  int b)  { return a+b; }
	//public int sum(long a, long b) { return 0; }
	//abstract int sum ();
	//private long sum(long a,long b) { return a+b; }
	public long sum(long a, int b) { return a+b; }
	
}
