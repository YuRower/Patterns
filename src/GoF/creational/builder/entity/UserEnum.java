package GoF.creational.builder.entity;

public enum UserEnum {
	USERS("users"), USER("user"),
	LOGIN("login"), PASSWORD("password");
	private String value;

	private UserEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}