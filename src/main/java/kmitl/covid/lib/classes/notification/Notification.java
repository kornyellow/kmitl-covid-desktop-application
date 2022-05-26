package kmitl.covid.lib.classes.notification;

import kmitl.covid.lib.classes.user.User;
import kmitl.covid.lib.korn.kornutil.KornDateTime;

public class Notification {
	public Notification() {
		this.id = -1;
	}
	public Notification(int id) {
		this.id = id;
	}

	private final int id;
	private User user;
	private String title;
	private String data;
	private KornDateTime date;
	private boolean isRead;

	public int getID() {
		return this.id;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getData() {
		return this.data;
	}
	public void setText(String data) {
		this.data = data;
	}
	public KornDateTime getDate() {
		return this.date;
	}
	public void setDate(KornDateTime date) {
		this.date = date;
	}
	public boolean isRead() {
		return this.isRead;
	}
	public void setIsRead(boolean isRead) {
		this.isRead = isRead;
	}
}