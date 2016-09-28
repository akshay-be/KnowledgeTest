package verifone.emv;

import java.io.File;

import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

import com.verifone.isd.viper.eps.pres.messages.tables.cardTable.CardTable;

public class JaxBParingWithComments {
	
	static String jaxbSchemaLocation = "com.verifone.isd.viper.eps.pres.messages.tables.cardTable";
	static String stFileName = "D:\\EMV\\NTS\\modifyCardTable\\CardTable234.xml";
	
	public static void main(String[] args) throws Exception {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource source = new StreamSource(stFileName);
        XMLStreamReader xsr = xif.createXMLStreamReader(source);

        JAXBContext jaxbContext = JAXBContext.newInstance(jaxbSchemaLocation);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CardTable xml = (CardTable) unmarshaller.unmarshal(xsr);

        while(xsr.hasNext()) {
            if(xsr.getEventType() == XMLStreamConstants.COMMENT) {
                System.out.println(xsr.getText());
            }
            xsr.next();
        }
        
		System.out.println("I am done!");
    }
}
