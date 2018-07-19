package GoF.creational.abstractfactory;

interface AbstractProduct {
	void info();
}

class ConcreteProduct implements AbstractProduct {

	public void info() {
		System.out.println("Concrete product");
	}
}

interface AbstractFactory {
	public AbstractProduct createProduct();
}

class ConcreteFactory implements AbstractFactory {
	public AbstractProduct createProduct() {
		System.out.println("Creating concrete product");
		AbstractProduct product = new ConcreteProduct();
		return product;
	}
}

class ActionClient {
	private AbstractFactory abstractFactory;
	private AbstractProduct abstractProduct;

	public void action() {
		abstractProduct = abstractFactory.createProduct();
		abstractProduct.info();
	}

	public void setAbstractFactory(AbstractFactory factory) {
		abstractFactory = factory;
	}
}

public class BaseAbstractFactoryRunner {
	public static void main(String[] args) {
		ActionClient client = new ActionClient();
		client.setAbstractFactory(new ConcreteFactory());
		client.action();
	}
}