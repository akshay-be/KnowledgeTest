package verifone.emv;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;


public class VfiClient {

	public static void main(String[] args) {
		try
		{
			//RCIImpl_PortType rci =(new RCIImplServiceLocator().getRCIImpl(new java.net.URL("http://192.168.31.11:8080/axis/services/RCIImpl")));
			
			System.out.println("*******Start************");
			SOAPFactory soapFactory = SOAPFactory.newInstance();
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();
			MimeHeaders hd = message.getMimeHeaders();
			String serverURI = "http://192.168.31.11:8080/axis/services/RCIImpl";
			hd.addHeader("SOAPAction",serverURI);
			
			SOAPHeader header = message.getSOAPHeader();
			SOAPBody body = message.getSOAPBody();
			header.detachNode();
			
			URL endpoint = new URL(serverURI);
			SOAPConnection connection = null;
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			connection = soapConnectionFactory.createConnection();
			SOAPMessage response = connection.call(message, endpoint);
			
			System.out.println(logSOAPMessage(response));
			
			System.out.println("*******End************");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static String logSOAPMessage(SOAPMessage message)  
	{    
		String messageString = "Invalid SOAP Message";
		ByteArrayOutputStream out = new ByteArrayOutputStream();        
		try {
			message.writeTo(out);
			//For fixing Coverity issue pass the Encoding character set
			//Since toString() uses default character set, if failed uses "ISO-8859-1"
			//If we use "ISO-8859-1" should go through
			messageString = out.toString("ISO-8859-1");
			out.close();
		} catch (SOAPException e) {
			
		} catch (IOException e) {
			
		}        
		return messageString;  
	}
}
