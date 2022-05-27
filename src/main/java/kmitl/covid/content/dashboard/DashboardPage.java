package kmitl.covid.content.dashboard;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.enums.EnumButtonType;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;
import kmitl.covid.lib.korn.kornutil.KornDateTime;
import kmitl.covid.lib.korn.kornutil.KornJSON;
import kmitl.covid.lib.methods.style.CVStyle;
import kmitl.covid.template.Home;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class DashboardPage {
	public static GridPane getContent() {
		if (DashboardPage.node != null) return DashboardPage.node;
		DashboardPage.node = new GridPane();
		DashboardPage.node.setAlignment(Pos.TOP_CENTER);

		JSONObject json = KornJSON.getJSONFromURL("https://covid19.ddc.moph.go.th/api/Cases/today-cases-all");
		DecimalFormat formatter = new DecimalFormat("#,###");

		int newCase = 0;
		int totalCase = 0;
		int newDeath = 0;
		int totalDeath = 0;
		int newRecovered = 0;
		int totalRecovered = 0;
		String updateDate = "";
		if (json != null) {
			newCase = json.getInt("new_case");
			totalCase = json.getInt("total_case");
			newDeath = json.getInt("new_death");
			totalDeath = json.getInt("total_death");
			newRecovered = json.getInt("new_recovered");
			totalRecovered = json.getInt("total_recovered");
			updateDate = json.getString("update_date");
		}

		Label header = new Label("หน้าหลัก");
		header.setFont(KornFont.headerBold);
		header.setGraphic(KornIcon.getIconBig("\uF015"));
		header.setGraphicTextGap(20);
		header.setPadding(new Insets(0, 0, 40, 0));
		GridPane.setHalignment(header, HPos.CENTER);
		GridPane.setColumnSpan(header, 3);
		DashboardPage.node.add(header, 0, 0);

		Label updateTitle = new Label("ข้อมูลประจำวันที่");
		Label updateTitleDate = new Label(KornDateTime.createFromMySQLDateTime(updateDate).toFullThaiDate());
		updateTitle.setFont(KornFont.paragraphBold);
		updateTitleDate.setFont(KornFont.paragraphNormal);

		VBox updateBox = new VBox();
		updateBox.setSpacing(10);
		updateBox.setAlignment(Pos.CENTER);
		updateBox.getChildren().add(updateTitle);
		updateBox.getChildren().add(updateTitleDate);
		GridPane.setColumnSpan(updateBox, 3);
		GridPane.setHalignment(updateBox, HPos.CENTER);
		GridPane.setMargin(updateBox, new Insets(0, 0, 30, 0));
		DashboardPage.node.add(updateBox, 0, 1);

		HBox infected = CVStyle.getInformationModule("\uE4A8", "ผู้ติดเชื้อรายใหม่",
			formatter.format(newCase),
			"สะสม " + formatter.format(totalCase),
			"danger"
		);
		HBox death = CVStyle.getInformationModule("\uF54C", "ผู้เสียชีวิตรายใหม่",
			formatter.format(newDeath),
			"สะสม " + formatter.format(totalDeath),
			"dark"
		);
		HBox recovered = CVStyle.getInformationModule("\uF484", "ผู้รักษาหายรายใหม่",
			formatter.format(newRecovered),
			"สะสม " + formatter.format(totalRecovered),
			"info"
		);

		GridPane.setMargin(infected, new Insets(0, 20, 0, 20));
		DashboardPage.node.add(infected, 0, 2);
		GridPane.setMargin(death, new Insets(0, 20, 0, 20));
		DashboardPage.node.add(death, 1, 2);
		GridPane.setMargin(recovered, new Insets(0, 20, 0, 20));
		DashboardPage.node.add(recovered, 2, 2);

		Button vaccineButton = CVStyle.makeButton("ทำการจองวัคซีน", "\uF48E", EnumButtonType.SUCCESS);
		vaccineButton.setOnAction(actionEvent -> {
			Home.redirect(EnumPage.BOOKVACCINE());
		});
		vaccineButton.setPrefWidth(1000);
		GridPane.setColumnSpan(vaccineButton, 3);
		GridPane.setHalignment(vaccineButton, HPos.CENTER);
		GridPane.setMargin(vaccineButton, new Insets(30, 0, 0, 0));
		DashboardPage.node.add(vaccineButton, 0, 3);

		return DashboardPage.node;
	}

	private static GridPane node;
}
