package GoF.behavioral.chainofResponsibility.exampleOne;

import java.util.HashMap;


public class MapEmployee {
	private HashMap<Integer, Employee> users = new HashMap<Integer, Employee>();

	public MapEmployee() {
		users.put(1, new Employee(10, "admin", "passwordAdmin"));
		users.put(2, new Employee(20, "employee", "passwordEmployee"));
		users.put(3, new Employee(30, "user", "passwordUser"));
	}

	public HashMap<Integer, Employee> getUsers() {
		return users;
	}

	public boolean containsUser(Employee emp) {
		return users.containsValue(emp);
	}
}
