package kmitl.covid.lib.korn.kornutil;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.classes.other.PasswordSkin;

public class KornField {
	public static VBox getTextFieldWithLabel(String labelText) {
		Label label = new Label(labelText);
		label.setFont(KornFont.paragraphNormal);

		TextField field = new TextField();
		field.setFont(KornFont.paragraphNormal);

		VBox box = new VBox();
		box.setSpacing(10);
		box.getChildren().add(label);
		box.getChildren().add(field);

		return box;
	}
	public static VBox getPasswordFieldWithLabel(String labelText) {
		Label label = new Label(labelText);
		label.setFont(KornFont.paragraphNormal);

		PasswordField field = new PasswordField();
		field.setFont(KornFont.paragraphNormal);
		field.setSkin(new PasswordSkin(field));

		VBox box = new VBox();
		box.setSpacing(10);
		box.getChildren().add(label);
		box.getChildren().add(field);

		return box;
	}
}
