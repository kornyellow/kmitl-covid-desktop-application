package kmitl.covid.lib.korn.kornresource;

import javafx.scene.image.Image;
import kmitl.covid.Launcher;

import java.util.Objects;

public class KornImage {
	public static void loadImage() {
		KornImage.backgroundPath = Objects.requireNonNull(Launcher.class.getResource("image/background.jpg")).toString();

		KornImage.background = new Image(KornImage.backgroundPath);
	}

	public static Image background;

	private static String backgroundPath;
}
