package kmitl.covid.lib.methods.authentication;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import kmitl.covid.lib.enums.EnumAlertType;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornutil.KornAlert;
import kmitl.covid.template.Home;

public class CVForgotPasswordEvent {
	public static EventHandler<ActionEvent> ForgotpasswordEvent(
		TextField email,
		TextField nationalID,
		TextField newPassword
	) {
		return actionEvent -> {
			String emailText = email.getText();
			String nationalIDText = nationalID.getText();
			String newPasswordText = newPassword.getText();

			if (emailText.isEmpty() && nationalIDText.isEmpty() && newPasswordText.isEmpty()) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"กรุณากรอกข้อมูลให้ครบถ้วน",
					dialogEvent -> Home.redirect(EnumPage.LOGIN())
				);
				email.requestFocus();
				return;
			}

			if (emailText.isEmpty()) {
				email.requestFocus();
				return;
			}

			if (nationalIDText.isEmpty()) {
				nationalID.requestFocus();
				return;
			}

			if (newPasswordText.isEmpty()) {
				newPassword.requestFocus();
				return;
			}

			KornAlert.alert(
				EnumAlertType.SUCCESS,
				"เปลี่ยนรหัสผ่านเรียบร้อย"
			);

			Home.redirect(EnumPage.LOGIN());
		};
	}
}
