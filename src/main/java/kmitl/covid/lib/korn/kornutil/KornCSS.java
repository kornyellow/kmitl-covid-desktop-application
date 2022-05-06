package kmitl.covid.lib.korn.kornutil;

import kmitl.covid.Launcher;

import java.util.Objects;

public class KornCSS {
	public static void loadCSS() {
		KornCSS.path = Objects.requireNonNull(Launcher.class.getResource("css/stylesheet.css")).toString();
	}

	public static String path;
}
