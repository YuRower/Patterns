package GoF.behavioral.state.exampleThree;

interface IState {
	void learning();

	void toCancel();
}

abstract class AbstractState implements IState {
	protected IState nextState;
}

class Teacher {
	private String name;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

class Course {
	private long id;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Teacher teacher;
	private IState currentState;

	public Course(long id, String name, Teacher teacher) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		currentState = new StartState();
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public IState getCurrentState() {
		System.out.println(currentState.getClass().getSimpleName());
		return currentState;
	}

	public void learning() {
		currentState.learning();
	}

	public void cancel() {
		currentState.toCancel();
	}

	public class StartState implements IState {
		private IState nextState;

		public void learning() {
			if (Course.this.teacher != null) {
				currentState = new ProcessState();
				System.out.println("обучение начато");
			} else {
				this.toCancel();
				System.out.println("обучение не начато: нет преподавателя");
			}
		}

		public void toCancel() {
			currentState = new CancelledState();
			System.out.println("курс обучения отменен");
		}
	}

	public class ProcessState implements IState {
		private IState nextState = new EndState();

		public void learning() {
			currentState = nextState;
			System.out.println("обучение успешно завершено");

		}

		public void toCancel() {
			throw new UnsupportedOperationException("Невозможно отменить уже начатый курс");
		}
	}

	public class EndState implements IState {
		private IState nextState = new StartState();

		public void learning() {
			currentState = nextState;
			Course.this.setTeacher(new Teacher());
			System.out.println("курс готов к началу обучения");
		}

		public void toCancel() {
			throw new UnsupportedOperationException("Курс уже закончен. Его проведение отменять нет смысла");
		}
	}

	public class CancelledState implements IState {
		private IState nextState = new EndState();

		public void learning() {
			currentState = new StartState();
			Course.this.setTeacher(new Teacher());
			System.out.println("курс готов к продолжению обучения");
		}

		public void toCancel() {
			throw new UnsupportedOperationException("Курс уже отменен");
		}
	}
}

public class StateCourse {
	public static void main(String[] args) {
		Course course = new Course(1, null, null);
		course.learning();
	//	course.setTeacher(new Teacher());
	//	course.setName("CS");
		course.learning();
		course.learning();
	//	course.cancel();
		course.learning();





		
		
		

	}
}
