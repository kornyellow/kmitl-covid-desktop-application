package kmitl.covid.lib.methods.authentication;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import kmitl.covid.lib.classes.user.User;
import kmitl.covid.lib.enums.EnumAlertType;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornfx.KornAlert;
import kmitl.covid.lib.methods.notification.CVNotification;
import kmitl.covid.lib.methods.user.CVUser;
import kmitl.covid.template.Home;

public class CVForgotPasswordEvent {
	public static EventHandler<ActionEvent> ForgotpasswordEvent(
		TextField emailField,
		TextField nationalIDField,
		TextField newPasswordField
	) {
		return actionEvent -> {
			String email = emailField.getText();
			String nationalID = nationalIDField.getText();
			String newPassword = newPasswordField.getText();

			if (email.isEmpty() && nationalID.isEmpty() && newPassword.isEmpty()) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"กรุณากรอกข้อมูลให้ครบถ้วน"
				);
				emailField.requestFocus();
				return;
			}
			if (email.isEmpty()) {
				emailField.requestFocus();
				return;
			}
			if (nationalID.isEmpty()) {
				nationalIDField.requestFocus();
				return;
			}
			if (newPassword.isEmpty()) {
				newPasswordField.requestFocus();
				return;
			}

			User user = CVUser.getUserFromNationalID(nationalID);
			if (user == null) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"อีเมลหรือรหัสบัตรประชาชนไม่ถูกต้อง"
				);
				return;
			}
			user = CVUser.getUserFromEmail(email);
			if (user == null) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"อีเมลหรือรหัสบัตรประชาชนไม่ถูกต้อง"
				);
				return;
			}

			user.setPassword(newPassword);
			CVUser.updatePassword(user);

			User finalUser = user;
			KornAlert.alert(
				EnumAlertType.SUCCESS,
				"เปลี่ยนรหัสผ่านเรียบร้อย",
				dialogEvent -> {
					emailField.clear();
					nationalIDField.clear();
					newPasswordField.clear();
					Home.redirect(EnumPage.LOGIN());

					CVNotification.pushNotification(
						finalUser,
						"การแก้ไขรหัสผ่าน",
						"คุณได้แก้ไขรหัสผ่านเรียบร้อยแล้ว"
					);
				}
			);
		};
	}
}
