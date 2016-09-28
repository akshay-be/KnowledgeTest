package verifone.emv;
import java.io.File;
import java.io.IOException;

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


public class XMLTestClass {

	/**
	 * @author PritpalT1
	 * @param args
	 */
	public static void main(String[] args) {

		String filePath = "D:\\EMV\\NTS\\modifyCardTable\\dom\\CardTable.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			/*//update attribute value
			updateAttributeValue(doc);*/

			//update Element value
			updateElementValue(doc);

		/*	//delete element
			deleteElement(doc);*/

		/*	//add new element
			addElement(doc);*/

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
			StreamResult result = new StreamResult(new File("D:\\EMV\\NTS\\modifyCardTable\\dom\\CardTable_M1.xml").getAbsolutePath());
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
	
	/*private static void addElement(Document doc) {
		NodeList employees = doc.getElementsByTagName("Employee");
		Element emp = null;

		//loop for each employee
		for(int i=0; i<employees.getLength();i++){
			emp = (Element) employees.item(i);
			Element salaryElement = doc.createElement("salary");
			salaryElement.appendChild(doc.createTextNode("10000"));
			emp.appendChild(salaryElement);
		}
	}
*/
	/*private static void deleteElement(Document doc) {
		NodeList employees = doc.getElementsByTagName("Employee");
		Element emp = null;
		//loop for each employee
		for(int i=0; i<employees.getLength();i++){
			emp = (Element) employees.item(i);
			Node genderNode = emp.getElementsByTagName("gender").item(0);
			emp.removeChild(genderNode);
		}

	}
*/
	private static void updateElementValue(Document doc) {
		NodeList cardRow = doc.getElementsByTagName("CardRow");
		Element card = null;
		//loop for each employee
		for(int i=0; i<cardRow.getLength();i++){
			card = (Element) cardRow.item(i);
			System.out.println( card.getElementsByTagName("CTI").item(0).getFirstChild().getNodeValue()+"");
			Node cardPANEle = card.getElementsByTagName("PANLength").item(0).getFirstChild();
			Node cardTypeLabel = card.getElementsByTagName("CardTypeLabel").item(0).getFirstChild();
			Node cardEntryMode = card.getElementsByTagName("EntryFlag").item(0).getFirstChild();
			Node cardEnabled  = card.getElementsByTagName("CardEnabled").item(0).getFirstChild();
		//	Node iccFlag  = card.getElementsByTagName("ICCFlag").item(0).getFirstChild();
			
			
			if((!cardEntryMode.getNodeValue().equals("M") && !cardEntryMode.getNodeValue().equals("SC"))  
					&& cardEnabled.getNodeValue().equals("2") && cardTypeLabel!=null && cardTypeLabel.getNodeValue()!=null && (cardTypeLabel.getNodeValue().trim().equalsIgnoreCase("AMEX") || cardTypeLabel.getNodeValue().trim().equalsIgnoreCase("DISCOVER") 
							|| cardTypeLabel.getNodeValue().trim().equalsIgnoreCase("MARATHON VISA")
					|| cardTypeLabel.getNodeValue().trim().equalsIgnoreCase("VISA") || cardTypeLabel.getNodeValue().trim().equalsIgnoreCase("VISA PUR")
					|| cardTypeLabel.getNodeValue().trim().equalsIgnoreCase("MC PURCH") || cardTypeLabel.getNodeValue().trim().equalsIgnoreCase("MASTERCARD"))){
				//cardPANEle.getNodeValue().equalsIgnoreCase("13")&& 
				String pnLength = cardPANEle.getNodeValue();
				Node handlingRoutine = card.getElementsByTagName("CardHandlingRoutineIndicator").item(0).getFirstChild();
				
				if(handlingRoutine.getNodeValue().equals("00")){
					
					
				
				if(pnLength.equals("11")){
					handlingRoutine.setNodeValue("21");
				}else if(pnLength.equals("12")){
					handlingRoutine.setNodeValue("22");
				}else if(pnLength.equals("13")){
					handlingRoutine.setNodeValue("23");
				}else if(pnLength.equals("14")){
					handlingRoutine.setNodeValue("24");
				}else if(pnLength.equals("15")){
					handlingRoutine.setNodeValue("25");
				}else if(pnLength.equals("16")){
					handlingRoutine.setNodeValue("26");
				}else if(pnLength.equals("17")){
					handlingRoutine.setNodeValue("27");
				}else if(pnLength.equals("18")){
					handlingRoutine.setNodeValue("28");
				}else if(pnLength.equals("19")){
					handlingRoutine.setNodeValue("29");
				}
				}else{
					System.out.println("Something worng "+card.getElementsByTagName("CTI").item(0).getFirstChild().getNodeValue());
					continue;
				}
				System.out.println( card.getElementsByTagName("CTI").item(0).getFirstChild().getNodeValue()+"Entries updated");
			}
			/*System.out.println(i+"Entries updated");*/
			
			/*cardPANEle.setNodeValue(cardPANEle.getNodeValue().toUpperCase());*/
		}
	}

	/*private static void updateAttributeValue(Document doc) {
		NodeList employees = doc.getElementsByTagName("Employee");
 		Element emp = null;
		//loop for each employee
		for(int i=0; i<employees.getLength();i++){
			emp = (Element) employees.item(i);
			String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
			if(gender.equalsIgnoreCase("male")){
				//prefix id attribute with M
				emp.setAttribute("id", "M"+emp.getAttribute("id"));
			}else{
				//prefix id attribute with F
				emp.setAttribute("id", "F"+emp.getAttribute("id"));
			}
		}
	}*/

}
