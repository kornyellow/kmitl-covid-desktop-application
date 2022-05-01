package kmitl.covid.lib.korn.kornutil;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.enums.EnumAlertType;

public class KornAlert {
	public static void alert(EnumAlertType title, String header, String content) {
		KornAlert alert = new KornAlert(title, header, content);
		alert.show();
	}

	public KornAlert(EnumAlertType type, String header, String content) {
		this.type = type;
		this.header = header;
		this.content = content;

		this.alert = new Alert(Alert.AlertType.NONE);
		this.alert.getDialogPane().setContent(this.getContent());
		this.alert.setTitle(this.type.getTitle());

		ButtonType buttonType = new ButtonType("", ButtonBar.ButtonData.OK_DONE);
		this.alert.getButtonTypes().setAll(buttonType);
		this.alert.getDialogPane().lookupButton(buttonType).setVisible(false);
	}

	public void show() {
		this.alert.show();
	}

	private Node getContent() {
		Label header = new Label(this.header);
		header.setFont(KornFont.headerBold);
		Label content = new Label(this.content);
		content.setFont(KornFont.paragraphNormal);

		VBox headerBox = new VBox();
		headerBox.getChildren().add(header);
		headerBox.getChildren().add(content);
		headerBox.setSpacing(10);

		HBox headerIconBox = new HBox();
		headerIconBox.getChildren().add(KornIcon.getIconMega(this.type.getIconTitle()));
		headerIconBox.getChildren().add(headerBox);
		headerIconBox.setSpacing(25);

		Button button = new Button(this.type.getTextConfirm());
		button.setFont(KornFont.paragraphNormal);
		button.setOnAction(this.closeAlertEvent());
		button.translateYProperty().set(20);
		button.setDefaultButton(true);
		button.setGraphic(KornIcon.getIconRegular(this.type.getIconConfirm()));
		button.setGraphicTextGap(10);

		VBox vBox = new VBox();
		vBox.setSpacing(30);
		vBox.getChildren().add(headerIconBox);
		vBox.getChildren().add(button);
		vBox.setAlignment(Pos.CENTER_RIGHT);
		vBox.setPadding(new Insets(40, 50, 0, 50));

		return vBox;
	}
	private EventHandler<ActionEvent> closeAlertEvent() {
		return actionEvent -> {
			for (ButtonType buttonType : this.alert.getDialogPane().getButtonTypes()) {
				if (buttonType.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
					Button button = (Button) alert.getDialogPane().lookupButton(buttonType);
					button.fire();
					break;
				}
			}
		};
	}

	private final Alert alert;
	private final EnumAlertType type;
	private final String header;
	private final String content;
}
