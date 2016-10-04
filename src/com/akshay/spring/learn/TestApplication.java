package com.akshay.spring.learn;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Staring application");
		
		System.out.println("staring spring container");
		ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext("Spring.xml");
		System.out.println("xml loaded");
		
		Performer p1 = (Performer) ctx.getBean("p1");
		p1.perform();
		
		Performer beemu = (Performer) ctx.getBean("beemu");
		beemu.perform();
		
		Performer mamu = (Performer) ctx.getBean("mamu");
		mamu.perform();
		
		
		
		Performer i1 = (Performer) ctx.getBean("i1");
		i1.perform();
		
		Performer i2 = (Performer) ctx.getBean("i2");
		i2.perform();
		
		Performer i3 = (Performer) ctx.getBean("i3");
		i3.perform();
		
		
		Performer i4 = (Performer) ctx.getBean("i4");
		i4.perform();
		
		Performer i5 = (Performer) ctx.getBean("i5");
		i5.perform();
		
		Performer i6 = (Performer) ctx.getBean("i6");
		i6.perform();
		
		
		Ticket t1 = (Ticket) ctx.getBean("ticket");
		Ticket t2 = (Ticket) ctx.getBean("ticket");
		
		System.out.println("t1 = "+t1);
		System.out.println("t2 = "+t2);
		System.out.println("t1==t2 ? "+(t1==t2));
		
		
		Ticket t3 = (Ticket) ctx.getBean("ticket1");
		Ticket t4 = (Ticket) ctx.getBean("ticket1");
		
		System.out.println("t3 = "+t3);
		System.out.println("t4 = "+t4);
		System.out.println("t3==t4 ? "+(t3==t4));
		
		ctx.close();
		System.out.println("Finished application");
	}

}
