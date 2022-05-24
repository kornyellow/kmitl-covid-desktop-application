package kmitl.covid.lib.enums;

public enum EnumVaccineType {
	PFIZER("Pfizer", "ไฟเซอร์"),
	MODERNA("Moderna", "โมเดอร์นา"),
	ASTRAZENECA("Astrazeneca", "แอสตร้าเซนเนก้า"),
	JOHNSON("Johnson&Johnson", "จอห์นสันแอนด์จอห์นสัน"),
	SINOVAC("Sinovac", "ซิโนแวค")
	;
	EnumVaccineType(String english, String thai) {
		this.english = english;
		this.thai = thai;
	}

	public static EnumNameTitle nameOf(String name) {
		for (EnumNameTitle vaccine : EnumNameTitle.values()) {
			if (vaccine.getThai().equals(name) ||
				vaccine.getEnglish().equals(name))
				return vaccine;
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