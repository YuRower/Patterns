package saxXML;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import GoF.creational.builder.User;

public class UserHandler extends DefaultHandler {
	private Set<User> users;
	private User current = null;
	private UserEnum currentEnum = null;
	private EnumSet<UserEnum> withText;

	public UserHandler() {
		users = new HashSet<User>();
		withText = EnumSet.range(UserEnum.LOGIN, UserEnum.PASSWORD);
	}

	public Set<User> getUsers() {
		return users;
	}

	public void startElement(String uri, String localName, String qName, Attributes attrs) {

		if ("user".equals(localName)) {
			current = new User();
		} else {
			UserEnum temp = UserEnum.valueOf(localName.toUpperCase());

			if (withText.contains(temp)) {
				currentEnum = temp;
			}
		}
	}

	public void endElement(String uri, String localName, String qName) {
		if ("user".equals(localName)) {
			users.add(current);
		}
	}

	public void characters(char[] ch, int start, int length) {
		String s = new String(ch, start, length).trim();
		if (currentEnum != null) {
			switch (currentEnum) {
			case LOGIN:
				current.setLogin(s);
				break;
			case PASSWORD:
				current.setPassword(s);

				break;
			default:

				throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
			}
		}
		currentEnum = null;
	}
}