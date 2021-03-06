package GoF.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
	public static void main(String[] args) {

		TextChat chat = new TextChat();

		User admin = new Admin(chat, "���� ������");
		User u1 = new SimpleUser(chat, "����");
		User u2 = new SimpleUser(chat, "����");
		User u3 = new SimpleUser(chat, "����");
		u2.setEnable(false);

		chat.setAdmin(admin);
		chat.addUser(u1);
		chat.addUser(u2);
		chat.addUser(u3);

		admin.sendMessage("������");
	}
}

abstract class User {
	Chat chat;
	String name;
	boolean isEnable = true;

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public User(Chat chat, String name) {
		this.chat = chat;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void sendMessage(String message) {
		chat.sendMessage(message, this);
	}

	abstract void getMessage(String message);

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
}

class Admin extends User {

	public Admin(Chat chat, String name) {
		super(chat, name);
	}

	public void getMessage(String message) {
		System.out.println("������������� " + getName() + " �������� ��������� '" + message + "'");
	}
}

class SimpleUser extends User {
	public SimpleUser(Chat chat, String name) {
		super(chat, name);
	}

	public void getMessage(String message) {
		System.out.println("������������ " + getName() + " �������� ��������� '" + message + "'");
	}
}

interface Chat {
	void sendMessage(String message, User user);
}

class TextChat implements Chat {
	User admin;
	List<User> users = new ArrayList<>();

	public void setAdmin(User admin) {
		if (admin != null && admin instanceof Admin) {
			this.admin = admin;
		} else {
			throw new RuntimeException("�� ������� ����");
		}
	}

	public void addUser(User u) {
		if (admin == null) {
			throw new RuntimeException("� ���� ��� ������!");
		}

		if (u instanceof SimpleUser) {
			users.add(u);
		} else {
			throw new RuntimeException("����� �� ����� ������� � ������ ���!");
		}
	}

	public void sendMessage(String message, User user) {
		if (user instanceof Admin) {
			for (User u : users) {
				u.getMessage(user.getName() + ": " + message);
			}
		}
		if (user instanceof SimpleUser) {
			for (User u : users) {
				if (u != user && u.isEnable())
					u.getMessage(user.getName() + ": " + message);
			}
			if (admin.isEnable())
				admin.getMessage(user.getName() + ": " + message);
		}
	}

}