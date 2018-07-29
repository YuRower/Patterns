package GoF.behavioral.command.exampleTwo;

public class Invoker {
	private ICommand mCommand;

	public Invoker(ICommand command) {
		mCommand = command;
	}

	public void invokeCommand() {
		System.out.println("Refer to command for execution");
		mCommand.execute();
	}
}