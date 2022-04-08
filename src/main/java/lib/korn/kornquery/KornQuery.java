package lib.korn.kornquery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

public class KornQuery {
	public KornQuery(Connection connection) {
		this.connection = connection;
	}

	public KornQuery query(KornQueryBuilder query) {
		try {
			PreparedStatement statement = this.connection.prepareStatement(query.build());
			statement.execute();
			KornQuery.queryCount ++;

			this.result = statement.getResultSet();
			if (this.result != null) {
				this.resultMeta = this.result.getMetaData();
				for (int col = 1; col <= this.resultMeta.getColumnCount(); col ++) {
					this.fields.put(this.resultMeta.getColumnName(col), null);
				}
			}
			return this;

		} catch (Exception e) {
			System.out.println("ERROR: Unable to prepare query (" + e.getMessage() + ")");
			return null;
		}
	}

	public KornQuery unsafeQuery(String query) {
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.execute();
			KornQuery.queryCount ++;

			this.result = statement.getResultSet();
			if (this.result != null) {
				this.resultMeta = this.result.getMetaData();
				for (int col = 1; col <= this.resultMeta.getColumnCount(); col ++) {
					this.fields.put(this.resultMeta.getColumnName(col), null);
				}
			}
			return this;

		} catch (Exception e) {
			System.out.println("ERROR: Unable to prepare query (" + e.getMessage() + ")");
			return null;
		}
	}

	public void close() {
		try {
			if (this.result == null) return;
			if (this.result.isClosed()) return;
			this.result.close();

		} catch (Exception e) {
			System.out.println("ERROR: Unable to close query (" + e.getMessage() + ")");
		}
	}

	public void bindValue(String fieldName, KornMySQLValue ref) {
		if (this.fields.containsKey(fieldName)) {
			this.fields.replace(fieldName, ref);
		} else {
			System.out.println("ERROR: Unable to bind \"" + fieldName + "\" (Field not exists)");
		}
	}

	public boolean nextBind() {
		try {
			boolean isNext = this.result.next();
			if (!isNext) return false;

			for (int col = 1; col <= this.resultMeta.getColumnCount(); col ++) {
				String fieldName = this.resultMeta.getColumnName(col);
				this.fields.getOrDefault(fieldName, null).setValue(this.result.getString(col));
			}

		} catch (Exception e) {
			System.out.println("ERROR: Unable to fetch (" + e.getMessage() + ")");
		}
		return true;
	}

	private final Connection connection;

	private Map<String, KornMySQLValue> fields = new HashMap<>();
	private static int queryCount;
	private ResultSet result;
	private ResultSetMetaData resultMeta;
	private int affectedRows;
	private int insertedID;

	public static int getQueryCount() {
		return queryCount;
	}
	public int getAffectedRows() {
		return affectedRows;
	}
	public int getInsertedID() {
		return insertedID;
	}
}
