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
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornutil.KornField;
import kmitl.covid.lib.korn.kornutil.KornFont;
import kmitl.covid.lib.korn.kornutil.KornIcon;
import kmitl.covid.lib.methods.authentication.CVLoginEvent;
import kmitl.covid.template.Home;

public class LoginPage {
	public static GridPane getContent() {
		if (LoginPage.node != null) return LoginPage.node;
		LoginPage.node = new GridPane();
		LoginPage.node.setAlignment(Pos.CENTER);
		LoginPage.node.setVgap(10);

		ColumnConstraints leftColumn = new ColumnConstraints(150);
		ColumnConstraints middleColumn = new ColumnConstraints(300);
		ColumnConstraints rightColumn = new ColumnConstraints(150);
		LoginPage.node.getColumnConstraints().addAll(
			leftColumn, middleColumn, rightColumn
		);

		Label headerLabel = new Label("ระบบจองวัคซีนออนไลน์");
		headerLabel.setFont(KornFont.headerBold);
		Label subHeaderLabel = new Label("มหาวิทยาลัยพระจอมเกล้าคุณทหารลาดกระบัง");
		subHeaderLabel.setFont(KornFont.subHeaderNormal);

		VBox header = new VBox();
		header.getChildren().add(headerLabel);
		header.getChildren().add(subHeaderLabel);
		header.setAlignment(Pos.CENTER);
		header.setPadding(new Insets(0, 0, 20, 0));

		GridPane.setColumnSpan(header, 3);
		LoginPage.node.add(header, 0, 0);

		VBox username = KornField.getTextFieldWithLabel("ชื่อผู้ใช้");
		LoginPage.node.add(username, 1, 1);

		VBox password = KornField.getPasswordFieldWithLabel("รหัสผ่าน");
		LoginPage.node.add(password, 1, 2);

		Button loginButton = new Button("เข้าสู่ระบบ");
		loginButton.setFont(KornFont.paragraphNormal);
		loginButton.setMinWidth(middleColumn.getPrefWidth());
		loginButton.setDefaultButton(true);
		loginButton.setGraphic(KornIcon.getIconRegular("\uF2F6"));
		loginButton.setGraphicTextGap(10);
		LoginPage.node.add(loginButton, 1, 3);

		Hyperlink forgotPasswordLink = new Hyperlink("ลืมรหัสผ่าน?");
		forgotPasswordLink.setFont(KornFont.paragraphNormal);
		forgotPasswordLink.setVisited(true);
		forgotPasswordLink.setPadding(new Insets(10, 0, 0, 0));
		forgotPasswordLink.setBorder(Border.EMPTY);
		GridPane.setHalignment(forgotPasswordLink, HPos.CENTER);
		LoginPage.node.add(forgotPasswordLink, 1, 4);

		Separator separator = new Separator();
		separator.setPadding(new Insets(20, 0, 20, 0));
		GridPane.setColumnSpan(separator, 3);
		LoginPage.node.add(separator, 0, 5);

		Button registerButton = new Button("สมัครสมาชิก");
		registerButton.setFont(KornFont.paragraphNormal);
		registerButton.setMinWidth(middleColumn.getPrefWidth());
		registerButton.setGraphic(KornIcon.getIconRegular("\uF234"));
		registerButton.setGraphicTextGap(10);
		LoginPage.node.add(registerButton, 1, 6);

		TextField usernameField = (TextField) username.getChildren().get(1);
		PasswordField passwordField = (PasswordField) password.getChildren().get(1);

		EventHandler<ActionEvent> loginEvent = CVLoginEvent.loginEvent(
			usernameField,
			passwordField
		);
		usernameField.setOnAction(loginEvent);
		passwordField.setOnAction(loginEvent);
		loginButton.setOnAction(loginEvent);

		forgotPasswordLink.setOnAction(Home.redirectEvent(EnumPage.FORGOTPASSWORD()));
		registerButton.setOnAction(Home.redirectEvent(EnumPage.REGISTER()));

		return LoginPage.node;
	}

	private static GridPane node;
}
