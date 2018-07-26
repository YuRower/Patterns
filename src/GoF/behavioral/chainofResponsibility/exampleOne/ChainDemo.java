package GoF.behavioral.chainofResponsibility.exampleOne;


public class ChainDemo {
	static public void main(String[] args) {
		Employee user = new Employee(30, "user", "passwordUser");
		RoleManager rm = new RoleManager();
		Authentification auth = new Authentification();
		TaskManager tm = new TaskManager();
		auth.setSuccessor(rm);
		rm.setSuccessor(tm);
		System.out.println("----chain--start----");
		auth.chain(user);
	}
}

