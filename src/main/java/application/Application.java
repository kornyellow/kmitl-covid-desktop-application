package application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lib.korn.kornutil.KornFix;
import lib.korn.kornutil.KornFont;
import other.Config;
import template.Home;

public class Application extends javafx.application.Application {
	@Override
	public void start(Stage primaryStage) {
		KornFix.fixAll();
		KornFont.fontPathLight = this.getClass().getClassLoader().getResource("GraphikThaiLoop-Light.otf").toString();
		KornFont.fontPathNormal = this.getClass().getClassLoader().getResource("GraphikThaiLoop-Regular.otf").toString();
		KornFont.fontPathBold = this.getClass().getClassLoader().getResource("GraphikThaiLoop-Semibold.otf").toString();
		KornFont.loadAllFont();
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