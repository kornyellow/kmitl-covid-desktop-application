package kmitl.covid.lib.enums;

public enum EnumGender {
	MALE("Male", "ชาย"),
	FEMALE("Female", "หญิง"),
	NOT_SPECIFIED("Not specified", "ไม่ระบุ"),
	;
	EnumGender(String english, String thai) {
		this.english = english;
		this.thai = thai;
	}

	public static EnumGender nameOf(String name) {
		for (EnumGender gender : EnumGender.values()) {
			if (gender.getThai().equals(name) ||
				gender.getEnglish().equals(name))
				return gender;
		}
		return null;
	}

	private final String english;
	private final String thai;

	public String getEnglish() {
		return english;
	}
	public String getThai() {
		return thai;
	}
}
