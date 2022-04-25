package kmitl.covid.launcher;

import javafx.scene.Scene;
import javafx.stage.Stage;
import kmitl.covid.other.Config;
import kmitl.covid.template.Home;

public class Application extends javafx.application.Application {
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(Home.getLayout(), Config.applicationWidth, Config.applicationHeight);
		primaryStage.setTitle(Config.applicationTitle);
		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}