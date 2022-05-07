package kmitl.covid.content.user;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.classes.user.User;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornutil.KornField;
import kmitl.covid.lib.korn.kornutil.KornFont;
import kmitl.covid.lib.korn.kornutil.KornIcon;
import kmitl.covid.lib.methods.authentication.CVLoginEvent;
import kmitl.covid.lib.methods.user.CVUser;
import kmitl.covid.lib.methods.user.CVUserEvent;
import kmitl.covid.template.Home;

public class SettingPage {
	public static GridPane getContent() {
		if (SettingPage.node != null) return SettingPage.node;

		double columnHGap = 40;
		double columnVGap = 15;
		double columnWidth = 120;

		SettingPage.node = new GridPane();
		SettingPage.node.setAlignment(Pos.TOP_CENTER);
		SettingPage.node.setVgap(columnVGap);
		SettingPage.node.setHgap(columnHGap);

		ColumnConstraints column = new ColumnConstraints(columnWidth);
		SettingPage.node.getColumnConstraints().addAll(
			column, column, column, column, column, column
		);

		Label header = new Label("ตั้งค่าข้อมูลผู้ใช้");
		header.setFont(KornFont.headerBold);
		header.setGraphic(KornIcon.getIconBig("\uF4FE"));
		header.setGraphicTextGap(20);
		header.setPadding(new Insets(0, 0, 20, 0));
		GridPane.setHalignment(header, HPos.CENTER);
		GridPane.setColumnSpan(header, 6);
		SettingPage.node.add(header, 0, 0);

		VBox username = KornField.getTextFieldWithLabel("ชื่อผู้ใช้");
		GridPane.setColumnSpan(username, 3);
		SettingPage.node.add(username, 0, 1);

		VBox nationalID = KornField.getTextFieldWithLabel("รหัสประจำตัวประชาชน");
		GridPane.setColumnSpan(nationalID, 3);
		SettingPage.node.add(nationalID, 3, 1);

		VBox nameTitle = KornField.getTextFieldWithLabel("คำนำหน้า");
		GridPane.setColumnSpan(nameTitle, 2);
		SettingPage.node.add(nameTitle, 0, 2);

		VBox firstName = KornField.getTextFieldWithLabel("ชื่อจริง");
		GridPane.setColumnSpan(firstName, 2);
		SettingPage.node.add(firstName, 2, 2);

		VBox lastName = KornField.getTextFieldWithLabel("นามสกุล");
		GridPane.setColumnSpan(lastName, 2);
		SettingPage.node.add(lastName, 4, 2);

		VBox gender = KornField.getTextFieldWithLabel("เพศ");
		GridPane.setColumnSpan(gender, 3);
		SettingPage.node.add(gender, 0, 3);

		VBox birthDate = KornField.getTextFieldWithLabel("วันเกิด");
		GridPane.setColumnSpan(birthDate, 3);
		SettingPage.node.add(birthDate, 3, 3);

		VBox email = KornField.getTextFieldWithLabel("อีเมล");
		GridPane.setColumnSpan(email, 3);
		SettingPage.node.add(email, 0, 4);

		VBox phoneNumber = KornField.getTextFieldWithLabel("เบอร์โทรศัพท์");
		GridPane.setColumnSpan(phoneNumber, 3);
		SettingPage.node.add(phoneNumber, 3, 4);

		VBox address = KornField.getTextFieldWithLabel("ที่อยู่");
		GridPane.setColumnSpan(address, 6);
		SettingPage.node.add(address, 0, 5);

		Separator separator = new Separator();
		separator.setPadding(new Insets(20, 0, 20, 0));
		GridPane.setColumnSpan(separator, 6);
		SettingPage.node.add(separator, 0, 6);

		Button saveButton = new Button("บันทึกข้อมูล");
		saveButton.setFont(KornFont.paragraphNormal);
		saveButton.setMinWidth((columnWidth * 2) + columnHGap);
		saveButton.setDefaultButton(true);
		saveButton.setGraphic(KornIcon.getIconRegular("\uF0C7"));
		saveButton.setGraphicTextGap(10);
		GridPane.setColumnSpan(saveButton, 2);
		SettingPage.node.add(saveButton, 1, 7);

		Button backButton = new Button("ย้อนกลับ");
		backButton.setFont(KornFont.paragraphNormal);
		backButton.setMinWidth((columnWidth * 2) + columnHGap);
		backButton.setCancelButton(true);
		backButton.setGraphic(KornIcon.getIconRegular("\uF01E"));
		backButton.setGraphicTextGap(10);
		GridPane.setColumnSpan(backButton, 2);
		SettingPage.node.add(backButton, 3, 7);

		Button logoutButton = new Button("ออกจากระบบ");
		logoutButton.setFont(KornFont.paragraphNormal);
		logoutButton.setMinWidth((columnWidth * 4) + (columnHGap * 3));
		logoutButton.setGraphic(KornIcon.getIconRegular("\uF2F5"));
		logoutButton.setGraphicTextGap(10);
		GridPane.setColumnSpan(logoutButton, 4);
		SettingPage.node.add(logoutButton, 1, 8);

		TextField usernameField = (TextField) username.getChildren().get(1);
		TextField nationalIDField = (TextField) nationalID.getChildren().get(1);
		TextField nameTitleField = (TextField) nameTitle.getChildren().get(1);
		TextField firstNameField = (TextField) firstName.getChildren().get(1);
		TextField lastNameField = (TextField) lastName.getChildren().get(1);
		TextField genderField = (TextField) gender.getChildren().get(1);
		TextField birthDateField = (TextField) birthDate.getChildren().get(1);
		TextField emailField = (TextField) email.getChildren().get(1);
		TextField phoneNumberField = (TextField) phoneNumber.getChildren().get(1);
		TextField addressField = (TextField) address.getChildren().get(1);

		User user = CVUser.getLoggedInUser();
		usernameField.setText(user.getUsername());
		// เขียนให้ครบทุก Field
		// ยกเว้น คำนำหน้า, เพศ, วันเกิด

		saveButton.setOnAction(CVUserEvent.saveEvent(
			usernameField, nationalIDField, nameTitleField, firstNameField,
			lastNameField, genderField, birthDateField,
			emailField, phoneNumberField, addressField
		));

		logoutButton.setOnAction(CVLoginEvent.logoutEvent());
		backButton.setOnAction(Home.redirectEvent(EnumPage.DASHBOARD()));

		return SettingPage.node;
	}

	private static GridPane node;
}