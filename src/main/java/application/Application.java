package application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lib.korn.kornutil.KornFix;
import template.Home;

public class Application extends javafx.application.Application {
	@Override
	public void start(Stage primaryStage) {
		KornFix.fixAll();
		Scene scene = new Scene(Home.getLayout(), 1920, 1080);
		primaryStage.setTitle("Covid-19 Desktop Application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}