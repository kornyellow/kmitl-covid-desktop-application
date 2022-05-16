package kmitl.covid.content.vaccine;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;

public class BookVaccinePage {
	public static GridPane getContent() {
		if (BookVaccinePage.node != null) return BookVaccinePage.node;
		BookVaccinePage.node = new GridPane();
		BookVaccinePage.node.setAlignment(Pos.TOP_CENTER);

		Label header = new Label("เลือกวันจองวัคซีน");
		header.setFont(KornFont.headerBold);
		header.setGraphic(KornIcon.getIconBig("\uF073"));
		header.setGraphicTextGap(20);
		header.setPadding(new Insets(0, 0, 20, 0));
		GridPane.setHalignment(header, HPos.CENTER);
		GridPane.setColumnSpan(header, 6);
		BookVaccinePage.node.add(header, 0, 0);

		return BookVaccinePage.node;
	}

	private static GridPane node;
}
