package kmitl.covid.content.vaccine;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;

public class BookVaccineDetailPage {
	public static GridPane getContent() {
		if (BookVaccineDetailPage.node != null) return BookVaccineDetailPage.node;
		BookVaccineDetailPage.node = new GridPane();
		BookVaccineDetailPage.node.setAlignment(Pos.TOP_CENTER);

		Label header = new Label("รายละเอียดการจองวัคซีน");
		header.setFont(KornFont.headerBold);
		header.setGraphic(KornIcon.getIconBig("\uF48E"));
		header.setGraphicTextGap(20);
		header.setPadding(new Insets(0, 0, 20, 0));
		GridPane.setHalignment(header, HPos.CENTER);
		GridPane.setColumnSpan(header, 6);
		BookVaccineDetailPage.node.add(header, 0, 0);

		return BookVaccineDetailPage.node;
	}

	private static GridPane node;
}
