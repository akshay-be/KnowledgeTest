package verifone.emv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import verifone.CardBean;

import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardRowType;
import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardTable;
import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.ObjectFactory;
import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.PriceTierType;


public class BuildCardTable {
	
	static String stFileName = "D:\\EMV\\NTS\\trackData\\CardTable.xml";
	static String jaxbSchemaLocation = "com.verifone.isd.viper.eps.pres.messages.tables.cardTable";

	public static void main(String[] args) {
		File file = new File("D:\\EMV\\NTS\\trackData\\TrackDetails.txt");
		BufferedReader br=null;
		ArrayList<CardBean> amex = new ArrayList<CardBean>();
		ArrayList<CardBean> discover = new ArrayList<CardBean>();
		ArrayList<CardBean> visa = new ArrayList<CardBean>();
		ArrayList<CardBean> master = new ArrayList<CardBean>();
		ArrayList<CardBean> debit = new ArrayList<CardBean>();
		
		ArrayList<String> amexPAN = new ArrayList<String>();
		ArrayList<String> discoverPAN = new ArrayList<String>();
		ArrayList<String> visaPAN = new ArrayList<String>();
		ArrayList<String> masterPAN = new ArrayList<String>();
		ArrayList<String> debitPAN = new ArrayList<String>();
		
		try {
			br = new BufferedReader(new FileReader(file.getPath()));
			String line =null;
			
			while ((line=br.readLine()) != null) {
				System.out.println(""+line);
				String[] arrElemetns = line.split(";");
				String lable = arrElemetns[0];
				String aid = arrElemetns[2];
				String pan = arrElemetns[3];
				String length = arrElemetns[4];
				
				if(lable!=null && (lable.contains("Debit") || lable.contains("DEBIT")) && !debitPAN.contains(pan.trim())){
					debitPAN.add(pan.trim());
					CardBean cb = new CardBean(lable.trim(),aid,pan.trim(), Integer.parseInt(length.trim()));
					debit.add(cb);
				}
				
				//Amex
				if(aid!=null && aid.trim().startsWith("A000000025") && !amexPAN.contains(pan.trim())){
					amexPAN.add(pan.trim());
					CardBean cb = new CardBean(lable.trim(),aid,pan.trim(), Integer.parseInt(length.trim()));
					amex.add(cb);
				}
				
				//Discover
				if(aid!=null && aid.trim().startsWith("A000000333") && !discoverPAN.contains(pan.trim())){
					discoverPAN.add(pan.trim());
					CardBean cb = new CardBean(lable.trim(),aid,pan.trim(), Integer.parseInt(length.trim()));
					discover.add(cb);
				}
				
				
				//Diners
				if(aid!=null && aid.trim().startsWith("A0000001523010") && !discoverPAN.contains(pan.trim())){
					discoverPAN.add(pan.trim());
					CardBean cb = new CardBean(lable.trim(),aid,pan.trim(), Integer.parseInt(length.trim()));
					discover.add(cb);
				}
				
				//Master
				if(aid!=null && aid.trim().startsWith("A000000004") && !masterPAN.contains(pan.trim())){
					masterPAN.add(pan.trim());
					CardBean cb = new CardBean(lable.trim(),aid,pan.trim(), Integer.parseInt(length.trim()));
					master.add(cb);
				}
				if(aid!=null && aid.trim().startsWith("B0123456781") && !masterPAN.contains(pan.trim())){
					masterPAN.add(pan.trim());
					CardBean cb = new CardBean(lable.trim(),aid,pan.trim(), Integer.parseInt(length.trim()));
					master.add(cb);
				}
				
				
				//VISA
				if(aid!=null && aid.trim().startsWith("A000000003") && !visaPAN.contains(pan.trim())){
					visaPAN.add(pan.trim());
					CardBean cb = new CardBean(lable.trim(),aid,pan.trim(), Integer.parseInt(length.trim()));
					visa.add(cb);
				}
				
				
			}
			
			System.out.println("Debit  : "+debitPAN);
			System.out.println("Amex : "+amexPAN);
			System.out.println("discover : "+discoverPAN);
			System.out.println("master : "+masterPAN);
			System.out.println("visa : "+visaPAN);
			
			br.close();
						
			Collections.sort(debit, new Comparator<CardBean>() {
				@Override
				public int compare(CardBean bean1, CardBean bean2) {
					Integer length1 =bean1.getLength();
					Integer length2=bean2.getLength();
						return length1.compareTo(length2);
				}});
			
			Collections.sort(amex, new Comparator<CardBean>() {
				@Override
				public int compare(CardBean bean1, CardBean bean2) {
					Integer length1 =bean1.getLength();
					Integer length2=bean2.getLength();
						return length1.compareTo(length2);
				}});
			
			Collections.sort(discover, new Comparator<CardBean>() {
				@Override
				public int compare(CardBean bean1, CardBean bean2) {
					Integer length1 =bean1.getLength();
					Integer length2=bean2.getLength();
						return length1.compareTo(length2);
				}});
			
			Collections.sort(master, new Comparator<CardBean>() {
				@Override
				public int compare(CardBean bean1, CardBean bean2) {
					Integer length1 =bean1.getLength();
					Integer length2=bean2.getLength();
						return length1.compareTo(length2);
				}});
			
			Collections.sort(visa, new Comparator<CardBean>() {
				@Override
				public int compare(CardBean bean1, CardBean bean2) {
					Integer length1 =bean1.getLength();
					Integer length2=bean2.getLength();
						return length1.compareTo(length2);
				}});
			
			
			JAXBContext jaxbContext = JAXBContext.newInstance(jaxbSchemaLocation);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();

			File file1 = new File(stFileName);
			Object obj = unMarshaller.unmarshal(file1);
			if(obj instanceof CardTable){
				CardTable cardTable = (CardTable) obj;
				List<CardRowType> listCardRows = cardTable.getCardRow();
				listCardRows.clear();
			
			
			
			ObjectFactory objectFactory = new ObjectFactory();
			
			amex.addAll(visa);
			amex.addAll(discover);
			amex.addAll(master);
			int rownum = 0;
			for(CardBean bean : amex){
				
				//A0000001523010
				CardRowType cardRowType = objectFactory.createCardRowType();
				
				if(bean.getAID().trim().startsWith("A000000025")){
					cardRowType.setCTI("Amex"+bean.getLength()+"ICCSC"+rownum);
					cardRowType.setCardType("AE");
					cardRowType.setLimitTableIndex("91");
					cardRowType.setReferralPhoneNumber("1-800-528-2121");
				}else if(bean.getAID().trim().startsWith("A000000003")){
					cardRowType.setCTI("Visa"+bean.getLength()+"ICCSC"+rownum);
					cardRowType.setCardType("VI");
					cardRowType.setLimitTableIndex("93");
					cardRowType.setReferralPhoneNumber("1-800-622-3858");
				}else if(bean.getAID().trim().startsWith("A000000333")){
					cardRowType.setCTI("Discover"+bean.getLength()+"ICCSC"+rownum);
					cardRowType.setCardType("DS");
					cardRowType.setLimitTableIndex("92");
					cardRowType.setReferralPhoneNumber("1-800-347-1111");
				}else if(bean.getAID().trim().startsWith("A000000004") || bean.getAID().trim().startsWith("B0123456781")){
					cardRowType.setCTI("Master"+bean.getLength()+"ICCSC"+rownum);
					cardRowType.setCardType("MC");
					cardRowType.setLimitTableIndex("94");
					cardRowType.setReferralPhoneNumber("1-800-622-3858");
				}else if(bean.getAID().trim().startsWith("A0000001523010")){
					cardRowType.setCTI("Diners"+bean.getLength()+"ICCSC"+rownum);
					cardRowType.setCardType("DS");
					cardRowType.setLimitTableIndex("92");
					cardRowType.setReferralPhoneNumber("1-800-347-1111");
				}
				
				
				cardRowType.setLowPrefix(bean.getApplicationPAN());
				cardRowType.setHighPrefix(bean.getApplicationPAN());
				cardRowType.setPANLength(new BigInteger(""+bean.getLength()));
				cardRowType.setCardEnabled(2);
				cardRowType.setEntryFlag("SC");	
				cardRowType.setLogicIndicator("0000");
				cardRowType.setCardValidationPromptIDIndex("000");
				cardRowType.setCardCheckRoutineIndex(3);
				cardRowType.setCheckExpirationDate(0);
				cardRowType.setPromptIndicator("0000");
				cardRowType.setCardHandlingRoutineIndicator("00");
				cardRowType.setProductTableIndex("01");
				cardRowType.setProductRestrictionPromptIDIndex("000");
				cardRowType.setFEPIndicator("01");
				cardRowType.setCardTypeLabel(bean.getApplicationLable());
				cardRowType.setReportGroupName("UseCardTypeLabel");
				cardRowType.setVelocityGroupIndex("01");
				cardRowType.setMaskingTableIndex("01");
				cardRowType.setReceiptIndicator("ICCRECEIPT001");
				cardRowType.setUsageFlag(new BigInteger("0"));
				cardRowType.setDualUseIndicator("ICCCREDITDEBIT");
				cardRowType.setExpirationDateFormat(0);
				cardRowType.setSendTrackI(1);
				cardRowType.setSendTrackII(2);
				cardRowType.setSendTrackIII(0);
				cardRowType.setManualEntryPrefix("0");
				cardRowType.setFeeIndicator(new BigInteger("0"));
				cardRowType.setSplitTenderFlag(1);
				cardRowType.setLoyaltyUsageFlag(0);
				cardRowType.setRefundAllowedFlag(1);
				cardRowType.setTrackMaskingIndicator("0045");
				cardRowType.setCardPreValidationIndicator("000");
				cardRowType.setCardValidationIndicator("000");
				cardRowType.setPriceTier(PriceTierType.CREDIT);
				cardRowType.setICCFlag(1);
				
				listCardRows.add(cardRowType);
				rownum++;
			}
			
			
			
			
			for(CardBean bean : amex){
				//int rownum = 0;
				CardRowType cardRowType = objectFactory.createCardRowType();
				
				if(bean.getAID().trim().startsWith("A000000025")){
					cardRowType.setCTI("Amex"+bean.getLength()+"ICCFB"+rownum);
					cardRowType.setCardType("AE");
					cardRowType.setLimitTableIndex("95");
					cardRowType.setReferralPhoneNumber("1-800-528-2121");
				}else if(bean.getAID().trim().startsWith("A000000003")){
					cardRowType.setCTI("Visa"+bean.getLength()+"ICCFB"+rownum);
					cardRowType.setCardType("VI");
					cardRowType.setLimitTableIndex("97");
					cardRowType.setReferralPhoneNumber("1-800-622-3858");
				}else if(bean.getAID().trim().startsWith("A000000333")){
					cardRowType.setCTI("Discover"+bean.getLength()+"ICCFB"+rownum);
					cardRowType.setCardType("DS");
					cardRowType.setLimitTableIndex("96");
					cardRowType.setReferralPhoneNumber("1-800-347-1111");
				}else if(bean.getAID().trim().startsWith("A000000004") || bean.getAID().trim().startsWith("B0123456781") ){
					cardRowType.setCTI("Master"+bean.getLength()+"ICCFB"+rownum);
					cardRowType.setCardType("MC");
					cardRowType.setLimitTableIndex("98");
					cardRowType.setReferralPhoneNumber("1-800-622-3858");
				}else if(bean.getAID().trim().startsWith("A0000001523010")){
					cardRowType.setCTI("Diners"+bean.getLength()+"ICCFB"+rownum);
					cardRowType.setCardType("DS");
					cardRowType.setLimitTableIndex("96");
					cardRowType.setReferralPhoneNumber("1-800-347-1111");
				}
				
				//cardRowType.setCTI("Visa"+bean.getLength()+"ICCFB"+rownum);
				cardRowType.setLowPrefix(bean.getApplicationPAN());
				cardRowType.setHighPrefix(bean.getApplicationPAN());
				cardRowType.setPANLength(new BigInteger(""+bean.getLength()));
				cardRowType.setCardEnabled(2);
				cardRowType.setEntryFlag("2");	
				cardRowType.setLogicIndicator("EMVT2SRVCCODEPAN"+bean.getLength());
				cardRowType.setCardValidationPromptIDIndex("INSERTCARD");
				cardRowType.setCardCheckRoutineIndex(3);
				cardRowType.setCheckExpirationDate(0);
				cardRowType.setPromptIndicator("0000");
				cardRowType.setCardHandlingRoutineIndicator("00");
				cardRowType.setProductTableIndex("01");
				cardRowType.setProductRestrictionPromptIDIndex("000");
				cardRowType.setFEPIndicator("01");
				cardRowType.setCardTypeLabel(bean.getApplicationLable());
				cardRowType.setReportGroupName("UseCardTypeLabel");
				cardRowType.setVelocityGroupIndex("01");
				cardRowType.setMaskingTableIndex("01");
				//cardRowType.setLimitTableIndex("91");
				cardRowType.setReceiptIndicator("ICCRECEIPT001");
				cardRowType.setUsageFlag(new BigInteger("0"));
				cardRowType.setDualUseIndicator("ICCCREDITDEBIT");
				//cardRowType.setCardType("VI");
				cardRowType.setExpirationDateFormat(0);
				cardRowType.setSendTrackI(1);
				cardRowType.setSendTrackII(2);
				cardRowType.setSendTrackIII(0);
				cardRowType.setManualEntryPrefix("0");
				cardRowType.setFeeIndicator(new BigInteger("0"));
				cardRowType.setSplitTenderFlag(1);
				cardRowType.setLoyaltyUsageFlag(0);
				cardRowType.setRefundAllowedFlag(1);
				cardRowType.setTrackMaskingIndicator("0045");
				cardRowType.setCardPreValidationIndicator("ISICCENABLED");
				cardRowType.setCardValidationIndicator("000");
				cardRowType.setPriceTier(PriceTierType.CREDIT);
				cardRowType.setICCFlag(1);
				
				listCardRows.add(cardRowType);
				rownum++;
			}
			
			
			
			for(CardBean bean : debit){
				//int rownum = 0;
				CardRowType cardRowType = objectFactory.createCardRowType();
				

				cardRowType.setCTI("Debit"+bean.getLength()+"ICCSC"+rownum);
				cardRowType.setCardType("DB");
				cardRowType.setLimitTableIndex("13");
				cardRowType.setLowPrefix(bean.getApplicationPAN());
				cardRowType.setHighPrefix(bean.getApplicationPAN());
				cardRowType.setPANLength(new BigInteger(""+bean.getLength()));
				cardRowType.setCardEnabled(2);
				cardRowType.setEntryFlag("SC");	
				cardRowType.setLogicIndicator("0000");
				cardRowType.setCardValidationPromptIDIndex("000");
				cardRowType.setCardCheckRoutineIndex(0);
				cardRowType.setCheckExpirationDate(0);
				cardRowType.setPromptIndicator("0000");
				cardRowType.setCardHandlingRoutineIndicator("00");
				cardRowType.setProductTableIndex("09");
				cardRowType.setProductRestrictionPromptIDIndex("000");
				cardRowType.setFEPIndicator("01");
				cardRowType.setCardTypeLabel(bean.getApplicationLable());
				cardRowType.setReportGroupName("UseCardTypeLabel");
				cardRowType.setVelocityGroupIndex("01");
				cardRowType.setMaskingTableIndex("01");
				cardRowType.setReceiptIndicator("ICCRECEIPT001");
				cardRowType.setUsageFlag(new BigInteger("1"));
				cardRowType.setDualUseIndicator("0000");
				cardRowType.setExpirationDateFormat(0);
				cardRowType.setSendTrackI(0);
				cardRowType.setSendTrackII(1);
				cardRowType.setSendTrackIII(0);
				cardRowType.setManualEntryPrefix("0");
				cardRowType.setFeeIndicator(new BigInteger("0"));
				cardRowType.setSplitTenderFlag(2);
				cardRowType.setLoyaltyUsageFlag(0);
				cardRowType.setRefundAllowedFlag(1);
				cardRowType.setTrackMaskingIndicator("0045");
				cardRowType.setCardPreValidationIndicator("000");
				cardRowType.setCardValidationIndicator("000");
				cardRowType.setPriceTier(PriceTierType.CREDIT);
				cardRowType.setICCFlag(1);
				
				listCardRows.add(cardRowType);
				rownum++;
			}
			
			
			for(CardBean bean : debit){
				//int rownum = 0;
				CardRowType cardRowType = objectFactory.createCardRowType();
				
				cardRowType.setCTI("Debit"+bean.getLength()+"ICCFB"+rownum);
				cardRowType.setCardType("DB");
				cardRowType.setLimitTableIndex("13");
				cardRowType.setLowPrefix(bean.getApplicationPAN());
				cardRowType.setHighPrefix(bean.getApplicationPAN());
				cardRowType.setPANLength(new BigInteger(""+bean.getLength()));
				cardRowType.setCardEnabled(2);
				cardRowType.setEntryFlag("2");	
				cardRowType.setLogicIndicator("EMVT2SRVCCODEPAN"+bean.getLength());
				cardRowType.setCardValidationPromptIDIndex("INSERTCARD");
				cardRowType.setCardCheckRoutineIndex(3);
				cardRowType.setCheckExpirationDate(0);
				cardRowType.setPromptIndicator("0000");
				cardRowType.setCardHandlingRoutineIndicator("00");
				cardRowType.setProductTableIndex("01");
				cardRowType.setProductRestrictionPromptIDIndex("000");
				cardRowType.setFEPIndicator("01");
				cardRowType.setCardTypeLabel(bean.getApplicationLable());
				cardRowType.setReportGroupName("UseCardTypeLabel");
				cardRowType.setVelocityGroupIndex("01");
				cardRowType.setMaskingTableIndex("01");
				//cardRowType.setLimitTableIndex("91");
				cardRowType.setReceiptIndicator("ICCRECEIPT001");
				cardRowType.setUsageFlag(new BigInteger("1"));
				cardRowType.setDualUseIndicator("ICCCREDITDEBIT");
				//cardRowType.setCardType("VI");
				cardRowType.setExpirationDateFormat(0);
				cardRowType.setSendTrackI(0);
				cardRowType.setSendTrackII(1);
				cardRowType.setSendTrackIII(0);
				cardRowType.setManualEntryPrefix("0");
				cardRowType.setFeeIndicator(new BigInteger("0"));
				cardRowType.setSplitTenderFlag(1);
				cardRowType.setLoyaltyUsageFlag(0);
				cardRowType.setRefundAllowedFlag(1);
				cardRowType.setTrackMaskingIndicator("0045");
				cardRowType.setCardPreValidationIndicator("ICCSERVICECODE");
				cardRowType.setCardValidationIndicator("000");
				cardRowType.setPriceTier(PriceTierType.CREDIT);
				cardRowType.setICCFlag(1);
				
				listCardRows.add(cardRowType);
				rownum++;
			}
			
			
			}
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			marshaller.marshal(obj, file1);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("I am done!");
	}
}
