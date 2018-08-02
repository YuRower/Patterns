package GoF.behavioral.state.exampleFour;

public class StateCourse {
	public static void main(String[] args) {
		Course course = new Course(1, "CS", new Teacher());
		course.learn();
		course.learn();
	}
}

class Course {
	private long id;
	private String name;
	private Teacher teacher;

	enum State {
		START {
			private State nextState;

			public void learning() {
				currentState = PROCESS;
			}

			public void toCancel() {
				currentState = CANCELLED;
				System.out.println("���� �������� �������");
			}
		},
		PROCESS {
			private State nextState;

			public void learning() {
				currentState = nextState;
				System.out.println("�������� ������� ���������");

			}

			public void toCancel() {
				throw new UnsupportedOperationException("���������� �������� ��� ������� ����");
			}
		},
		CANCELLED {
			private State nextState;

			public void learning() {
				currentState = START;
				System.out.println("���� ����� � ����������� ��������");
			}

			public void toCancel() {
				throw new UnsupportedOperationException("���� ��� �������");
			}
		},
		END {
			private State nextState;

			public void learning() {
				currentState = nextState;
				System.out.println("���� ����� � ������ ��������");
			}

			public void toCancel() {
				throw new UnsupportedOperationException("���� ��� ��������. ��� ���������� �������� ��� ������");
			}
		};
		private static State currentState;

		abstract void learning();

		abstract void toCancel();
	}

	public Course(long id, String name, Teacher teacher) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		State.currentState = State.START;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public static State getCurrentState() {
		System.out.println(State.currentState);
		return State.currentState;
	}

	public void learn() {
		State.currentState.learning();
	}

	public void cancel() {
		State.currentState.toCancel();
	}
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