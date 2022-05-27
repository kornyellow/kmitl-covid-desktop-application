package kmitl.covid.content.user;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.classes.notification.Notification;
import kmitl.covid.lib.enums.EnumAlertType;
import kmitl.covid.lib.enums.EnumButtonType;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornfx.KornAlert;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;
import kmitl.covid.lib.methods.notification.CVNotification;
import kmitl.covid.lib.methods.style.CVStyle;
import kmitl.covid.lib.methods.user.CVUser;
import kmitl.covid.template.Home;

import java.util.ArrayList;

public class NotificationPage {
	public static GridPane getContent() {
		if (NotificationPage.node != null) return NotificationPage.node;
		NotificationPage.node = new GridPane();
		NotificationPage.node.setVgap(20);
		NotificationPage.node.setAlignment(Pos.TOP_CENTER);

		Label header = new Label("การแจ้งเตือน");
		header.setFont(KornFont.headerBold);
		header.setGraphic(KornIcon.getIconBig("\uF0F3"));
		header.setGraphicTextGap(20);
		header.setPadding(new Insets(0, 0, 20, 0));
		GridPane.setHalignment(header, HPos.CENTER);
		NotificationPage.node.add(header, 0, 0);

		HBox box = new HBox();
		box.setSpacing(20);
		box.setAlignment(Pos.CENTER);

		Button deleteButton = CVStyle.makeButton("ลบการแจ้งเตือน", "\uF2ED", EnumButtonType.DANGER);
		deleteButton.setOnAction(actionEvent -> {
			CVNotification.readNotifications(CVUser.getLoggedInUser());
			KornAlert.alert(
				EnumAlertType.SUCCESS,
				"ลบการแจ้งเตือนทั้งหมดสำเร็จ",
				dialogEvent -> Home.redirect(EnumPage.DASHBOARD())
			);
		});
		box.getChildren().add(deleteButton);

		Button backButton = CVStyle.makeButton("ย้อนกลับ", "\uF01E", EnumButtonType.INFO);
		backButton.setOnAction(Home.redirectEvent(EnumPage.DASHBOARD()));
		box.getChildren().add(backButton);

		GridPane.setHalignment(box, HPos.CENTER);
		NotificationPage.node.add(box, 0, 1);

		if (CVUser.getLoggedInUser() != null && CVNotification.getNotificationsUnRead(CVUser.getLoggedInUser()).size() != 0) {
			ArrayList<Notification> notifications = CVNotification.getNotificationsUnRead(CVUser.getLoggedInUser());
			int row = 2;
			for (Notification notification : notifications) {
				VBox notificationLogin = CVStyle.getNotificationBox(notification);
				NotificationPage.node.add(notificationLogin, 0, row++);
			}
		}

		return NotificationPage.node;
	}

	private static GridPane node;

	public static void reset() {
		NotificationPage.node = null;
	}
}
