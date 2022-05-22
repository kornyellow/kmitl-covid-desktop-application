package kmitl.covid.content.authentication;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.enums.EnumButtonType;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornfx.KornField;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.methods.authentication.CVLoginEvent;
import kmitl.covid.lib.methods.style.CVStyle;
import kmitl.covid.template.Home;

public class LoginPage {
	public static GridPane getContent() {
		if (LoginPage.node != null) return LoginPage.node;
		LoginPage.node = new GridPane();
		LoginPage.node.setAlignment(Pos.CENTER);
		LoginPage.node.setVgap(20);

		ColumnConstraints leftColumn = new ColumnConstraints(150);
		ColumnConstraints middleColumn = new ColumnConstraints(300);
		ColumnConstraints rightColumn = new ColumnConstraints(150);
		LoginPage.node.getColumnConstraints().addAll(
			leftColumn, middleColumn, rightColumn
		);

		Label headerLabel = new Label("ระบบจองวัคซีนออนไลน์");
		headerLabel.setFont(KornFont.headerBold);
		Label subHeaderLabel = new Label("สถาบันเทคโนโลยีพระจอมเกล้าคุณทหารลาดกระบัง");
		subHeaderLabel.setFont(KornFont.subHeaderNormal);

		VBox header = new VBox();
		header.getChildren().add(headerLabel);
		header.getChildren().add(subHeaderLabel);
		header.setAlignment(Pos.CENTER);
		header.setPadding(new Insets(0, 0, 20, 0));

		GridPane.setColumnSpan(header, 3);
		LoginPage.node.add(header, 0, 0);

		VBox username = KornField.getTextFieldWithLabel("ชื่อผู้ใช้หรืออีเมล");
		LoginPage.node.add(username, 1, 1);

		VBox password = KornField.getPasswordFieldWithLabel("รหัสผ่าน");
		LoginPage.node.add(password, 1, 2);

		Button loginButton = CVStyle.makeButton("เข้าสู่ระบบ", "\uF2F6", EnumButtonType.PRIMARY);
		loginButton.setMinWidth(middleColumn.getPrefWidth());
		loginButton.setDefaultButton(true);
		GridPane.setMargin(loginButton, new Insets(10, 0, 0, 0));
		LoginPage.node.add(loginButton, 1, 3);

		Button forgotPasswordButton = CVStyle.makeButton("ลืมรหัสผ่าน?", "", EnumButtonType.EMPTY);
		forgotPasswordButton.setFont(KornFont.paragraphNormal);
		GridPane.setHalignment(forgotPasswordButton, HPos.CENTER);
		LoginPage.node.add(forgotPasswordButton, 1, 4);

		Separator separator = new Separator();
		separator.setPadding(new Insets(10, 0, 10, 0));
		GridPane.setColumnSpan(separator, 3);
		LoginPage.node.add(separator, 0, 5);

		Button registerButton = CVStyle.makeButton("สมัครสมาชิก", "\uF234", EnumButtonType.SUCCESS);
		registerButton.setMinWidth(middleColumn.getPrefWidth());
		LoginPage.node.add(registerButton, 1, 6);

		// TEMP
		Button notificationButton = CVStyle.makeButton("ไปหน้าการแจ้งเตือน", "", EnumButtonType.INFO);
		notificationButton.setOnAction(Home.redirectEvent(EnumPage.NOTIFICATION()));
		LoginPage.node.add(notificationButton, 1, 7);
		Button vaccineDetailButton = CVStyle.makeButton("ไปหน้ารายละเอียดวัคซีน", "", EnumButtonType.INFO);
		vaccineDetailButton.setOnAction(Home.redirectEvent(EnumPage.BOOKVACCINEDETAIL()));
		LoginPage.node.add(vaccineDetailButton, 1, 8);
		Button vaccineButton = CVStyle.makeButton("ไปหน้าปฏิทินจองวัคซีน", "", EnumButtonType.INFO);
		vaccineButton.setOnAction(Home.redirectEvent(EnumPage.BOOKVACCINE()));
		LoginPage.node.add(vaccineButton, 1, 9);
		// END TEMP

		TextField usernameField = (TextField) username.getChildren().get(1);
		PasswordField passwordField = (PasswordField) password.getChildren().get(1);

		EventHandler<ActionEvent> loginEvent = CVLoginEvent.loginEvent(
			usernameField,
			passwordField
		);
		usernameField.setOnAction(loginEvent);
		passwordField.setOnAction(loginEvent);
		loginButton.setOnAction(loginEvent);

		forgotPasswordButton.setOnAction(Home.redirectEvent(EnumPage.FORGOTPASSWORD()));
		registerButton.setOnAction(Home.redirectEvent(EnumPage.REGISTER()));

		return LoginPage.node;
	}

	private static GridPane node;
}
