package lib.korn.kornutil;

import javafx.scene.text.Font;

public class KornFont {
	public static Font headerLight = Font.loadFont(KornFont.fontPathLight, KornFont.textHeader);
	public static Font headerNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textHeader);
	public static Font headerBold = Font.loadFont(KornFont.fontPathBold, KornFont.textHeader);
	public static Font subHeaderLight = Font.loadFont(KornFont.fontPathLight, KornFont.textSubHeader);
	public static Font subHeaderNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textSubHeader);
	public static Font subHeaderBold = Font.loadFont(KornFont.fontPathBold, KornFont.textSubHeader);
	public static Font paragraphLight = Font.loadFont(KornFont.fontPathLight, KornFont.textParagraph);
	public static Font paragraphNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textParagraph);
	public static Font paragraphBold = Font.loadFont(KornFont.fontPathBold, KornFont.textParagraph);
	public static Font smallLight = Font.loadFont(KornFont.fontPathLight, KornFont.textSmall);
	public static Font smallNormal = Font.loadFont(KornFont.fontPathNormal, KornFont.textSmall);
	public static Font smallBold = Font.loadFont(KornFont.fontPathBold, KornFont.textSmall);

	private static final int textHeader = 24;
	private static final int textSubHeader = 20;
	private static final int textParagraph = 16;
	private static final int textSmall = 14;
	private static final String fontPathLight = "file:static/font/graphik_thai_loop/GraphikThaiLoop-Light.otf";
	private static final String fontPathNormal = "file:static/font/graphik_thai_loop/GraphikThaiLoop-Regular.otf";
	private static final String fontPathBold = "file:static/font/graphik_thai_loop/GraphikThaiLoop-Semibold.otf";
}
