package hackerrank.test1;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student implements Comparable<Student> , Comparator<Student> {
    private int token;
    private String fname;
    private double cgpa;
    public Student() { 
        super();
        this.token = -1;
        this.fname = null;
        this.cgpa = -1;
    }
    public Student(String fname, double cgpa, int token) {
        super();
        this.token = token;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    
    public int getToken()    { return token; }
    public String getFname() { return fname; }
    public double getCgpa()  { return cgpa;  }
    
    public int compareTo(Student student2) {
        if(this.getCgpa() > student2.getCgpa()) return -1; // before
        else if(this.getCgpa() < student2.getCgpa()) return 1; // after
        else { // gpa draw
            if(!this.getFname().equals(this.getFname() ) ) // diff names
                return this.getFname().compareTo(student2.getFname() );
            else { // same names
            	return this.getToken() - student2.getToken();
            }   
        }
    }
	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getCgpa() < student2.getCgpa()) return 1;
        else if (student1.getCgpa() > student2.getCgpa()) return -1;
        else {
            if (!student1.getFname().equals(student2.getFname()))
            return student1.getFname().compareTo(student2.getFname());
            else return student1.getToken() - student2.getToken();
        }
    
	}
}

public class JavaPriorityQueue {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int totalEvents = Integer.parseInt(in.nextLine());
	        Student stud = new Student();
	        PriorityQueue<Student> priorQueue =  new PriorityQueue<Student>();
	        
	        while(totalEvents>0) {
	            String event = in.next();
	            if(event.equals("ENTER")) { // read Name, cgpa and token
	                stud = new Student(in.next(),in.nextDouble(),in.nextInt());
	                priorQueue.add(stud);
	            } 
	            else if (event.equals("SERVED") ) {
	                if(priorQueue.size() > 0) {
	                    priorQueue.poll();
	                }
	            }
	            totalEvents--;
	        }
	        
	        if(priorQueue.size() == 0) 
	            System.out.println("EMPTY");
	        else {
	            while(priorQueue.size() > 0) {
	                stud = priorQueue.poll();
	                System.out.println(stud.getFname());
	            }
	         }
	    }
}
