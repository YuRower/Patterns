package GoF.creational.builder;

import saxXML.SAXBuilder;

class Director {
	public static User createUser(UserBuilder builder) {
		builder.buildLogin();
		builder.buildPassword();
		return builder.getUser();
	}
}

public class Runner {
	public static void main(String args[]) {
	//	User e1 = Director.createUser(new DomBuilder());
		User e2 = Director.createUser(new SAXBuilder());
	}
}
