package kmitl.covid.content.authentication;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import kmitl.covid.lib.methods.authentication.CVForgotPasswordEvent;
import kmitl.covid.lib.methods.style.CVStyle;
import kmitl.covid.template.Home;

public class ForgotPasswordPage {
	public static GridPane getContent() {
		if (ForgotPasswordPage.node != null) return ForgotPasswordPage.node;
		ForgotPasswordPage.node = new GridPane();
		ForgotPasswordPage.node.setAlignment(Pos.TOP_CENTER);
		ForgotPasswordPage.node.setVgap(20);

		ColumnConstraints leftColumn = new ColumnConstraints(150);
		ColumnConstraints middleColumn = new ColumnConstraints(300);
		ColumnConstraints rightColumn = new ColumnConstraints(150);
		ForgotPasswordPage.node.getColumnConstraints().addAll(
			leftColumn, middleColumn, rightColumn
		);

		Label headerLabel = new Label("ลืมรหัสผ่าน");
		headerLabel.setFont(KornFont.headerBold);
		Label subHeaderLabel = new Label("ระบบจองวัคซีนออนไลน์");
		subHeaderLabel.setFont(KornFont.subHeaderNormal);

		VBox header = new VBox();
		header.getChildren().add(headerLabel);
		header.getChildren().add(subHeaderLabel);
		header.setAlignment(Pos.CENTER);
		header.setPadding(new Insets(0, 0, 20, 0));

		GridPane.setColumnSpan(header, 5);
		ForgotPasswordPage.node.add(header, 0, 0);

		VBox email = KornField.getTextFieldWithLabel("อีเมล");
		ForgotPasswordPage.node.add(email, 1, 1);

		VBox nationalID = KornField.getTextFieldWithLabel("รหัสบัตรประชาชน");
		ForgotPasswordPage.node.add(nationalID, 1, 2);

		VBox newPassword = KornField.getTextFieldWithLabel("รหัสผ่านใหม่");
		ForgotPasswordPage.node.add(newPassword, 1, 3);

		Button changePasswordButton = CVStyle.makeButton("เปลี่ยนรหัสผ่าน", "\uF044", EnumButtonType.WARNING);
		changePasswordButton.setMinWidth(middleColumn.getPrefWidth());
		changePasswordButton.setDefaultButton(true);
		GridPane.setMargin(changePasswordButton, new Insets(10, 0, 0, 0));
		ForgotPasswordPage.node.add(changePasswordButton, 1, 4);

		Separator separator = new Separator();
		separator.setPadding(new Insets(10, 0, 10, 0));
		GridPane.setColumnSpan(separator, 3);
		ForgotPasswordPage.node.add(separator, 0, 5);

		Button backButton = CVStyle.makeButton("ย้อนกลับ", "\uF01E", EnumButtonType.INFO);
		backButton.setMinWidth(middleColumn.getPrefWidth());
		backButton.setCancelButton(true);
		ForgotPasswordPage.node.add(backButton, 1, 6);

		TextField emailField = (TextField) email.getChildren().get(1);
		TextField nationalIDField = (TextField) nationalID.getChildren().get(1);
		TextField newPasswordField = (TextField) newPassword.getChildren().get(1);
		EventHandler<ActionEvent> forgotPasswordEvent = CVForgotPasswordEvent.ForgotpasswordEvent(
			emailField,
			nationalIDField,
			newPasswordField
		);

		emailField.setOnAction(forgotPasswordEvent);
		nationalIDField.setOnAction(forgotPasswordEvent);
		newPasswordField.setOnAction(forgotPasswordEvent);
		changePasswordButton.setOnAction(forgotPasswordEvent);

		backButton.setOnAction(Home.redirectEvent(EnumPage.LOGIN()));

		return ForgotPasswordPage.node;
	}

	private static GridPane node;
}
