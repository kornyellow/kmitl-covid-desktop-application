package kmitl.covid.content.authentication;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.enums.EnumButtonType;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornutil.KornField;
import kmitl.covid.lib.korn.kornutil.KornFont;
import kmitl.covid.lib.methods.style.CVStyle;
import kmitl.covid.lib.methods.user.CVUserEvent;
import kmitl.covid.template.Home;

public class RegisterPage {
	public static GridPane getContent() {
		if (RegisterPage.node != null) return RegisterPage.node;

		double columnHGap = 40;
		double columnVGap = 20;
		double columnWidth = 120;

		RegisterPage.node = new GridPane();
		RegisterPage.node.setAlignment(Pos.TOP_CENTER);
		RegisterPage.node.setVgap(columnVGap);
		RegisterPage.node.setHgap(columnHGap);

		ColumnConstraints column = new ColumnConstraints(columnWidth);
		RegisterPage.node.getColumnConstraints().addAll(
			column, column, column, column, column, column
		);

		Label headerLabel = new Label("สมัครสมาชิก");
		headerLabel.setFont(KornFont.headerBold);
		Label subHeaderLabel = new Label("ระบบจองวัคซีนออนไลน์");
		subHeaderLabel.setFont(KornFont.subHeaderNormal);

		VBox header = new VBox();
		header.getChildren().add(headerLabel);
		header.getChildren().add(subHeaderLabel);
		header.setAlignment(Pos.CENTER);
		header.setPadding(new Insets(0, 0, 20, 0));

		GridPane.setColumnSpan(header, 6);
		RegisterPage.node.add(header, 0, 0);

		VBox username = KornField.getTextFieldWithLabel("ชื่อผู้ใช้");
		GridPane.setColumnSpan(username, 3);
		RegisterPage.node.add(username, 0, 1);

		VBox nationalID = KornField.getTextFieldWithLabel("รหัสประจำตัวประชาชน");
		GridPane.setColumnSpan(nationalID, 3);
		RegisterPage.node.add(nationalID, 3, 1);

		VBox password = KornField.getPasswordFieldWithLabel("รหัสผ่าน");
		GridPane.setColumnSpan(password, 3);
		RegisterPage.node.add(password, 0, 2);

		VBox confirmPassword = KornField.getPasswordFieldWithLabel("ยืนยันรหัสผ่าน");
		GridPane.setColumnSpan(confirmPassword, 3);
		RegisterPage.node.add(confirmPassword, 3, 2);

		VBox nameTitle = KornField.getRadioButtonNameTitle("คำนำหน้า");
		GridPane.setColumnSpan(nameTitle, 2);
		RegisterPage.node.add(nameTitle, 0, 3);

		VBox firstName = KornField.getTextFieldWithLabel("ชื่อจริง");
		GridPane.setColumnSpan(firstName, 2);
		RegisterPage.node.add(firstName, 2, 3);

		VBox lastName = KornField.getTextFieldWithLabel("นามสกุล");
		GridPane.setColumnSpan(lastName, 2);
		RegisterPage.node.add(lastName, 4, 3);

		VBox gender = KornField.getRadioButtonGender("เพศ");
		GridPane.setColumnSpan(gender, 3);
		RegisterPage.node.add(gender, 0, 4);

		VBox birthDate = KornField.getTextFieldWithLabel("วันเกิด");
		GridPane.setColumnSpan(birthDate, 4);
		RegisterPage.node.add(birthDate, 2, 4);

		VBox email = KornField.getTextFieldWithLabel("อีเมล");
		GridPane.setColumnSpan(email, 3);
		RegisterPage.node.add(email, 0, 5);

		VBox phoneNumber = KornField.getTextFieldWithLabel("เบอร์โทรศัพท์");
		GridPane.setColumnSpan(phoneNumber, 3);
		RegisterPage.node.add(phoneNumber, 3, 5);

		VBox address = KornField.getTextFieldWithLabel("ที่อยู่");
		GridPane.setColumnSpan(address, 6);
		RegisterPage.node.add(address, 0, 6);

		Separator separator = new Separator();
		separator.setPadding(new Insets(20, 0, 20, 0));
		GridPane.setColumnSpan(separator, 6);
		RegisterPage.node.add(separator, 0, 7);

		Button registerButton = CVStyle.makeButton("สมัครสมาชิก", "\uF234", EnumButtonType.SUCCESS);
		registerButton.setMinWidth((columnWidth * 2) + columnHGap);
		registerButton.setDefaultButton(true);
		GridPane.setColumnSpan(registerButton, 2);
		RegisterPage.node.add(registerButton, 1, 8);

		Button backButton = CVStyle.makeButton("ย้อนกลับ", "\uF01E", EnumButtonType.INFO);
		backButton.setMinWidth((columnWidth * 2) + columnHGap);
		backButton.setCancelButton(true);
		GridPane.setColumnSpan(backButton, 2);
		RegisterPage.node.add(backButton, 3, 8);

		TextField usernameField = (TextField) username.getChildren().get(1);
		TextField nationalIDField = (TextField) nationalID.getChildren().get(1);
		TextField passwordField = (TextField) password.getChildren().get(1);
		TextField confirmPasswordField = (TextField) confirmPassword.getChildren().get(1);
		TextField genderField = new TextField();
		TextField firstNameField = (TextField) firstName.getChildren().get(1);
		TextField lastNameField = (TextField) lastName.getChildren().get(1);
		TextField nameTitleField = new TextField();
		TextField birthDateField = new TextField();
		TextField emailField = (TextField) email.getChildren().get(1);
		TextField phoneNumberField = (TextField) phoneNumber.getChildren().get(1);
		TextField addressField = (TextField) address.getChildren().get(1);
		registerButton.setOnAction(CVUserEvent.registerEvent(
			usernameField, nationalIDField, passwordField,
			confirmPasswordField, nameTitleField, firstNameField,
			lastNameField, genderField, birthDateField,
			emailField, phoneNumberField, addressField
		));

		backButton.setOnAction(Home.redirectEvent(EnumPage.LOGIN()));

		return RegisterPage.node;
	}

	private static GridPane node;
}
