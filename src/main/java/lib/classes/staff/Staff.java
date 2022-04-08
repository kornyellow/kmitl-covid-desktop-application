package lib.classes.staff;

public class Staff {
	public Staff() {
		this.id = -1;
	}

	public Staff(int id) {
		this.id = id;
	}

	private final int id;
	private String firstName;
	private String lastName;

	public int getID() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
