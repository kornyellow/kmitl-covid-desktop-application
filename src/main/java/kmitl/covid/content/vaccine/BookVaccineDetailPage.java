package kmitl.covid.content.vaccine;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import kmitl.covid.lib.enums.EnumButtonType;
import kmitl.covid.lib.korn.kornfx.KornField;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;
import kmitl.covid.lib.methods.style.CVStyle;

public class BookVaccineDetailPage {
	public static GridPane getContent() {
		double columnVGap = 50;
		double columnHGap = 40;
		double columnWidth = 120;

		if (BookVaccineDetailPage.node != null) return BookVaccineDetailPage.node;
		BookVaccineDetailPage.node = new GridPane();
		BookVaccineDetailPage.node.setAlignment(Pos.TOP_CENTER);

		BookVaccineDetailPage.node = new GridPane();
		BookVaccineDetailPage.node.setAlignment(Pos.TOP_CENTER);
		BookVaccineDetailPage.node.setVgap(columnVGap);
		//BookVaccineDetailPage.node.setHgap(columnHGap);

		ColumnConstraints column = new ColumnConstraints(columnWidth);
		BookVaccineDetailPage.node.getColumnConstraints().addAll(
			column, column, column, column, column, column
		);

		Label header = new Label("รายละเอียดการจองวัคซีน");
		header.setFont(KornFont.headerBold);
		header.setGraphic(KornIcon.getIconBig("\uF48E"));
		header.setGraphicTextGap(20);
		header.setPadding(new Insets(0, 0, 20, 0));
		GridPane.setHalignment(header, HPos.CENTER);
		GridPane.setColumnSpan(header, 6);
		BookVaccineDetailPage.node.add(header, 0, 0);

		Label dateLabel = new Label("คุณได้เลือกวันรับวัคซีน");
		dateLabel.setFont(KornFont.paragraphNormal);
		VBox date = new VBox();
		date.getChildren().add(dateLabel);
		GridPane.setColumnSpan(date, 3);
		BookVaccineDetailPage.node.add(date, 2, 1);

		VBox time = KornField.getTextFieldWithLabel("เวลานัด");
		GridPane.setColumnSpan(time, 3);
		BookVaccineDetailPage.node.add(time, 2, 2);

		Label vaccineLabel = new Label("ยี่ห้อวัคซีนที่ต้องการ");
		vaccineLabel.setFont(KornFont.paragraphNormal);
		VBox vaccine = new VBox();
		vaccine.getChildren().add(vaccineLabel);
		GridPane.setColumnSpan(vaccine, 3);
		BookVaccineDetailPage.node.add(vaccine, 1, 3);

		Pair<VBox, ToggleGroup> vaccineSelect = KornField.getRadioButtonVaccineType("ยี่ห้อวัคซีนที่ต้องการ");
		GridPane.setColumnSpan(vaccineSelect.getKey(), 6);
		BookVaccineDetailPage.node.add(vaccineSelect.getKey(), 1, 3);

		Button saveButton = CVStyle.makeButton("ทำการจอง", "\uF0C7", EnumButtonType.SUCCESS);
		saveButton.setMinWidth((columnWidth * 2) + columnHGap);
		saveButton.setDefaultButton(true);
		GridPane.setColumnSpan(saveButton, 2);
		BookVaccineDetailPage.node.add(saveButton, 1, 4);

		Button backButton = CVStyle.makeButton("ย้อนกลับ", "\uF01E", EnumButtonType.INFO);
		backButton.setMinWidth((columnWidth * 2) + columnHGap);
		backButton.setCancelButton(true);
		GridPane.setColumnSpan(backButton, 2);
		BookVaccineDetailPage.node.add(backButton, 4, 4);

		return BookVaccineDetailPage.node;
	}

	private static GridPane node;
}
