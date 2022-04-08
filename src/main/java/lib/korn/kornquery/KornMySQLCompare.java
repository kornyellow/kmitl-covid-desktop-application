package lib.korn.kornquery;

import lib.korn.kornutil.KornEnum;

public class KornMySQLCompare extends KornEnum {
	public KornMySQLCompare(String key) {
		super(key);
	}

	public static KornMySQLCompare EQUAL() { return new KornMySQLCompare("="); }
	public static KornMySQLCompare NOT_EQUAL() { return new KornMySQLCompare("!="); }
	public static KornMySQLCompare LIKE() { return new KornMySQLCompare("LIKE"); }
	public static KornMySQLCompare MORE_THAN() { return new KornMySQLCompare(">"); }
	public static KornMySQLCompare MORE_THAN_EQUAL() { return new KornMySQLCompare(">="); }
	public static KornMySQLCompare LESS_THAN() { return new KornMySQLCompare("<"); }
	public static KornMySQLCompare LESS_THAN_EQUAL() { return new KornMySQLCompare("<="); }

	public static KornMySQLCompare IS_NULL() { return new KornMySQLCompare("IS NULL"); }
	public static KornMySQLCompare IS_NOT_NULL() { return new KornMySQLCompare("IS NOT NULL"); }
}
