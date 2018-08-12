package GoF.structural.bridge;

interface IAction {
	double chargeInterest();

	double defineMaxSum();

	double increasePayment();

}

abstract class Action implements IAction {
	public void operation() {
	}
}

class RegularAction extends Action {
	private final static int MAX_SUM = 100;
	private final static int NORMAL_INTEREST = 3;

	@Override
	public double chargeInterest() {
		return NORMAL_INTEREST;
	}

	@Override
	public double defineMaxSum() {
		return MAX_SUM;
	}

	@Override
	public double increasePayment() {
		return 0;
	}
}

class UrgentAction extends Action {
	final static int MONTHLY_PAYMENT = 10;
	private final static int MAX_SUM = 50;

	@Override
	public double chargeInterest() {
		return 0;
	}

	@Override
	public double defineMaxSum() {
		return MAX_SUM;
	}

	@Override
	public double increasePayment() {
		return MONTHLY_PAYMENT;
	}
}

abstract class Account {
	private int id;
	private double amount;
	private Action action;

	protected Account(Action action) {
		this.action = action;
	}

	public Action getAction() {
		return action;
	}

	protected void setAction(Action action) {
		this.action = action;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public abstract boolean takeSum(double sum);

}

class DepositAccount extends Account {
	public DepositAccount(Action action) {
		super(action);
	}

	@Override
	public boolean takeSum(double sum) {
		System.out.println("Performing by deposit account:");
		double interest = getAction().chargeInterest();
		double maxSum = getAction().defineMaxSum();
		System.out.print("accountID: " + getId() + " : interest is " + interest);
		System.out.print(" : recording of changes in the state accounts");
		System.out.println(": withdrawal : " + sum);
		return true;
	}
}

class CreditAccount extends Account {
	private double limitCredit;

	public double getLimitCredit() {
		return limitCredit;
	}

	public void setLimitCredit(double limitCredit) {
		this.limitCredit = limitCredit;
	}

	public CreditAccount(Action action) {
		super(action);
	}

	public boolean takeSum(double sum) {
		System.out.println("Performing by credit account:");
		double maxSum = getAction().defineMaxSum();
		double payment = getAction().increasePayment();
		System.out.print("accountID: " + getId() + " increase monthly payments: " + payment);
		System.out.print(": recording of changes in the state accounts");
		System.out.println(" : withdrawal :" + sum);
		return true;
	}
}

public class BridgeClient {
	public static void main(String[] args) {
		Action action = new RegularAction();
		DepositAccount depositAccount = new DepositAccount(action);
		depositAccount.setId(777);
		depositAccount.setAmount(1500);
		depositAccount.takeSum(200);
		action = new UrgentAction();
		depositAccount.setAction(action); 
		depositAccount.takeSum(100);
		new CreditAccount(action).takeSum(50);
	}
}