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

	private final String english;
	private final String thai;

	public String getEnglish() {
		return english;
	}
	public String getThai() {
		return thai;
	}
}