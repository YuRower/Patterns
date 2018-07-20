package saxXML;

import java.io.IOException;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXSimpleMain {
	public static void main(String[] args) throws SAXException, IOException {
		UsersSAXBuilder saxBuilder = new UsersSAXBuilder();
		saxBuilder.buildSetUsers("user.xml");
		System.out.println(saxBuilder.getUsers());
	}
}