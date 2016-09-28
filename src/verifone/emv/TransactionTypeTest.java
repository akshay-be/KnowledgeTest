package verifone.emv;

public class TransactionTypeTest {

	public static void main(String[] args) {
		
		String transactionTypes = "g000";
		
		try{
		if(transactionTypes!=null && transactionTypes.length()>2){
			
			String firstByte = Integer.toBinaryString(Integer.decode("0x" +transactionTypes.substring(0, 2)));
			while (firstByte.length() < 8) {
				firstByte = "0" + firstByte;
			}
			
			char[] array = firstByte.toCharArray();
			if(array[0]=='1'){
				System.out.println("Credit");
			}
			
			if(array[1]=='1'){
				System.out.println("Debit");
			}
			
			if(array[2]=='1'){
				System.out.println("EBT");
			}
			
			if(array[3]=='1'){
				System.out.println("Gift");
			}
			
			if(array[4]=='1'){
				System.out.println("Loayaty");
			}
			
			if(array[5]=='1'){
				System.out.println("StoreValue");
			}
		}
		}catch(NumberFormatException exception){
			
		}
	
		System.out.println("i am done..!");
	}
}
