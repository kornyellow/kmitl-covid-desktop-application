package kmitl.covid.lib.methods.user;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import kmitl.covid.lib.classes.user.User;
import kmitl.covid.lib.enums.EnumAlertType;
import kmitl.covid.lib.enums.EnumGender;
import kmitl.covid.lib.enums.EnumNameTitle;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornutil.KornAlert;
import kmitl.covid.lib.korn.kornutil.KornDateTime;
import kmitl.covid.template.Home;
import kmitl.covid.template.TemplateHeader;

public class CVUserEvent {
	public static EventHandler<ActionEvent> saveEvent(
		TextField usernameField, TextField nationalIDField,
		TextField nameTitleField, TextField firstNameField,
		TextField lastNameField, TextField genderField,
		TextField birthDateField, TextField emailField,
		TextField telephoneNumberField, TextField addressField
	) {
		return actionEvent -> {
			String username = usernameField.getText();
			String nationalID = nationalIDField.getText();
			String nameTitle = nameTitleField.getText();
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String gender = genderField.getText();
			String birthDate = birthDateField.getText();
			String email = emailField.getText();
			String telephoneNumber = telephoneNumberField.getText();
			String address = addressField.getText();

			if (username.isEmpty() || nationalID.isEmpty() ||
				nameTitle.isEmpty() || firstName.isEmpty() ||
				lastName.isEmpty() || gender.isEmpty() ||
				birthDate.isEmpty() || email.isEmpty() ||
				telephoneNumber.isEmpty() || address.isEmpty()) {

				KornAlert.alert(
					EnumAlertType.ERROR,
					"กรุณากรอกข้อมูลให้ครบถ้วน"
				);
				return;
			}

			String convertedNationalID = nationalID.replaceAll("[^0-9]", "");
			String convertedTelephoneNumber = telephoneNumber.replaceAll("[^0-9]", "");
			nationalID = convertedNationalID;
			telephoneNumber = convertedTelephoneNumber;

			if (CVUser.isDuplicateUsername(username)) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"พบชื่อผู้ใช้ซ้ำ กรุณาใช้ชื่อผู้ใช้อื่น"
				);
				return;
			}
			if (CVUser.isDuplicateEmail(email)) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"พบอีเมลซ้ำ กรุณาใช้อีเมลอื่น"
				);
				return;
			}
			if (nationalID.length() != 13) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"เลขบัตรประชาชนไม่ถูกต้อง"
				);
				return;
			}
			if (CVUser.isDuplicateNationalID(nationalID)) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"พบเลขบัตรประชาชนซ้ำ กรุณาใช้เลขบัตรประชาชนอื่น"
				);
				return;
			}
			if (telephoneNumber.length() < 9 || telephoneNumber.length() > 10) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"เบอร์โทรศัพท์ไม่ถูกต้อง"
				);
				return;
			}

			User user = CVUser.getLoggedInUser();
			user.setUsername(username);
			user.setNationalID(nationalID);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setTelephoneNumber(telephoneNumber);
			user.setAddress(address);

			CVUser.updateUser(user);
			CVUser.setLoggedInUser(user);

			KornAlert.alert(
				EnumAlertType.SUCCESS,
				"ข้อมูลผู้ใช้ถูกเปลี่ยนแปลงเรียบร้อย",
				dialogEvent -> {
					nationalIDField.setText(convertedNationalID);
					telephoneNumberField.setText(convertedTelephoneNumber);

					TemplateHeader.resetHeader();
					Home.redirect(EnumPage.SETTING());
				}
			);
		};

	}
	public static EventHandler<ActionEvent> registerEvent(
		TextField usernameField, TextField nationalIDField,
		TextField passwordField, TextField confirmPasswordField,
		TextField nameTitleField, TextField firstNameField,
		TextField lastNameField, TextField genderField,
		TextField birthDateField, TextField emailField,
		TextField telephoneNumberField, TextField addressField
	) {
		return actionEvent -> {
			String username = usernameField.getText();
			String nationalID = nationalIDField.getText();
			String password = passwordField.getText();
			String confirmPassword = confirmPasswordField.getText();
			String nameTitle = nameTitleField.getText();
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String gender = genderField.getText();
			String birthDate = birthDateField.getText();
			String email = emailField.getText();
			String telephoneNumber = telephoneNumberField.getText();
			String address = addressField.getText();

			if (username.isEmpty() || nationalID.isEmpty() || password.isEmpty() ||
				confirmPassword.isEmpty() || nameTitle.isEmpty() || firstName.isEmpty() ||
				lastName.isEmpty() || gender.isEmpty() || birthDate.isEmpty() ||
				email.isEmpty() || telephoneNumber.isEmpty() || address.isEmpty()) {

				KornAlert.alert(
					EnumAlertType.ERROR,
					"กรุณากรอกข้อมูลให้ครบถ้วน"
				);
				return;
			}

			String convertedNationalID = nationalID.replaceAll("[^d]", "");
			String convertedTelephoneNumber = telephoneNumber.replaceAll("[^d]", "");
			nationalID = convertedNationalID;
			telephoneNumber = convertedTelephoneNumber;

			if (CVUser.isDuplicateUsername(username)) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"พบชื่อผู้ใช้ซ้ำ กรุณาใช้ชื่อผู้ใช้อื่น"
				);
				return;
			}
			if (CVUser.isDuplicateEmail(email)) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"พบอีเมลซ้ำ กรุณาใช้อีเมลอื่น"
				);
				return;
			}
			if (nationalID.length() != 13) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"เลขบัตรประชาชนไม่ถูกต้อง"
				);
				return;
			}
			if (CVUser.isDuplicateNationalID(nationalID)) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"พบเลขบัตรประชาชนซ้ำ กรุณาใช้เลขบัตรประชาชนอื่น"
				);
				return;
			}
			if (!password.equals(confirmPassword)) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"ยืนยันรหัสผ่านไม่ถูกต้อง"
				);
				return;
			}
			if (password.length() < 8) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"กรุณากรอกรหัสผ่านอย่างน้อย 8 ตัวอักษร"
				);
				return;
			}
			if (telephoneNumber.length() < 9 || telephoneNumber.length() > 10) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"เบอร์โทรศัพท์ไม่ถูกต้อง"
				);
				return;
			}

			User user = new User();
			user.setUsername(username);
			user.setNationalID(nationalID);
			user.setPassword(password);
			user.setNameTitle(EnumNameTitle.MISTER);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setGender(EnumGender.MALE);
			user.setBirthDate(KornDateTime.createFromDate(2, 2, 2002));
			user.setEmail(email);
			user.setTelephoneNumber(telephoneNumber);
			user.setAddress(address);

			CVUser.insertUser(user);

			KornAlert.alert(
				EnumAlertType.SUCCESS,
				"สามารถเข้าสู่ระบบได้เรียบร้อย",
				dialogEvent -> {
					usernameField.clear();
					nationalIDField.clear();
					passwordField.clear();
					confirmPasswordField.clear();
					nameTitleField.clear();
					firstNameField.clear();
					lastNameField.clear();
					genderField.clear();
					birthDateField.clear();
					emailField.clear();
					telephoneNumberField.clear();
					addressField.clear();
					Home.redirect(EnumPage.LOGIN());
				}
			);
		};
	}
}
