package learn;
public class CountCharacter {

	private int chartecterCount=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountCharacter ch = new CountCharacter();
		int count = ch.charcterCount("AKSaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaihhasfndslnfalidfiaf" +
				"iladshfuadhfuadhnfjkadnfuadhfoaidfandjfnbahsdbadfjfsijfai" +
				"hsfisdjfljdahnfauhfadhfadfjadfjadfaaaaaaaaaaaaaaHAY");
		System.out.println("Count : "+count);
	}

	public int charcterCount(String str){
		System.out.println(" String : "+str);
		if(str.length()==0)
			return 0;
		else if(str.charAt(0)=='A' || str.charAt(0)=='a'){
			System.out.println(" chart at : "+str.charAt(0));
			chartecterCount++;
		}
		charcterCount(str.substring(1));
		return chartecterCount;
	}
}
