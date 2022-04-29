package kmitl.covid.lib.classes.other;

import javafx.scene.control.TextField;
import javafx.scene.control.skin.TextFieldSkin;

public class PasswordSkin extends TextFieldSkin {
	public PasswordSkin(TextField textField) {
		super(textField);
	}

	protected String maskText(String text) {
		if (getSkinnable() == null) return text;
		return "•".repeat(text.length());
	}
}
