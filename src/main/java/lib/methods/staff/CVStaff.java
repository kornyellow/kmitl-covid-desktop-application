package lib.methods.staff;

import lib.classes.staff.Staff;
import lib.korn.kornquery.*;
import lib.methods.connectivity.CVDB;

import java.util.ArrayList;

public class CVStaff {
	public static Staff getStaff(int id) {
		KornSelectMySQL select = CVStaff.getQueryObject();
		select.where("s_id", String.valueOf(id));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVStaff.processObject(query);
	}

	public static ArrayList<Staff> getStaffs() {
		KornSelectMySQL select = CVStaff.getQueryObject();

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVStaff.processObjectArray(query);
	}

	public static int insertStaff(Staff staff) {
		KornInsertMySQL insert = new KornInsertMySQL();
		insert.table("staff");

		insert.insert("s_firstname", staff.getFirstName());
		insert.insert("s_lastname", staff.getLastName());

		System.out.println(insert.build());

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(insert);
		int insertedID = query.getInsertedID();
		query.close();

		return insertedID;
	}

	public static int updateStaff(Staff staff) {
		KornUpdateMySQL update = new KornUpdateMySQL();
		update.table("staff");

		update.set("s_firstname", staff.getFirstName());
		update.set("s_lastname", staff.getLastName());

		update.where("s_id",  String.valueOf(staff.getID()));

		System.out.println(update.build());

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(update);
		query.close();

		return query.getAffectedRows();
	}

	private static KornSelectMySQL getQueryObject() {
		KornSelectMySQL select = new KornSelectMySQL();
		select.table("staff");

		select.select(
			"s_id",
			"s_firstname",
			"s_lastname"
		);

		return select;
	}

	private static ArrayList<Staff> processObjectArray(KornQuery query) {
		ArrayList<Staff> result = new ArrayList<>();

		KornMySQLValue s_id = new KornMySQLValue();
		KornMySQLValue s_firstname = new KornMySQLValue();
		KornMySQLValue s_lastname = new KornMySQLValue();

		query.bindValue("s_id", s_id);
		query.bindValue("s_firstname", s_firstname);
		query.bindValue("s_lastname", s_lastname);

		while (query.nextBind()) {
			Staff staff = new Staff(Integer.parseInt(s_id.getValue()));

			staff.setFirstName(s_firstname.getValue());
			staff.setLastName(s_lastname.getValue());

			result.add(staff);
		}
		query.close();

		return result;
	}

	private static Staff processObject(KornQuery query) {
		return CVStaff.processObjectArray(query).get(0);
	}
}
