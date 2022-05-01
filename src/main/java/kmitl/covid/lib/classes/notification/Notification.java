package kmitl.covid.lib.classes.notification;

import kmitl.covid.lib.classes.user.User;

public class Notification {
	public Notification() {this.id = -1; }
	public Notification(int id) {this.id = id;}

	private final int id;
	private User user;
	private String text;
	private boolean isRead;

	public int getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getText(){
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean read) {
		isRead = read;
	}

}

