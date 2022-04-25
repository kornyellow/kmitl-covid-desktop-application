package kmitl.covid.lib.korn.kornutil;

public class KornEnum {
	public KornEnum(String key) {
		this.key = key;
	}

	public boolean equal(KornEnum e) {
		return this.key.equals(e.key);
	}

	@Override
	public String toString() {
		return this.key;
	}

	private final String key;

	public String getKey() {
		return key;
	}
}
