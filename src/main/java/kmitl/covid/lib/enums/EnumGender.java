package kmitl.covid.lib.enums;

public enum EnumGender {
	MALE("Male", "ผู้ชาย"),
	FEMALE("Female", "ผู้หญิง"),
	OTHER("Other", "อื่น ๆ"),
	;
	EnumGender(String english, String thai) {
		this.english = english;
		this.thai = thai;
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
