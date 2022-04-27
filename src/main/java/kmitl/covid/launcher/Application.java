package kmitl.covid.launcher;

import javafx.scene.Scene;
import javafx.stage.Stage;
import kmitl.covid.other.Config;
import kmitl.covid.template.Home;

public class Application extends javafx.application.Application {
	@Override
	public void start(Stage primaryStage) {
		Application.primaryStage = primaryStage;
		Application.primaryStage.setScene(Home.getScene());
		Application.primaryStage.setTitle(Config.applicationTitle);
		Application.primaryStage.setMaximized(true);
		Application.primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}

	private static Stage primaryStage;

	public static void setStageScene(Scene scene) {
		Application.primaryStage.setScene(scene);
	}
}