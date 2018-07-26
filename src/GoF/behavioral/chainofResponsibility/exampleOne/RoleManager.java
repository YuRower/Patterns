package GoF.behavioral.chainofResponsibility.exampleOne;

public class RoleManager extends AbstractHandler {
	public RoleManager() {
	}

	@Override
	public void handleRequest(Employee user) {
		checkPermission();
	}

	public void checkPermission() {
		System.out.println("checking role");
	}
}
