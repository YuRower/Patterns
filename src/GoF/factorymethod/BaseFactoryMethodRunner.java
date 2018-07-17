package GoF.factorymethod;

 interface Product {
	void doSomething();
}

 class ConcreteProduct implements Product {
	public void doSomething() {
		System.out.println("Concrete Product");
	}
}

 abstract class Creator {
	public abstract Product factoryMethod();

	public void someOperation() {
		System.out.println("someOperation");
	}
}

 class ConcreteCreator extends Creator {
	public Product factoryMethod() {
		this.someOperation();
		return new ConcreteProduct();
	}
}

public class BaseFactoryMethodRunner {
	public static void main(String[] args) {
		Creator creator = new ConcreteCreator();
		Product product = creator.factoryMethod();
		product.doSomething();
	}
}