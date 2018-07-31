package GoF.behavioral.mediator;

public class RunnerDemoMediator {
	public static void main(String[] args) {
		ConcreteMediator cm = new ConcreteMediator();

		cm.setTrue();
		cm.setFalse();
		cm.setDifferent();
	}
}

interface Colleague {
	void changetFlag(boolean flag);
}

class ConcreteColleagueOne implements Colleague {
	private boolean flag;

	public void changetFlag(boolean flag) {
		this.flag = flag;
	}
}

class ConcreteColleagueTwo implements Colleague {
	private boolean flag;

	public void changetFlag(boolean flag) {
		this.flag = flag;
	}
}

interface Mediator {
	void setTrue();

	void setFalse();

	void setDifferent();
}

class ConcreteMediator implements Mediator {
	private ConcreteColleagueOne colleagueOne;
	private ConcreteColleagueTwo colleagueTwo;

	public ConcreteMediator() {
		colleagueOne = new ConcreteColleagueOne();
		colleagueTwo = new ConcreteColleagueTwo();
	}

	public void setTrue() {
		colleagueOne.changetFlag(true);
		colleagueTwo.changetFlag(true);
		System.out.println("Both set to true");
	}

	public void setFalse() {
		colleagueOne.changetFlag(false);
		colleagueTwo.changetFlag(false);
		System.out.println("Both set to false");
	}

	public void setDifferent() {
		colleagueOne.changetFlag(true);
		colleagueTwo.changetFlag(false);
		System.out.println("First - true. Second - false");
	}
}