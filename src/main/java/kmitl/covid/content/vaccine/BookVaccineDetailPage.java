package kmitl.covid.content.vaccine;

import javafx.scene.layout.GridPane;

public class BookVaccineDetailPage {
	public static GridPane getContent() {
		if (BookVaccineDetailPage.node != null) return BookVaccineDetailPage.node;
		BookVaccineDetailPage.node = new GridPane();

		return BookVaccineDetailPage.node;
	}

	private static GridPane node;
}
