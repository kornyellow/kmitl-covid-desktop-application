package kmitl.covid.lib.enums;

public enum EnumNameTitle {
	MISTER("Mister", "นาย"),
	MISTRESS("Mistress", "นาง"),
	MISS("Miss", "นางสาว"),
	;
	EnumNameTitle(String english, String thai) {
		this.english = english;
		this.thai = thai;
	}

	public static EnumNameTitle nameOf(String name) {
		for (EnumNameTitle gender : EnumNameTitle.values()) {
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