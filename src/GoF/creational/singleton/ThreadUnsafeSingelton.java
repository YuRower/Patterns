package GoF.creational.singleton;

public class ThreadUnsafeSingelton {

	private static ThreadUnsafeSingelton instance;

	private ThreadUnsafeSingelton() {
	}

	public static ThreadUnsafeSingelton getInstance() {
		if (instance == null) {
			instance = new ThreadUnsafeSingelton();
		}
		return instance;
	}
}
