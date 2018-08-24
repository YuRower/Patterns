package GoF.structural.proxy;

interface BaseInterface {
	public void perform();
}

class BaseClass implements BaseInterface {
	public void perform() {
		System.out.println("...performing...");
	}
}

class Proxy implements BaseInterface {
	private BaseClass base = null;

	public void perform() {
		base = new BaseClass();
		base.perform();
	}
}

public class BaseProxy {
	public static void main(String args[]) {
		BaseInterface base = new Proxy();
		base.perform();
	}
}