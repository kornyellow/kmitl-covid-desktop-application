package kmitl.covid.lib.korn.kornquery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KornUpdateMySQL extends KornQueryBuilder {
	public KornUpdateMySQL set(String key, String value) {
		this.toUpdate.put(key, value);
		return this;
	}
	public KornUpdateMySQL where(String column, String value) {
		this.wheres.add(new KornWhereMySQL(column, KornMySQLCompare.EQUAL(), value, KornMySQLOperator.AND()));
		return this;
	}
	public KornUpdateMySQL whereWithCompare(String column, KornMySQLCompare compare, String value) {
		this.wheres.add(new KornWhereMySQL(column, compare, value, KornMySQLOperator.AND()));
		return this;
	}
	public KornUpdateMySQL whereWithCompareAndOperator(String column, KornMySQLCompare compare, String value, KornMySQLOperator operator) {
		this.wheres.add(new KornWhereMySQL(column, compare, value, operator));
		return this;
	}
	public KornUpdateMySQL limit(int limit) {
		this.limit = limit;
		return this;
	}

	@Override
	public String build() {
		StringBuilder output = new StringBuilder();
		output.append("UPDATE ");
		output.append("`").append(this.table).append("` SET ");

		for (Map.Entry<String, String> entry : this.toUpdate.entrySet()) {
			output.append("`").append(entry.getKey()).append("` = '").append(entry.getValue()).append("', ");
		}
		output.delete(output.length() - 2, output.length());

		if (!this.wheres.isEmpty()) {
			boolean isAlreadyWhere = false;
			output.append(" WHERE");
			for (KornWhereMySQL where : this.wheres) {
				if (isAlreadyWhere) {
					output.append(" ").append(where.getOperator()).append(" ");
				}
				output.append(" ").append(where.getWhereString()).append(" ");
				isAlreadyWhere = true;
			}
		}

		if (this.limit > 0) {
			output.append(" LIMIT ").append(this.limit);
		}

		return output.toString();
	}

	private final Map<String, String> toUpdate = new HashMap<>();
	private final ArrayList<KornWhereMySQL> wheres = new ArrayList<>();

	private int limit;
}
