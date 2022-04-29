package kmitl.covid.content.user;

import javafx.scene.layout.GridPane;

public class SettingPage {
	public static GridPane getContent() {
		if (SettingPage.node != null) return SettingPage.node;
		SettingPage.node = new GridPane();

		return SettingPage.node;
	}

	private static GridPane node;
}
