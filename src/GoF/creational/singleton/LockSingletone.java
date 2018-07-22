package GoF.creational.singleton;

import java.util.concurrent.locks.ReentrantLock;

public class LockSingletone {
	private static LockSingletone instance = null;
	private static ReentrantLock lock = new ReentrantLock();

	private LockSingletone() {
	}

	public static LockSingletone getInstance() {
		lock.lock(); 
		try {
			if (instance == null) {
				instance = new LockSingletone();
			}
		} finally {
			lock.unlock(); 
		}
		return instance;
	}
}