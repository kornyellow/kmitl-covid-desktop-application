package kmitl.covid.lib.methods.user;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import kmitl.covid.lib.classes.user.User;
import kmitl.covid.lib.enums.EnumAlertType;
import kmitl.covid.lib.enums.EnumGender;
import kmitl.covid.lib.enums.EnumNameTitle;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornfx.KornAlert;
import kmitl.covid.lib.korn.kornutil.KornDateTime;
import kmitl.covid.lib.korn.kornutil.KornString;
import kmitl.covid.template.Home;
import kmitl.covid.template.TemplateHeader;

import java.time.format.DateTimeFormatter;

public class CVUserEvent {
	public static EventHandler<ActionEvent> saveEvent(
		TextField usernameField, TextField nationalIDField,
		ToggleGroup nameTitleField, TextField firstNameField,
		TextField lastNameField, ToggleGroup genderField,
		DatePicker birthDateField, TextField emailField,
		TextField telephoneNumberField, TextField addressField
	) {
		return actionEvent -> {
			if (nameTitleField.getSelectedToggle() == null ||
				genderField.getSelectedToggle() == null ||
				birthDateField.getValue() == null) {

				KornAlert.alert(
					EnumAlertType.ERROR,
					"กรุณากรอกข้อมูลให้ครบถ้วน"
				);
				return;
			}

			String username = usernameField.getText();
			String nationalID = nationalIDField.getText();
			String nameTitle = ((RadioButton) nameTitleField.getSelectedToggle()).getText();
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String gender = ((RadioButton) genderField.getSelectedToggle()).getText();
			String birthDate = birthDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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

			String convertedNationalID = nationalID.replaceAll("\\D", "");
			String convertedTelephoneNumber = telephoneNumber.replaceAll("\\D", "");
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
			user.setNameTitle(EnumNameTitle.nameOf(nameTitle));
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setGender(EnumGender.nameOf(gender));
			user.setBirthDate(KornDateTime.createFromMySQLDate(birthDate));
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
		ToggleGroup nameTitleField, TextField firstNameField,
		TextField lastNameField, ToggleGroup genderField,
		DatePicker birthDateField, TextField emailField,
		TextField telephoneNumberField, TextField addressField
	) {
		return actionEvent -> {
			if (nameTitleField.getSelectedToggle() == null ||
				genderField.getSelectedToggle() == null ||
				birthDateField.getValue() == null) {

				KornAlert.alert(
					EnumAlertType.ERROR,
					"กรุณากรอกข้อมูลให้ครบถ้วน"
				);
				return;
			}

			String username = KornString.trim(usernameField.getText(), 64);
			String nationalID = nationalIDField.getText();
			String password = passwordField.getText();
			String confirmPassword = confirmPasswordField.getText();
			String nameTitle = ((RadioButton) nameTitleField.getSelectedToggle()).getText();
			String firstName = KornString.trim(firstNameField.getText(), 64);
			String lastName = KornString.trim(lastNameField.getText(), 64);
			String gender = ((RadioButton) genderField.getSelectedToggle()).getText();
			String birthDate = birthDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String email = KornString.trim(emailField.getText(), 64);
			String telephoneNumber = telephoneNumberField.getText();
			String address = KornString.trim(addressField.getText(), 256);

			if (username.isEmpty() || nationalID.isEmpty() || password.isEmpty() ||
				confirmPassword.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
				email.isEmpty() || telephoneNumber.isEmpty() || address.isEmpty()) {

				KornAlert.alert(
					EnumAlertType.ERROR,
					birthDate
				);
				return;
			}

			String convertedNationalID = nationalID.replaceAll("\\D", "");
			String convertedTelephoneNumber = telephoneNumber.replaceAll("\\D", "");
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
			int sum = 0;
			for (int i = 0; i < 12; i++) {
				sum += (double) nationalID.charAt(i) * (13 - i);
			}
			if (((11 - sum % 11) % 10 != (double) nationalID.charAt(12)) || (nationalID.length() != 13)) {
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
			user.setNameTitle(EnumNameTitle.nameOf(nameTitle));
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setGender(EnumGender.nameOf(gender));
			user.setBirthDate(KornDateTime.createFromMySQLDate(birthDate));
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
					nameTitleField.selectToggle(null);
					firstNameField.clear();
					lastNameField.clear();
					genderField.selectToggle(null);
					birthDateField.getEditor().clear();
					emailField.clear();
					telephoneNumberField.clear();
					addressField.clear();
					Home.redirect(EnumPage.LOGIN());
				}
			);
		};
	}
}
