package kmitl.covid.content.user;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import kmitl.covid.lib.korn.kornutil.KornFont;
import kmitl.covid.lib.korn.kornutil.KornIcon;

public class NotificationPage {
	public static GridPane getContent() {
		if (NotificationPage.node != null) return NotificationPage.node;
		NotificationPage.node = new GridPane();
		NotificationPage.node.setAlignment(Pos.TOP_CENTER);

		Label header = new Label("การแจ้งเตือน");
		header.setFont(KornFont.headerBold);
		header.setGraphic(KornIcon.getIconBig("\uF0F3"));
		header.setGraphicTextGap(20);
		header.setPadding(new Insets(0, 0, 20, 0));
		GridPane.setHalignment(header, HPos.CENTER);
		GridPane.setColumnSpan(header, 6);
		NotificationPage.node.add(header, 0, 0);

		return NotificationPage.node;
	}

	private static GridPane node;
}
