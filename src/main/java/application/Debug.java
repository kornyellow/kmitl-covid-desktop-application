package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Debug extends javafx.application.Application {
	@Override
	public void start(Stage primaryStage) {
		Button button = new Button("Your JavaFX is working!");
		Scene scene = new Scene(button, 200, 250);
		primaryStage.setTitle("JavaFX Test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
