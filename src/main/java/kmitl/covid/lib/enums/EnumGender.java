package kmitl.covid.lib.enums;

import kmitl.covid.lib.korn.kornutil.KornEnum;

public class EnumGender extends KornEnum {
	public EnumGender(String key) {
		super(key);
	}

	public static EnumGender MALE() { return new EnumGender("เพศชาย"); }
	public static EnumGender FEMALE() { return new EnumGender("เพศหญิง"); }
	public static EnumGender OTHER() { return new EnumGender("อื่น ๆ"); }
}
