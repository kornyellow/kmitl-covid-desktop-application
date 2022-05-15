package kmitl.covid.lib.korn.kornresource;

public class KornResource {
	public static void loadResource() {
		KornFont.loadFont();
		KornIcon.loadIcon();
		KornCSS.loadCSS();
		KornImage.loadImage();
	}
}
