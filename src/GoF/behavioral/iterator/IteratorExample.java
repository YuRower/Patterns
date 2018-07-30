package GoF.behavioral.iterator;

import java.util.HashMap;

public class IteratorExample {
	public static void main(String[] args) {
		StudentSession session = new StudentSession();
		session.addExam("MA", 9);
		session.addExam("TFCV", 10);
		session.addExam("DS", 8);
		System.out.println("The list of exams: ");
		CustomIterator iterator = session.createIterator();
		while (!iterator.isDone()) {
			System.out.println(iterator.currentItem());
			iterator.next();
		}
	}
}

interface Aggregate {
	CustomIterator createIterator();
}

class StudentSession implements Aggregate {
	private HashMap<String, Integer> exams = new HashMap<String, Integer>();

	public CustomIterator createIterator() {
		CustomIterator iterator = new ExamsIterator(this);
		iterator.first();
		return iterator;
	}

	public void addExam(String name, Integer mark) {
		exams.put(name, mark);
	}

	public Integer getMark(String name) {
		return exams.get(name);
	}

	public HashMap<String, Integer> getExams() {
		return exams;
	}
}

interface CustomIterator {
	void first();

	void next();

	boolean isDone();

	Object currentItem();
}

class ExamsIterator implements CustomIterator {
	private StudentSession session;

	private String current;
	private java.util.Iterator<String> iterator;
	private boolean done;

	public ExamsIterator(StudentSession session) {
		this.session = session;
	}

	public Object currentItem() {
		return current;
	}

	public void first() {
		iterator = session.getExams().keySet().iterator();
		next();
	}

	public boolean isDone() {
		return done;
	}

	public void next() {
		if (iterator.hasNext()) {
			current = iterator.next();
		} else {
			done = true;
		}
	}
}