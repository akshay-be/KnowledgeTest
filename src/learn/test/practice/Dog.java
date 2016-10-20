package learn.test.practice;

public class Dog extends Animal {
	
	String name;
	
	public Dog(){
		name = "Dog";
	}
	
	public void sleep(){
		System.out.println(name+" Sleeping");
		super.sleep();
	}

}
