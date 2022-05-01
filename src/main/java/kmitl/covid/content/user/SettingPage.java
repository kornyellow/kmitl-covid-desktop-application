package kmitl.covid.content.user;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import kmitl.covid.lib.korn.kornutil.KornFont;

public class SettingPage {
	public static GridPane getContent() {
		if (SettingPage.node != null) return SettingPage.node;
		SettingPage.node = new GridPane();

		Label label = new Label("ตั้งค่า");
		label.setFont(KornFont.bigHeaderBold);
		SettingPage.node.add(label, 0, 0);

		return SettingPage.node;
	}

	private static GridPane node;
}
