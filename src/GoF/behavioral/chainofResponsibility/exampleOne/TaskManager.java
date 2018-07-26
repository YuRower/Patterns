package GoF.behavioral.chainofResponsibility.exampleOne;

public class TaskManager extends AbstractHandler {
	public TaskManager() {

	}

	@Override
	public void handleRequest(Employee user) {
		assignTask();
	}

	public void assignTask() {
		System.out.println("assign task");
	}
}