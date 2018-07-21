package GoF.creational.builder;

import GoF.creational.builder.dom.DOMBuilder;
import GoF.creational.builder.entity.User;
import GoF.creational.builder.sax.SAXBuilder;
import GoF.creational.builder.stax.StaxBuilder;
class Director {
	public static User createUser(UserBuilder builder) {
		builder.buildLogin();
		builder.buildPassword();
		return builder.getUser();
	}
}

public class RunnerXML {
	public static void main(String args[]) {
 	User e1 = Director.createUser(new DOMBuilder());
	User e2 = Director.createUser(new SAXBuilder());
	User e3 = Director.createUser(new StaxBuilder());

	}
}
