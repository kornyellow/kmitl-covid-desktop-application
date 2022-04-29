package kmitl.covid.content.authentication;

import javafx.scene.layout.GridPane;

public class RegisterPage {
	public static GridPane getContent() {
		if (RegisterPage.node != null) return RegisterPage.node;
		RegisterPage.node = new GridPane();

		return RegisterPage.node;
	}

	private static GridPane node;
}
