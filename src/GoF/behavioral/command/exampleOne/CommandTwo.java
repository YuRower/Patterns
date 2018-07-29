package GoF.behavioral.command.exampleOne;

public class CommandTwo implements ICommand {
	private Receiver receiver;

	public CommandTwo(Receiver reciever) {
		this.receiver = reciever;
	}

	public void execute() {
		System.out.println("Determine connection between receiver and action");
		receiver.action(TypeCommand.TWO);
	}
}