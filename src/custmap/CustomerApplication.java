package custmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 
 * @author Chaitra
 *
 */
public class CustomerApplication {
	private HashMap<Integer, Customer> custMap = null;
	
	public void init(){
		custMap =  new HashMap<Integer, Customer>();
	}
	
	public static void main(String[] args) throws CustomerAlreadyExistException, CustomerDoesNotExistException {
		CustomerApplication custApp = new CustomerApplication();
		custApp.init();
		
		Customer cust1 = new Customer(1, "chaitra", "chai@gmail.com");
		Customer cust2 = new Customer(2,"aaa", "aa@gmail.com");
		Customer cust3 = new Customer(3, "bbb", "bb@gmail.com");
		
		custApp.addCustomer(cust1);
		custApp.addCustomer(cust2);
		custApp.addCustomer(cust3);
		
		Collection<Customer> custList = custApp.getCustometList();
		System.out.println("custList -->"+custList);
		
		Customer customer = custApp.getCustomer(1);
		System.out.println("\nRequested customer details >>>  id: "+ customer.getId() +"    email : "+ customer.getEmail() +"     name: "+ customer.getName());
		
		custApp.deleteCustomer(1);
		System.out.println("\n********** customers list after deletion ******* \n"+custApp.getCustometList());
		
		custApp.getCustomer(1);
	}
	


	private Collection<Customer> getCustometList() throws CustomerDoesNotExistException {
		 Collection<Customer> custList = custMap.values();
		 if(custList.isEmpty()){
			 throw new CustomerDoesNotExistException("No customers");
		 }
		
		 return custList;
	}

	private void deleteCustomer(int id) throws CustomerDoesNotExistException {
		Customer c = custMap.get(id);
		if(c == null){
			throw new CustomerDoesNotExistException("Customer do not exist");
		}

		Iterator<Entry<Integer, Customer>> iter = custMap.entrySet().iterator();
		while(iter.hasNext()){
			Entry<Integer, Customer> entry = iter.next();
			if(entry.getKey() == id){
				iter.remove();
			}

		}
	}



	private void addCustomer(Customer cust) throws CustomerAlreadyExistException {
		if(custMap.get(cust.getId()) != null){
			throw new CustomerAlreadyExistException("Customer already exist for the ID : "+cust.getId());
		}
		custMap.put(cust.getId(), cust);
		
	}
	
	private Customer getCustomer(Integer id) throws CustomerDoesNotExistException{
		if(custMap.get(id) ==null){
			throw new CustomerDoesNotExistException("Customer do not exist for the given ID: "+ id);
		}
			
		return custMap.get(id);
		
	}
	
	
	class CustomerAlreadyExistException extends Exception{
		public CustomerAlreadyExistException(String message) {
			super(message);
		}
		
	}
	
	class CustomerDoesNotExistException extends Exception{
		public CustomerDoesNotExistException(String message) {
			super(message);
		}
		
	}

}
