package kmitl.covid.content.authentication;

import javafx.scene.layout.GridPane;

public class ForgotPasswordPage {
	public static GridPane getContent() {
		if (ForgotPasswordPage.node != null) return ForgotPasswordPage.node;
		ForgotPasswordPage.node = new GridPane();

		return ForgotPasswordPage.node;
	}

	private static GridPane node;
}
