package kmitl.covid.content.authentication;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.classes.other.PasswordSkin;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornutil.KornFont;
import kmitl.covid.lib.korn.kornutil.KornIcon;
import kmitl.covid.lib.methods.authentication.CVLoginEvent;
import kmitl.covid.template.Home;

public class LoginPage {
	public static GridPane getContent() {
		if (LoginPage.node != null) return LoginPage.node; // ไม่ต้องสนใจ แต่ถ้าอยากรู้มาถามได้
		LoginPage.node = new GridPane(); // GridPane คือตารางเป็นช่องคล้าย ๆ Excel
		LoginPage.node.setAlignment(Pos.CENTER); // ตั้งค่าให้อะไรก็ตามที่อยู่ในช่องมันเรียงตรงกลาง
		LoginPage.node.setVgap(10); // ให้แต่ละช่องห่างกันแนวตั้ง 10 pixels

		// สร้างข้อกำหนดทั้งหมด 3 คอลัมน์ โดยกำหนดให้มีขนาดตามนี้
		ColumnConstraints leftColumn = new ColumnConstraints(150);
		ColumnConstraints middleColumn = new ColumnConstraints(300);
		ColumnConstraints rightColumn = new ColumnConstraints(150);
		// ยัดข้อกำหนดใส่ในตาราง Excel ของเรา
		LoginPage.node.getColumnConstraints().addAll(
			leftColumn,
			middleColumn,
			rightColumn
		);

		Label headerLabel = new Label("ระบบจองวัคซีนออนไลน์"); // สร้างอารมณ์ประมาณป้ายข้อความ
		headerLabel.setFont(KornFont.headerBold); // เซตฟอนต์ให้เป็นขนาดตัวใหญ่สุด ตัวหนา
		Label subHeaderLabel = new Label("มหาวิทยาลัยพระจอมเกล้าคุณทหารลาดกระบัง"); // สร้างเหมือนเดิม
		subHeaderLabel.setFont(KornFont.subHeaderNormal); // เซตขนาดให้เป็นตัวรองใหญ่ ตัวปกติ

		VBox header = new VBox(); // VBox คือแนวตั้งคล้าย ๆ ลิ้นชัก
		header.getChildren().add(headerLabel); // เพิ่มหัวข้อเข้าไปชั้นบนสุด
		header.getChildren().add(subHeaderLabel); // เพิ่มรองหัวข้อชั้นลงมา
		header.setAlignment(Pos.CENTER); // เซตการวางตำแหน่งเป็นตรงกลาง
		header.setPadding(new Insets(0, 0, 20, 0)); // ใส่ Padding คือช่องว่างรอบ ๆ ขนาดก็ตามที่เขียนเลย

		GridPane.setColumnSpan(header, 3); // เซตให้มัน Merge คอลัมน์ไป 3 ช่อง คือกินช่องทั้งหมด 3 ช่องนั่นเอง
		LoginPage.node.add(header, 0, 0); // เอาสิ่งที้่เราเขียนไป ยัดเข้าไปตัวหลัก (GridPage) ในตำแหน่งที่ 0,0 ของตาราง

		TextField usernameField = new TextField(); // สร้างช่องใส่ชื่อผู้ใช้
		usernameField.setFont(KornFont.paragraphNormal); // เซตฟอนเช่นเดิม
		usernameField.setPromptText("ชื่อผู้ใช้"); // ใส่ตัวหนังสือเทา ๆ บอกใบ้ข้างในช่องใส่ข้อความ
		LoginPage.node.add(usernameField, 1, 1); // ยัดใส่เช่นเดิมในตำแหน่งที่ 1,1

		PasswordField passwordField = new PasswordField(); // สร้างช่องใส่รหัสผ่าน
		passwordField.setFont(KornFont.paragraphNormal); // เซตฟอนต์เช่นเดิม
		passwordField.setPromptText("รหัสผ่าน"); // เหมือนเดิม
		passwordField.setSkin(new PasswordSkin(passwordField)); // อันนี้ใส่ Mask หรือเวลาซ่อน Password มันจะเป็นอักษรที่เราต้องการ ไม่ต้องสนใจ
		LoginPage.node.add(passwordField, 1, 2); // ยัดใส่เช่้นเดิมในตำแหน่ง 1,2

		Button loginButton = new Button("เข้าสู่ระบบ"); // สร้างปุ่มเข้าสู่ระบบ
		loginButton.setFont(KornFont.paragraphNormal); // เซตฟอนต์เช่นเดิม
		loginButton.setMinWidth(middleColumn.getPrefWidth()); // เซตขนาดความกว้างของปุ่มให้มันขนาดตามกับขนาดช่องของคอลัมน์นั้น ๆ คือทำให้เต็มช่องนั่นแหละ...
		loginButton.setDefaultButton(true); // เซ็ตให้เป็นปุ่มเริ่มต้น หมายถึงถ้ามีปุ่มนี้ในหน้าไหน กด Enter จะเป็นเรียกการทำงานของปุ่ม
		loginButton.setGraphic(KornIcon.getIconRegular("\uF2F6")); // ใส่ Icon หน้า Text ของปุ่ม
		loginButton.setGraphicTextGap(10); // ระยะห่างระหว่าง Icon กับ Text
		LoginPage.node.add(loginButton, 1, 3); // ยัดใส่เช่้นเดิม


		Hyperlink forgotPasswordLink = new Hyperlink("ลืมรหัสผ่าน?"); // สร้างลิ้งลืมรหัสผ่าน คล้าย ๆ ปุ่ม แค่ไม่มีรูปปุ่ม
		forgotPasswordLink.setFont(KornFont.paragraphNormal); // เช่นเดิม
		forgotPasswordLink.setVisited(true); // อันนี้เซตสีเฉย ๆ เวลาไม่ได้เคยลิ้งมันจะเป็นสีฟ้า ถ้ากดแล้วจะเป็นสีดำ เลยเซตให้มันเป้นสีดำ
		forgotPasswordLink.setPadding(new Insets(10, 0, 0, 0)); // ช่องว่างรอบเช่นเดิม
		forgotPasswordLink.setBorder(Border.EMPTY); // เอาขอบเส้นประมันออก อยากรู้ว่าเป็นยังไงก็ลองเอาบรรทัดนี้ออกดู -.-
		GridPane.setHalignment(forgotPasswordLink, HPos.CENTER); // ตั้งให้มันจัดไว้ตรงกลาง
		LoginPage.node.add(forgotPasswordLink, 1, 4); // ยัดใส่เช่นเดิม

		Separator separator = new Separator(); // ไม่มีอะไร ตัวแบ่งเฉย ๆ
		separator.setPadding(new Insets(20, 0, 20, 0)); // ช่องว่างรอบเช่นเดิม
		GridPane.setColumnSpan(separator, 3); // อันนี้ Merge เหมือนเดิม 3 ช่อง
		LoginPage.node.add(separator, 0, 5); // ยัดใส่จ้า

		Button registerButton = new Button("สมัครสมาชิก"); // ปุ่มสมัคร
		registerButton.setFont(KornFont.paragraphNormal); // เซตฟอนต์
		registerButton.setMinWidth(middleColumn.getPrefWidth()); // เซตขนาดให้ใหญ่ที่สุดตามขนาดคอลัมน์เช่นเดิม
		registerButton.setGraphic(KornIcon.getIconRegular("\uF234")); // ใส่ Icon หน้า Text ของปุ่ม
		registerButton.setGraphicTextGap(10); // ระยะห่างระหว่าง Icon กับ Text
		LoginPage.node.add(registerButton, 1, 6); // ยัดใส่เช่นเดิม

		// อันนี้คือ Event ลองกดเข้าไปดูใน Class CVLoginEvent คือการเขียน Event ที่จะทำหากทำอะไรที่กำหนด
		// Event อันนี้เอาไว้เช็ค Username Password ว่าเป็นยังไง ถูกต้องหรือไม่ อยากรู้มาถามเพิ่มเติมเอา
		EventHandler<ActionEvent> loginEvent = CVLoginEvent.loginEvent(
			usernameField,
			passwordField
		);
		usernameField.setOnAction(loginEvent); // เอา Event ที่ได้ดึงมาใส่ลงไปในช่องชื่อผู้ใช้ หากกด Enter เวลากำลังเขียนอยู่ มันจะทำงาน Event ดังกล่าว
		passwordField.setOnAction(loginEvent); // เช่นเดียวกัน
		loginButton.setOnAction(loginEvent); // อันนี้ต้องกดปุ่ม ถึงจะทำงาน Event ดังกล่าว

		// อันนี้คือวิธีการเปลี่ยนหน้าไปหน้าอื่น ๆ ก็คือยัด Home.redirectEvent(หน้าที่ต้องการ) ใส่ลงไปใน setOnAction ของปุ่มได้เลย
		forgotPasswordLink.setOnAction(Home.redirectEvent(EnumPage.FORGOTPASSWORD())); // อันนี้คือเปลี่ยนหน้าเป้นลืมรหัสผ่าน
		registerButton.setOnAction(Home.redirectEvent(EnumPage.REGISTER())); // อันนี้คือเปลี่ยนหน้าเป็นสมัครสมาชิก

		return LoginPage.node; // คืนค่าตัวหลักที่เรายัดอะไรไปทั้งหมด ให้มันไปแสดงผล
	}

	private static GridPane node;
}
