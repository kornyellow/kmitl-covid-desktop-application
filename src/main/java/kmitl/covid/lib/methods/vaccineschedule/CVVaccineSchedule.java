package kmitl.covid.lib.methods.vaccineschedule;

import kmitl.covid.lib.classes.vaccineschedule.VaccineSchedule;
import kmitl.covid.lib.korn.kornquery.KornInsertMySQL;
import kmitl.covid.lib.korn.kornquery.KornMySQLValue;
import kmitl.covid.lib.korn.kornquery.KornQuery;
import kmitl.covid.lib.korn.kornquery.KornSelectMySQL;
import kmitl.covid.lib.korn.kornquery.KornUpdateMySQL;
import kmitl.covid.lib.korn.kornutil.KornDateTime;
import kmitl.covid.lib.methods.connectivity.CVDB;

import java.util.ArrayList;

public class CVVaccineSchedule {
	public static VaccineSchedule getVaccineSchedule(int id) {
		KornSelectMySQL select = CVVaccineSchedule.getQueryObject();
		select.table("vaccine_schedule");

		select.where("vs_id", String.valueOf(id));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVVaccineSchedule.processObject(query);
	}
	public static VaccineSchedule getVaccineSchedule(KornDateTime date) {
		KornSelectMySQL select = CVVaccineSchedule.getQueryObject();
		select.table("vaccine_schedule");

		select.where("vs_date", date.getMySQLDateFormat());

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVVaccineSchedule.processObject(query);
	}
	public static int insertVaccineSchedule(KornDateTime date) {
		KornInsertMySQL insert = new KornInsertMySQL();
		insert.table("vaccine_schedule");

		insert.insert("vs_date", date.getMySQLDateFormat());

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(insert);
		query.close();

		return query.getInsertedID();
	}
	public static void updateVaccineSchedule(VaccineSchedule vaccineSchedule) {
		KornUpdateMySQL update = new KornUpdateMySQL();
		update.table("vaccine_schedule");

		update.set("vs_is_available", String.valueOf(vaccineSchedule.isAvailable() ? 1 : 0));

		update.where("vs_id", String.valueOf(vaccineSchedule.getID()));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(update);
	}
	private static KornSelectMySQL getQueryObject() {
		KornSelectMySQL select = new KornSelectMySQL();
		select.select(
			"vs_id",
			"vs_date",
			"vs_is_available"
		);

		return select;
	}
	private static ArrayList<VaccineSchedule> processObjectArray(KornQuery query) {
		ArrayList<VaccineSchedule> result = new ArrayList<>();

		KornMySQLValue vs_id = new KornMySQLValue();
		KornMySQLValue vs_date = new KornMySQLValue();
		KornMySQLValue vs_is_available = new KornMySQLValue();

		query.bindValue("vs_id", vs_id);
		query.bindValue("vs_date", vs_date);
		query.bindValue("vs_is_available", vs_is_available);

		while (query.nextBind()) {
			VaccineSchedule vaccineSchedule = new VaccineSchedule(Integer.parseInt(vs_id.getValue()));

			vaccineSchedule.setDate(KornDateTime.createFromMySQLDate(vs_date.getValue()));
			vaccineSchedule.setAvailable("1".equals(vs_is_available.getValue()));

			result.add(vaccineSchedule);
		}
		query.close();

		return result;
	}
	private static VaccineSchedule processObject(KornQuery query) {
		ArrayList<VaccineSchedule> vaccineSchedules = CVVaccineSchedule.processObjectArray(query);
		if (vaccineSchedules.isEmpty()) return null;
		return vaccineSchedules.get(0);
	}
}
