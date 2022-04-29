package kmitl.covid.lib.methods.authentication;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import kmitl.covid.content.dashboard.DashboardPage;
import kmitl.covid.lib.enums.EnumAlertType;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornutil.KornAlert;
import kmitl.covid.lib.methods.user.CVUser;
import kmitl.covid.template.Home;

public class CVLoginEvent {
	public static EventHandler<ActionEvent> loginEvent(
		TextField username,
		TextField password
	) {
		return actionEvent -> {
			String usernameText = username.getText();
			String passwordText = password.getText();

			if (usernameText.isEmpty() && passwordText.isEmpty()) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"ไม่สามารถเข้าสู่ระบบได้",
					"กรุณากรอกข้อมูลให้ครบถ้วน"
				);
				username.requestFocus();
				return;
			}

			if (usernameText.isEmpty()) {
				username.requestFocus();
				return;
			}

			if (passwordText.isEmpty()) {
				password.requestFocus();
				return;
			}

			if (!CVUser.tryLogin(usernameText, passwordText)) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"ไม่สามารถเข้าสู่ระบบได้",
					"ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง"
				);
				password.clear();
				password.requestFocus();
				return;
			}

			Home.redirect(EnumPage.DASHBOARD());
		};
	}
}
