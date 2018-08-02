package GoF.behavioral.state;

public class StateApp {
	public static void main(String[] args) {

		Human human = new Human();
		human.setState(new Work());
		for (int i = 0; i < 10; i++) {
			human.doSomething();
		}
	}
}

class Human {
	private Activity state;

	public void setState(Activity s) {
		this.state = s;
	}

	public void doSomething() {
		state.doSomething(this);
	}
}

interface Activity {
	void doSomething(Human humann);
}

class Work implements Activity {
	public void doSomething(Human context) {
		System.out.println("Работаем!!!");
		context.setState(new WeekEnd());
	}
}

class WeekEnd implements Activity {
	private int count = 0;

	public void doSomething(Human context) {
		if (count < 3) {
			System.out.println("Отдыхаем (Zzz)");
			count++;
		} else {
			context.setState(new Work());
		}
	}
}
