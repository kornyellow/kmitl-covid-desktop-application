package kmitl.covid.template;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class Home {
	public static GridPane getLayout() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);

		gridPane.getChildren().add(NonLoggedIn.getLayout());
		return gridPane;
	}
}
