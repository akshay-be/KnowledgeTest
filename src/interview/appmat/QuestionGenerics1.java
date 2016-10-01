package interview.appmat;

import java.util.ArrayList;
import java.util.List;

interface Wagger {}
class Pet implements Wagger{}
class Dog extends Pet {}
class Cat extends Pet {}
public class QuestionGenerics1 {

	public static void main(String[] args) {
		List<Pet> p = new ArrayList<Pet>();
		List<Dog> d = new ArrayList<Dog>();
		List<Cat> c = new ArrayList<Cat>();
		examine(p);
		examine(d);
		examine(c);
	}
	//Select all correct answers. for bek=low mwthod argument type.
	//List<? extends Pet>
	//List<? super Pet>
	//List<? extends Wagger>
	//List<? super Wagger>
	static void examine( List    pets){
		System.out.println("Your pets need urgent attention.");
	}

}
