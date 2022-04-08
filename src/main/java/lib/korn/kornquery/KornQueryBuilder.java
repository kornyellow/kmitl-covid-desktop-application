package lib.korn.kornquery;

abstract class KornQueryBuilder {
	public abstract String build();

	public KornQueryBuilder table(String table) {
		this.table = table;
		return this;
	}

	protected String table;
}
