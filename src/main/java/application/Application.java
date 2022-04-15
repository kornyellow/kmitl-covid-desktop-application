package application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lib.korn.kornutil.KornFix;
import other.Config;
import template.Home;

public class Application extends javafx.application.Application {
	@Override
	public void start(Stage primaryStage) {
		KornFix.fixAll();
		Scene scene = new Scene(Home.getLayout(), Config.applicationWidth, Config.applicationHeight);
		primaryStage.setTitle(Config.applicationTitle);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}