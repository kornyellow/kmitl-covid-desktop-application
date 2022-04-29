package kmitl.covid.content.vaccine;

import javafx.scene.layout.GridPane;

public class BookVaccinePage {
	public static GridPane getContent() {
		if (BookVaccinePage.node != null) return BookVaccinePage.node;
		BookVaccinePage.node = new GridPane();

		return BookVaccinePage.node;
	}

	private static GridPane node;
}
