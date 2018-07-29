package GoF.behavioral.command;

public class CommandApp {
	public static void main(String[] args) {

		Computer c = new Computer();
		User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));

		u.startComputer();
		u.stopComputer();
		u.resetComputer();

	}
}

interface Command {
	void execute();
}

class Computer {
	void start() {
		System.out.println("Start");
	}

	void stop() {
		System.out.println("Stop");
	}

	void reset() {
		System.out.println("Reset");
	}
}

class StartCommand implements Command {
	Computer computer;

	public StartCommand(Computer computer) {
		this.computer = computer;
	}

	@Override
	public void execute() {
		computer.start();
	}
}

class StopCommand implements Command {
	Computer computer;

	public StopCommand(Computer computer) {
		this.computer = computer;
	}

	@Override
	public void execute() {
		computer.stop();
	}
}

class ResetCommand implements Command {
	Computer computer;

	public ResetCommand(Computer computer) {
		this.computer = computer;
	}

	@Override
	public void execute() {
		computer.reset();
	}
}


class User {
	Command start;
	Command stop;
	Command reset;

	public User(Command start, Command stop, Command reset) {
		this.start = start;
		this.stop = stop;
		this.reset = reset;
	}

	void startComputer() {
		start.execute();
	}

	void stopComputer() {
		stop.execute();
	}

	void resetComputer() {
		reset.execute();
	}
}