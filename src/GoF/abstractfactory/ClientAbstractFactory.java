package GoF.abstractfactory;

abstract class AbstractMediaFactory {
	public abstract TCPMediaContent createTCPObject();

	public abstract UDPMediaContent createUDPObject();
}

class AudioFactory extends AbstractMediaFactory {
	public TCPMediaContent createTCPObject() {
		System.out.println("Creating TCP Audio Content");
		return new TCPAudioContent();
	}

	public UDPMediaContent createUDPObject() {
		System.out.println("Creating UDP Audio Content");

		return new UDPAudioContent();
	}
}

class VideoFactory extends AbstractMediaFactory {
	public TCPMediaContent createTCPObject() {
		System.out.println("Creating TCP Video Content");

		return new TCPVideoContent();
	}

	public UDPMediaContent createUDPObject() {
		System.out.println("Creating UDP Video Content");

		return new UDPVideoContent();
	}
}

abstract class TCPMediaContent {
	abstract void play();
}

class TCPAudioContent extends TCPMediaContent {
	void play() {
		System.out.println("Play TCP Audio Content");
	}
}

class TCPVideoContent extends TCPMediaContent {
	void play() {
		System.out.println("Play TCP Video Content");

	}
}

abstract class UDPMediaContent {
	abstract void play();

	abstract void transform();
}

class UDPAudioContent extends UDPMediaContent {
	void play() {
		System.out.println("Play UDP Audio Content");

	}

	void transform() {
		System.out.println("Transform UDP Audio Content");

	}
}

class UDPVideoContent extends UDPMediaContent {
	void play() {
		System.out.println("Play UDP Video Content");

	}

	void transform() {
		System.out.println("Transform UDP Video Content");

	}
}

class Client {
	private UDPMediaContent contentUDP;
	private TCPMediaContent contentTCP;

	public void makeMediaFactoryWork(AbstractMediaFactory factory) {
		contentUDP = factory.createUDPObject();
		contentTCP = factory.createTCPObject();
		contentUDP.play();
		contentUDP.transform();
		contentTCP.play();
	}
}

public class ClientAbstractFactory {
	public static void main(String[] args) {
		Client client = new Client();
		client.makeMediaFactoryWork(new AudioFactory());
	}
}