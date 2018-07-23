package GoF.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class ProRunner {
	public static void main(String[] args) {
		ArrayList<Issue> issueList = new ArrayList<Issue>() {
			{
				this.add(new Book(615, "Steve McConnell", "Code Complete", 2012));
				this.add(new Book(453, "Bruce Eckel", "Thinking in Java", 2006));
				this.add(new Book(721, "Joshua Bloch", "Effective Java", 2008));
				this.add(new Magazine(1009, 9, "PC Magazine", 2012));
			}
		};
		IssueCacheClient cache = new IssueCacheClient(issueList);
		Issue copy = cache.cloneElementById(453);
		System.out.println(issueList);
		System.out.println(copy);
	}
}

abstract class Issue implements Cloneable {
	private Integer id;
	private String name;
	private int year;

	public Issue(Integer id, String name, int year) {
		this.id = id;
		this.name = name;
		this.year = year;
	}

	@Override
	protected Issue clone() {
		Issue cloned = null;
		try {
			cloned = (Issue) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}

	public Object getId() {
		return id;
	}
}

class Book extends Issue {
	private String author;

	public Book(Integer id, String author, String name, int year) {
		super(id, name, year);
		this.author = author;
	}
}

class Magazine extends Issue {
	private int number;

	public Magazine(Integer id, int number, String name, int year) {
		super(id, name, year);
		this.number = number;
	}
}

class IssueCacheClient implements Client<Issue> {
	private List<Issue> cache;

	public IssueCacheClient() {
		cache = new ArrayList<Issue>();
	}

	public IssueCacheClient(List<Issue> issueList) {
		this.cache = issueList;
	}

	@Override
	public Issue cloneElementById(Integer id) {
		for (Issue issue : cache) {
			if (issue.getId().equals(id)) {
				return issue.clone();
			}
		}
		throw new IllegalArgumentException("illegal ID " + id);
	}

	@Override
	public List<Issue> cloneElements(Object... param) {
		ArrayList<Issue> list = new ArrayList<Issue>();
		return list;
	}
}

interface Client<T> {
	T cloneElementById(Integer id);

	List<T> cloneElements(Object... param);
}