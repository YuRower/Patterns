package GoF.behavioral.state.exampleOne;

public class PurchasedState implements IPayState {
	public void check(Order order) {
		System.out.println("���������� ����� ��������");
	}

	public void purchase(Order order) {
		System.out.println("����� �������");
	}
}
