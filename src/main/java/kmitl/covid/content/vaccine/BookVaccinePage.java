package kmitl.covid.content.vaccine;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.classes.vaccineschedule.VaccineSchedule;
import kmitl.covid.lib.enums.EnumButtonType;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;
import kmitl.covid.lib.korn.kornutil.KornDateTime;
import kmitl.covid.lib.methods.style.CVStyle;
import kmitl.covid.lib.methods.vaccineschedule.CVVaccineSchedule;
import kmitl.covid.template.Home;

import java.util.Calendar;
import java.util.Map;

public class BookVaccinePage {
	public static GridPane getContent() {
		BookVaccinePage.node = new GridPane();
		BookVaccinePage.node.setAlignment(Pos.TOP_CENTER);

		Label header = new Label("เลือกวันจองวัคซีน");
		header.setFont(KornFont.headerBold);
		header.setGraphic(KornIcon.getIconBig("\uF073"));
		header.setGraphicTextGap(20);
		header.setPadding(new Insets(0, 0, 20, 0));
		GridPane.setHalignment(header, HPos.CENTER);
		BookVaccinePage.node.add(header, 0, 0);
		BookVaccinePage.node.setVgap(20);

		KornDateTime date = KornDateTime.createFromDate(1,
			BookVaccinePage.selectedMonth,
			BookVaccinePage.selectedYear
		);
		KornDateTime dateNow = new KornDateTime();

		Label yearLabel = new Label("เดือน " + date.getMonthStringThai() + " ปี พ.ศ." + date.getYearThai());
		yearLabel.setFont(KornFont.paragraphBold);
		GridPane.setHalignment(yearLabel, HPos.CENTER);
		BookVaccinePage.node.add(yearLabel, 0, 1);

		HBox days = new HBox();
		days.setSpacing(10);
		Map<Integer, String> dayOfWeeks = KornDateTime.getDayNameThai();
		for (String day : dayOfWeeks.values()) {
			Label dayName = new Label(day);
			dayName.setAlignment(Pos.CENTER);
			dayName.setFont(KornFont.paragraphBold);
			dayName.setPrefSize(150, 50);
			days.getChildren().add(dayName);
		}
		BookVaccinePage.node.add(days, 0, 2);

		int dayNumber = Integer.parseInt(date.getDateNumber());
		for (int i = 0; i < dayNumber - 1; i++)
			date.decreaseDay();

		VBox calendar = new VBox();
		calendar.setSpacing(10);
		for (int row = 0; row < 6; row++) {
			HBox dayRow = new HBox();
			dayRow.setSpacing(10);
			for (int col = 1; col <= 7; col++) {
				Button button = new Button(date.getDate());
				button.getStyleClass().addAll("btn-blank");

				if (date.isMoreThan(dateNow) == -1 || date.isMoreThan(dateNow) == 0)
					button.setDisable(true);

				if (Integer.parseInt(date.getMonth()) != BookVaccinePage.selectedMonth)
					button.getStyleClass().add("btn-blank-other");

				button.setFont(KornFont.paragraphBold);
				button.setPrefSize(150, 50);
				KornDateTime dateButton = new KornDateTime((Calendar) date.getCalendar().clone());
				button.setOnAction(actionEvent -> {
					BookVaccinePage.selectedDate = dateButton;
					Home.redirect(EnumPage.BOOKVACCINEDETAIL());
				});

				VaccineSchedule vaccineSchedule = CVVaccineSchedule.getVaccineSchedule(date);
				if (vaccineSchedule != null) {
					button.getStyleClass().removeAll("btn-blank-other", "btn-blank");
					if (vaccineSchedule.isAvailable())
						button.getStyleClass().addAll("btn", "btn-warning");
					else button.getStyleClass().addAll("btn", "btn-danger");
				}

				dayRow.getChildren().add(button);

				date.increaseDay();
			}
			calendar.getChildren().add(dayRow);
		}
		BookVaccinePage.node.add(calendar, 0, 3);

		Button previousMonth = CVStyle.makeButton("เดือนก่อนหน้า", "\uF01E", EnumButtonType.SUCCESS);
		if (BookVaccinePage.selectedMonth == Integer.parseInt(dateNow.getMonth()) &&
			BookVaccinePage.selectedYear == Integer.parseInt(dateNow.getYear()))
			previousMonth.setDisable(true);

		Button nextMonth = CVStyle.makeButton("เดือนถัดไป", "\uF01E", EnumButtonType.SUCCESS);
		previousMonth.setOnAction(actionEvent -> {
			BookVaccinePage.selectedMonth--;
			if (selectedMonth == -1) {
				selectedYear--;
				selectedMonth = 12;
			}
			Home.redirect(EnumPage.BOOKVACCINE());
		});
		nextMonth.setOnAction(actionEvent -> {
			BookVaccinePage.selectedMonth++;
			if (selectedMonth == 13) {
				selectedYear++;
				selectedMonth = 1;
			}
			Home.redirect(EnumPage.BOOKVACCINE());
		});

		nextMonth.setPrefWidth(200);
		previousMonth.setPrefWidth(200);

		HBox navigationBox = new HBox();
		navigationBox.setSpacing(20);
		navigationBox.getChildren().addAll(previousMonth, nextMonth);
		BookVaccinePage.node.add(navigationBox, 0, 4);

		Button backButton = CVStyle.makeButton("ย้อนกลับ", "\uF01E", EnumButtonType.INFO);
		backButton.setPrefWidth(250);
		backButton.setCancelButton(true);
		backButton.setOnAction(Home.redirectEvent(EnumPage.DASHBOARD()));
		GridPane.setHalignment(backButton, HPos.RIGHT);
		BookVaccinePage.node.add(backButton, 0, 5);

		return BookVaccinePage.node;
	}

	private static int selectedMonth = Integer.parseInt(new KornDateTime().getMonth());
	private static int selectedYear = Integer.parseInt(new KornDateTime().getYear());
	public static KornDateTime selectedDate;

	private static GridPane node;
}
