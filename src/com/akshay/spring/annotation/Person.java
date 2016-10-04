package com.akshay.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Value("Ranga")
	private String name;
	
	@Value("23")
	private int age;
	
	@Autowired
	private Address addre;

	public Person() {
		System.out.println(" Pearson No argument constructor...");
	}

	public Person(String name, int age) {
		System.out.println(" Pearson argument constructor...");
		this.name = name;
		this.age = age;
	}
	
	
	public void dance(){
		if(age<40){
			System.out.println("annamma dance");
		}else{
			System.out.println("standing dance");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(" Pearson setName method...");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println(" Pearson setAge method...");
	}

	@Override
	public String toString() {
		return "Pearson [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
