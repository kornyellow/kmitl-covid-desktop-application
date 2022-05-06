package kmitl.covid.lib.methods.user;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import kmitl.covid.lib.classes.user.User;
import kmitl.covid.lib.enums.EnumGender;
import kmitl.covid.lib.enums.EnumNameTitle;
import kmitl.covid.lib.korn.kornutil.KornDateTime;

public class CVUserEvent {
	public static EventHandler<ActionEvent> saveEvent() {
		return actionEvent -> {

		};
	}
	public static EventHandler<ActionEvent> registerEvent(
		TextField usernameField, TextField nationalIDField
	) {
		return actionEvent -> {
			String username = usernameField.getText();
			String nationalID = nationalIDField.getText();

			if (username.isEmpty()) {
				// เด้ง alert
				return;
			}

			// 1. เช็คว่าชื่อผู้ใช้ มีซ้ำในระบบหรือเปล่า
			// (ลบ "-" ออกจาก รหัสบัตรให้ด้วย ถึงแม้มันจะไม่มี)
			// 2. เช็คว่ารหัสบัตรประชาชน ถูกต้องมั้ย
			// 3. เช็คว่ารหัสบัตรประชาชน ซ้ำกับในระบบมั้ย
			// 4. รหัสผ่าน === ยืนยันรหัสผ่าน (อย่างน้อย 8)
			// (ลบ "-" ออกจาก เบอร์โทร ถึงแม้มันจะไม่มี)

			// นำข้อมูลเข้าสู่ระบบ
			User user = new User();
			user.setUsername(username);
			//..
			//..
			user.setNameTitle(EnumNameTitle.MISTER);
			//..
			//..
			user.setGender(EnumGender.MALE);
			user.setBirthDate(KornDateTime.createFromDate(2, 2, 2002));
			//..
			//..
			//..

			CVUser.insertUser(user);

			// เด้ง alert ว่าสำเร็จ
			// ย้ายหน้ากลับไป Login
			// clear field ทุก field
			usernameField.clear();
		};
	}
}
