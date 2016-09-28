package verifone.emv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.verifone.isd.viper.eps.pres.messages.tables.aidTable.AIDRowType;
import com.verifone.isd.viper.eps.pres.messages.tables.aidTable.AIDTable;
import com.verifone.isd.viper.eps.pres.messages.tables.capkTable.CAPKRowType;
import com.verifone.isd.viper.eps.pres.messages.tables.capkTable.CAPKTable;



public class DeviceRequestBuilder {
	
	static String aidTableName = "D:\\EMV\\NTS\\deviceRequest\\AIDTable.xml";
	static String aidTableJaxbSchemaLocation = "com.verifone.isd.viper.eps.pres.messages.tables.aidTable";
	
	static String capKeyTableName = "D:\\EMV\\NTS\\deviceRequest\\CAPKTable.xml";
	static String capKeyTableJaxbSchemaLocation = "com.verifone.isd.viper.eps.pres.messages.tables.capkTable";

	public static void main(String[] args) throws JAXBException, IOException {
		
		File file = new File("D:\\EMV\\NTS\\deviceRequest\\DeviceRequestBuilder.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file); 
		
		String aidDevReq = aidDeviceRequestBuilder();
		writer.write("AID Dev Req \n");
		writer.write(aidDevReq);
		writer.write("\n \n \n");
		String capDevReq = capKeyDeviceRequestBuilder();
		writer.write("Cap Dev Req \n");
		writer.write(capDevReq);
		writer.write("\n \n \n");
		
		
		writer.flush();
	    writer.close();
	    System.out.println("I am done!");
	}
	
	public static String capKeyDeviceRequestBuilder() throws JAXBException {
		
		String startUpdateKeys = "<DeviceRequest RequestID=\"00002244\" POPID=\"001\" WorkstationID=\"POS001\" RequestType=\"Input\" xmlns:ns2=\"urn:vfi-viper:eps.2004-03-12\" xmlns=\"http://www.nrf-arts.org/IXRetail/namespace\"> <Output OutDeviceTarget=\"PinPad\"> <TextLine> </TextLine> </Output> <Input InDeviceTarget=\"PinPad\"> <Command TimeOut=\"75\" Echo=\"true\" MaxLength=\"0\" MinLength=\"0\">UpdateKeys</Command>";
		String endUpdateKeys = "</Input>  </DeviceRequest>";
		
		JAXBContext jaxbContext = JAXBContext.newInstance(capKeyTableJaxbSchemaLocation);
		Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();

		File file = new File(capKeyTableName);
		Object obj = unMarshaller.unmarshal(file);
		String inSecureData =null;
		
		if(obj instanceof CAPKTable){
			CAPKTable capkTable = (CAPKTable) obj;
			 List<CAPKRowType>  capKeyRows = capkTable.getCAPKRow();
			 
			 for (CAPKRowType capkRowType : capKeyRows) {
				 System.out.println(""+capkRowType.getCAPKId());
				 inSecureData = "<InSecureData>";
				 inSecureData += "<ICCData><ICCParameter>RID</ICCParameter><ICCValue>"+convertAsciiToHex(capkRowType.getRID())+"</ICCValue></ICCData>";
				 inSecureData += "<ICCData><ICCParameter>CAPKModulus</ICCParameter><ICCValue>"+convertAsciiToHex(capkRowType.getCAPKModulus())+"</ICCValue></ICCData>";
				 inSecureData += "<ICCData><ICCParameter>CAPKExponent</ICCParameter><ICCValue>"+convertAsciiToHex(capkRowType.getCAPKExponent())+"</ICCValue></ICCData>";
				 inSecureData += "<ICCData><ICCParameter>CAPKChecksum</ICCParameter><ICCValue>"+convertAsciiToHex(capkRowType.getCAPKChecksum())+"</ICCValue></ICCData>";
				 inSecureData += "<ICCData><SecureTag>9F22</SecureTag><SecureValue>"+convertAsciiToHex(capkRowType.getCAPKIndex())+"</SecureValue></ICCData>";
				 
				 startUpdateKeys += inSecureData +" </InSecureData>";
				 //System.out.println("Done!"+startUpdateKeys);
			}
			// System.out.println("Done123"+startUpdateKeys);
		}
		//System.out.println(startUpdateKeys);
		startUpdateKeys +=endUpdateKeys;
		
		System.out.println(startUpdateKeys.length());
		return startUpdateKeys;

	}
	
	
	
	public static String aidDeviceRequestBuilder() throws JAXBException {
		
		String startUpdateAID = "<DeviceRequest RequestID=\"00002243\" POPID=\"001\" WorkstationID=\"POS001\" RequestType=\"Input\" xmlns:ns2=\"urn:vfi-viper:eps.2004-03-12\" xmlns=\"http://www.nrf-arts.org/IXRetail/namespace\"> <Output OutDeviceTarget=\"PinPad\">    <TextLine> </TextLine>  </Output> <Input InDeviceTarget=\"PinPad\"> <Command TimeOut=\"75\" Echo=\"true\" MaxLength=\"0\" MinLength=\"0\">UpdateAID</Command>";
				
		JAXBContext jaxbContext = JAXBContext.newInstance(aidTableJaxbSchemaLocation);
		Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();

		File file = new File(aidTableName);
		Object obj = unMarshaller.unmarshal(file);
		String aidInSecureData =null;
		if(obj instanceof AIDTable){
			AIDTable aidTable = (AIDTable) obj;
			
			 List<AIDRowType> aidRows  = aidTable.getAIDRow();
			 
			 for (AIDRowType aidRowType : aidRows) {
				 System.out.println(aidRowType.getAID());
				if(aidRowType.isAIDEnabled()){
					aidInSecureData = "<InSecureData Mode=\"Contact\">";
					if(aidRowType.getAIDName()!=null && !aidRowType.getAIDName().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>AIDName</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getAIDName())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getTACDefault()!=null && !aidRowType.getAIDName().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>TACDefault</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getTACDefault())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getTACDenial()!=null && !aidRowType.getTACDenial().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>TACDenial</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getTACDenial())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getTACOnline()!=null  && !aidRowType.getTACOnline().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>TACOnline</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getTACOnline())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getTDOLDefault()!=null && !aidRowType.getTDOLDefault().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>TDOLDefault</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getTDOLDefault())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getDDOLDefault()!=null && !aidRowType.getDDOLDefault().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>DDOLDefault</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getDDOLDefault())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getRandomSelectionThreshold()!=null && !aidRowType.getRandomSelectionThreshold().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>RandomSelectionThreshold</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getRandomSelectionThreshold())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getTargetRandomSelectionPercent()!=null && !aidRowType.getTargetRandomSelectionPercent().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>MaxRandomSelectionPercent</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getMaxRandomSelectionPercent())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getTargetRandomSelectionPercent()!=null && !aidRowType.getAIDName().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>TargetRandomSelectionPercent</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getTargetRandomSelectionPercent())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getRIDName()!=null && !aidRowType.getRIDName().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>RIDName</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getRIDName())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getAIDMode()!=null && !aidRowType.getAIDMode().toString().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>AIDMode</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getAIDMode().toString())+"</ICCValue></ICCData>";
					}
			
					aidInSecureData += "<ICCData><ICCParameter>AIDEnabled</ICCParameter><ICCValue>"+convertAsciiToHex("true")+"</ICCValue></ICCData>";
					
					if(aidRowType.getPinBypassFlag()!=null && !aidRowType.getPinBypassFlag().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>PinBypassFlag</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getPinBypassFlag())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getAIDName()!=null && !aidRowType.getAIDName().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>TransactionType</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getTargetRandomSelectionPercent())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getTargetRandomSelectionPercent()!=null && !aidRowType.getTargetRandomSelectionPercent().trim().isEmpty()){
						aidInSecureData += "<ICCData><ICCParameter>TargetRandomSelectionPercent</ICCParameter><ICCValue>"+convertAsciiToHex(aidRowType.getTargetRandomSelectionPercent())+"</ICCValue></ICCData>";
					}
					if(aidRowType.getAID()!=null && !aidRowType.getAID().trim().isEmpty()){
						aidInSecureData += "<ICCData><SecureTag>9F06</SecureTag><SecureValue>"+convertAsciiToHex(aidRowType.getAID())+"</SecureValue></ICCData>";
					}
					if(aidRowType.getTerminalApplicationVersionNumber1()!=null && !aidRowType.getTerminalApplicationVersionNumber1().trim().isEmpty()){
						aidInSecureData += "<ICCData><SecureTag>9F09</SecureTag><SecureValue>"+convertAsciiToHex(aidRowType.getTerminalApplicationVersionNumber1())+"</SecureValue></ICCData>";
					}
					if(aidRowType.getTerminalFloorLimit()!=null && !aidRowType.getTerminalFloorLimit().trim().isEmpty()){
						aidInSecureData += "<ICCData><SecureTag>9F1B</SecureTag><SecureValue>"+convertAsciiToHex(aidRowType.getTerminalFloorLimit())+"</SecureValue></ICCData>";
					}
					if(aidRowType.getTerminalCapabilities()!=null && !aidRowType.getTerminalCapabilities().trim().isEmpty()){
						aidInSecureData += "<ICCData><SecureTag>9F33</SecureTag><SecureValue>"+convertAsciiToHex(aidRowType.getTerminalCapabilities())+"</SecureValue></ICCData>";
					}
					if(aidRowType.getTerminalRiskManagementData()!=null && !aidRowType.getTerminalRiskManagementData().trim().isEmpty()){
						aidInSecureData += "<ICCData><SecureTag>9F1D</SecureTag><SecureValue>"+convertAsciiToHex(aidRowType.getTerminalRiskManagementData())+"</SecureValue></ICCData>";
					}
					if(aidRowType.getApplicationCountryCode()!=null && !aidRowType.getApplicationCountryCode().trim().isEmpty()){
						aidInSecureData += "<ICCData><SecureTag>9F1A</SecureTag><SecureValue>"+convertAsciiToHex(aidRowType.getApplicationCountryCode())+"</SecureValue></ICCData>";
					}
					//System.out.println("AID  : "+aidInSecureData);
					startUpdateAID += aidInSecureData +" </InSecureData>";
				}
			}
			 
			 startUpdateAID += "</Input></DeviceRequest>";
			 
			 System.out.println(startUpdateAID);
			 return startUpdateAID;
			
		}
		return startUpdateAID;
		
	}
	
	public static String convertHexToAscii(String hex) {
		System.out.println(" Hex : "+hex);
		 StringBuilder output = new StringBuilder();
		    for (int i = 0; i < hex.length(); i+=2) {
		        String str = hex.substring(i, i+2);
		        output.append((char)Integer.parseInt(str, 16));
		    }
			return output.toString();
		}
	
	/**
     * API to convert ascii string to hex encoded
     * @param asciiString
     * @return
     */
	public static String convertAsciiToHex(String asciiString){
		if(asciiString !=null){
			char[] chars = asciiString.toCharArray();
			StringBuilder hex = new StringBuilder();
			for (int i = 0; i < chars.length; i++)
			{
				hex.append(Integer.toHexString((int) chars[i]));
			}
			return hex.toString();
		}
		return null;
	}
}
