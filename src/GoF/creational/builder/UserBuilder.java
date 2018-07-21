package GoF.creational.builder;

import GoF.creational.builder.entity.User;

public abstract class UserBuilder {
	protected User user = new User();

	public User getUser() {
		return user;
	}

	public abstract void buildLogin();

	public abstract void buildPassword();
}
