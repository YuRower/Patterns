package GoF.behavioral.command.exampleOne;

public class RunnerBase {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Client client = new Client(receiver);
		ICommand commandOne = client.initCommand(TypeCommand.ONE);
		Invoker invokerOne = new Invoker(commandOne);
		invokerOne.invokeCommand();
		ICommand commandTwo = client.initCommand(TypeCommand.TWO);
		Invoker invokerTwo = new Invoker(commandTwo);
		invokerTwo.invokeCommand();
	}
}