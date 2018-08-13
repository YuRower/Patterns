package GoF.structural.bridge;

public class BridgeAuto {
	public static void main(String[] args) {
		Car car = new Sedan(new Toyota());
		car.showDetails();
	}
}

abstract class Car {
	Produce produce;

	public Car(Produce produce) {
		this.produce = produce;
	}

	abstract void showType();

	void showDetails() {
		showType();
		produce.setMake();
	}

}

class Sedan extends Car {
	public Sedan(Produce make) {
		super(make);
	}

	@Override
	void showType() {
		System.out.println("Sedan");
	}
}

class Hatchback extends Car {
	public Hatchback(Produce make) {
		super(make);
	}

	@Override
	void showType() {
		System.out.println("Hatchback");
	}
}

interface Produce {
	void setMake();

}

class Toyota implements Produce {
	@Override
	public void setMake() {
		System.out.println("Toyota");
	}
}

class Subaru implements Produce {
	@Override
	public void setMake() {
		System.out.println("Subaru");
	}
}

class Mitsubishi implements Produce {
	@Override
	public void setMake() {
		System.out.println("Mitsubishi");
	}
}
