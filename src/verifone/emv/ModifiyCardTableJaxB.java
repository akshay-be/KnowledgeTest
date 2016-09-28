package verifone.emv;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardRowType;
import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardTable;


public class ModifiyCardTableJaxB {

	static String stFileName = "D:\\EMV\\NTS\\modifyCardTable\\CardTable.xml";
	
	static String jaxbSchemaLocation = "com.verifone.isd.viper.eps.pres.messages.tables.cardTable";
	public static void main(String[] args) {
		
		System.out.println("Strt");
		Set<String> entryFlagSet = new TreeSet<String>();
		Set<String> cardtypeLableSet = new TreeSet<String>();
		Set<String> panLengthSet = new TreeSet<String>();
		Set<String> cardEnabledSet = new TreeSet<String>();
		
		Set<String>  cardHandlingRoutineIndicatorSet = new TreeSet<String>();
		
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(jaxbSchemaLocation);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();

			File file = new File(stFileName);
			Object obj = unMarshaller.unmarshal(file);
			if(obj instanceof CardTable){
				CardTable cardTable = (CardTable) obj;
				
				List<CardRowType> listCardRows = cardTable.getCardRow();
				
				int count = 0;
				for (CardRowType cardRowType : listCardRows) {
					System.out.println(""+cardRowType.getCTI());
					
					String cardtypeLable = cardRowType.getCardTypeLabel();
					cardtypeLableSet.add(cardtypeLable);
					String entryFlag  = cardRowType.getEntryFlag();
					
					
					
					
					if(entryFlag!=null && !entryFlag.equals("M") && 
							(cardtypeLable.trim().equalsIgnoreCase("AMEX") || cardtypeLable.trim().equalsIgnoreCase("DISCOVER") || 
									cardtypeLable.trim().equalsIgnoreCase("MARATHON VISA") || cardtypeLable.trim().equalsIgnoreCase("VISA") || cardtypeLable.trim().equalsIgnoreCase("VISA PUR") ||
									cardtypeLable.trim().equalsIgnoreCase("MC PURCH") || cardtypeLable.trim().equalsIgnoreCase("MASTERCARD")  )){
						
						//cardRowType.setCardTypeLabel(cardtypeLable.trim());
						
						//CardEnabled
						
						String PANLength = cardRowType.getPANLength().toString();
						count ++;
						entryFlagSet.add(entryFlag);
						panLengthSet.add(PANLength);
						cardHandlingRoutineIndicatorSet.add(cardRowType.getCardHandlingRoutineIndicator());
						cardEnabledSet.add(""+cardRowType.getCardEnabled());
						/*if (PANLength.equals("11")) {
							cardRowType.setCardHandlingRoutineIndicator("21");
						}else if (PANLength.equals("12")) {
							cardRowType.setCardHandlingRoutineIndicator("22");
						}else if (PANLength.equals("13")) {
							cardRowType.setCardHandlingRoutineIndicator("23");
						}else if (PANLength.equals("14")) {
							cardRowType.setCardHandlingRoutineIndicator("24");
						}else if (PANLength.equals("15")) {
							cardRowType.setCardHandlingRoutineIndicator("25");
						}else if (PANLength.equals("16")) {
							cardRowType.setCardHandlingRoutineIndicator("26");
						}else if (PANLength.equals("17")) {
							cardRowType.setCardHandlingRoutineIndicator("27");
						}else if (PANLength.equals("18")) {
							cardRowType.setCardHandlingRoutineIndicator("28");
						}else if (PANLength.equals("19")) {
							cardRowType.setCardHandlingRoutineIndicator("29");
						}else{
							System.out.println("Zombi PAN legth.");
						}*/
					}
				}
				System.out.println(" Cardtable "+count);
				System.out.println(" cardtypeLableSet "+cardtypeLableSet);
				System.out.println(" entryFlag "+entryFlagSet);
				System.out.println(" PAN Length "+panLengthSet);
				System.out.println(" CardHandlingRoutineIndicator  "+cardHandlingRoutineIndicatorSet);
				System.out.println(" cardEnabledSet  "+cardEnabledSet);
			}

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			marshaller.marshal(obj, file);
			 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("END");

	}

	
	
}
