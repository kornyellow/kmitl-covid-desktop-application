package kmitl.covid.lib.enums;

import kmitl.covid.lib.korn.kornutil.KornEnum;

public class EnumNameTitle extends KornEnum {
	public EnumNameTitle(String key) {
		super(key);
	}

	public static EnumNameTitle MISTER() { return new EnumNameTitle("นาย"); }
	public static EnumNameTitle MISS() { return new EnumNameTitle("นางสาว"); }
	public static EnumNameTitle MISTRESS() { return new EnumNameTitle("นาง"); }
}
