package kmitl.covid.template;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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
		gridPane.setAlignment(Pos.CENTER);
		gridPane.getChildren().add(TemplateHeader.getContent());
		gridPane.getChildren().add(TemplateHandler.getContent(content));
		gridPane.getChildren().add(TemplateFooter.getContent());

		return new Scene(gridPane, Config.applicationWidth, Config.applicationHeight);
	}
	private static Scene getNonLoggedInScene(Node content) {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.getChildren().add(content);

		return new Scene(gridPane, Config.applicationWidth, Config.applicationHeight);
	}

	public static void redirect(EnumPage page) {
		Application.setStageScene(Home.getScene(page));
	}
	public static EventHandler<ActionEvent> redirectEvent(EnumPage page) {
		return actionEvent -> Home.redirect(page);
	}
}
