/*
 * Created on August 26, 2016 
 * Author: akshayb1
 * Verifone Inc., Copyright(c) 2016 All rights reserved
 */
package com.verifone.isd.viper.eps.version;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Util class for version manager to perform any utility task.
 * 
 * @author AkshayB1
 * 
 */
public class VersionMangerUtil {

	private static final Logger log = LoggerFactory.getLogger(VersionMangerUtil.class.getName());
	
	public static final String UTF8_ENCODING = "UTF8";
	/**
	 * API to notify RCI module to register with Version manager.
	 * @return
	 */
	public static void notifyRCIToRegisterVersion(){
		log.info("notify RCI to register version with VersionManager");

		SOAPConnection connection = null;
		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			connection = soapConnectionFactory.createConnection();
			
			if(connection == null) {
				log.info("The SOAPConnection failed! Try again!");
			}else {
			
			SOAPFactory soapFactory = SOAPFactory.newInstance();
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();
			MimeHeaders hd = message.getMimeHeaders();
			String serverURI = "http://localhost:8080/axis/services/RCIImpl";
			hd.addHeader("SOAPAction",serverURI);

			SOAPHeader header = message.getSOAPHeader();
			SOAPBody body = message.getSOAPBody();
			header.detachNode();

			Name bodyName = soapFactory.createName("registerToVersionManager", "m", serverURI);
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
			log.debug("Body elemet object : "+bodyElement);
			message.saveChanges();
			
			log.debug("Request : "+logSOAPMessage(message));
			URL endpoint = new URL(serverURI);
			SOAPMessage response = connection.call(message, endpoint);
			log.debug("Response : "+logSOAPMessage(response));
			
			log.info("Notified RCI.. It will register with Version manager.");
			}
		} catch (SOAPException e) {
			log.error("A SOAPException was thrown, make sure Tomcat is running", e);
			
		} catch (MalformedURLException e) {
			log.error("A malformed URL should never happen, make sure Tomcat is running", e);
			
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SOAPException e) {
				log.error("Error closing SOAP Connection", e);
			}
			
		}
	}
	
	/**
	 * Notify Web module to register with Version manager.
	 */
	public static void notifyWebToRegisterVersion(){
		log.info("notify Web to register version with VersionManager");
	    BufferedReader in = null;
		try {
			String httpURL = "http://localhost:8080/eps/RegisterToVersionManager";
			URL myurl = new URL(httpURL);
			HttpURLConnection con = (HttpURLConnection)myurl.openConnection();
		    in = new BufferedReader(new InputStreamReader(con.getInputStream(),UTF8_ENCODING));
		    String inputLine;

		    while ((inputLine = in.readLine()) != null)
		    {
		    	log.info(inputLine);
		    }
		} catch (MalformedURLException e) {
			log.error("A malformed URL should never happen, make sure Tomcat is running", e);
		} catch (IOException e) {
			log.error("IO Exception..", e);
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					log.error("IO Exception in closing resource", e);
				}
			}
		}
	    
	}
	
	/**
	 * For converting the Soap Message to string
	 * @param message
	 * @return
	 */
	public static String logSOAPMessage(SOAPMessage message)  
	{    
		String messageString = "Invalid SOAP Message";
		ByteArrayOutputStream out = new ByteArrayOutputStream();        
		try {
			message.writeTo(out);
			messageString = out.toString(UTF8_ENCODING);
			out.close();
		} catch (SOAPException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}        
		return messageString;  
	}
}
