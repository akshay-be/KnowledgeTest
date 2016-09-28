package verifone.emv;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardRowType;
import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardTable;
import com.verifone.isd.viper.eps.pres.messages.tables.logicIndicatorTable.LogicIndicatorRowType;
import com.verifone.isd.viper.eps.pres.messages.tables.logicIndicatorTable.LogicIndicatorTable;


public class LogicIndicatorCreater {
	static Set<String> combLogic = new HashSet<String>();

	public static void main(String[] args) throws JAXBException, IOException {

		loadCardTable();

		String inputLogicFileName = "D:\\EMV\\NTS\\CardTableDevelpment\\LCT\\LogicIndicatorTable.xml";
		String outputLogicFileName = "D:\\EMV\\NTS\\CardTableDevelpment\\LCT\\LogicIndicatorTableNew.xml";
		String jaxbSchemaLocation = "com.verifone.isd.viper.eps.pres.messages.tables.logicIndicatorTable";

		JAXBContext jaxbContext = JAXBContext.newInstance(jaxbSchemaLocation);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		BufferedInputStream inputLogicBuf = new BufferedInputStream(new FileInputStream(new File(inputLogicFileName)));
		LogicIndicatorTable inputlogicTable = (LogicIndicatorTable) unmarshaller.unmarshal(inputLogicBuf);
		List<LogicIndicatorRowType> logicIndicatorentries = inputlogicTable.getLogicIndicatorRow();
		System.out.println("Logic table entry size :"+logicIndicatorentries.size());

//		BufferedInputStream outputLogicBuf = new BufferedInputStream(new FileInputStream(new File(outputLogicFileName)));
//		LogicIndicatorTable outputLogic = (LogicIndicatorTable) unmarshaller.unmarshal(outputLogicBuf);
//		List<LogicIndicatorRowType> finalEntries = outputLogic.getLogicIndicatorRow();
//		finalEntries.clear();
//		System.out.println("Clearing the size:"+finalEntries.size());
		
		List<LogicIndicatorRowType> finalEntries = new ArrayList<LogicIndicatorRowType>();

		com.verifone.isd.viper.eps.pres.messages.tables.logicIndicatorTable.ObjectFactory obLC = new com.verifone.isd.viper.eps.pres.messages.tables.logicIndicatorTable.ObjectFactory();
		
		
		for(String newlogic: combLogic){
			String logic = newlogic.substring(0, 4);
			String pan = newlogic.substring(7,9);
			String track = newlogic.substring(10);
			String EMVlogic = null;
			if(track.equals("1")){
				EMVlogic = "EMVT1SERVICECODE";
			}else{
				EMVlogic = "EMVT2SRVCCODEPAN"+pan;
			}
			
			
			LogicIndicatorRowType logicEntry = getLogicEntry(logic , logicIndicatorentries);
			LogicIndicatorRowType EmvlogicEntry = getLogicEntry(EMVlogic , logicIndicatorentries);
			if(logicEntry == null || EmvlogicEntry == null){
				System.out.println("Not able to create entry for : "+newlogic);
			}else{
				System.out.println("able to create entry for : ");
				LogicIndicatorRowType newrow = obLC.createLogicIndicatorRowType();
				newrow.setLogicIndicator(newlogic);
				List<LogicIndicatorRowType.LogicControlList> newList = new ArrayList<LogicIndicatorRowType.LogicControlList>();
				Iterator<LogicIndicatorRowType.LogicControlList> listcontrollist = logicEntry.getLogicControlList().iterator();
				while(listcontrollist.hasNext()){
					LogicIndicatorRowType.LogicControlList list = listcontrollist.next();
					newList.add(list);
				}
				newList.add(EmvlogicEntry.getLogicControlList().get(0));
				newrow.getLogicControlList().addAll(newList);
				finalEntries.add(newrow);
			}
		}
		System.out.println("finalentyes  : "+finalEntries.size());
		
		logicIndicatorentries.clear();
		logicIndicatorentries.addAll(finalEntries);
		JAXBContext jaxbContext1 = JAXBContext.newInstance(jaxbSchemaLocation);
		Marshaller marshaller = jaxbContext1.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		File file = new File(outputLogicFileName);
	
		marshaller.marshal(inputlogicTable, file);
		System.out.println("I am done! Count  : "+finalEntries.size());
	}

	
	private static LogicIndicatorRowType getLogicEntry(String logic,
			List<LogicIndicatorRowType> logicIndicatorentries) {
	
		Iterator<LogicIndicatorRowType> itr = logicIndicatorentries.iterator();
		LogicIndicatorRowType result = null;
		while(itr.hasNext()){
			LogicIndicatorRowType row = itr.next();
			String index = row.getLogicIndicator();
			if(index.equals(logic)){
				result = row;
				break;
			}
		}
		
		return result;
	}


	private static void loadCardTable() throws JAXBException, IOException{

		String stFileName = "D:\\EMV\\NTS\\CardTableDevelpment\\LCT\\CardTable.xml";
		String jaxbSchemaLocation = "com.verifone.isd.viper.eps.pres.messages.tables.cardTable";
		JAXBContext jaxbContext = JAXBContext.newInstance(jaxbSchemaLocation);

		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(stFileName)));
		CardTable cardTable = (CardTable) unmarshaller.unmarshal(bis);
		List<CardRowType> cardTableEntries = cardTable.getCardRow();

		System.out.println("aa Total Entry size "+cardTableEntries.size());
		int m = 0;
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		for(Iterator i = cardTableEntries.iterator(); i.hasNext();){
			CardRowType row = (CardRowType)i.next();

			String cardtype = row.getCardType();
			String cti = row.getCTI();
			Integer iccenable = row.getICCFlag();
			String entryflag = row.getEntryFlag();
			String logic = row.getLogicIndicator();
			String pan = row.getPANLength().toString();

			if( ("AE".equals(cardtype)|| "MC".equals(cardtype) || "MV".equals(cardtype)||"VI".equals(cardtype)
					||"DS".equals(cardtype)||"DB".equals(cardtype)||"MP".equals(cardtype)||"VP".equals(cardtype))
					&&(!"M".equals(entryflag)) && !entryflag.equals("SC") && !cti.trim().startsWith("FB")){

				if(!"0000".equals(logic)){
					System.out.println(" "+cti);
					combLogic.add(logic+"EMV"+pan+"T"+entryflag);
					m++;
				}
			}

		}
		bis.close();

		System.out.println("Logic indicators: "+ Arrays.toString(combLogic.toArray()));
		System.out.println("Size uniqueue Logic : " +combLogic.size());
//		System.out.println("Ctis :"+Arrays.toString(list.toArray()));
//		System.out.println("Size uniqueue Ctis : " +list.size());
		System.out.println("Added etries:  "+m);

	}

}
