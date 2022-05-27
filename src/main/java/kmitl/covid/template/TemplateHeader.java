package kmitl.covid.template;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;
import kmitl.covid.lib.methods.notification.CVNotification;
import kmitl.covid.lib.methods.user.CVUser;

public class TemplateHeader {
	public static GridPane getContent() {
		if (TemplateHeader.node != null) return TemplateHeader.node;
		TemplateHeader.node = new GridPane();

		RowConstraints row = new RowConstraints();
		row.setVgrow(Priority.ALWAYS);
		TemplateHeader.node.getRowConstraints().addAll(row);

		ColumnConstraints column = new ColumnConstraints();
		column.setHgrow(Priority.ALWAYS);
		TemplateHeader.node.getColumnConstraints().addAll(column);

		HBox titleBox = new HBox();
		titleBox.getChildren().add(KornIcon.getIconBig("\uE596"));

		Label title = new Label("ระบบจองวัคซีนออนไลน์");
		title.setFont(KornFont.headerBold);
		titleBox.setAlignment(Pos.CENTER_LEFT);
		titleBox.setSpacing(10);
		titleBox.getChildren().add(title);

		GridPane.setHalignment(titleBox, HPos.LEFT);
		GridPane.setValignment(titleBox, VPos.CENTER);
		TemplateHeader.node.add(titleBox, 0, 0);

		Label welcome = new Label("ยินดีต้อนรับ");
		welcome.setFont(KornFont.paragraphBold);
		Label name = new Label("คุณ " + CVUser.getLoggedInUser().getFullName());
		name.setFont(KornFont.paragraphNormal);

		VBox username = new VBox();
		username.setAlignment(Pos.CENTER_RIGHT);
		username.getChildren().add(welcome);
		username.getChildren().add(name);

		HBox welcomeMessage = new HBox();
		welcomeMessage.setAlignment(Pos.CENTER);
		welcomeMessage.setSpacing(20);
		welcomeMessage.getChildren().add(username);

		Hyperlink userIcon = new Hyperlink("\uF007");
		userIcon.setFont(KornIcon.bigFont);
		userIcon.setAlignment(Pos.CENTER);
		userIcon.setPadding(new Insets(10, 0, 15, 15));
		userIcon.setBorder(Border.EMPTY);
		userIcon.setVisited(true);
		userIcon.setOnAction(Home.redirectEvent(EnumPage.SETTING()));
		userIcon.getStyleClass().add("btn-other");
		welcomeMessage.getChildren().add(userIcon);

		Hyperlink notificationIcon = new Hyperlink("\uF0F3");
		notificationIcon.setFont(KornIcon.bigFont);
		notificationIcon.setAlignment(Pos.CENTER);
		notificationIcon.setPadding(new Insets(10, 0, 15, 15));
		notificationIcon.setBorder(Border.EMPTY);
		notificationIcon.setVisited(true);
		notificationIcon.setOnAction(Home.redirectEvent(EnumPage.NOTIFICATION()));
		notificationIcon.getStyleClass().add("btn-other");
		welcomeMessage.getChildren().add(notificationIcon);

		Pane notificationPane = new Pane();
		notificationPane.setPrefSize(50, 50);

		int notificationCount = CVNotification.getNotificationsUnRead(CVUser.getLoggedInUser()).size();
		if (notificationCount > 0) {
			boolean isTooBig = false;
			String notificationString = String.valueOf(notificationCount);
			if (notificationCount > 99) {
				isTooBig = true;
				notificationString = "99+";
			}

			Label notificationBadge = new Label(notificationString);
			notificationBadge.setFont(KornFont.smallBold);
			notificationBadge.setTranslateX(-25);
			notificationBadge.setTranslateY(50);
			notificationBadge.getStyleClass().add("notification-badge");
			notificationBadge.setPrefSize(
				20 + ((notificationCount >= 10) ? 10 : 0) + (isTooBig ? 10 : 0),
				20
			);
			notificationBadge.setAlignment(Pos.CENTER);
			notificationPane.getChildren().add(notificationBadge);
		} else {
			notificationIcon.setDisable(true);
		}

		welcomeMessage.getChildren().add(notificationPane);

		GridPane.setHalignment(welcomeMessage, HPos.RIGHT);
		GridPane.setValignment(welcomeMessage, VPos.CENTER);
		TemplateHeader.node.add(welcomeMessage, 1, 0);

		return TemplateHeader.node;
	}

	private static GridPane node;

	public static void reset() {
		TemplateHeader.node = null;
	}
}
