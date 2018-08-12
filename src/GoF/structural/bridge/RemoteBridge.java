package GoF.structural.bridge;

interface Device {
	public boolean isEnabled();

	public void enable();

	public void disable();

	public int getVolume();

	public void setVolume(int percent);

	public int getChannel();

	public void setChannel(int channel);

	public void printStatus();
}

class Radio implements Device {
	private boolean on = false;
	private int volume = 30;
	private int channel = 1;

	@Override
	public boolean isEnabled() {
		return on;
	}

	@Override
	public void enable() {
		on = true;
	}

	@Override
	public void disable() {
		on = false;
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public void setVolume(int volume) {
		if (volume > 100) {
			volume = 100;
		} else if (volume < 0) {
			volume = 0;
		}
		this.volume = volume;
	}

	@Override
	public int getChannel() {
		return channel;
	}

	@Override
	public void setChannel(int channel) {
		this.channel = channel;
	}

	@Override
	public void printStatus() {
		System.out.println("------------------------------------");
		System.out.println("| I'm radio.");
		System.out.println("| I'm " + (on ? "enabled" : "disabled"));
		System.out.println("| Current volume is " + volume + "%");
		System.out.println("| Current channel is " + channel);
		System.out.println("------------------------------------\n");
	}
}

class Tv implements Device {
	private boolean on = false;
	private int volume = 30;
	private int channel = 1;

	@Override
	public boolean isEnabled() {
		return on;
	}

	@Override
	public void enable() {
		on = true;
	}

	@Override
	public void disable() {
		on = false;
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public void setVolume(int volume) {
		if (volume > 100) {
			volume = 100;
		} else if (volume < 0) {
			volume = 0;
		}
		this.volume = volume;
	}

	@Override
	public int getChannel() {
		return channel;
	}

	@Override
	public void setChannel(int channel) {
		this.channel = channel;
	}

	@Override
	public void printStatus() {
		System.out.println("------------------------------------");
		System.out.println("| I'm TV set.");
		System.out.println("| I'm " + (on ? "enabled" : "disabled"));
		System.out.println("| Current volume is " + volume + "%");
		System.out.println("| Current channel is " + channel);
		System.out.println("------------------------------------\n");
	}
}

interface Remote {
	public void power();

	public void volumeDown();

	public void volumeUp();

	public void channelDown();

	public void channelUp();
}

class BasicRemote implements Remote {
	protected Device device;

	public BasicRemote() {
	}

	public BasicRemote(Device device) {
		this.device = device;
	}

	@Override
	public void power() {
		System.out.println("Remote: power toggle");
		if (device.isEnabled()) {
			device.disable();
		} else {
			device.enable();
		}
	}

	@Override
	public void volumeDown() {
		System.out.println("Remote: volume down");
		device.setVolume(device.getVolume() - 10);
	}

	@Override
	public void volumeUp() {
		System.out.println("Remote: volume up");
		device.setVolume(device.getVolume() + 10);
	}

	@Override
	public void channelDown() {
		System.out.println("Remote: channel down");
		device.setChannel(device.getChannel() - 1);
	}

	@Override
	public void channelUp() {
		System.out.println("Remote: channel up");
		device.setChannel(device.getChannel() + 1);
	}
}

class AdvancedRemote extends BasicRemote {
	public AdvancedRemote() {
	}

	public AdvancedRemote(Device device) {
		super.device = device;
	}

	public void mute() {
		System.out.println("Remote: mute");
		device.setVolume(0);
	}
}

class SuperAdvancedRemote extends AdvancedRemote {

	public SuperAdvancedRemote(Device device) {
		super.device = device;
	}

	public void geolocation() {
		System.out.println("Remote: geolocation");
		device.setVolume(0);
	}
}

public class RemoteBridge {
	public static void main(String[] args) {
		testDevice(new Tv());
		testDevice(new Radio());
	}

	public static void testDevice(Device device) {
		System.out.println("Tests with basic remote.");
		BasicRemote basicRemote = new BasicRemote(device);
		basicRemote.power();
		device.printStatus();

		System.out.println("Tests with advanced remote.");
		AdvancedRemote advancedRemote = new AdvancedRemote(device);
		advancedRemote.power();
		advancedRemote.mute();
		device.printStatus();

		SuperAdvancedRemote superRemote = new SuperAdvancedRemote(device);
		superRemote.power();
		superRemote.mute();
		superRemote.geolocation();
		device.printStatus();
	}
}
