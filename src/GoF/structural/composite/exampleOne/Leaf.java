package GoF.structural.composite.exampleOne;

public class Leaf implements Component {
	public void operation() {
		System.out.println("Leaf -> Performing operation");
	}

	public void add(Component c) {
		System.out.println("Leaf -> add. Doing nothing");
	}

	public void remove(Component c) {
		System.out.println("Leaf -> remove. Doing nothing");
	}

	public Object getChild(int index) {
		throw new UnsupportedOperationException();
	}
}