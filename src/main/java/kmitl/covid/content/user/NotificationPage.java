package kmitl.covid.content.user;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;
import kmitl.covid.lib.methods.authentication.CVNotification;

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
		GridPane.setColumnSpan(header, 6);
		NotificationPage.node.add(header, 0, 0);

		VBox notificationLogin = CVNotification.getNotificationLogin();
		NotificationPage.node.add(notificationLogin,1,2);

		VBox notificationDataUpdate = CVNotification.getNotificationDataUpdate();
		NotificationPage.node.add(notificationDataUpdate,1,3);

		VBox notificationBookVaccineDetail= CVNotification.getNotificationBookVaccineDetail();
		NotificationPage.node.add(notificationBookVaccineDetail,1,4);

//		Button backButton = CVStyle.makeButton("ย้อนกลับ","\uF01E", EnumButtonType.INFO);
//		backButton.setMinWidth(middleColumn.getPrefWidth());
//		backButton.setCancelButton(true);
//		NotificationPage.node.add(backButton,5,4);
//
//		backButton.setOnAction(actionEvent -> { Home.redirect(EnumPage.LOGIN());});
		return NotificationPage.node;
	}

	private static GridPane node;
}
