package GoF.creational.builder;

class User {
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

abstract class BaseBuilder {
	protected User user = new User();

	public User getUser() {
		return user;
	}

	public abstract void buildLogin();

	public abstract void buildPassword();
}

class Director {
	public static User createUser(BaseBuilder builder) {
		builder.buildLogin();
		builder.buildPassword();
		return builder.getUser();
	}
}

public class Runner {
	public static void main(String args[]) {
		User e1 = Director.createUser(new DomBuilder());
		User e2 = Director.createUser(new SAXBuilder());
	}
}
