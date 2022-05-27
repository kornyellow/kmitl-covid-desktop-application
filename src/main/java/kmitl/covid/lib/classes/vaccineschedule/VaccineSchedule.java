package kmitl.covid.lib.classes.vaccineschedule;

import kmitl.covid.lib.korn.kornutil.KornDateTime;

public class VaccineSchedule {
	public VaccineSchedule() {
		this.id = -1;
	}
	public VaccineSchedule(int id) {
		this.id = id;
	}

	private final int id;
	private KornDateTime date;
	private boolean isAvailable;

	public int getID() {
		return id;
	}
	public KornDateTime getDate() {
		return date;
	}
	public void setDate(KornDateTime date) {
		this.date = date;
	}
	public boolean isAvailable() {
		return this.isAvailable;
	}
	public void setAvailable(boolean available) {
		this.isAvailable = available;
	}
}

