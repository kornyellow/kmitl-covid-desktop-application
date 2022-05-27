package kmitl.covid.launcher;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import kmitl.covid.Launcher;
import kmitl.covid.lib.enums.EnumPage;
import kmitl.covid.lib.korn.kornresource.KornResource;
import kmitl.covid.lib.korn.kornutil.KornFix;
import kmitl.covid.other.Config;
import kmitl.covid.template.Home;

import java.util.Locale;
import java.util.Objects;

public class Application extends javafx.application.Application {
	@Override
	public void start(Stage primaryStage) {
		Locale.setDefault(new Locale("TH"));
		KornFix.fixAll();
		KornResource.loadResource();

		Application.primaryStage = primaryStage;

		String iconPath = Objects.requireNonNull(Launcher.class.getResource("image/icon.png")).toString();
		Application.primaryStage.getIcons().add(new Image(iconPath));

		Application.primaryStage.setScene(Home.getScene(EnumPage.LOGIN()));
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
	public static Scene getCurrentScene() {
		return Application.primaryStage.getScene();
	}
}