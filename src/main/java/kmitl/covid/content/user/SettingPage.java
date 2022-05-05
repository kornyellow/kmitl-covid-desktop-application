package kmitl.covid.content.user;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornutil.KornFont;
import kmitl.covid.template.Home;

public class SettingPage {
	public static GridPane getContent() {
		if (SettingPage.node != null) return SettingPage.node;
		SettingPage.node = new GridPane(); // GridPane คือตารางเป็นช่องคล้าย ๆ Excel
		SettingPage.node.setAlignment((Pos.TOP_LEFT)); // ตั้งค่าให้อะไรก็ตามที่อยู่ในช่องมันเรียงตรงกลาง
		SettingPage.node.setVgap(9); // ให้แต่ละช่องห่างกันแนวตั้ง 10 pixels
		SettingPage.node.setHgap(50); // ให้แต่ละช่องห่างกันแนวนอน 50 pixels

		// สร้างข้อกำหนดทั้งหมด 3 คอลัมน์ โดยกำหนดให้มีขนาดตามนี้
		ColumnConstraints Column1 = new ColumnConstraints(200);
		ColumnConstraints Column2 = new ColumnConstraints(200);
		ColumnConstraints Column3 = new ColumnConstraints(200);
		ColumnConstraints Column4 = new ColumnConstraints(200);
		ColumnConstraints Column5 = new ColumnConstraints(200);
		ColumnConstraints Column6 = new ColumnConstraints(200);
		 //ยัดข้อกำหนดใส่ในตาราง Excel ของเรา
		SettingPage.node.getColumnConstraints().addAll(
			Column1,
			Column2,
			Column3,
			Column4,
			Column5,
			Column6
		);

		//Username
		Label usernameLabel = new Label("ชื่อผู้ใช้"); //อารมณ์ประมาณสร้างป้ายข้อความ
		usernameLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox username = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		username.getChildren().add(usernameLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		username.setAlignment(Pos.TOP_LEFT); // เซตการวางตำแหน่ง
		SettingPage.node.add(username, 1, 0); // เอาสิ่งที้่เราเขียนไป ยัดเข้าไปตัวหลัก (GridPage) ในตำแหน่งที่ 0,0 ของตาราง

		//กล่อง Username
		TextField usernameField = new TextField(); // สร้างช่องใส่ชื่อผู้ใช้
		usernameField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		usernameField.setPromptText("ชื่อผู้ใช้"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		GridPane.setColumnSpan(usernameField, 2); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(usernameField, 1, 1); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,1

		//National ID
		Label nationalidLabel = new Label("รหัสประจำตัวประชาชน"); //อารมณ์ประมาณสร้างป้ายข้อความ
		nationalidLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox nationalid = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		nationalid.getChildren().add(nationalidLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		nationalid.setAlignment(Pos.TOP_LEFT);

		SettingPage.node.add(nationalid, 1, 4);

		//กล่อง National ID
		TextField nationalidField = new TextField(); // สร้างช่องใส่รหัสบัตรปชช
		nationalidField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		nationalidField.setPromptText("รหัสประจำตัวประชาชน"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		GridPane.setColumnSpan(nationalidField, 2); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(nationalidField, 1, 5); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,6

		//First Name
		Label firstnameLabel = new Label("ชื่อจริง"); //อารมณ์ประมาณสร้างป้ายข้อความ
		firstnameLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox firstname = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		firstname.getChildren().add(firstnameLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		firstname.setAlignment(Pos.TOP_LEFT);

		SettingPage.node.add(firstname, 1, 8);

		//กล่อง First Name
		TextField firstnameField = new TextField(); // สร้างช่องใส่รหัสบัตรปชช
		firstnameField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		firstnameField.setPromptText("ชื่อจริง"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		GridPane.setColumnSpan(firstnameField, 2); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(firstnameField, 1, 9); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,11

		//Name Title
		Label nametitleLabel = new Label("คำนำหน้าชื่อ"); //อารมณ์ประมาณสร้างป้ายข้อความ
		nametitleLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox nametitle = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		nametitle.getChildren().add(nametitleLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		nametitle.setAlignment(Pos.TOP_LEFT);

		SettingPage.node.add(nametitle, 1, 12);

		//กล่อง Name Title
		TextField nametitleField = new TextField(); // สร้างช่องใส่รหัสบัตรปชช
		nametitleField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		nametitleField.setPromptText("คำนำหน้าชื่อ"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		GridPane.setColumnSpan(nametitleField, 1); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(nametitleField, 1, 13); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,11

		//E-mail
		Label emailLabel = new Label("อีเมล"); //อารมณ์ประมาณสร้างป้ายข้อความ
		emailLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox email = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		email.getChildren().add(emailLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		email.setAlignment(Pos.TOP_LEFT);

		SettingPage.node.add(email, 1, 16);

		//กล่อง E-mail
		TextField emailField = new TextField(); // สร้างช่องใส่รหัสบัตรปชช
		emailField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		emailField.setPromptText("อีเมล"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		GridPane.setColumnSpan(emailField, 2); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(emailField, 1, 17); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,11

		//Address
		Label addressLabel = new Label("ที่อยู่"); //อารมณ์ประมาณสร้างป้ายข้อความ
		addressLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox address = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		address.getChildren().add(addressLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		address.setAlignment(Pos.TOP_LEFT);

		SettingPage.node.add(address, 1, 20);

		//กล่อง Address
		TextField addressField = new TextField(); // สร้างช่องใส่รหัสบัตรปชช
		addressField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		addressField.setPromptText("ที่อยู่"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		GridPane.setColumnSpan(addressField, 2); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(addressField, 1, 21); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,11

		///ขวา////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//Password
		Label passwordLabel = new Label("รหัสผ่าน"); //อารมณ์ประมาณสร้างป้ายข้อความ
		passwordLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox password = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		password.getChildren().add(passwordLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		password.setAlignment(Pos.TOP_LEFT);

		SettingPage.node.add(password, 3, 0);

		//กล่อง Password
		TextField passwordField = new TextField(); // สร้างช่องใส่รหัสบัตรปชช
		passwordField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		passwordField.setPromptText("รหัสผ่าน"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		GridPane.setColumnSpan(passwordField, 2); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(passwordField, 3, 1); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,11

		//Last Name
		Label lastnameLabel = new Label("นามสกุล"); //อารมณ์ประมาณสร้างป้ายข้อความ
		lastnameLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox lastname = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		lastname.getChildren().add(lastnameLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		lastname.setAlignment(Pos.TOP_LEFT);

		SettingPage.node.add(lastname, 3, 8);

		//กล่อง Last Name
		TextField lastnameField = new TextField(); // สร้างช่องใส่รหัสบัตรปชช
		lastnameField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		lastnameField.setPromptText("นามสกุล"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		GridPane.setColumnSpan(lastnameField, 2); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(lastnameField, 3, 9); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,11

		//Gender
		Label genderLabel = new Label("เพศ"); //อารมณ์ประมาณสร้างป้ายข้อความ
		genderLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox gender = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		gender.getChildren().add(genderLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		gender.setAlignment(Pos.TOP_LEFT);

		SettingPage.node.add(gender, 2, 12);

		//กล่อง Gender
		TextField genderField = new TextField(); // สร้างช่องใส่รหัสบัตรปชช
		genderField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		genderField.setPromptText("เพศ"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		GridPane.setColumnSpan(genderField, 1); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(genderField, 2, 13); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,11

		//Birthdate
		Label birthdateLabel = new Label("วันเกิด (วว/ดด/ปปปป)"); //อารมณ์ประมาณสร้างป้ายข้อความ
		birthdateLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox birthdate = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		birthdate.getChildren().add(birthdateLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		birthdate.setAlignment(Pos.TOP_LEFT);

		SettingPage.node.add(birthdate, 3, 12);

		//กล่อง Birthdate
		TextField birthdateField = new TextField(); // สร้างช่องใส่รหัสบัตรปชช
		birthdateField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		GridPane.setColumnSpan(birthdateField, 1); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(birthdateField, 3, 13); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,11

		//Phone number
		Label phonenumberLabel = new Label("หมายเลขโทรศัพท์"); //อารมณ์ประมาณสร้างป้ายข้อความ
		phonenumberLabel.setFont(KornFont.smallLight); //เซตฟอนต์

		VBox phonenumber = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		phonenumber.getChildren().add(phonenumberLabel); //เพิ่มหัวข้อเข้าไปชั้นบนสุด
		phonenumber.setAlignment(Pos.TOP_LEFT);

		SettingPage.node.add(phonenumber, 3, 16);

		//กล่อง Phone number
		TextField phonenumberField = new TextField(); // สร้างช่องใส่รหัสบัตรปชช
		phonenumberField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		phonenumberField.setPromptText("หมายเลขโทรศัพท์"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		GridPane.setColumnSpan(phonenumberField, 2); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		SettingPage.node.add(phonenumberField, 3, 17); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,11

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//Save Button
		Button saveButton = new Button("บันทึกข้อมูล"); // สร้างปุ่ม Save
		saveButton.setFont(KornFont.paragraphNormal); // เซตฟอนต์เช่นเดิม
		saveButton.setMinWidth(Column3.getPrefWidth() * 2); // เซตขนาดความกว้างของปุ่มให้มันขนาดตามกับขนาดช่องของคอลัมน์นั้น ๆ คือทำให้เต็มช่องนั่นแหละ...
		saveButton.setDefaultButton(true); // เซ็ตให้เป็นปุ่มเริ่มต้น หมายถึงถ้ามีปุ่มนี้ในหน้าไหน กด Enter จะเป็นเรียกการทำงานของปุ่ม
		//loginButton.setGraphic(KornIcon.getIconRegular("\uF2F6")); // ใส่ Icon หน้า Text ของปุ่ม
		//loginButton.setGraphicTextGap(10); // ระยะห่างระหว่าง Icon กับ Text
		GridPane.setColumnSpan(saveButton, 2);
		SettingPage.node.add(saveButton, 2, 26); // ยัดใส่เช่้นเดิม

		//Log out Button
		Button logoutButton = new Button("ออกจากระบบ"); // สร้างปุ่ม Save
		logoutButton.setFont(KornFont.paragraphNormal); // เซตฟอนต์เช่นเดิม
		logoutButton.setMinWidth(Column3.getPrefWidth() * 2); // เซตขนาดความกว้างของปุ่มให้มันขนาดตามกับขนาดช่องของคอลัมน์นั้น ๆ คือทำให้เต็มช่องนั่นแหละ...
		//loginButton.setGraphic(KornIcon.getIconRegular("\uF2F6")); // ใส่ Icon หน้า Text ของปุ่ม
		//loginButton.setGraphicTextGap(10); // ระยะห่างระหว่าง Icon กับ Text
		GridPane.setColumnSpan(logoutButton, 2);
		SettingPage.node.add(logoutButton, 2, 29); // ยัดใส่เช่้นเดิม

		//Back Button
		Button backButton = new Button("ย้อนกลับ"); // สร้างปุ่ม Save
		backButton.setFont(KornFont.paragraphNormal); // เซตฟอนต์เช่นเดิม
		backButton.setMinWidth(Column6.getPrefWidth()); // เซตขนาดความกว้างของปุ่มให้มันขนาดตามกับขนาดช่องของคอลัมน์นั้น ๆ คือทำให้เต็มช่องนั่นแหละ...
		backButton.setCancelButton(true); // เซ็ตให้เป็นปุ่มเริ่มต้น หมายถึงถ้ามีปุ่มนี้ในหน้าไหน กด Esc จะเป็นเรียกการทำงานของปุ่ม
		//loginButton.setGraphic(KornIcon.getIconRegular("\uF2F6")); // ใส่ Icon หน้า Text ของปุ่ม
		//loginButton.setGraphicTextGap(10); // ระยะห่างระหว่าง Icon กับ Text
		GridPane.setColumnSpan(backButton, 2);
		SettingPage.node.add(backButton, 4, 29); // ยัดใส่เช่้นเดิม

		backButton.setOnAction(Home.redirectEvent(EnumPage.DASHBOARD()));

		return SettingPage.node;
	}

	private static GridPane node;
}