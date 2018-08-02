package GoF.behavioral.state.exampleTwo;

public class StateTCPApp {
	public static void main(String[] args) {
		TCPConnection conn = new TCPConnection();
		conn.open();
		conn.synchronize();
		conn.close();
	}
}

class TCPConnection {
	private TCPState state;

	public TCPConnection() {
		state = new TCPClosedState();
	}

	public void open() {
		state.open(this);
		this.changeState(new TCPOpenState());
	}

	public void close() {
		state.close(this);
		this.changeState(new TCPClosedState());
	}

	public void synchronize() {
		state.synchronize(this);
		this.changeState(new TCPEstablishedState());
	}

	public void changeState(TCPState state) {
		this.state = state;
	}
}

interface TCPState {
	void open(TCPConnection context);

	void close(TCPConnection context);

	void synchronize(TCPConnection context);
}

class TCPClosedState implements TCPState {
	@Override
	public void open(TCPConnection context) {
		System.out.println("State Closed: Opening");
	}

	@Override
	public void close(TCPConnection context) {
		System.out.println("State Closed: Closing");
	}

	@Override
	public void synchronize(TCPConnection context) {
		System.out.println("State Closed: Synchronizing");
	}
}

class TCPOpenState implements TCPState {
	@Override
	public void open(TCPConnection context) {
		System.out.println("State Open: Opening");
	}

	@Override
	public void close(TCPConnection context) {
		System.out.println("State Open: Closing");
	}

	@Override
	public void synchronize(TCPConnection context) {
		System.out.println("State Open: Synchronizing");
	}
}

class TCPEstablishedState implements TCPState {
	@Override
	public void open(TCPConnection context) {
		System.out.println("State Established: Opening");
	}

	@Override
	public void close(TCPConnection context) {
		System.out.println("State Established: Closing");
	}

	@Override
	public void synchronize(TCPConnection context) {
		System.out.println("State Established: Synchronizing");
	}
}