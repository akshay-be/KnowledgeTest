package learn.others;
public class ChitiCalculation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int amonunt = 10000;
		int baseAmunt = 10000;
		int numberOfInstalments = 17;
		
		System.out.println("1 : "+amonunt+" : 0");
		for(int i =2 ; i<=numberOfInstalments ; i++){
			int interset = (int) (amonunt*0.022);
			
			amonunt = baseAmunt+amonunt+interset;
			int soFarPaid = baseAmunt*i;
			System.out.println(i+" : "+soFarPaid+" : "+amonunt+" : "+interset);
		}

		System.out.println("Final : "+amonunt);
		System.out.println("to Pay : "+numberOfInstalments*baseAmunt);
	}

}
