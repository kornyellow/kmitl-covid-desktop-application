package kmitl.covid.content.vaccine;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import kmitl.covid.lib.classes.vaccineschedule.VaccineSchedule;
import kmitl.covid.lib.classes.vaccineschedule.VaccineScheduleDetail;
import kmitl.covid.lib.enums.EnumAlertType;
import kmitl.covid.lib.enums.EnumButtonType;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornfx.KornAlert;
import kmitl.covid.lib.korn.kornfx.KornField;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;
import kmitl.covid.lib.korn.kornutil.KornDateTime;
import kmitl.covid.lib.methods.notification.CVNotification;
import kmitl.covid.lib.methods.style.CVStyle;
import kmitl.covid.lib.methods.user.CVUser;
import kmitl.covid.lib.methods.vaccineschedule.CVVaccineSchedule;
import kmitl.covid.lib.methods.vaccineschedule.CVVaccineScheduleDetail;
import kmitl.covid.template.Home;

public class BookVaccineDetailPage {
	public static GridPane getContent() {
		BookVaccineDetailPage.node = new GridPane();
		BookVaccineDetailPage.node.setAlignment(Pos.TOP_CENTER);

		Label header = new Label("รายละเอียดการจองวัคซีน");
		header.setFont(KornFont.headerBold);
		header.setGraphic(KornIcon.getIconBig("\uF48E"));
		header.setGraphicTextGap(20);
		header.setPadding(new Insets(0, 0, 40, 0));
		GridPane.setHalignment(header, HPos.CENTER);
		GridPane.setColumnSpan(header, 3);
		BookVaccineDetailPage.node.add(header, 0, 0);

		KornDateTime dateTime = new KornDateTime();
		if (BookVaccinePage.selectedDate != null)
			dateTime = BookVaccinePage.selectedDate;

		String date = dateTime.toFullThaiDate();
		if (BookVaccinePage.selectedDate != null)
			date = BookVaccinePage.selectedDate.toFullThaiDate();

		VBox form = new VBox();
		form.setSpacing(40);

		Label dateLabel = new Label("คุณจะจองเข้ามารับวัคซีนวันที่ " + date);
		dateLabel.setFont(KornFont.paragraphBold);
		form.getChildren().add(dateLabel);

		GridPane table = new GridPane();

		ColumnConstraints tableQueueCol = new ColumnConstraints(100);
		tableQueueCol.setHalignment(HPos.CENTER);
		ColumnConstraints tableNameCol = new ColumnConstraints();
		ColumnConstraints tableVaccineCol = new ColumnConstraints(250);
		tableNameCol.setHgrow(Priority.ALWAYS);
		table.getColumnConstraints().setAll(
			tableQueueCol,
			tableNameCol,
			tableVaccineCol
		);

		Label queueLabel = new Label("คิวที่");
		queueLabel.setFont(KornFont.smallBold);
		Label nameLabel = new Label("ชื่อจริง-นามสกุล");
		nameLabel.setFont(KornFont.smallBold);
		Label vaccineLabel = new Label("วัคซีน");
		vaccineLabel.setFont(KornFont.smallBold);

		table.add(queueLabel, 0, 0);
		table.add(nameLabel, 1, 0);
		table.add(vaccineLabel, 2, 0);
		table.getStyleClass().add("grid-card");
		table.setVgap(10);

		int thisQueue = 1;

		VaccineSchedule vaccineSchedule = CVVaccineSchedule.getVaccineSchedule(dateTime);
		for (int queueNumber = 1; queueNumber <= 8; queueNumber++) {
			String nameText = "";
			String vaccineText = "";
			VaccineScheduleDetail vaccineScheduleDetail = null;
			if (vaccineSchedule != null)
				vaccineScheduleDetail = CVVaccineScheduleDetail.getVaccineScheduleDetail(vaccineSchedule, queueNumber);

			if (vaccineScheduleDetail != null) {
				nameText = vaccineScheduleDetail.getUser().getFullName();
				vaccineText = vaccineScheduleDetail.getVaccineName();
				thisQueue++;
			}

			Label queue = new Label(String.valueOf(queueNumber));
			queue.setFont(KornFont.smallNormal);
			Label name = new Label(nameText);
			name.setFont(KornFont.smallNormal);
			Label vaccine = new Label(vaccineText);
			vaccine.setFont(KornFont.smallNormal);

			table.add(queue, 0, queueNumber);
			table.add(name, 1, queueNumber);
			table.add(vaccine, 2, queueNumber);
		}

		form.getChildren().add(table);

		Pair<VBox, ToggleGroup> vaccineSelect = KornField.getRadioButtonVaccineType("ยี่ห้อวัคซีนที่ต้องการ");
		form.getChildren().add(vaccineSelect.getKey());

		ToggleGroup vaccineField = vaccineSelect.getValue();

		Button saveButton = CVStyle.makeButton("จองวัคซีน", "\uF0C7", EnumButtonType.SUCCESS);
		saveButton.setDefaultButton(true);
		saveButton.setPrefWidth(400);

		if (vaccineSchedule != null)
			saveButton.setDisable(!vaccineSchedule.isAvailable());

		int queue = thisQueue;
		KornDateTime dateOrder = dateTime;
		saveButton.setOnAction(actionEvent -> {
			if (vaccineField.getSelectedToggle() == null) {
				KornAlert.alert(
					EnumAlertType.ERROR,
					"กรุณาเลือกประเภทวัคซีน"
				);
				return;
			}

			String vaccineResult = ((RadioButton) vaccineField.getSelectedToggle()).getText();

			int vaccineScheduleID;
			VaccineSchedule vaccineScheduleCheck = CVVaccineSchedule.getVaccineSchedule(dateOrder);
			if (vaccineScheduleCheck == null)
				vaccineScheduleID = CVVaccineSchedule.insertVaccineSchedule(dateOrder);
			else vaccineScheduleID = vaccineScheduleCheck.getID();

			VaccineScheduleDetail vaccineScheduleDetail = new VaccineScheduleDetail();
			vaccineScheduleDetail.setVaccineSchedule(CVVaccineSchedule.getVaccineSchedule(vaccineScheduleID));
			vaccineScheduleDetail.setUser(CVUser.getLoggedInUser());
			vaccineScheduleDetail.setVaccineNumber(queue);
			vaccineScheduleDetail.setVaccineName(vaccineResult);
			vaccineScheduleDetail.setNote("");

			if (queue == 8 && vaccineScheduleCheck != null) {
				vaccineScheduleCheck.setAvailable(false);
				CVVaccineSchedule.updateVaccineSchedule(vaccineScheduleCheck);
			}

			CVVaccineScheduleDetail.insertVaccineScheduleDetail(vaccineScheduleDetail);

			KornAlert.alert(
				EnumAlertType.SUCCESS,
				"ลงทะเบียนจองวัคซีนสำเร็จ",
				dialogEvent -> {
					vaccineField.selectToggle(null);

					CVNotification.pushNotification(
						CVUser.getLoggedInUser(),
						"จองวัคซีนสำเร็จ",
						"จองวัคซีน " + vaccineResult + " เรียบร้อย คิวของท่านอยู่ลำดับที่ " + queue + " กรุณาเข้ามารับวัคซีนวันที่ " + dateOrder.toFullThaiDate()
					);

					Home.redirect(EnumPage.BOOKVACCINEDETAIL());
				}
			);
		});

		Button backButton = CVStyle.makeButton("ย้อนกลับ", "\uF01E", EnumButtonType.INFO);
		backButton.setCancelButton(true);
		backButton.setPrefWidth(400);
		backButton.setOnAction(actionEvent -> {
			vaccineField.selectToggle(null);
			Home.redirect(EnumPage.BOOKVACCINE());
		});

		HBox buttons = new HBox();
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(saveButton, backButton);
		buttons.setSpacing(30);
		form.getChildren().add(buttons);

		BookVaccineDetailPage.node.add(form, 0, 1);

		return BookVaccineDetailPage.node;
	}

	private static GridPane node;
}
