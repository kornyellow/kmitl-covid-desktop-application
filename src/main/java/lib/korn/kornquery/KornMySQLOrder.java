package lib.korn.kornquery;

import lib.korn.kornutil.KornEnum;

public class KornMySQLOrder extends KornEnum {
	public KornMySQLOrder(String key) {
		super(key);
	}

	public static KornMySQLOrder ASC() { return new KornMySQLOrder("ASC"); }
	public static KornMySQLOrder DESC() { return new KornMySQLOrder("DESC"); }
}
