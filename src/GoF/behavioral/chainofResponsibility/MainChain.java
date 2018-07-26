package GoF.behavioral.chainofResponsibility;

 interface BaseInterface {
	public String handleRequest();
}

 class Task implements BaseInterface {
	private String message = "";

	public Task(String message) {
		this.message = message;
	}

	public String handleRequest() {
		System.out.println("message in Task: " + message);
		return message;
	}
}

 class SubTask implements BaseInterface {
	private String message = "";
	private Task root = null;

	public SubTask(Task root, String message) {

		this.root = root;
		this.message = message;
	}

	public String handleRequest() {
		System.out.println("message in SubTask: " + message);
		if (root == null) {
			return message;
		} else {
			return root.handleRequest();
		}
	}
}

 class Question implements BaseInterface {
	private String message = "";
	private SubTask parent = null;

	public Question(SubTask parent, String message) {
		this.parent = parent;
		this.message = message;
	}

	public String handleRequest() {
		System.out.println("message in Question: " + message);
		if (parent == null) {
			return message;
		} else {
			return parent.handleRequest();
		}
	}
}

public class MainChain {
	public static void main(String args[]) {
		Task root = new Task("Получить зачет");
		SubTask subTask = new SubTask(root, "Написать тест");
		Question question = new Question(subTask, "Сделать лабораторную");
		System.out.println("Message from Question < " + question.handleRequest() + " >");
	}
}