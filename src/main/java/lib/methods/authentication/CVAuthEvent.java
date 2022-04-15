package lib.methods.authentication;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CVAuthEvent {
	public static EventHandler<ActionEvent> submitButtonEvent(
		Label invalidUsernameLabel, TextField username,
		Label invalidPasswordLabel, TextField password) {
		return actionEvent -> {
			invalidUsernameLabel.setText("");
			invalidPasswordLabel.setText("");
			if (username.getText().isEmpty()) invalidUsernameLabel.setText("กรุณาใส่ชื่อผู้ใช้");
			if (password.getText().isEmpty()) invalidPasswordLabel.setText("กรุณาใส่รหัสผ่าน");
		};
	}
}
