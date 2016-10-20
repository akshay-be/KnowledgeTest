package learn.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Student /*implements  Comparable*/ {
	
	String name = null;
	int marks = 0;
	
	public Student() {
		name = "default";
		marks =0;
	}
	public Student(String name, int marks){
		this.name = name;
		this.marks = marks;
	}

	@Override
	public int hashCode() {
		System.out.println("HashCode : "+name);
		final int prime = 31;
		int result = 1;
		result = prime * result + marks;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("inside equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (marks != other.marks)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set s2 = new HashSet();
		s2.add(new Student());
		s2.add(new Student());
		s2.add(new Student());
		s2.add(new Student());
		System.out.println(""+s2.size());
		
		Set s3 = new HashSet();
		s3.add("aks");
		s3.add("aks");
		s3.add("aks");
		s3.add("aks");
		s3.add("aks1");
		System.out.println(""+s3.size());
		
		
		List s4 = new ArrayList();
		s4.add(new Student("",3));
		s4.add(new Student("",4));
		s4.add(new Student("",5));
		s4.add(new Student("",6));
		System.out.println(""+s4.size());

		Collections.sort(s4);
	}
	/*@Override
	public int compareTo(Object arg0) {
		System.out.println("Hi");
		return 0;
	}*/

}
