package com.wissen;

class MyThread extends Thread {
	public String str;

	public MyThread(String str) {
		this.str = str;
	}

	public void run() {
		System.out.println(str);
	}
}

public class Q16ThreadTest {

	public static void main(String[] args) {
		MyThread my1 = new MyThread("1");
		MyThread my2 = new MyThread("2");
		
		my1.start();
		my2.start();
		
		System.out.println("3");
	}

}
