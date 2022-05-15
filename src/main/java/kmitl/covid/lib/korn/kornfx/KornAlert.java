package kmitl.covid.lib.korn.kornfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import kmitl.covid.lib.enums.EnumAlertType;
import kmitl.covid.lib.korn.kornresource.KornFont;
import kmitl.covid.lib.korn.kornresource.KornIcon;
import kmitl.covid.lib.korn.kornresource.KornCSS;
import kmitl.covid.lib.methods.style.CVStyle;

public class KornAlert {
	public static void alert(EnumAlertType type, String content) {
		KornAlert alert = new KornAlert(type, content);
		alert.show();
	}
	public static void alert(EnumAlertType type, String content, EventHandler<DialogEvent> callBackEvent) {
		KornAlert alert = new KornAlert(type, content, callBackEvent);
		alert.show();
	}

	public KornAlert(EnumAlertType type, String content, EventHandler<DialogEvent> callbackEvent) {
		this.type = type;
		this.header = this.type.getTitle();
		this.content = content;
		this.callBackEvent = callbackEvent;

		this.alert = new Alert(Alert.AlertType.NONE);
		this.alert.getDialogPane().setContent(this.getContent());
		this.alert.setTitle(this.type.getTitle());

		ButtonType buttonType = new ButtonType("", ButtonBar.ButtonData.OK_DONE);
		this.alert.getButtonTypes().setAll(buttonType);
		this.alert.getDialogPane().lookupButton(buttonType).setVisible(false);
		this.alert.getDialogPane().getStylesheets().add(KornCSS.path);

		if (this.callBackEvent != null)
			this.alert.setOnCloseRequest(this.callBackEvent);
	}
	public KornAlert(EnumAlertType type, String content) {
		this(type, content, null);
	}

	public void show() {
		this.alert.show();
	}

	private Node getContent() {
		Label header = new Label(this.header);
		header.setFont(KornFont.headerBold);
		header.getStyleClass().add(this.type.getTitleColor());
		Label content = new Label(this.content);
		content.setFont(KornFont.paragraphNormal);

		VBox headerBox = new VBox();
		headerBox.getChildren().add(header);
		headerBox.getChildren().add(content);
		headerBox.setSpacing(10);

		Label icon = KornIcon.getIconMega(this.type.getIconTitle());
		icon.getStyleClass().add(this.type.getTitleColor());

		HBox headerIconBox = new HBox();
		headerIconBox.getChildren().add(icon);
		headerIconBox.getChildren().add(headerBox);
		headerIconBox.setSpacing(25);

		Button button = CVStyle.makeButton(
			this.type.getTextConfirm(),
			this.type.getIconConfirm(),
			this.type.getButtonType()
		);
		button.setOnAction(this.closeAlertEvent());
		button.translateYProperty().set(20);
		button.setDefaultButton(true);

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
	private final EventHandler<DialogEvent> callBackEvent;
}
