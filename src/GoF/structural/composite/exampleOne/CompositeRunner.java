package GoF.structural.composite.exampleOne;

public class CompositeRunner {
	public static void main(String[] args) {
		Component composite = new Composite();
		Component leaf = new Leaf();
		leaf.add(composite);
		composite.add(leaf);
		Client client = new Client(composite);
		client.execute();
	}
}