package GoF.creational.singleton;

public class LazySingleton {
	private LazySingleton() {
	}

	private static class SingletonHolder { 
		private final static LazySingleton INSTANCE = new LazySingleton();
	}

	public static LazySingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}