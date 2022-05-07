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

public class CVUserEvent {
	public static EventHandler<ActionEvent> saveEvent(
		TextField usernameField, TextField nationalIDField,
		TextField nameTitleField, TextField firstNameField,
		TextField lastNameField, TextField genderField,
		TextField birthDateField, TextField emailField,
		TextField phoneNumberField, TextField addressField
	) {
		return actionEvent -> {
			// ดึงข้อมูลเป็น String

			// เช็คช่องว่างก่อน

			// CVUser.isDuplicateUsername("usernameที่ต้องการเช็ค")
			// CVUser.isDuplicateNationalID("รหัสบัตรประชาชน")

			// 1. เช็คว่าชื่อผู้ใช้ มีซ้ำในระบบหรือเปล่า
			// 2. (ลบ ทุกอย่างนอกจากตัวเลข ออกจาก รหัสบัตรให้ด้วย ถึงแม้มันจะไม่มี)
			// 3. เช็คว่ารหัสบัตรประชาชน ถูกต้องมั้ย
			// 4. เช็คว่ารหัสบัตรประชาชน ซ้ำกับในระบบมั้ย
			// 5. (ลบ ทุกอย่างนอกจากตัวเลข ออกจาก เบอร์โทร ถึงแม้มันจะไม่มี)

			// บันทึกข้อมูล แจ้งเตือน เปลี่ยนหน้า
			User user = CVUser.getLoggedInUser();
			user.setFirstName("สวัสดี");
			// .. ทำให้ครบทุกอัน ยกเว้น 3 อันนั้น
			CVUser.updateUser(user);
		};
	}
	public static EventHandler<ActionEvent> registerEvent(
		TextField usernameField, TextField nationalIDField,
		TextField passwordField, TextField confirmPasswordField,
		TextField nameTitleField, TextField firstNameField,
		TextField lastNameField, TextField genderField,
		TextField birthDateField, TextField emailField,
		TextField phoneNumberField, TextField addressField
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
			String phoneNumber = phoneNumberField.getText();
			String address = addressField.getText();

			if (username.isEmpty() || nationalID.isEmpty() || password.isEmpty() ||
				confirmPassword.isEmpty() || nameTitle.isEmpty() || firstName.isEmpty() ||
				lastName.isEmpty() || gender.isEmpty() || birthDate.isEmpty() ||
				email.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {

				KornAlert.alert(
					EnumAlertType.ERROR,
					"ไม่สามารถสมัครผู้ใช้ได้",
					"เนื่องจากกรอกข้อมูลไม่ครบถ้วน"
				);
				return;
			}


			// 1. เช็คว่าชื่อผู้ใช้ มีซ้ำในระบบหรือเปล่า
			// (ลบ "-" ออกจาก รหัสบัตรให้ด้วย ถึงแม้มันจะไม่มี)
			//for (int i = 0; i < 13; i++) {

			//}
			// 2. เช็คว่ารหัสบัตรประชาชน ถูกต้องมั้ย
			// 3. เช็คว่ารหัสบัตรประชาชน ซ้ำกับในระบบมั้ย
			// 4. รหัสผ่าน === ยืนยันรหัสผ่าน (อย่างน้อย 8)
			// (ลบ "-" ออกจาก เบอร์โทร ถึงแม้มันจะไม่มี)
			//for (int i = 0; i < 10; i++) {

			//}

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
			user.setTelephoneNumber(phoneNumber);
			user.setAddress(address);

			CVUser.insertUser(user);

			KornAlert.alert(
				EnumAlertType.SUCCESS,
				"สมัครผู้ใช้สำเร็จ",
				"กรุณาลงชื่อเข้าใช้",
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
					phoneNumberField.clear();
					addressField.clear();

					Home.redirect(EnumPage.LOGIN());
				}
			);
		};
	}
}
