package kmitl.covid.lib.classes.user;

import kmitl.covid.lib.enums.EnumGender;
import kmitl.covid.lib.enums.EnumNameTitle;
import kmitl.covid.lib.korn.kornutil.KornDateTime;

public class User {
	public User() {
		this.id = -1;
	}

	private final int id;
	private String username;
	private String password;
	private KornDateTime lastLogin;
	private EnumNameTitle nameTitle;
	private String firstName;
	private String lastName;
	private EnumGender gender;
	private String nationalID;
	private KornDateTime birthDate;
	private String address;
	private String telephoneNumber;

	public int getID() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public KornDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(KornDateTime lastLogin) {
		this.lastLogin = lastLogin;
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
