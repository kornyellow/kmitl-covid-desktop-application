package kmitl.covid.template;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import kmitl.covid.launcher.Application;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.enums.EnumPageType;
import kmitl.covid.other.Config;

public class Home {
	public static Scene getScene(EnumPage page) {
		if (page.pageType().equals(EnumPageType.NONLOGGEDIN))
			return Home.getNonLoggedInScene(page.page());
		return Home.getLoggedInScene(page.page());
	}
	private static Scene getLoggedInScene(Node content) {
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(30));

		RowConstraints topRow = new RowConstraints(50);
		RowConstraints middleRow = new RowConstraints();
		middleRow.setVgrow(Priority.ALWAYS);
		RowConstraints bottomRow = new RowConstraints(30);
		gridPane.getRowConstraints().addAll(
			topRow,
			middleRow,
			bottomRow
		);

		ColumnConstraints column = new ColumnConstraints();
		column.setHgrow(Priority.ALWAYS);
		gridPane.getColumnConstraints().addAll(column);

		GridPane header = TemplateHeader.getContent();
		gridPane.add(header, 0, 0);

		ScrollPane handler = TemplateHandler.getContent(content);
		GridPane.setValignment(handler, VPos.CENTER);
		gridPane.add(handler, 0, 1);

		GridPane footer = TemplateFooter.getContent();
		gridPane.add(footer, 0, 2);

		double applicationWidth = (Application.getCurrentScene() != null) ?
			Application.getCurrentScene().getWidth() :
			Config.applicationWidth;
		double applicationHeight = (Application.getCurrentScene() != null) ?
			Application.getCurrentScene().getHeight() :
			Config.applicationHeight;

		return new Scene(gridPane, applicationWidth, applicationHeight);
	}
	private static Scene getNonLoggedInScene(Node content) {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.getChildren().add(content);

		double applicationWidth = (Application.getCurrentScene() != null) ?
			Application.getCurrentScene().getWidth() :
			Config.applicationWidth;
		double applicationHeight = (Application.getCurrentScene() != null) ?
			Application.getCurrentScene().getHeight() :
			Config.applicationHeight;

		return new Scene(gridPane, applicationWidth, applicationHeight);
	}

	public static void redirect(EnumPage page) {
		Application.setStageScene(Home.getScene(page));
	}
	public static EventHandler<ActionEvent> redirectEvent(EnumPage page) {
		return actionEvent -> Home.redirect(page);
	}
}
