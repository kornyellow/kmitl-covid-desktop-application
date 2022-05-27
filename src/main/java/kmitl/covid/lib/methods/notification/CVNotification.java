package kmitl.covid.lib.methods.notification;

import kmitl.covid.content.user.NotificationPage;
import kmitl.covid.lib.classes.notification.Notification;
import kmitl.covid.lib.classes.user.User;
import kmitl.covid.lib.korn.kornquery.KornInsertMySQL;
import kmitl.covid.lib.korn.kornquery.KornMySQLOrder;
import kmitl.covid.lib.korn.kornquery.KornMySQLValue;
import kmitl.covid.lib.korn.kornquery.KornQuery;
import kmitl.covid.lib.korn.kornquery.KornSelectMySQL;
import kmitl.covid.lib.korn.kornquery.KornUpdateMySQL;
import kmitl.covid.lib.korn.kornutil.KornDateTime;
import kmitl.covid.lib.methods.connectivity.CVDB;
import kmitl.covid.lib.methods.user.CVUser;
import kmitl.covid.template.TemplateHeader;

import java.util.ArrayList;

public class CVNotification {
	public static Notification getNotification(int id) {
		KornSelectMySQL select = CVNotification.getQueryObject();
		select.table("notification");

		select.where("n_id", String.valueOf(id));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVNotification.processObject(query);
	}
	public static ArrayList<Notification> getNotificationsUnRead(User user) {
		KornSelectMySQL select = CVNotification.getQueryObject();
		select.table("notification");

		select.where("n_u_id", String.valueOf(user.getID()));
		select.where("n_is_read", String.valueOf(false));

		select.orderBy("n_id", KornMySQLOrder.DESC);

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVNotification.processObjectArray(query);
	}
	public static int insertNotification(Notification notification) {
		KornInsertMySQL insert = new KornInsertMySQL();
		insert.table("notification");

		insert.insert("n_u_id", String.valueOf(notification.getUser().getID()));
		insert.insert("n_title", notification.getTitle());
		insert.insert("n_data", notification.getData());
		insert.insert("n_date", notification.getDate().getMySQLDateTimeFormat());
		insert.insert("n_is_read", String.valueOf(notification.isRead() ? 1 : 0));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(insert);
		query.close();

		return query.getInsertedID();
	}
	private static KornSelectMySQL getQueryObject() {
		KornSelectMySQL select = new KornSelectMySQL();
		select.select(
			"n_id",
			"n_u_id",
			"n_title",
			"n_data",
			"n_date",
			"n_is_read"
		);

		return select;
	}
	private static ArrayList<Notification> processObjectArray(KornQuery query) {
		ArrayList<Notification> result = new ArrayList<>();

		KornMySQLValue n_id = new KornMySQLValue();
		KornMySQLValue n_u_id = new KornMySQLValue();
		KornMySQLValue n_title = new KornMySQLValue();
		KornMySQLValue n_data = new KornMySQLValue();
		KornMySQLValue n_date = new KornMySQLValue();
		KornMySQLValue n_is_read = new KornMySQLValue();

		query.bindValue("n_id", n_id);
		query.bindValue("n_u_id", n_u_id);
		query.bindValue("n_title", n_title);
		query.bindValue("n_data", n_data);
		query.bindValue("n_date", n_date);
		query.bindValue("n_is_read", n_is_read);

		while (query.nextBind()) {
			Notification notification = new Notification(Integer.parseInt(n_id.getValue()));

			notification.setUser(CVUser.getUser(Integer.parseInt(n_u_id.getValue())));
			notification.setTitle(n_title.getValue());
			notification.setText(n_data.getValue());
			notification.setDate(KornDateTime.createFromMySQLDateTime(n_date.getValue()));
			notification.setIsRead("1".equals(n_is_read.getValue()));

			result.add(notification);
		}
		query.close();

		return result;
	}
	private static Notification processObject(KornQuery query) {
		ArrayList<Notification> notifications = CVNotification.processObjectArray(query);
		if (notifications.isEmpty()) return null;
		return notifications.get(0);
	}

	public static void pushNotification(User user, String title, String text) {
		Notification notification = new Notification();
		notification.setUser(user);
		notification.setTitle(title);
		notification.setText(text);
		notification.setDate(new KornDateTime());

		CVNotification.insertNotification(notification);
		TemplateHeader.reset();
		NotificationPage.reset();
	}
	public static void readNotifications(User user) {
		KornUpdateMySQL update = new KornUpdateMySQL();
		update.table("notification");

		update.set("n_is_read", "1");

		update.where("n_u_id", String.valueOf(user.getID()));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(update);
		query.close();

		TemplateHeader.reset();
		NotificationPage.reset();
	}
}
