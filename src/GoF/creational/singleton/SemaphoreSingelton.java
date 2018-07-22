package GoF.creational.singleton;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SemaphoreSingelton {
	private static final int MAX_AVAILABLE = 10;
	private static Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true);
	private static ArrayList<SemaphoreSingelton> instances = new ArrayList<SemaphoreSingelton>(MAX_AVAILABLE);

	private SemaphoreSingelton() {
	}

	public static SemaphoreSingelton getInstance(int index) throws SingletonException {
		if (index >= 0 && index < instances.size()) {
			return instances.get(index);
		}
		if (semaphore.tryAcquire()) {
			SemaphoreSingelton tmp = new SemaphoreSingelton();
			instances.add(tmp);
			return tmp;
		}
		throw new SingletonException("Превышен лимит на число экземпляров");
	}
}

class SingletonException extends Exception {
	public SingletonException() {
	}

	public SingletonException(String error) {
		super(error);
	}
}