package GoF.creational.builder.stax;

import GoF.creational.builder.UserBuilder;

public class StaxBuilder extends UserBuilder{
	public StaxBuilder() {
		UserStAXBuilder staxBuilder = new UserStAXBuilder();
		staxBuilder.buildSetStudents("user.xml");
		System.out.println(staxBuilder.getUsers());
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
