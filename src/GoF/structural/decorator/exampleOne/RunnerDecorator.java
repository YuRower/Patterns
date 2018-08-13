package GoF.structural.decorator.exampleOne;

public class RunnerDecorator {
	public static void main(String[] args) {
		IEmployee employee = new TesterDecorator(new Employee("Ivanov"));
		employee.reopenTask();
		employee = new TeamLeadDecorator(new Employee("Petrov"));
		employee.openTask();
		employee = new DeveloperDecorator(new Employee("Sydorov"));
		employee.resolveTask();
	}
}