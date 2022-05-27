package kmitl.covid.lib.methods.style;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.classes.notification.Notification;
import kmitl.covid.lib.enums.EnumButtonType;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;

public class CVStyle {
	public static Button makeButton(String text, String icon, EnumButtonType type) {
		Button button = new Button(text);
		button.setFont(KornFont.paragraphBold);
		if (icon != null) {
			button.setGraphic(KornIcon.getIconRegular(icon));
			button.setGraphicTextGap(10);
			button.getGraphic().getStyleClass().addAll("graphic");
		}
		button.getStyleClass().addAll("btn", type.getStyle());

		return button;
	}

	public static VBox getNotificationBox(Notification notification) {
		Label title = new Label(notification.getTitle());
		title.setFont(KornFont.subHeaderBold);

		Label subTitle = new Label(notification.getData());
		subTitle.setFont(KornFont.subHeaderNormal);

		Label timeStamp = new Label(notification.getDate().toFullThaiDate() + " เวลา " + notification.getDate().getFullTime24FormatWithLeadingZero());
		timeStamp.setFont(KornFont.subHeaderNormal);

		GridPane titleBox = new GridPane();
		titleBox.getColumnConstraints().addAll(
			new ColumnConstraints(100, 500, 500),
			new ColumnConstraints(100, 500, 500)
		);

		titleBox.add(title, 0, 0);
		GridPane.setHalignment(timeStamp, HPos.RIGHT);
		GridPane.setValignment(timeStamp, VPos.TOP);
		titleBox.add(timeStamp, 1, 0);

		VBox box = new VBox();
		box.setSpacing(20);
		box.getChildren().addAll(titleBox, subTitle);
		box.getStyleClass().add("grid-card");

		return box;
	}

	public static HBox getInformationModule(String iconText, String headerText, String contentText, String footerText, String color) {
		HBox card = new HBox();
		card.setAlignment(Pos.TOP_LEFT);
		card.setSpacing(30);

		Label icon = KornIcon.getIconMassive(iconText);
		icon.getStyleClass().add("text-light");
		card.getChildren().add(icon);

		Label header = new Label(headerText);
		header.setFont(KornFont.paragraphBold);
		header.getStyleClass().add("text-light");
		Label content = new Label(contentText);
		content.setFont(KornFont.bigHeaderLight);
		content.getStyleClass().add("text-light");
		Label footer = new Label(footerText);
		footer.setFont(KornFont.smallBold);
		footer.getStyleClass().add("text-light");

		VBox box = new VBox();
		box.setSpacing(5);
		box.setAlignment(Pos.CENTER_RIGHT);
		box.getChildren().add(header);
		box.getChildren().add(content);
		box.getChildren().add(footer);
		card.getChildren().add(box);
		card.getStyleClass().addAll("card-color", "card-color-" + color);

		return card;
	}
}
