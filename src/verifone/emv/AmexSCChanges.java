package verifone.emv;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class AmexSCChanges {

	/**
	 * @author PritpalT1
	 * @param args
	 */
	public static void main(String[] args) {

		String filePath = "D:\\EMV\\NTS\\modifyCardTable\\removeprompt\\CardTable.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();



			//update Element value
			updateElementValue(doc);



			//write the updated document to file or console
			doc.getDocumentElement().normalize();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = null;
			try {
				transformer = transformerFactory.newTransformer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("D:\\EMV\\NTS\\modifyCardTable\\amex\\CardTable_AMSC.xml").getAbsolutePath());
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			System.out.println("XML file updated successfully");

		} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	private static void updateElementValue(Document doc) {
		NodeList cardRow = doc.getElementsByTagName("CardRow");
		Element card = null;
		//loop for each employee
		int count = 0;
		Map<String,String> prompts = new HashMap<String,String>();
		for(int i=0; i<cardRow.getLength();i++){
			card = (Element) cardRow.item(i);
			Node cardEntryMode = card.getElementsByTagName("EntryFlag").item(0).getFirstChild();
			Node cardType  = card.getElementsByTagName("CardType").item(0).getFirstChild();
			Node  limitTableIndex= card.getElementsByTagName("LimitTableIndex").item(0).getFirstChild();
			Node  cardEnabled= card.getElementsByTagName("CardEnabled").item(0).getFirstChild();
			
			
			/*if(cardEntryMode.getNodeValue().equals("SC")  && cardType.getNodeValue().equals("AE")){
				
				
				Node promptIndicator = card.getElementsByTagName("PromptIndicator").item(0).getFirstChild();
				
				if(promptIndicator.getNodeValue().equals("0146")){
					promptIndicator.setNodeValue("AMEXICCSCPROMPTS");
					count++;
				}else{
					System.out.println("Something worng "+card.getElementsByTagName("CTI").item(0).getFirstChild().getNodeValue());
					//continue;
				}
				//System.out.println( card.getElementsByTagName("CTI").item(0).getFirstChild().getNodeValue()+"Entries updated");
			}*/
			
			
			String strCardType = cardType.getNodeValue();
			if(!cardEntryMode.getNodeValue().equals("M") && !cardEnabled.getNodeValue().equals("3") && (cardType.getNodeValue().equals("VP") 
					|| strCardType.equals("VI") 
					|| strCardType.equals("DS")
					|| strCardType.equals("MC")
					|| strCardType.equals("MV")
					|| strCardType.equals("DB")
					|| strCardType.equals("MP")
					|| strCardType.equals("AE"))){
				Node promptIndicator = card.getElementsByTagName("PromptIndicator").item(0).getFirstChild();
				if(!promptIndicator.getNodeValue().equals("0000")){
					if(prompts.containsKey(strCardType)){
						String value = prompts.get(strCardType);
						if(!value.contains(promptIndicator.getNodeValue())){
							prompts.put(strCardType, prompts.get(strCardType)+" , "+promptIndicator.getNodeValue());
						}
					}else{
						prompts.put(strCardType,promptIndicator.getNodeValue());
					}
					//System.out.println("CTI : "+card.getElementsByTagName("CTI").item(0).getFirstChild().getNodeValue()+" : "+promptIndicator.getNodeValue()+" CardType : "+cardType.getNodeValue());
				}
			}
			
		}
		//System.out.println(count+"  Entries updated");
		System.out.println(""+prompts);
	}

}
