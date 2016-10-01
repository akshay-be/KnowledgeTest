package interview.morgan.stanely;

public class Question26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Question26 q26 = new Question26();
		
		TestA x = new TestA("a","aa");
		TestA y = new TestA("a","aa");
		System.out.println(" 1st "+q26.function(x, y));
		
		TestA x1 = new TestA("a","aa");
		TestA y1 = new TestA("b","bb");
		System.out.println(" 2nd "+q26.function(x1, y1));
		
		TestA x2 = new TestA("a","aa");
		TestA y2 = x2;
		System.out.println(" 3rd "+q26.function(x2, y2));
		
		
	}

	String function(TestA x, TestA y){
		return (x==y)+" "+x.equals(y)+" "+(x.hashCode()==y.hashCode());
	}
}


class TestA{
	String name;
	String email;
	
	public TestA(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		TestA other = (TestA) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
