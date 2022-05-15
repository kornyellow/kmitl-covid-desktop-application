package kmitl.covid.lib.korn.kornresource;

import javafx.scene.text.Font;
import kmitl.covid.Launcher;

import java.util.Objects;

public class KornFont {
	public static void loadFont() {
		KornFont.fontPathLight = Objects.requireNonNull(Launcher.class.getResource("font/graphikthailoop/GraphikThaiLoop-Light.otf")).toString();
		KornFont.fontPathNormal = Objects.requireNonNull(Launcher.class.getResource("font/graphikthailoop/GraphikThaiLoop-Regular.otf")).toString();
		KornFont.fontPathBold = Objects.requireNonNull(Launcher.class.getResource("font/graphikthailoop/GraphikThaiLoop-Semibold.otf")).toString();

		Font.loadFont(Objects.requireNonNull(Launcher.class.getResource("font/graphikthailoop/GraphikThaiLoop-Light.otf")).toExternalForm(), 10);
		Font.loadFont(Objects.requireNonNull(Launcher.class.getResource("font/graphikthailoop/GraphikThaiLoop-Regular.otf")).toExternalForm(), 10);
		Font.loadFont(Objects.requireNonNull(Launcher.class.getResource("font/graphikthailoop/GraphikThaiLoop-Semibold.otf")).toExternalForm(), 10);

		KornFont.bigHeaderLight = Font.loadFont(KornFont.fontPathLight, KornFont.textBigHeader);
		KornFont.bigHeaderNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textBigHeader);
		KornFont.bigHeaderBold = Font.loadFont(KornFont.fontPathBold, KornFont.textBigHeader);
		KornFont.headerLight = Font.loadFont(KornFont.fontPathLight, KornFont.textHeader);
		KornFont.headerNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textHeader);
		KornFont.headerBold = Font.loadFont(KornFont.fontPathBold, KornFont.textHeader);
		KornFont.subHeaderLight = Font.loadFont(KornFont.fontPathLight, KornFont.textSubHeader);
		KornFont.subHeaderNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textSubHeader);
		KornFont.subHeaderBold = Font.loadFont(KornFont.fontPathBold, KornFont.textSubHeader);
		KornFont.paragraphLight = Font.loadFont(KornFont.fontPathLight, KornFont.textParagraph);
		KornFont.paragraphNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textParagraph);
		KornFont.paragraphBold = Font.loadFont(KornFont.fontPathBold, KornFont.textParagraph);
		KornFont.smallLight = Font.loadFont(KornFont.fontPathLight, KornFont.textSmall);
		KornFont.smallNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textSmall);
		KornFont.smallBold = Font.loadFont(KornFont.fontPathBold, KornFont.textSmall);
	}

	public static Font bigHeaderLight;
	public static Font bigHeaderNormal;
	public static Font bigHeaderBold;
	public static Font headerLight;
	public static Font headerNormal;
	public static Font headerBold;
	public static Font subHeaderLight;
	public static Font subHeaderNormal;
	public static Font subHeaderBold;
	public static Font paragraphLight;
	public static Font paragraphNormal;
	public static Font paragraphBold;
	public static Font smallLight;
	public static Font smallNormal;
	public static Font smallBold;

	private static final int textBigHeader = 48;
	private static final int textHeader = 36;
	private static final int textSubHeader = 24;
	private static final int textParagraph = 20;
	private static final int textSmall = 16;
	private static String fontPathLight;
	private static String fontPathNormal;
	private static String fontPathBold;
}
