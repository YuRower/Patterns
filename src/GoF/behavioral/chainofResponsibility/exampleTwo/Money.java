package GoF.behavioral.chainofResponsibility.exampleTwo;

public class Money {
	private int amt;

	public Money(int amt) {
		setAmt(amt);
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		if (amt > 0 && amt < 20_000 && amt % Note.UA50 == 0) {
			this.amt = amt;
		} else {
			throw new RuntimeException("Сумма денег должна быть не более 10 000 и кратная 50");
		}
	}
}