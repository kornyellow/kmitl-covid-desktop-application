package kmitl.covid.lib.korn.kornutil;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.classes.other.PasswordSkin;

public class KornField {
	public static VBox getTextFieldWithLabel(String labelText) {
		Label label = new Label(labelText);
		label.setFont(KornFont.paragraphNormal);
		label.getStyleClass().add("text");

		TextField field = new TextField();
		field.setFont(KornFont.paragraphNormal);
		field.getStyleClass().add("form");

		VBox box = new VBox();
		box.setSpacing(15);
		box.getChildren().add(label);
		box.getChildren().add(field);

		return box;
	}
	public static VBox getPasswordFieldWithLabel(String labelText) {
		Label label = new Label(labelText);
		label.setFont(KornFont.paragraphNormal);
		label.getStyleClass().add("text");

		PasswordField field = new PasswordField();
		field.setFont(KornFont.paragraphNormal);
		field.setSkin(new PasswordSkin(field));
		field.getStyleClass().add("form");

		VBox box = new VBox();
		box.setSpacing(15);
		box.getChildren().add(label);
		box.getChildren().add(field);

		return box;
	}
	public static VBox getRadioButtonGender(String labelText) {
		Label label = new Label(labelText);
		label.setFont(KornFont.paragraphNormal);
		label.getStyleClass().add("text");

		ToggleGroup group = new ToggleGroup();

		RadioButton radioButton1 = new RadioButton("ชาย");
		radioButton1.setFont(KornFont.paragraphNormal);
		radioButton1.setToggleGroup(group);
		radioButton1.getStyleClass().addAll("form-radio");

		RadioButton radioButton2 = new RadioButton("หญิง");
		radioButton2.setFont(KornFont.paragraphNormal);
		radioButton2.setToggleGroup(group);
		radioButton2.getStyleClass().addAll("form-radio");

		RadioButton radioButton3 = new RadioButton("ไม่ระบุ");
		radioButton3.setFont(KornFont.paragraphNormal);
		radioButton3.setToggleGroup(group);
		radioButton3.getStyleClass().addAll("form-radio");

		HBox radioBox = new HBox();
		radioBox.setSpacing(20);
		radioBox.getChildren().add(radioButton1);
		radioBox.getChildren().add(radioButton2);
		radioBox.getChildren().add(radioButton3);

		VBox box = new VBox();
		box.setSpacing(20);
		box.getChildren().add(label);
		box.getChildren().add(radioBox);

		return box;
	}
	public static VBox getRadioButtonNameTitle(String labelText) {
		Label label = new Label(labelText);
		label.setFont(KornFont.paragraphNormal);
		label.getStyleClass().add("text");

		ToggleGroup group = new ToggleGroup();

		RadioButton radioButton1 = new RadioButton("นาย");
		radioButton1.setFont(KornFont.paragraphNormal);
		radioButton1.setToggleGroup(group);
		radioButton1.getStyleClass().addAll("form-radio");

		RadioButton radioButton2 = new RadioButton("นางสาว");
		radioButton2.setFont(KornFont.paragraphNormal);
		radioButton2.setToggleGroup(group);
		radioButton2.getStyleClass().addAll("form-radio");

		RadioButton radioButton3 = new RadioButton("นาง");
		radioButton3.setFont(KornFont.paragraphNormal);
		radioButton3.setToggleGroup(group);
		radioButton3.getStyleClass().addAll("form-radio");

		HBox radioBox = new HBox();
		radioBox.setSpacing(15);
		radioBox.getChildren().add(radioButton1);
		radioBox.getChildren().add(radioButton2);
		radioBox.getChildren().add(radioButton3);

		VBox box = new VBox();
		box.setSpacing(20);
		box.getChildren().add(label);
		box.getChildren().add(radioBox);

		return box;
	}
}
