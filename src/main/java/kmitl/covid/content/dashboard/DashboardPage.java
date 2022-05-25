package kmitl.covid.content.dashboard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.korn.kornfx.KornField;
import kmitl.covid.lib.korn.kornresource.KornFont;

public class DashboardPage {
	public static GridPane getContent() {
		if (DashboardPage.node != null) return DashboardPage.node;
		DashboardPage.node = new GridPane();
		DashboardPage.node.setAlignment(Pos.TOP_CENTER);

		double columnHGap = 40;
		double columnVGap = 20;
		double columnWidth = 120;

		DashboardPage.node.setVgap(columnVGap);
		DashboardPage.node.setHgap(columnHGap);

		ColumnConstraints column = new ColumnConstraints(columnWidth);
		DashboardPage.node.getColumnConstraints().addAll(
			column, column, column, column, column, column
		);

		Label headerLabel = new Label("Dashboard");
		headerLabel.setFont(KornFont.headerBold);
		Label subHeaderLabel = new Label("ข้อมูล Covid-19");
		subHeaderLabel.setFont(KornFont.subHeaderNormal);

		VBox header = new VBox();
		header.getChildren().add(headerLabel);
		header.getChildren().add(subHeaderLabel);
		header.setAlignment(Pos.CENTER);
		header.setPadding(new Insets(0, 0, 20, 0));

		GridPane.setColumnSpan(header, 6);
		DashboardPage.node.add(header, 0, 0);

		VBox newInfections = KornField.getTextFieldWithLabel("จำนวนผู้ติดเชื้อรายใหม่");
		GridPane.setColumnSpan(newInfections, 3);
		DashboardPage.node.add(newInfections, 0, 1);

		VBox newDeaths = KornField.getTextFieldWithLabel("จำนวนผู้เสียชีวิตรายใหม่");
		GridPane.setColumnSpan(newDeaths, 3);
		DashboardPage.node.add(newDeaths, 2, 1);

		VBox newHeal = KornField.getTextFieldWithLabel("จำนวนรักษาหายรายใหม่");
		GridPane.setColumnSpan(newHeal, 3);
		DashboardPage.node.add(newHeal, 4, 1);

		VBox allNewInfections = KornField.getTextFieldWithLabel("สะสม");
		GridPane.setColumnSpan(allNewInfections, 3);
		DashboardPage.node.add(allNewInfections, 0, 3);

		VBox allNewDeaths = KornField.getTextFieldWithLabel("สะสม");
		GridPane.setColumnSpan(allNewDeaths, 3);
		DashboardPage.node.add(allNewDeaths, 2, 3);

		VBox allNewHealing = KornField.getTextFieldWithLabel("สะสม");
		GridPane.setColumnSpan(allNewHealing, 3);
		DashboardPage.node.add(allNewHealing, 4, 3);

		VBox local = KornField.getTextFieldWithLabel("ในประเทศ");
		GridPane.setColumnSpan(local, 3);
		DashboardPage.node.add(local, 0, 5);

		VBox vaccinated = KornField.getTextFieldWithLabel("การได้รับวัคซีน");
		GridPane.setColumnSpan(vaccinated, 3);
		DashboardPage.node.add(vaccinated, 2, 5);

		VBox Healing = KornField.getTextFieldWithLabel("กำลังรักษา");
		GridPane.setColumnSpan(Healing, 3);
		DashboardPage.node.add(Healing, 4, 5);

		VBox AllLocal = KornField.getTextFieldWithLabel("สะสม");
		GridPane.setColumnSpan(AllLocal, 3);
		DashboardPage.node.add(AllLocal, 0, 7);

		VBox first = KornField.getTextFieldWithLabel("1 เข็ม");
		GridPane.setColumnSpan(first, 3);
		DashboardPage.node.add(first, 2, 6);

		VBox second = KornField.getTextFieldWithLabel("2 เข็ม");
		GridPane.setColumnSpan(second, 3);
		DashboardPage.node.add(second, 2, 8);

		VBox ATK = KornField.getTextFieldWithLabel("ติดเชื้อเข้าข่าย/ATK");
		GridPane.setColumnSpan(ATK, 3);
		DashboardPage.node.add(ATK, 0, 9);

		VBox severe = KornField.getTextFieldWithLabel("อาการหนัก");
		GridPane.setColumnSpan(severe, 3);
		DashboardPage.node.add(severe, 6, 9);

		return DashboardPage.node;
	}

	private static GridPane node;
}
