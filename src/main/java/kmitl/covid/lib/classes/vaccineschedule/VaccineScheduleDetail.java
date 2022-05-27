package kmitl.covid.lib.classes.vaccineschedule;

import kmitl.covid.lib.classes.user.User;

public class VaccineScheduleDetail {
	public VaccineScheduleDetail() {
		this.id = -1;
	}
	public VaccineScheduleDetail(int id) {
		this.id = id;
	}

	private final int id;
	private VaccineSchedule vaccineSchedule;
	private User user;
	private int vaccineNumber;
	private String vaccineName;
	private String note;

	public int getID() {
		return id;
	}
	public VaccineSchedule getVaccineSchedule() {
		return vaccineSchedule;
	}
	public void setVaccineSchedule(VaccineSchedule vaccineSchedule) {
		this.vaccineSchedule = vaccineSchedule;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getVaccineNumber() {
		return vaccineNumber;
	}
	public void setVaccineNumber(int vaccineNumber) {
		this.vaccineNumber = vaccineNumber;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
