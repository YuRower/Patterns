package GoF.behavioral.command.exampleOne;

public class Receiver {
	public void action(TypeCommand cmd) {
		switch (cmd) {
		case ONE:
			System.out.println("Know the information to complete request One");
			break;
		case TWO:
			System.out.println("Know the information to complete request Two");
			break;
		}
	}
}