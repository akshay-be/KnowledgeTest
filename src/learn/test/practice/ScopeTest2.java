package learn.test.practice;

import learn.test.ScopeTest;

public class ScopeTest2 extends ScopeTest {

	void showABC(){
		
		System.out.println(""+i);
	}
}


class ABCD{
	void showABC(){
		ScopeTest2 s3 = new ScopeTest2();
		//System.out.println(""+s3.i);
	}
}