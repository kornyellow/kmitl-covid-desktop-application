package kmitl.covid.template;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;

public class TemplateHandler {
	public static ScrollPane getContent(Node content) {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10, 0, 10, 0));
		hbox.getChildren().add(content);

		ScrollPane node = new ScrollPane(hbox);
		//node.setStyle("-fx-background-color: transparent; -fx-control-inner-background: transparent;");
		node.setBorder(Border.EMPTY);
		node.setFitToHeight(true);

		return node;
	}
}
