package kmitl.covid.lib.methods.user;

import kmitl.covid.lib.classes.user.User;
import kmitl.covid.lib.enums.EnumGender;
import kmitl.covid.lib.enums.EnumNameTitle;
import kmitl.covid.lib.korn.kornquery.KornInsertMySQL;
import kmitl.covid.lib.korn.kornquery.KornMySQLValue;
import kmitl.covid.lib.korn.kornquery.KornQuery;
import kmitl.covid.lib.korn.kornquery.KornSelectMySQL;
import kmitl.covid.lib.korn.kornquery.KornUpdateMySQL;
import kmitl.covid.lib.korn.kornutil.KornDateTime;
import kmitl.covid.lib.korn.kornutil.KornHash;
import kmitl.covid.lib.methods.connectivity.CVDB;

import java.util.ArrayList;

public class CVUser {
	public static User getUser(int id) {
		KornSelectMySQL select = CVUser.getQueryObject();
		select.table("user");

		select.where("u_id", String.valueOf(id));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVUser.processObject(query);
	}
	public static ArrayList<User> getUsers() {
		KornSelectMySQL select = CVUser.getQueryObject();
		select.table("user");

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVUser.processObjectArray(query);
	}
	public static int insertUser(User user) {
		KornInsertMySQL insert = new KornInsertMySQL();
		insert.table("user");

		insert.insert("u_username", user.getUsername());
		insert.insert("u_password", KornHash.getHash(user.getPassword()));
		insert.insert("u_nametitle", user.getNameTitle().name());
		insert.insert("u_firstname", user.getFirstName());
		insert.insert("u_lastname", user.getLastName());
		insert.insert("u_gender", user.getGender().name());
		insert.insert("u_national_id", user.getNationalID());
		insert.insert("u_birthdate", user.getBirthDate().getMySQLDateTimeFormat());
		insert.insert("u_email", user.getEmail());
		insert.insert("u_address", user.getAddress());
		insert.insert("u_telephone_number", user.getTelephoneNumber());

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(insert);
		query.close();

		return query.getInsertedID();
	}
	public static int updateUser(User user) {
		KornUpdateMySQL update = new KornUpdateMySQL();
		update.table("user");

		update.set("u_nametitle", user.getNameTitle().name());
		update.set("u_firstname", user.getFirstName());
		update.set("u_lastname", user.getLastName());
		update.set("u_gender", user.getGender().name());
		update.set("u_birthdate", user.getBirthDate().getMySQLDateTimeFormat());
		update.set("u_email", user.getEmail());
		update.set("u_address", user.getAddress());
		update.set("u_telephone_number", user.getTelephoneNumber());

		update.where("u_id", String.valueOf(user.getID()));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(update);
		query.close();

		return query.getAffectedRows();
	}
	private static KornSelectMySQL getQueryObject() {
		KornSelectMySQL select = new KornSelectMySQL();
		select.select(
			"u_id",
			"u_username",
			"u_password",
			"u_last_login",
			"u_nametitle",
			"u_firstname",
			"u_lastname",
			"u_gender",
			"u_national_id",
			"u_birthdate",
			"u_email",
			"u_address",
			"u_telephone_number"
		);

		return select;
	}
	private static ArrayList<User> processObjectArray(KornQuery query) {
		ArrayList<User> result = new ArrayList<>();

		KornMySQLValue u_id = new KornMySQLValue();
		KornMySQLValue u_username = new KornMySQLValue();
		KornMySQLValue u_password = new KornMySQLValue();
		KornMySQLValue u_last_login = new KornMySQLValue();
		KornMySQLValue u_nametitle = new KornMySQLValue();
		KornMySQLValue u_firstname = new KornMySQLValue();
		KornMySQLValue u_lastname = new KornMySQLValue();
		KornMySQLValue u_gender = new KornMySQLValue();
		KornMySQLValue u_national_id = new KornMySQLValue();
		KornMySQLValue u_birthdate = new KornMySQLValue();
		KornMySQLValue u_email = new KornMySQLValue();
		KornMySQLValue u_address = new KornMySQLValue();
		KornMySQLValue u_telephone_number = new KornMySQLValue();

		query.bindValue("u_id", u_id);
		query.bindValue("u_username", u_username);
		query.bindValue("u_password", u_password);
		query.bindValue("u_last_login", u_last_login);
		query.bindValue("u_nametitle", u_nametitle);
		query.bindValue("u_firstname", u_firstname);
		query.bindValue("u_lastname", u_lastname);
		query.bindValue("u_gender", u_gender);
		query.bindValue("u_national_id", u_national_id);
		query.bindValue("u_birthdate", u_birthdate);
		query.bindValue("u_email", u_email);
		query.bindValue("u_address", u_address);
		query.bindValue("u_telephone_number", u_telephone_number);

		while (query.nextBind()) {
			User user = new User(Integer.parseInt(u_id.getValue()));

			user.setUsername(u_username.getValue());
			user.setPassword(u_password.getValue());
			if (user.getLastLogin() != null)
				user.setLastLogin(KornDateTime.createFromMySQLDateTime(u_last_login.getValue()));

			user.setNameTitle(EnumNameTitle.valueOf(u_nametitle.getValue()));
			user.setFirstName(u_firstname.getValue());
			user.setLastName(u_last_login.getValue());
			user.setGender(EnumGender.valueOf(u_gender.getValue()));
			user.setNationalID(u_national_id.getValue());
			user.setBirthDate(KornDateTime.createFromMySQLDateTime(u_birthdate.getValue()));
			user.setEmail(u_email.getValue());
			user.setAddress(u_address.getValue());
			user.setTelephoneNumber(u_telephone_number.getValue());

			result.add(user);
		}
		query.close();

		return result;
	}
	private static User processObject(KornQuery query) {
		ArrayList<User> users = CVUser.processObjectArray(query);
		if (users.isEmpty()) return null;
		return users.get(0);
	}

	public static boolean tryLogin(String username, String password) {
		KornSelectMySQL select = CVUser.getQueryObject();
		select.table("user");

		select.where("u_username", username);

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);
		User queriedUser = processObject(query);
		if (queriedUser == null)
			return false;
		query.close();

		CVUser.loggedInUser = queriedUser;
		return KornHash.verifyHash(password, queriedUser.getPassword());
	}

	private static User loggedInUser;
}
