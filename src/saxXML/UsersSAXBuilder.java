package saxXML;

import java.io.IOException;
import java.util.Set;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class UsersSAXBuilder {
	private Set<User> user;
	private UserHandler uh;
	private XMLReader reader;

	public UsersSAXBuilder() {
		uh = new UserHandler();
		try {
			reader = XMLReaderFactory.createXMLReader();

			reader.setContentHandler(uh);
		} catch (SAXException e) {
			System.err.print("ошибка SAX парсера: " + e);
		}
	}

	 public Set<User> getUsers() {
		return user;
	}

	public void buildSetUsers(String fileName) {
		try {
			reader.parse(fileName);
		} catch (SAXException e) {
			System.err.print("ошибка SAX парсера: " + e);
		} catch (IOException e) {
			System.err.print("ошибка I/О потока: " + e);
		}
		user = uh.getUsers();
	}
}