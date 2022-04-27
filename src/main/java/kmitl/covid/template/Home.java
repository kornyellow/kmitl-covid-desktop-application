package kmitl.covid.template;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import kmitl.covid.other.Config;

public class Home {
	public static Scene getScene() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);

		return new Scene(gridPane, Config.applicationWidth, Config.applicationHeight);
	}
}
