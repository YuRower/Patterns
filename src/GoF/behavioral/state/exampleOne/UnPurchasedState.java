package GoF.behavioral.state.exampleOne;

public class UnPurchasedState implements IPayState {
	public void check(Order order) {
		double percent = 0;
		if (order.getDays() <= 0) {
			percent = order.getCost() + order.PERCENT;
			order.setCost(order.getCost() + percent);
		}
		System.out.println("Заказ не оплачен: штраф ->" + percent);
	}

	public void purchase(Order order) {
		order.setCurrentOrderState(new PurchasedState());
	}
}

