package kmitl.covid.template;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

public class TemplateHandler {
	public static ScrollPane getContent(Node content) {
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.setPadding(new Insets(40, 30, 30, 30));
		hbox.getChildren().add(content);

		ScrollPane node = new ScrollPane(hbox);
		node.setStyle("-fx-background-color: transparent;");
		node.setFitToHeight(true);
		node.setFitToWidth(true);

		return node;
	}
}
