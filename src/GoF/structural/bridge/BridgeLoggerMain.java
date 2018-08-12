package GoF.structural.bridge;

interface LoggerImplementor {
	void logToConsole();

	void logToFile();

	void logToSocket();
}

class MultiThreadedLogger implements LoggerImplementor {
	@Override
	public void logToConsole() {
		System.out.println("Multithreaded console log");
	}

	@Override
	public void logToFile() {
		System.out.println("Multithreaded file log");
	}

	@Override
	public void logToSocket() {
		System.out.println("Multithreaded socket log");
	}
}

class SingleThreadedLogger implements LoggerImplementor {
	@Override
	public void logToConsole() {

		System.out.println("Singlethreaded console log");
	}

	@Override
	public void logToFile() {
		System.out.println("Singlethreaded file log");
	}

	@Override
	public void logToSocket() {
		System.out.println("Singlethreaded socket log");
	}
}

abstract class Logger {
	protected LoggerImplementor logger;

	public Logger() {
	}

	public Logger(LoggerImplementor logger) {
		this.logger = logger;
	}

	public void setLogger(LoggerImplementor logger) {
		this.logger = logger;
	}

	public abstract void log();
}

class ConsoleLogger extends Logger {
	public ConsoleLogger() {
	}

	public ConsoleLogger(LoggerImplementor logger) {
		super(logger);
	}

	public void log() {
		logger.logToConsole();
	}
}

class FileLogger extends Logger {
	public FileLogger() {
	}

	public FileLogger(LoggerImplementor logger) {
		super(logger);
	}

	public void log() {
		logger.logToFile();
	}
}

public class BridgeLoggerMain {
	public static void main(String[] args) {
		LoggerImplementor loggerImpl = new SingleThreadedLogger();
		Logger logger = new ConsoleLogger(loggerImpl);
		logger.log();
		new FileLogger(loggerImpl).log();
		loggerImpl = new MultiThreadedLogger();
		logger.setLogger(loggerImpl);
		logger.log();
		new FileLogger(loggerImpl).log();
	}
}
