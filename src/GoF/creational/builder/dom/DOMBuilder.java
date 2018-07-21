package GoF.creational.builder.dom;

import GoF.creational.builder.UserBuilder;

public class DOMBuilder extends UserBuilder {
	public DOMBuilder() {

		UserDOMBuilder domBuilder = new UserDOMBuilder();
		domBuilder.buildSetUsers("user.xml");
		System.out.println(domBuilder.getUsers());
	}

	@Override
	public void buildLogin() {
		getUser().getLogin();
	}

	@Override
	public void buildPassword() {
		getUser().getPassword();

	}
}