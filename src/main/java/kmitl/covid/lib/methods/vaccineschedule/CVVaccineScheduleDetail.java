package kmitl.covid.lib.methods.vaccineschedule;

import kmitl.covid.lib.classes.user.User;
import kmitl.covid.lib.classes.vaccineschedule.VaccineSchedule;
import kmitl.covid.lib.classes.vaccineschedule.VaccineScheduleDetail;
import kmitl.covid.lib.korn.kornquery.KornInsertMySQL;
import kmitl.covid.lib.korn.kornquery.KornMySQLValue;
import kmitl.covid.lib.korn.kornquery.KornQuery;
import kmitl.covid.lib.korn.kornquery.KornSelectMySQL;
import kmitl.covid.lib.methods.connectivity.CVDB;
import kmitl.covid.lib.methods.user.CVUser;

import java.util.ArrayList;

public class CVVaccineScheduleDetail {
	public static VaccineScheduleDetail getVaccineScheduleDetail(VaccineSchedule vaccineSchedule, int queueNumber) {
		KornSelectMySQL select = CVVaccineScheduleDetail.getQueryObject();
		select.table("vaccine_schedule_detail");

		select.where("vsd_vs_id", String.valueOf(vaccineSchedule.getID()));
		select.where("vsd_number", String.valueOf(queueNumber));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVVaccineScheduleDetail.processObject(query);
	}
	public static VaccineScheduleDetail getVaccineScheduleDetail(int id) {
		KornSelectMySQL select = CVVaccineScheduleDetail.getQueryObject();
		select.table("vaccine_schedule_detail");

		select.where("vsd_id", String.valueOf(id));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVVaccineScheduleDetail.processObject(query);
	}
	public static ArrayList<VaccineScheduleDetail> getVaccineScheduleDetails(VaccineSchedule vaccineSchedule, User user) {
		KornSelectMySQL select = CVVaccineScheduleDetail.getQueryObject();
		select.table("vaccine_schedule_detail");

		select.where("vsd_vs_id", String.valueOf(vaccineSchedule.getID()));
		select.where("vsd_u_id", String.valueOf(user.getID()));

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(select);

		return CVVaccineScheduleDetail.processObjectArray(query);
	}
	public static int insertVaccineScheduleDetail(VaccineScheduleDetail vaccineScheduleDetail) {
		KornInsertMySQL insert = new KornInsertMySQL();
		insert.table("vaccine_schedule_detail");
		insert.insert("vsd_vs_id", String.valueOf(vaccineScheduleDetail.getVaccineSchedule().getID()));
		insert.insert("vsd_u_id", String.valueOf(vaccineScheduleDetail.getUser().getID()));
		insert.insert("vsd_number", String.valueOf(vaccineScheduleDetail.getVaccineNumber()));
		insert.insert("vsd_vaccine", vaccineScheduleDetail.getVaccineName());
		insert.insert("vsd_note", vaccineScheduleDetail.getNote());

		KornQuery query = new KornQuery(CVDB.getDB());
		query.query(insert);
		query.close();

		return query.getInsertedID();
	}
	private static KornSelectMySQL getQueryObject() {
		KornSelectMySQL select = new KornSelectMySQL();
		select.select(
			"vsd_id",
			"vsd_vs_id",
			"vsd_u_id",
			"vsd_number",
			"vsd_vaccine",
			"vsd_note"
		);

		return select;
	}
	private static ArrayList<VaccineScheduleDetail> processObjectArray(KornQuery query) {
		ArrayList<VaccineScheduleDetail> result = new ArrayList<>();

		KornMySQLValue vsd_id = new KornMySQLValue();
		KornMySQLValue vsd_vs_id = new KornMySQLValue();
		KornMySQLValue vsd_u_id = new KornMySQLValue();
		KornMySQLValue vsd_number = new KornMySQLValue();
		KornMySQLValue vsd_vaccine = new KornMySQLValue();
		KornMySQLValue vsd_note = new KornMySQLValue();

		query.bindValue("vsd_id", vsd_id);
		query.bindValue("vsd_vs_id", vsd_vs_id);
		query.bindValue("vsd_u_id", vsd_u_id);
		query.bindValue("vsd_number", vsd_number);
		query.bindValue("vsd_vaccine", vsd_vaccine);
		query.bindValue("vsd_note", vsd_note);

		while (query.nextBind()) {
			VaccineScheduleDetail vaccineScheduleDetail = new VaccineScheduleDetail(Integer.parseInt(vsd_id.getValue()));

			vaccineScheduleDetail.setVaccineSchedule(CVVaccineSchedule.getVaccineSchedule(Integer.parseInt(vsd_vs_id.getValue())));
			vaccineScheduleDetail.setUser(CVUser.getUser(Integer.parseInt(vsd_u_id.getValue())));
			vaccineScheduleDetail.setVaccineNumber(Integer.parseInt(vsd_number.getValue()));
			vaccineScheduleDetail.setVaccineName(vsd_vaccine.getValue());
			vaccineScheduleDetail.setNote(vsd_note.getValue());

			result.add(vaccineScheduleDetail);
		}
		query.close();

		return result;
	}
	private static VaccineScheduleDetail processObject(KornQuery query) {
		ArrayList<VaccineScheduleDetail> vaccineScheduleDetails = CVVaccineScheduleDetail.processObjectArray(query);
		if (vaccineScheduleDetails.isEmpty()) return null;
		return vaccineScheduleDetails.get(0);
	}
}
