import java.util.Date;


final public class Customer {

	 private String  name;
  	private String age;
	 private String email;
	 private Date d1;
	
	

	   public String getName() {
		return name;
	}




	public String getAge() {
		return age;
	}




	public String getEmail() {
		return email;
	}




	public Date getD1() {
		
		return (Date)d1.clone();
	}




	public Customer updateemail(String email)
	   {
		  
		   Customer c=new Customer();
		   c.age=this.age;
		   c.name=this.name;
		   c.email=email;
		   c.d1=this.d1;
		   
		   
		   
		     return c;
		   
	   }
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Customer c1 = new Customer();
		Date d = c1.getD1();
		
		//
		d.setHours(152);

	}

}
