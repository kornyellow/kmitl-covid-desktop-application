package kmitl.covid.template;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import kmitl.covid.lib.korn.kornutil.KornDateTime;
import kmitl.covid.lib.korn.kornutil.KornFont;
import kmitl.covid.other.Config;

public class TemplateFooter {
	public static GridPane getContent() {
		if (TemplateFooter.node != null) return TemplateFooter.node;
		TemplateFooter.node = new GridPane();

		RowConstraints row = new RowConstraints();
		row.setVgrow(Priority.ALWAYS);
		TemplateFooter.node.getRowConstraints().addAll(row);

		ColumnConstraints column = new ColumnConstraints();
		column.setHgrow(Priority.ALWAYS);
		TemplateFooter.node.getColumnConstraints().addAll(column);

		Label version = new Label("© " + new KornDateTime().getYear() + " - KMITL Students");
		version.setFont(KornFont.smallNormal);
		GridPane.setHalignment(version, HPos.LEFT);
		GridPane.setValignment(version, VPos.CENTER);
		TemplateFooter.node.add(version, 0, 0);

		String isLocalHost = (Config.isLocalhost) ? "Localhost" : "Production";
		Label copyright = new Label("Version - " + Config.applicationVersion +
			" (" + isLocalHost + ")");
		copyright.setFont(KornFont.smallNormal);
		GridPane.setHalignment(copyright, HPos.RIGHT);
		GridPane.setValignment(copyright, VPos.CENTER);
		TemplateFooter.node.add(copyright, 1, 0);

		return TemplateFooter.node;
	}

	private static GridPane node;
}
