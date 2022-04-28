package kmitl.covid.lib.korn.kornquery;

public enum KornMySQLOperator {
	AND("AND"),
	OR("OR"),
	;
	KornMySQLOperator(String value) {
		this.value = value;
	}

	private final String value;

	String getValue() {
		return this.value;
	}
}