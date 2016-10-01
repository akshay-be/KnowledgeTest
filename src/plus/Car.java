package plus;

 class Car {
	 public class Bugati{
		 void printName(){
			 System.out.println("bugati"+hashCode());
		 }
	 };
	 
	 
	 public static void main(String[] args) {
		Car car = new Car();
		Bugati bugati = car.new Bugati();
		bugati.printName();
		car.doNothing();
		
		Bugati bugati2 = car.new Bugati();
		bugati2.printName();
	}

	void doNothing(){
		System.out.println("Doing nothing"+hashCode());
	}

}
