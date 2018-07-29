package GoF.behavioral.command.exampleOne;

public class Client {
	private Receiver mReceiver;

	public Client(Receiver receiver) {
		mReceiver = receiver;
	}

	public ICommand initCommand(TypeCommand cmd) {
		ICommand command = null;
		switch (cmd) {
		case ONE:
			System.out.println("Creating command One and set up its receiver");
			command = new CommandOne(mReceiver);
			break;
		case TWO:
			System.out.println("Creating command Two and set up its receiver");
			command = new CommandTwo(mReceiver);
			break;
		}
		return command;
	}
}