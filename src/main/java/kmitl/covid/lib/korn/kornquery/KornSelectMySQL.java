package kmitl.covid.lib.korn.kornquery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KornSelectMySQL extends KornQueryBuilder {
	public KornSelectMySQL select(String... vars) {
		selects.addAll(Arrays.asList(vars));
		return this;
	}
	public KornSelectMySQL where(String column, String value) {
		this.wheres.add(new KornWhereMySQL(column, KornMySQLCompare.EQUAL(), value, KornMySQLOperator.AND()));
		return this;
	}
	public KornSelectMySQL whereWithCompare(String column, KornMySQLCompare compare, String value) {
		this.wheres.add(new KornWhereMySQL(column, compare, value, KornMySQLOperator.AND()));
		return this;
	}
	public KornSelectMySQL whereWithCompareAndOperator(String column, KornMySQLCompare compare, String value, KornMySQLOperator operator) {
		this.wheres.add(new KornWhereMySQL(column, compare, value, operator));
		return this;
	}
	public KornSelectMySQL limit(int limit) {
		this.limit = limit;
		return this;
	}
	public KornSelectMySQL offset(int offset) {
		this.offset = offset;
		return this;
	}
	public KornSelectMySQL orderBy(String column, KornMySQLOrder orderBy) {
		this.orderBy.put(column, orderBy);
		return this;
	}

	@Override
	public String build() {
		StringBuilder output = new StringBuilder();
		output.append("SELECT ");

		for (String select : this.selects) {
			output.append(select).append(", ");
		}
		output.delete(output.length() - 2, output.length());

		output.append(" FROM `").append(this.table).append("`");

		if (!this.wheres.isEmpty()) {
			boolean isAlreadyWhere = false;
			output.append(" WHERE ");
			for (KornWhereMySQL where : this.wheres) {
				if (isAlreadyWhere) {
					output.append(" ").append(where.getOperator()).append(" ");
				}
				output.append(" ").append(where.getWhereString()).append(" ");
				isAlreadyWhere = true;
			}
		}

		if (!this.orderBy.isEmpty()) {
			output.append(" ORDER BY ");
			for (Map.Entry<String, KornMySQLOrder> entry : this.orderBy.entrySet()) {
				output.append(entry.getKey()).append(" ").append(entry.getValue()).append(", ");
			}
			output.delete(output.length() - 2, output.length());
		}

		if (this.limit > 0) {
			output.append(" LIMIT ");
			if (this.offset == 0) {
				output.append(this.limit);
			} else if (this.offset > 0) {
				output.append(this.offset).append(", ").append(this.limit);
			}
		}

		return output.toString();
	}

	private final ArrayList<String> selects = new ArrayList<>();
	private final ArrayList<KornWhereMySQL> wheres = new ArrayList<>();
	private final Map<String, KornMySQLOrder> orderBy = new HashMap<>();

	private int limit;
	private int offset;
}
