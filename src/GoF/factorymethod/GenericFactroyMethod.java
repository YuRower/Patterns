package GoF.factorymethod;

abstract class AbstractOrderFactory<T extends AbstractOrder> {
	public abstract T createInstance();
}

class SimpleOrderFactory extends AbstractOrderFactory<SimpleOrder> {
	@Override
	public SimpleOrder createInstance() {
		return new SimpleOrder();
	}
}

class ExtendedOrderFactory extends AbstractOrderFactory<ExtendedOrder> {
	@Override
	public ExtendedOrder createInstance() {
		return new ExtendedOrder();
	}
}

abstract class AbstractOrder {
	public abstract void perform();
}

class SimpleOrder extends AbstractOrder {
	public void perform() {
		System.out.println("Simple order");
	}
}

class ExtendedOrder extends AbstractOrder {
	public void perform() {
		System.out.println("Extended order");
	}
}

public class GenericFactroyMethod {
	public static void main(String[] args) {
		AbstractOrderFactory<SimpleOrder> ob1 = new SimpleOrderFactory();
		AbstractOrder ord = ob1.createInstance();
		ord.perform();
	}
}