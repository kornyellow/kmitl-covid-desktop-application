package application;

import lib.classes.staff.Staff;
import lib.methods.staff.CVStaff;

public class Debug {
	public static void main(String[] args) {
		Staff staff = new Staff();
		staff.setFirstName("Korn");
		staff.setLastName("Rojrattapanya");

		CVStaff.insertStaff(staff);
	}
}
