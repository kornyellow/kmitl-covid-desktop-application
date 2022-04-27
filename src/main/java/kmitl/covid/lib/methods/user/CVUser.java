package kmitl.covid.lib.methods.user;

import kmitl.covid.lib.classes.user.User;
import kmitl.covid.lib.korn.kornquery.KornInsertMySQL;
import kmitl.covid.lib.korn.kornquery.KornMySQLValue;
import kmitl.covid.lib.korn.kornquery.KornQuery;
import kmitl.covid.lib.korn.kornquery.KornSelectMySQL;
import kmitl.covid.lib.korn.kornquery.KornUpdateMySQL;
import kmitl.covid.lib.korn.kornutil.KornHash;
import kmitl.covid.lib.methods.connectivity.CVDB;

import java.util.ArrayList;

public class CVUser {
	public static User getUser(int id) {
		KornSelectMySQL select = CVUser.getQueryObject();
		select.where("u_id", String.valueOf(id));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVUser.processObject(query);
	}
	public static ArrayList<User> getUsers() {
		KornSelectMySQL select = CVUser.getQueryObject();

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
		insert.insert("u_address", user.getAddress());
		insert.insert("u_telephone_number", user.getTelephoneNumber());

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(insert);
		int insertedID = query.getInsertedID();
		query.close();

		return insertedID;
	}
	public static int updateUser(User user) {
		KornUpdateMySQL update = new KornUpdateMySQL();
		update.table("user");

		update.set("u_username", user.getUsername());
		update.set("u_password", KornHash.getHash(user.getPassword()));
		update.set("u_nametitle", user.getNameTitle().name());
		update.set("u_firstname", user.getFirstName());
		update.set("u_lastname", user.getLastName());
		update.set("u_gender", user.getGender().name());
		update.set("u_national_id", user.getNationalID());
		update.set("u_address", user.getAddress());
		update.set("u_telephone_number", user.getTelephoneNumber());

		update.where("s_id", String.valueOf(user.getID()));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(update);
		query.close();

		return query.getAffectedRows();
	}
	private static KornSelectMySQL getQueryObject() {
		KornSelectMySQL select = new KornSelectMySQL();
		select.table("user");

		select.select(
			"s_id",
			"s_firstname",
			"s_lastname"
		);

		return select;
	}
	private static ArrayList<User> processObjectArray(KornQuery query) {
		ArrayList<User> result = new ArrayList<>();

		KornMySQLValue s_id = new KornMySQLValue();
		KornMySQLValue s_firstname = new KornMySQLValue();
		KornMySQLValue s_lastname = new KornMySQLValue();

		query.bindValue("s_id", s_id);
		query.bindValue("s_firstname", s_firstname);
		query.bindValue("s_lastname", s_lastname);

		while (query.nextBind()) {
			User user = new User(Integer.parseInt(s_id.getValue()));

			user.setAddress(s_firstname.getValue());

			result.add(user);
		}
		query.close();

		return result;
	}
	private static User processObject(KornQuery query) {
		return CVUser.processObjectArray(query).get(0);
	}
}
