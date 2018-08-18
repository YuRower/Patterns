package GoF.structural.composite.exampleOne;

public class Client {
	private Component component;

	public Client(Component component) {
		this.component = component;
	}

	public void execute() {
		component.operation();
	}
}