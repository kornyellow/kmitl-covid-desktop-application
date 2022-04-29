package kmitl.covid.content.vaccine;

import javafx.scene.layout.GridPane;

public class BookVaccineSuccessPage {
	public static GridPane getContent() {
		if (BookVaccineSuccessPage.node != null) return BookVaccineSuccessPage.node;
		BookVaccineSuccessPage.node = new GridPane();

		return BookVaccineSuccessPage.node;
	}

	private static GridPane node;
}
