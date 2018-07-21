package GoF.creational.builder.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import GoF.creational.builder.entity.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class UserDOMBuilder {
	private Set<User> users;
	private DocumentBuilder docBuilder;

	public UserDOMBuilder() {
		this.users = new HashSet<User>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("Parser configuration error:" + e);
		}
	}

	public Set<User> getUsers() {
		return users;
	}

	public void buildSetUsers(String fileName) {
		Document doc = null;
		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			NodeList userList = root.getElementsByTagName("user");
			for (int i = 0; i < userList.getLength(); i++) {
				Element userElement = (Element) userList.item(i);
				User user = buildUser(userElement);
				users.add(user);
			}
		} catch (IOException e) {
			System.err.println("File error or I/O error: " + e);
		} catch (SAXException e) {
			System.err.println("Parsing failure: " + e);
		}
	}

	private User buildUser(Element userElement) {
		User user = new User();
		user.setLogin(getElementTextContent(userElement, "login"));
		user.setPassword(getElementTextContent(userElement, "password"));
		return user;
	}

	private static String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;
	}
}