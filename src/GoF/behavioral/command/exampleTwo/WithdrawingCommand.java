package GoF.behavioral.command.exampleTwo;

public class WithdrawingCommand implements ICommand {
	private Receiver receiver;

	public WithdrawingCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		receiver.action(CommandTypes.WITHDRAWING);
	}
}
