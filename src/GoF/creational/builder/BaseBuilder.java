package GoF.creational.builder;

class Product {

	private int part1;
	private String part2;

	public void setPart1(int part1) {
		this.part1 = part1;
	}

	public void setPart2(String part2) {
		this.part2 = part2;
	}

	@Override
	public String toString() {
		return "Product [part1=" + part1 + ", part2=" + part2 + "]";
	}
}

interface Builder {
	Product getProduct();

	void buildPart1(int part1);

	void buildPart2(String part2);
}

class ConcreteBuilder implements Builder {
	private Product product = new Product();

	public Product getProduct() {
		return product;
	}

	public void buildPart1(int part1) {
		product.setPart1(part1);
	}

	public void buildPart2(String part2) {
		product.setPart2(part2);
	}
}

class DirectorD {
	private Builder builder;

	public void setBuilder(Builder builderMode) {
		builder = builderMode;
	}

	public Product construct(String sourceName) {

		builder.buildPart1(1);
		builder.buildPart2("2");
		return builder.getProduct();
	}
}

public class BaseBuilder {
	public static void main(String[] args) {
		DirectorD director = new DirectorD();
		director.setBuilder(new ConcreteBuilder());
		Product prod = director.construct("sourcePath");
		System.out.println(prod);
	}
}