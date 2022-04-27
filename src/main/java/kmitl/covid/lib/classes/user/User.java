package kmitl.covid.lib.classes.user;

import kmitl.covid.lib.enums.EnumGender;
import kmitl.covid.lib.enums.EnumNameTitle;
import kmitl.covid.lib.korn.kornutil.KornDateTime;

public class User {
	public User() {
		this.id = -1;
	}
	public User(int id) {
		this.id = id;
	}

	private final int id;
	private EnumNameTitle nameTitle;
	private String firstName;
	private String lastName;
	private EnumGender gender;
	private String nationalID;
	private KornDateTime birthDate;
	private String address;
	private String telephoneNumber;

	public int getId() {
		return id;
	}
	public EnumNameTitle getNameTitle() {
		return nameTitle;
	}
	public void setNameTitle(EnumNameTitle nameTitle) {
		this.nameTitle = nameTitle;
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
	public EnumGender getGender() {
		return gender;
	}
	public void setGender(EnumGender gender) {
		this.gender = gender;
	}
	public String getNationalID() {
		return nationalID;
	}
	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}
	public KornDateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(KornDateTime birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
}
