package GoF.factorymethod;

abstract class ClientAbstractOrderFactory {
	public abstract AbstractOrder createOrder();

}

class ClientSimpleOrderFactory extends ClientAbstractOrderFactory {
	@Override
	public SimpleOrder createOrder() {
		return new SimpleOrder();
	}
}

class ClientExtendedOrderFactory extends ClientAbstractOrderFactory {
	@Override
	public ExtendedOrder createOrder() {
		return new ExtendedOrder();
	}
}

class Client {
	public void someOperation(ClientAbstractOrderFactory factory) {
		AbstractOrder order = factory.createOrder();
		order.perform();
	}
}

public class ClientFactroyMethod {
	public static void main(String[] args) {
		Client client = new Client();
		client.someOperation(new ClientSimpleOrderFactory());
	}
}