package kmitl.covid.lib.korn.kornutil;

public class KornString {
	public static String trim(String string, int length) {
		return string.substring(0, Math.min(string.length(), length));
	}
}
