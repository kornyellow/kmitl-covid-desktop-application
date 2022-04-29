package kmitl.covid.content.user;

import javafx.scene.layout.GridPane;

public class NotificationPage {
	public static GridPane getContent() {
		if (NotificationPage.node != null) return NotificationPage.node;
		NotificationPage.node = new GridPane();

		return NotificationPage.node;
	}

	private static GridPane node;
}
