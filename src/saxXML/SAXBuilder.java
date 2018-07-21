package saxXML;
import GoF.creational.builder.UserBuilder;


public class SAXBuilder extends UserBuilder {

 public SAXBuilder() {
		UsersSAXBuilder saxBuilder = new UsersSAXBuilder();
		saxBuilder.buildSetUsers("user.xml");
		System.out.println(saxBuilder.getUsers());
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