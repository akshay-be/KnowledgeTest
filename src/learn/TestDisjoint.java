package learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestDisjoint {
	
	public static void main(String[] args) {
		List<String> fepNames = new ArrayList<String>();
		//fepNames.add("vaps");
		//fepNames.add("nbs");
		//fepNames.add("hps");
        
        List<String> excludesList = new ArrayList<String>();
       // excludesList.add("worldpay");
        //excludesList.add("paypoint");
       
       
        boolean isCommon = Collections.disjoint(fepNames,excludesList);
        System.out.println("Does not found any common elements? "+isCommon);
        
        excludesList.add("hps");
        isCommon = Collections.disjoint(fepNames,excludesList);
        System.out.println("Does not found any common elements? "+isCommon);

	}

}
