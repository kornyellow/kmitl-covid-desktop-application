package kmitl.covid.lib.korn.kornquery;

public class KornWhereMySQL {
	public KornWhereMySQL(String column, KornMySQLCompare compare, String value, KornMySQLOperator operator) {
		this.column = column;
		this.value = value;
		this.compare = compare;
		this.operator = operator;

		if (this.value == null && this.compare.equals(KornMySQLCompare.EQUAL)) {
			this.compare = KornMySQLCompare.IS_NULL;
		}
	}

	public String getWhereString() {
		StringBuilder output = new StringBuilder();
		output.append(this.column).append(" ").append(this.compare.getValue());

		if (!this.compare.equals(KornMySQLCompare.IS_NULL) && !this.compare.equals(KornMySQLCompare.IS_NOT_NULL)) {
			output.append(" '").append(this.value).append("'");
		}

		return output.toString();
	}

	private KornMySQLCompare compare;
	private KornMySQLOperator operator;
	private final String column;
	private final String value;

	public KornMySQLCompare getCompare() {
		return compare;
	}
	public KornMySQLOperator getOperator() {
		return operator;
	}
	public String getColumn() {
		return column;
	}
	public String getValue() {
		return value;
	}
}
