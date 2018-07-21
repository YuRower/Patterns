package GoF.creational.builder.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import GoF.creational.builder.entity.User;
import GoF.creational.builder.entity.UserEnum;

public class UserStAXBuilder {
	private HashSet<User> user = new HashSet<>();
	private XMLInputFactory inputFactory;

	public UserStAXBuilder() {
		inputFactory = XMLInputFactory.newInstance();
	}

	public Set<User> getUsers() {
		return user;
	}

	public void buildSetStudents(String fileName) {
		XMLStreamReader reader = null;
		try (FileInputStream inputStream = new FileInputStream(new File(fileName));) {
			reader = inputFactory.createXMLStreamReader(inputStream);
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					String name = reader.getLocalName();
					if (UserEnum.valueOf(name.toUpperCase()) == UserEnum.USERS) {
						User us = buildUser(reader);
						user.add(us);
					}
				}
			}
		} catch (XMLStreamException ex) {
			System.err.println("StAX parsing error! " + ex.getMessage());
		} catch (IOException ex) {
			System.err.println("File " + fileName + " not found! " + ex);
		}
	}

	private User buildUser(XMLStreamReader reader) throws XMLStreamException {
		User us = new User();
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (UserEnum.valueOf(name.toUpperCase())) {
				case LOGIN:
					us.setLogin(getXMLText(reader));
					break;
				case PASSWORD:
					us.setPassword(getXMLText(reader));
					break;

				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (UserEnum.valueOf(name.toUpperCase()) == UserEnum.USERS) {
					return us;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Student");
	}

	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}
}