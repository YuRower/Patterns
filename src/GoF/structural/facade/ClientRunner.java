package GoF.structural.facade;

interface IFacade {
	void generate();

	void find();
}

class Facade implements IFacade {
	private SecuritySystem securitySystem;
	private SubSystem subSystem;

	public Facade() {
		this.subSystem = new SubSystem();
		this.securitySystem = new SecuritySystem();
	}

	@Override
	public void generate() {
		securitySystem.checkUser();
		securitySystem.checkRights();
		subSystem.createNode();
	}

	@Override
	public void find() {
		securitySystem.checkUser();
		subSystem.parse();
	}
}

class SecuritySystem {
	boolean checkUser() {

		return true;
	}

	boolean checkRights() {
		return true;
	}
}

class SubSystem {
	public void parse() {
		System.out.println("Parsing");
	}

	public void createNode() {
		System.out.println("Creating program node");
	}
}

public class ClientRunner {
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.generate();
	}
}