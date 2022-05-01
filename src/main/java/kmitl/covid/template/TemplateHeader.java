package kmitl.covid.template;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornutil.KornFont;
import kmitl.covid.lib.korn.kornutil.KornIcon;
import kmitl.covid.lib.methods.user.CVUser;

public class TemplateHeader {
	public static GridPane getContent() {
		if (TemplateHeader.node != null) return TemplateHeader.node;
		TemplateHeader.node = new GridPane();

		RowConstraints row = new RowConstraints();
		row.setVgrow(Priority.ALWAYS);
		TemplateHeader.node.getRowConstraints().addAll(row);

		ColumnConstraints column = new ColumnConstraints();
		column.setHgrow(Priority.ALWAYS);
		TemplateHeader.node.getColumnConstraints().addAll(column);

		Label title = new Label("ระบบจองวัคซีนออนไลน์");
		title.setFont(KornFont.headerBold);
		GridPane.setHalignment(title, HPos.LEFT);
		GridPane.setValignment(title, VPos.CENTER);
		TemplateHeader.node.add(title, 0, 0);

		Label welcome = new Label("ยินดีต้อนรับ");
		welcome.setFont(KornFont.paragraphBold);
		Label name = new Label("คุณ " + CVUser.getLoggedInUser().getFullName());
		name.setFont(KornFont.paragraphNormal);

		VBox username = new VBox();
		username.setAlignment(Pos.CENTER_RIGHT);
		username.getChildren().add(welcome);
		username.getChildren().add(name);

		HBox welcomeMessage = new HBox();
		welcomeMessage.setAlignment(Pos.CENTER);
		welcomeMessage.getChildren().add(username);

		Hyperlink userIcon = new Hyperlink("\uF007");
		userIcon.setFont(KornIcon.bigFont);
		userIcon.setAlignment(Pos.CENTER);
		userIcon.setPadding(new Insets(10, 0, 15, 15));
		userIcon.setBorder(Border.EMPTY);
		userIcon.setVisited(true);
		userIcon.setOnAction(Home.redirectEvent(EnumPage.SETTING()));
		welcomeMessage.getChildren().add(userIcon);

		GridPane.setHalignment(welcomeMessage, HPos.RIGHT);
		GridPane.setValignment(welcomeMessage, VPos.CENTER);
		TemplateHeader.node.add(welcomeMessage, 1, 0);

		return TemplateHeader.node;
	}

	private static GridPane node;
}
