package kmitl.covid.content.dashboard;

import javafx.scene.layout.GridPane;

public class DashboardPage {
	public static GridPane getContent() {
		if (DashboardPage.node != null) return DashboardPage.node;
		DashboardPage.node = new GridPane();

		return DashboardPage.node;
	}

	private static GridPane node;
}
