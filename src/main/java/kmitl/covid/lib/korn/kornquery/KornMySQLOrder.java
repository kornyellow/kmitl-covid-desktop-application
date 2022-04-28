package kmitl.covid.lib.korn.kornquery;

public enum KornMySQLOrder {
	ASC("ASC"),
	DESC("DESC"),
	;
	KornMySQLOrder(String value) {
		this.value = value;
	}

	private final String value;

	String getValue() {
		return this.value;
	}
}