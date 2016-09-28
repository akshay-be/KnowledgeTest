package verifone.emv;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardRowType;
import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardTable;


public class FindLimitTableIndex {

	
static String stFileName = "D:\\githome\\Working_Branch\\petroApps\\viper\\data\\custom\\nts\\data\\tables\\CardTable.xml";
	
	static String jaxbSchemaLocation = "com.verifone.isd.viper.eps.pres.messages.tables.cardTable";
	public static void main(String[] args) {
		
		System.out.println("Strt");
		Map<String,String> limitsMap = new HashMap<String, String>();
		
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(jaxbSchemaLocation);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();

			File file = new File(stFileName);
			Object obj = unMarshaller.unmarshal(file);
			if(obj instanceof CardTable){
				CardTable cardTable = (CardTable) obj;
				
				List<CardRowType> listCardRows = cardTable.getCardRow();
				int i=0;
				for (CardRowType cardRowType : listCardRows) {
					//System.out.println(""+cardRowType.getCTI());
					
					String entryFlag  = cardRowType.getEntryFlag();
					Integer iccFlag = cardRowType.getICCFlag();
					
					if(iccFlag!=null && iccFlag==1){
						continue;
					}
					
					
					if(entryFlag!=null && !entryFlag.equals("SC")){
						String cardType = cardRowType.getCardType().trim();
						if(cardType.equals("AE")){
							if(!limitsMap.containsValue(cardRowType.getLimitTableIndex().trim())){
								i++;
								limitsMap.put(cardType+i, cardRowType.getLimitTableIndex().trim());
							}
						}
						
					}
				}
				
			}
			System.out.println(""+limitsMap);

			 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("END");

	}

}
