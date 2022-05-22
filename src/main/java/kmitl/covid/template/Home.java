package kmitl.covid.template;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import kmitl.covid.launcher.Application;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.enums.EnumPageType;
import kmitl.covid.lib.korn.kornresource.KornCSS;
import kmitl.covid.lib.korn.kornresource.KornImage;
import kmitl.covid.lib.methods.user.CVUser;
import kmitl.covid.other.Config;

public class Home {
	public static Scene getScene(EnumPage page) {
		Scene scene;
		if (page.pageType().equals(EnumPageType.NONLOGGEDIN))
			scene = Home.getNonLoggedInScene(page.page());
		else if (CVUser.getLoggedInUser() == null && !Config.isDisableStrictLogin)
			scene = Home.getNonLoggedInScene(EnumPage.LOGIN().page());
		else scene = Home.getLoggedInScene(page.page());

		scene.getStylesheets().add(KornCSS.path);
		return scene;
	}
	private static Scene getLoggedInScene(Node content) {
		GridPane gridPane = new GridPane();

		RowConstraints topRow = new RowConstraints(100);
		RowConstraints middleRow = new RowConstraints();
		middleRow.setVgrow(Priority.ALWAYS);
		RowConstraints bottomRow = new RowConstraints(40);
		gridPane.getRowConstraints().addAll(
			topRow,
			middleRow,
			bottomRow
		);

		ColumnConstraints column = new ColumnConstraints();
		column.setHgrow(Priority.ALWAYS);
		gridPane.getColumnConstraints().addAll(column);

		GridPane header = TemplateHeader.getContent();
		header.setPadding(new Insets(0, 40, 0, 40));
		header.getStyleClass().add("header");
		gridPane.add(header, 0, 0);

		ScrollPane handler = TemplateHandler.getContent(content);
		GridPane.setValignment(handler, VPos.CENTER);
		gridPane.add(handler, 0, 1);

		GridPane footer = TemplateFooter.getContent();
		footer.setPadding(new Insets(0, 40, 0, 40));
		footer.getStyleClass().add("footer");
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

		Background background = new Background(new BackgroundImage(
			KornImage.background,
			BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER,
			new BackgroundSize(
				1920,
				1080,
				true,
				true,
				true,
				true
			)
		));
		gridPane.setBackground(background);

		content.getStyleClass().add("main-card");
		HBox hbox = new HBox(content);
		hbox.setAlignment(Pos.CENTER);

		ScrollPane body = new ScrollPane(hbox);
		body.setFitToWidth(true);
		body.setFitToHeight(true);

		GridPane.setHgrow(body, Priority.ALWAYS);
		GridPane.setHalignment(body, HPos.CENTER);
		gridPane.getChildren().add(body);

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
