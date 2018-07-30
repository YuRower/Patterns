package GoF.behavioral.iterator;

public class BaseIterator {
	public static void main(String[] args) {
		ConcreteAggregate ca = new ConcreteAggregate();
		Iterator iter = ca.getIterator();
		while (iter.hasNext()) {
			System.out.println((String) iter.next());
		}
	}
}

interface Iterator {
	boolean hasNext();

	Object next();
}

interface AggregateContainer {
	Iterator getIterator();
}

class ConcreteAggregate implements AggregateContainer {
	String[] tasks = { "Task1", "Task2", "Task3" };

	@Override
	public Iterator getIterator() {
		return new TaskIterator();
	}

	private class TaskIterator implements Iterator {
		int index = 0;

		@Override
		public boolean hasNext() {
			if (index < tasks.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			return tasks[index++];
		}

	}
}