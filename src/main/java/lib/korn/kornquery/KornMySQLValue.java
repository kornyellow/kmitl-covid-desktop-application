package lib.korn.kornquery;

public class KornMySQLValue {
	public KornMySQLValue() {
		this.val = null;
	}

	private String val;

	public String getValue() {
		return this.val;
	}
	public void setValue(String val) {
		this.val = val;
	}
}
