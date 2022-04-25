package kmitl.covid.lib.korn.kornquery;

import java.util.HashMap;
import java.util.Map;

public class KornInsertMySQL extends KornQueryBuilder {
	public KornInsertMySQL insert(String key, String value) {
		this.inserts.put(key, value);
		return this;
	}

	@Override
	public String build() {
		StringBuilder output = new StringBuilder("INSERT INTO ");
		output.append("`").append(this.table).append("`");

		output.append(" (");
		for (String key : this.inserts.keySet()) {
			output.append("`").append(key).append("`, ");
		}
		output.delete(output.length() - 2, output.length());
		output.append(") VALUES (");

		for (String value : this.inserts.values()) {
			output.append("\"").append(value).append("\", ");
		}
		output.delete(output.length() - 2, output.length());
		output.append(")");

		return output.toString();
	}

	private final Map<String, String> inserts = new HashMap<>();
}
