package kmitl.covid.lib.korn.kornquery;

public enum KornMySQLCompare {
	EQUAL("="),
	NOT_EQUAL("!="),
	LIKE("LIKE"),
	MORE_THAN(">"),
	MORE_THAN_EQUAL(">="),
	LESS_THAN("<"),
	LESS_THAN_EQUAL("<="),
	IS_NULL("IS NULL"),
	IS_NOT_NULL("IS NOT NULL"),
	;
	KornMySQLCompare(String value) {
		this.value = value;
	}

	private final String value;

	String getValue() {
		return this.value;
	}
}