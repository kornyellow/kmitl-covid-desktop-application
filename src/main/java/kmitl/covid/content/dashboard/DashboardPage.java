package kmitl.covid.content.dashboard;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import kmitl.covid.lib.korn.kornutil.KornFont;

public class DashboardPage {
	public static GridPane getContent() {
		if (DashboardPage.node != null) return DashboardPage.node;
		DashboardPage.node = new GridPane();

		Label label = new Label("หน้าแรก");
		label.setFont(KornFont.bigHeaderBold);
		DashboardPage.node.add(label, 0, 0);

		return DashboardPage.node;
	}

	private static GridPane node;
}
