package verifone.emv;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardRowType;
import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardTable;
import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.ObjectFactory;


public class CompleteCardTable {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		ObjectFactory objectFactory = new ObjectFactory();
		String stFileName = "D:\\EMV\\NTS\\modifyCardTable\\after58202\\CardTable.xml";
		String emvFileName = "D:\\EMV\\NTS\\modifyCardTable\\after58202\\CardTableEMV.xml";
		String jaxbSchemaLocation = "com.verifone.isd.viper.eps.pres.messages.tables.cardTable";
		
		
		ArrayList<CardRowType> amexChip = new ArrayList<CardRowType>();
		ArrayList<CardRowType> discoverChip = new ArrayList<CardRowType>();
		ArrayList<CardRowType> visaChip = new ArrayList<CardRowType>();
		ArrayList<CardRowType> masterChip = new ArrayList<CardRowType>();
		ArrayList<CardRowType> debitChip = new ArrayList<CardRowType>();
		
		ArrayList<CardRowType> amexFB = new ArrayList<CardRowType>();
		ArrayList<CardRowType> discoverFB = new ArrayList<CardRowType>();
		ArrayList<CardRowType> visaFB = new ArrayList<CardRowType>();
		ArrayList<CardRowType> masterFB = new ArrayList<CardRowType>();
		ArrayList<CardRowType> debitFB = new ArrayList<CardRowType>();
		
		 
		JAXBContext jaxbContext = JAXBContext.newInstance(jaxbSchemaLocation);
		 
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(stFileName)));
		CardTable cardTable = (CardTable) unmarshaller.unmarshal(bis);
		List<CardRowType> cardTableEntries = cardTable.getCardRow();
		System.out.println(cardTableEntries.size());
		int count =0;
		int numberOfEntries = 0;
		for (CardRowType cardRowType : cardTableEntries) {
			if(cardRowType.getEntryFlag().equalsIgnoreCase("M") || cardRowType.getEntryFlag().equalsIgnoreCase("SC") || cardRowType.getCardEnabled()!=2){
				continue;
			}
			/*if(cardRowType.getCardEnabled()!=2 || cardRowType.getCardEnabled()!=1){
				continue;
			}*/
			
			String cardTypeLabel = cardRowType.getCardTypeLabel().trim();
			//System.out.println(cardTypeLabel);
			if(cardTypeLabel!=null){
				CardRowType cardRowTypeSC = objectFactory.createCardRowType();
				
				if(cardRowType.getCTI().length()<=8){
					cardRowTypeSC.setCTI("IS"+cardRowType.getCTI());
				}else if(cardRowType.getCTI().length()==9){
					cardRowTypeSC.setCTI("I"+cardRowType.getCTI());
				}else{
					cardRowTypeSC.setCTI("ICCSC"+count++);
				}
				
				cardRowTypeSC.setCardType(cardRowType.getCardType());
				cardRowTypeSC.setEntryFlag("SC");	
				
				cardRowTypeSC.setReferralPhoneNumber(cardRowType.getReferralPhoneNumber());
				//cardRowTypeSC.setLogicIndicator("0000");
				cardRowTypeSC.setLogicIndicator("EMVT2SRVCCODEPAN"+cardRowType.getPANLength());
				cardRowTypeSC.setCardValidationPromptIDIndex("000");
				cardRowTypeSC.setCardCheckRoutineIndex(3);
				cardRowTypeSC.setCheckExpirationDate(0);
				cardRowTypeSC.setCardHandlingRoutineIndicator("00");
				cardRowTypeSC.setReceiptIndicator("ICCRECEIPT001");
				cardRowTypeSC.setDualUseIndicator("ICCACCOUNTTYPE");
				cardRowTypeSC.setExpirationDateFormat(0);
				cardRowTypeSC.setICCFlag(1);
				
				cardRowTypeSC.setLowPrefix(cardRowType.getLowPrefix());
				cardRowTypeSC.setHighPrefix(cardRowType.getHighPrefix());
				cardRowTypeSC.setPANLength(cardRowType.getPANLength());
				cardRowTypeSC.setCardEnabled(cardRowType.getCardEnabled());	
				
				if(cardRowType.getPromptIndicator().equals("0145")){
					cardRowTypeSC.setPromptIndicator("ICC0145");
				}else if(cardRowType.getPromptIndicator().equals("0146")){
					cardRowTypeSC.setPromptIndicator("ICC0146");
				}else if(cardRowType.getPromptIndicator().equals("0025")){
					cardRowTypeSC.setPromptIndicator("ICC0025");
				}else{
					cardRowTypeSC.setPromptIndicator(cardRowType.getPromptIndicator());
				}
					
				cardRowTypeSC.setProductTableIndex(cardRowType.getProductTableIndex());
				cardRowTypeSC.setProductRestrictionPromptIDIndex(cardRowType.getProductRestrictionPromptIDIndex());
				cardRowTypeSC.setFEPIndicator(cardRowType.getFEPIndicator());
				cardRowTypeSC.setCardTypeLabel(cardRowType.getCardTypeLabel().trim());
				cardRowTypeSC.setReportGroupName(cardRowType.getReportGroupName());
				cardRowTypeSC.setVelocityGroupIndex(cardRowType.getVelocityGroupIndex());
				cardRowTypeSC.setMaskingTableIndex(cardRowType.getMaskingTableIndex());
				cardRowTypeSC.setUsageFlag(cardRowType.getUsageFlag());
				cardRowTypeSC.setSendTrackI(cardRowType.getSendTrackI());
				cardRowTypeSC.setSendTrackII(cardRowType.getSendTrackII());
				cardRowTypeSC.setSendTrackIII(cardRowType.getSendTrackIII());
				cardRowTypeSC.setManualEntryPrefix(cardRowType.getManualEntryPrefix());
				cardRowTypeSC.setFeeIndicator(cardRowType.getFeeIndicator());
				cardRowTypeSC.setSplitTenderFlag(cardRowType.getSplitTenderFlag());
				cardRowTypeSC.setLoyaltyUsageFlag(cardRowType.getLoyaltyUsageFlag());
				cardRowTypeSC.setRefundAllowedFlag(cardRowType.getRefundAllowedFlag());
				cardRowTypeSC.setTrackMaskingIndicator(cardRowType.getTrackMaskingIndicator());
				cardRowTypeSC.setCardPreValidationIndicator("ISICCALLOWED");
				cardRowTypeSC.setCardValidationIndicator(cardRowType.getCardValidationIndicator());
				cardRowTypeSC.setPriceTier(cardRowType.getPriceTier());
				
				cardRowTypeSC.setDeclineReceiptIndicator("ICCRECEIPT002");
				
				
				
				CardRowType cardRowTypeFB = objectFactory.createCardRowType();
				cardRowTypeFB.setCTI("FB"+cardRowType.getCTI());
				
				if(cardRowType.getCTI().length()<=8){
					cardRowTypeFB.setCTI("FB"+cardRowType.getCTI());
				}else if(cardRowType.getCTI().length()==9){
					cardRowTypeFB.setCTI("F"+cardRowType.getCTI());
				}else{
					cardRowTypeFB.setCTI("ICCFB"+count++);
				}
				
				
				cardRowTypeFB.setCardType(cardRowType.getCardType());
				cardRowTypeFB.setReferralPhoneNumber(cardRowType.getReferralPhoneNumber());
				cardRowTypeFB.setLogicIndicator("EMVT2SRVCCODEPAN"+cardRowType.getPANLength());
				//cardRowTypeFB.setCardValidationPromptIDIndex("INSERTCARD");
				cardRowTypeFB.setCardValidationPromptIDIndex(cardRowType.getCardValidationPromptIDIndex());
				cardRowTypeFB.setCardCheckRoutineIndex(3);
				cardRowTypeFB.setCheckExpirationDate(cardRowType.getCheckExpirationDate());
				cardRowTypeFB.setCardHandlingRoutineIndicator("00");
				cardRowTypeFB.setReceiptIndicator(cardRowType.getReceiptIndicator());
				cardRowTypeFB.setDualUseIndicator(cardRowType.getDualUseIndicator());
				cardRowTypeFB.setExpirationDateFormat(cardRowType.getExpirationDateFormat());
				cardRowTypeFB.setEntryFlag("2");
				cardRowTypeFB.setCardPreValidationIndicator("ISICCENABLED");
				cardRowTypeFB.setICCFlag(1);
				cardRowTypeFB.setCardValidationPromptIndicator("INSERTCARDPI");
				
				
				cardRowTypeFB.setLowPrefix(cardRowType.getLowPrefix());
				cardRowTypeFB.setHighPrefix(cardRowType.getHighPrefix());
				cardRowTypeFB.setPANLength(cardRowType.getPANLength());
				cardRowTypeFB.setCardEnabled(cardRowType.getCardEnabled());
				cardRowTypeFB.setPromptIndicator(cardRowType.getPromptIndicator());
				cardRowTypeFB.setProductTableIndex(cardRowType.getProductTableIndex());
				cardRowTypeFB.setProductRestrictionPromptIDIndex(cardRowType.getProductRestrictionPromptIDIndex());
				cardRowTypeFB.setFEPIndicator(cardRowType.getFEPIndicator());
				cardRowTypeFB.setCardTypeLabel(cardRowType.getCardTypeLabel().trim());
				cardRowTypeFB.setReportGroupName(cardRowType.getReportGroupName());
				cardRowTypeFB.setVelocityGroupIndex(cardRowType.getVelocityGroupIndex());
				cardRowTypeFB.setMaskingTableIndex(cardRowType.getMaskingTableIndex());
				cardRowTypeFB.setUsageFlag(cardRowType.getUsageFlag());
				cardRowTypeFB.setSendTrackI(cardRowType.getSendTrackI());
				cardRowTypeFB.setSendTrackII(cardRowType.getSendTrackII());
				cardRowTypeFB.setSendTrackIII(cardRowType.getSendTrackIII());
				cardRowTypeFB.setManualEntryPrefix(cardRowType.getManualEntryPrefix());
				cardRowTypeFB.setFeeIndicator(cardRowType.getFeeIndicator());
				cardRowTypeFB.setSplitTenderFlag(cardRowType.getSplitTenderFlag());
				cardRowTypeFB.setLoyaltyUsageFlag(cardRowType.getLoyaltyUsageFlag());
				cardRowTypeFB.setRefundAllowedFlag(cardRowType.getRefundAllowedFlag());
				cardRowTypeFB.setTrackMaskingIndicator(cardRowType.getTrackMaskingIndicator());
				cardRowTypeFB.setCardValidationIndicator(cardRowType.getCardValidationIndicator());
				cardRowTypeFB.setPriceTier(cardRowType.getPriceTier());
				if(cardRowType.getDeclineReceiptIndicator()!=null){
					cardRowTypeFB.setDeclineReceiptIndicator("ICCRECEIPT002");
				}
				
				if(cardTypeLabel.trim().equalsIgnoreCase("AMEX")){
					cardRowTypeSC.setLimitTableIndex("91");
					cardRowTypeFB.setLimitTableIndex("95");
					amexChip.add(cardRowTypeSC);
					amexFB.add(cardRowTypeFB);
					numberOfEntries++;
				}else if(cardTypeLabel.trim().equalsIgnoreCase("DISCOVER")){
					cardRowTypeSC.setLimitTableIndex("92");
					cardRowTypeFB.setLimitTableIndex("96");
					discoverChip.add(cardRowTypeSC);
					discoverFB.add(cardRowTypeFB);
					numberOfEntries++;
				}else if(cardTypeLabel.trim().equalsIgnoreCase("MARATHON VISA") || cardTypeLabel.trim().equalsIgnoreCase("VISA") || cardTypeLabel.trim().equalsIgnoreCase("VISA PUR")){
					cardRowTypeSC.setLimitTableIndex("93");
					cardRowTypeFB.setLimitTableIndex("97");
					visaChip.add(cardRowTypeSC);
					visaFB.add(cardRowTypeFB);
					numberOfEntries++;
				}else if(cardTypeLabel.trim().equalsIgnoreCase("MC PURCH") || cardTypeLabel.trim().equalsIgnoreCase("MASTERCARD")){
					cardRowTypeSC.setLimitTableIndex("94");
					cardRowTypeFB.setLimitTableIndex("98");
					masterChip.add(cardRowTypeSC);
					masterFB.add(cardRowTypeFB);
					numberOfEntries++;
				}else if(cardTypeLabel.trim().equalsIgnoreCase("DEBIT")){
					cardRowTypeSC.setDeclineReceiptIndicator("ICCRECEIPT003");
					if(cardRowType.getDeclineReceiptIndicator()!=null){
						cardRowTypeFB.setDeclineReceiptIndicator("ICCRECEIPT003");
					}
					cardRowTypeSC.setLimitTableIndex("13");
					cardRowTypeFB.setLimitTableIndex("13");
					
					cardRowTypeSC.setReceiptIndicator("ICCRECEIPT004");
					debitChip.add(cardRowTypeSC);
					debitFB.add(cardRowTypeFB);
					numberOfEntries++;
				}
					
			}
		}
		 
		System.out.println("AMEX : "+amexChip.size());
		System.out.println("DISCOVER : "+discoverChip.size());
		System.out.println("VISA : "+visaChip.size());
		System.out.println("MASTERCARD : "+masterChip.size());
		System.out.println("DEBIT : "+debitChip.size());
		System.out.println("Count : "+count);
		
		 
		
		CardTable emvCardTable = objectFactory.createCardTable();
		List<CardRowType> listOfEMVEntries = emvCardTable.getCardRow();
		listOfEMVEntries.clear();
		
		listOfEMVEntries.addAll(amexChip);
		listOfEMVEntries.addAll(discoverChip);
		listOfEMVEntries.addAll(visaChip);
		listOfEMVEntries.addAll(masterChip);
		listOfEMVEntries.addAll(debitChip);
		
		listOfEMVEntries.addAll(amexFB);
		listOfEMVEntries.addAll(discoverFB);
		listOfEMVEntries.addAll(visaFB);
		listOfEMVEntries.addAll(masterFB);
		listOfEMVEntries.addAll(debitFB);
		 
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		File file = new File(emvFileName);
		marshaller.marshal(emvCardTable, file);
		System.out.println("numberOfEntries added : "+numberOfEntries);
		System.out.println("I am done! Count  : "+listOfEMVEntries.size());
	}

}
