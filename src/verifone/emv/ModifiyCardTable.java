package verifone.emv;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.w3c.dom.*;

public class ModifiyCardTable {

	public static void main(String[] args) {

       
        try {
        	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        	 DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("D:\\EMV\\NTS\\modifyCardTable\\CardTable123.xml"));
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element of the doc is :\" "+ doc.getDocumentElement().getNodeName() + "\"");
            NodeList listOfCardRows = doc.getElementsByTagName("CardRow");
            
            int totalRows = listOfCardRows.getLength();
            System.out.println("Total no of Rows : " + totalRows);
            
            
            for (int rowIndex = 0; rowIndex < listOfCardRows.getLength(); rowIndex++) 
            {
                Node firstPersonNode = listOfCardRows.item(rowIndex);
                if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                	String cti=((Element) firstPersonNode).getElementsByTagName("CTI").item(0).getChildNodes().item(0).getNodeValue().trim();
                	
                	String cardTypeLabel=((Element) firstPersonNode).getElementsByTagName("CardTypeLabel").item(0).getChildNodes().item(0).getNodeValue().trim();
                	/*if(cardTypeLabel.equals("CITGO BUS SELECT")){
                		((Element) firstPersonNode).getElementsByTagName("CardTypeLabel").item(0).getChildNodes().item(0).setNodeValue("Akshay");
                	}*/
                    System.out.println("CTI :: "+cti+" "+cardTypeLabel);
                }
            }
            
            System.out.println("Total no of Rows : " + totalRows);
            
		} catch (SAXParseException err)  {
            System.out.println("** Parsing error" + ", line "+ err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        } 
        catch (SAXException e) {
			System.out.println(""+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(""+e.getMessage());
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			System.out.println(""+e.getMessage());
			e.printStackTrace();
		}

	}

}
