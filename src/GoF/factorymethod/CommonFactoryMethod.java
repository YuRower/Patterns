package GoF.factorymethod;

public class CommonFactoryMethod {
	public static void main(String[] args) {
		OrderCreator ob1 = getFactoryMethod("With");
		IOrder ord = ob1.createOrder();
		ord.makeAnOrder();

	}

	public static OrderCreator getFactoryMethod(String marker) {
		if (marker.equals("With")) {
			return new WithDeliveryCreator();
		} else if (marker.equals("Without")) {
			return new WithoutDeliveryCreator();
		}
		throw new RuntimeException("not Found");
	}
}

interface IOrder {
	void makeAnOrder();
}

class WithDelivery implements IOrder {

	@Override
	public void makeAnOrder() {
		System.out.println("With Delivery");
	}
}

class WithoutDelivery implements IOrder {
	@Override
	public void makeAnOrder() {
		System.out.println("Without Delivery");
	}

}

interface OrderCreator {
	IOrder createOrder();
}

class WithDeliveryCreator implements OrderCreator {

	@Override
	public IOrder createOrder() {
		return new WithDelivery();

	}

}

class WithoutDeliveryCreator implements OrderCreator {
	@Override
	public IOrder createOrder() {
		return new WithoutDelivery();

	}

}