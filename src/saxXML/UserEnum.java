package saxXML;

public enum UserEnum {
    USERS("users"),

	LOGIN("login"), PASSWORD("password");
	private String value;

	private UserEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}