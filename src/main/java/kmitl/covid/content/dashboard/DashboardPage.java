package kmitl.covid.content.dashboard;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import kmitl.covid.lib.enums.EnumButtonType;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;
import kmitl.covid.lib.methods.style.CVStyle;
import kmitl.covid.template.Home;

public class DashboardPage {
	public static GridPane getContent() {
		if (DashboardPage.node != null) return DashboardPage.node;
		DashboardPage.node = new GridPane();
		DashboardPage.node.setAlignment(Pos.TOP_CENTER);

		Label header = new Label("หน้าหลัก");
		header.setFont(KornFont.headerBold);
		header.setGraphic(KornIcon.getIconBig("\uF015"));
		header.setGraphicTextGap(20);
		header.setPadding(new Insets(0, 0, 20, 0));
		GridPane.setHalignment(header, HPos.CENTER);
		GridPane.setColumnSpan(header, 6);
		DashboardPage.node.add(header, 0, 0);

		Button notificationButton = CVStyle.makeButton("ไปหน้าการแจ้งเตือน", "", EnumButtonType.INFO);
		notificationButton.setOnAction(Home.redirectEvent(EnumPage.NOTIFICATION()));
		DashboardPage.node.add(notificationButton, 0, 1);
		Button vaccineDetailButton = CVStyle.makeButton("ไปหน้ารายละเอียดวัคซีน", "", EnumButtonType.INFO);
		vaccineDetailButton.setOnAction(Home.redirectEvent(EnumPage.BOOKVACCINEDETAIL()));
		DashboardPage.node.add(vaccineDetailButton, 0, 2);

		return DashboardPage.node;
	}

	private static GridPane node;
}
