package lib.korn.kornutil;

public class KornFix {
	public static void fixAll() {
		KornFix.fontRendering();
	}

	private static void fontRendering() {
		System.setProperty("prism.lcdtext", "false");
		System.setProperty("prism.text", "t2k");
	}
}
