package GoF.factorymethod;

abstract class Watch {
	public abstract void showTime();
}

class WristWatch extends Watch {
	public void showTime() {
		System.out.println("Wrist Watch");
	}
}

class TableWatch extends Watch {
	public void showTime() {
		System.out.println("Table Watch");
	}
}

enum TypeOrder {
	WRIST, TABLE
}

class OrderFactory {
	public static Watch createWatchFromFactory(String type) {
		TypeOrder sign = TypeOrder.valueOf(type.toUpperCase());
		switch (sign) {
		case WRIST:
			return new WristWatch();
		case TABLE:
			return new TableWatch();
		default:
			throw new EnumConstantNotPresentException(TypeOrder.class, sign.name());
		}

	}

}

public class EnumFactoryMethod {
	public static void main(String args[]) {
		Watch ob1 = OrderFactory.createWatchFromFactory("wrist");
		Watch ob2 = OrderFactory.createWatchFromFactory("table");
		ob1.showTime();
		ob2.showTime();
	}
}