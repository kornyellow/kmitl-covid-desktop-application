package kmitl.covid.lib.korn.kornresource;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import kmitl.covid.Launcher;

import java.util.Objects;

public class KornIcon {
	public static void loadIcon() {
		KornIcon.fontPath = Objects.requireNonNull(Launcher.class.getResource("font/fontawesome/FontAwesome.otf")).toString();

		KornIcon.megaFont = Font.loadFont(KornIcon.fontPath, KornIcon.iconMega);
		KornIcon.bigFont = Font.loadFont(KornIcon.fontPath, KornIcon.iconBig);
		KornIcon.regularFont = Font.loadFont(KornIcon.fontPath, KornIcon.iconRegular);
		KornIcon.smallFont = Font.loadFont(KornIcon.fontPath, KornIcon.iconSmall);
	}

	public static Label getIconMega(String icon) {
		Label label = new Label(icon);
		label.setFont(KornIcon.megaFont);
		return label;
	}
	public static Label getIconBig(String icon) {
		Label label = new Label(icon);
		label.setFont(KornIcon.bigFont);
		return label;
	}
	public static Label getIconRegular(String icon) {
		Label label = new Label(icon);
		label.setFont(KornIcon.regularFont);
		return label;
	}
	public static Label getIconSmall(String icon) {
		Label label = new Label(icon);
		label.setFont(KornIcon.smallFont);
		return label;
	}

	public static Font megaFont;
	public static Font bigFont;
	public static Font regularFont;
	public static Font smallFont;

	private static final int iconMega = 64;
	private static final int iconBig = 38;
	private static final int iconRegular = 16;
	private static final int iconSmall = 10;
	private static String fontPath;
}
