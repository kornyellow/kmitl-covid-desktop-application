package lib.methods.authentication;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lib.classes.staff.Staff;
import lib.methods.staff.CVStaff;

public class CVAuthEvent {
	public static EventHandler<ActionEvent> submitButtonEvent(
		Label invalidUsernameLabel, TextField username,
		Label invalidPasswordLabel, TextField password) {
		return actionEvent -> {
			invalidUsernameLabel.setText("");
			invalidPasswordLabel.setText("");
			if (password.getText().isEmpty()) {
				invalidPasswordLabel.setText("กรุณาใส่รหัสผ่าน");
				password.requestFocus();
			}
			if (username.getText().isEmpty()) {
				invalidUsernameLabel.setText("กรุณาใส่ชื่อผู้ใช้");
				username.requestFocus();
			}
			if (username.getText().isEmpty() || password.getText().isEmpty()) return;

			Staff staff = new Staff();
			staff.setFirstName(username.getText());
			staff.setLastName(password.getText());

			CVStaff.insertStaff(staff);

			username.setText("");
			password.setText("");

			username.requestFocus();
		};
	}
}
