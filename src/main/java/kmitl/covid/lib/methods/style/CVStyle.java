package kmitl.covid.lib.methods.style;

import javafx.scene.control.Button;
import kmitl.covid.lib.enums.EnumButtonType;
import kmitl.covid.lib.korn.kornutil.KornFont;
import kmitl.covid.lib.korn.kornutil.KornIcon;

public class CVStyle {
	public static Button makeButton(String text, String icon, EnumButtonType type) {
		Button button = new Button(text);
		button.setFont(KornFont.paragraphBold);
		button.setGraphic(KornIcon.getIconRegular(icon));
		button.setGraphicTextGap(10);
		button.getGraphic().getStyleClass().addAll("graphic");
		button.getStyleClass().addAll("btn", type.getStyle());

		return button;
	}
}
