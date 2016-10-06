package com.akshay.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("staring spring container");
		ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext("SpringAnnotation.xml");
		System.out.println("xml loaded");
		
		Person person = (Person) ctx.getBean("person");
		System.out.println("Person : "+person);
 
	}

}
