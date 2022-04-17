package lib.korn.kornutil;

import javafx.scene.text.Font;

public class KornFont {
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

	private static final int textHeader = 24;
	private static final int textSubHeader = 20;
	private static final int textParagraph = 16;
	private static final int textSmall = 14;
	public static String fontPathLight;
	public static String fontPathNormal;
	public static String fontPathBold;

	public static void loadAllFont() {
		headerLight = Font.loadFont(KornFont.fontPathLight, KornFont.textHeader);
		headerNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textHeader);
		headerBold = Font.loadFont(KornFont.fontPathBold, KornFont.textHeader);
		subHeaderLight = Font.loadFont(KornFont.fontPathLight, KornFont.textSubHeader);
		subHeaderNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textSubHeader);
		subHeaderBold = Font.loadFont(KornFont.fontPathBold, KornFont.textSubHeader);
		paragraphLight = Font.loadFont(KornFont.fontPathLight, KornFont.textParagraph);
		paragraphNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textParagraph);
		paragraphBold = Font.loadFont(KornFont.fontPathBold, KornFont.textParagraph);
		smallLight = Font.loadFont(KornFont.fontPathLight, KornFont.textSmall);
		smallNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textSmall);
		smallBold = Font.loadFont(KornFont.fontPathBold, KornFont.textSmall);
	}
}
