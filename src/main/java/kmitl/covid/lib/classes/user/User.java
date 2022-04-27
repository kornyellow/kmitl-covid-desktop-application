package kmitl.covid.lib.classes.user;

import kmitl.covid.lib.korn.kornutil.KornDateTime;
import kmitl.covid.lib.korn.kornutil.KornEnum;

public class User {
    public User() {

    }
    public User(int id, KornEnum nameTitle, String firstName, String lastName, KornEnum gender, String nationalID, KornDateTime birthDate, String address, String telephoneNumber) {
        this.id = id;
        this.nameTitle = nameTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.nationalID = nationalID;
        this.birthDate = birthDate;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    private int id;
    private KornEnum nameTitle;
    private String firstName;
    private String lastName;
    private KornEnum gender;
    private String nationalID;
    private KornDateTime birthDate;
    private String address;
    private String telephoneNumber;

    public int getId() {
        return id;
    }

    public KornEnum getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(KornEnum nameTitle) {
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

    public KornEnum getGender() {
        return gender;
    }

    public void setGender(KornEnum gender) {
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
