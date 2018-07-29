package GoF.behavioral.command.exampleTwo;

public class BlockingCommand implements ICommand {
	private Receiver receiver;

	public BlockingCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		receiver.action(CommandTypes.BLOCKING);
	}
}