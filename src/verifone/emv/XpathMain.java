package verifone.emv;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
 

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XpathMain {

	public static void main(String[] args) {
		try{
		 //FileInputStream file = new FileInputStream(new File("D:\\Personal\\Xpath\\Employee.xml"));
		 FileInputStream file = new FileInputStream(new File("D:\\Personal\\Xpath\\ValidationIndicatorTable.xml"));
		 //ValidationIndicatorTable.xml
         DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
          
         DocumentBuilder builder =  builderFactory.newDocumentBuilder();
          
         Document xmlDocument = builder.parse(file);

         XPath xPath =  XPathFactory.newInstance().newXPath();


         System.out.println("*************************");
         //String expression = "//ValidationIndicatorRow[ValidationIndicator='220' or ValidationIndicator='221' or ValidationIndicator='222' or ValidationIndicator='223' or ValidationIndicator='224' or ValidationIndicator='225' or ValidationIndicator='214']";
         
         String expression = "//ValidationIndicatorRow[ValidationIndicator!='220' and ValidationIndicator!='221' and ValidationIndicator!='222' and ValidationIndicator!='223' and ValidationIndicator!='224' and ValidationIndicator!='225' and ValidationIndicator!='214']";
         
         System.out.println(expression);
         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
         for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node childNode = nodeList.item(i);
        	 Element e = (Element) childNode;
             System.out.println(childNode.getNodeName()+" : "+e.getTextContent()); 
         }
         
         System.out.println("*************************");
         

        /* System.out.println("*************************");
         expression = "/Employees/Employee[@type='admin']/firstname";
         System.out.println(expression);
         nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
         for (int i = 0; i < nodeList.getLength(); i++) {
             System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
         }

         System.out.println("*************************");
         expression = "/Employees/Employee[@emplid='2222']";
         System.out.println(expression);
         Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
         if(null != node) {
             nodeList = node.getChildNodes();
             for (int i = 0;null!=nodeList && i < nodeList.getLength(); i++) {
                 Node nod = nodeList.item(i);
                 if(nod.getNodeType() == Node.ELEMENT_NODE)
                     System.out.println(nodeList.item(i).getNodeName() + " : " + nod.getFirstChild().getNodeValue()); 
             }
         }
          
         System.out.println("*************************");

         expression = "/Employees/Employee[age>40]/firstname";
         nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
         System.out.println(expression);
         for (int i = 0; i < nodeList.getLength(); i++) {
             System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
         }
      
         System.out.println("*************************");
         expression = "/Employees/Employee[1]/firstname";
         System.out.println(expression);
         nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
         for (int i = 0; i < nodeList.getLength(); i++) {
             System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
         }
         System.out.println("*************************");
         expression = "/Employees/Employee[position() <= 2]/firstname";
         System.out.println(expression);
         nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
         for (int i = 0; i < nodeList.getLength(); i++) {
             System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
         }

         System.out.println("*************************");
         expression = "/Employees/Employee[last()]/firstname";
         System.out.println(expression);
         nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
         for (int i = 0; i < nodeList.getLength(); i++) {
             System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
         }

         System.out.println("*************************");*/

     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (SAXException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     } catch (ParserConfigurationException e) {
         e.printStackTrace();
     } catch (XPathExpressionException e) {
         e.printStackTrace();
     }       

	}

}
