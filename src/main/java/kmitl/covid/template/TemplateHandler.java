package kmitl.covid.template;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class TemplateHandler {
	public static ScrollPane getContent(Node content) {
		HBox hbox = new HBox();
		hbox.getStyleClass().addAll("sub-body");
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.setPadding(new Insets(40));

		content.getStyleClass().add("card");
		HBox.setHgrow(content, Priority.ALWAYS);
		hbox.getChildren().add(content);

		ScrollPane node = new ScrollPane(hbox);
		node.setFitToHeight(true);
		node.setFitToWidth(true);

		return node;
	}
}
