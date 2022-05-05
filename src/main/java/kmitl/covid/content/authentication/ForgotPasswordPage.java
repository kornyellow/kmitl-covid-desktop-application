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
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornutil.KornFont;
import kmitl.covid.template.Home;

public class ForgotPasswordPage {
	public static GridPane getContent() {
		if (ForgotPasswordPage.node != null) return ForgotPasswordPage.node;
		ForgotPasswordPage.node = new GridPane();
		ForgotPasswordPage.node.setAlignment(Pos.TOP_CENTER);
		ForgotPasswordPage.node.setVgap(10);

		ColumnConstraints leftColumn = new ColumnConstraints(150);
		ColumnConstraints middleColumn = new ColumnConstraints(300);
		ColumnConstraints rightColumn = new ColumnConstraints(150);

		ForgotPasswordPage.node.getColumnConstraints().addAll(
			leftColumn,
			middleColumn,
			rightColumn
		);

		Label headerLabel = new Label("ลืมรหัสผ่าน");
		headerLabel.setFont(KornFont.headerBold);

		VBox header = new VBox();
		header.getChildren().add(headerLabel);
		header.setAlignment(Pos.TOP_CENTER);
		header.setPadding(new Insets(0, 0, 20, 0));

		GridPane.setColumnSpan(header, 5);
		ForgotPasswordPage.node.add(header, 0, 0);

		TextField emailField = new TextField();
		emailField.setFont(KornFont.paragraphNormal);
		emailField.setPromptText("อีเมล");
		emailField.setAlignment(Pos.CENTER);
		ForgotPasswordPage.node.add(emailField, 1, 1);

		TextField nationalIDField = new TextField();
		nationalIDField.setFont(KornFont.paragraphNormal);
		nationalIDField.setPromptText("รหัสบัตรประชาชน");
		nationalIDField.setAlignment(Pos.CENTER);
		ForgotPasswordPage.node.add(nationalIDField, 1, 2);

		TextField newPasswordField = new TextField();
		newPasswordField.setFont(KornFont.paragraphNormal);
		newPasswordField.setPromptText("รหัสผ่านใหม่");
		newPasswordField.setAlignment(Pos.CENTER);
		ForgotPasswordPage.node.add(newPasswordField, 1, 3);

		Button resetPassword = new Button("เปลี่ยนรหัสผ่าน");
		resetPassword.setFont(KornFont.paragraphNormal);
		resetPassword.setMinWidth(middleColumn.getPrefWidth());
		resetPassword.setDefaultButton(true);
		resetPassword.setGraphicTextGap(10);
		ForgotPasswordPage.node.add(resetPassword, 1, 4);

		Separator separator = new Separator();
		separator.setPadding(new Insets(20, 0, 20, 0));
		GridPane.setColumnSpan(separator, 3);
		ForgotPasswordPage.node.add(separator, 0, 5);

		Button back = new Button("ย้อนกลับ");
		back.setFont(KornFont.paragraphNormal);
		back.setMinWidth(middleColumn.getPrefWidth());
		back.setGraphicTextGap(10);
		back.setCancelButton(true);
		ForgotPasswordPage.node.add(back, 1, 6);

		back.setOnAction(Home.redirectEvent(EnumPage.LOGIN()));

		return ForgotPasswordPage.node;
	}

	private static GridPane node;
}
