package kmitl.covid.lib.korn.kornutil;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class KornHash {
	public static String getHash(String toHash) {
		return BCrypt.withDefaults().hashToString(12, toHash.toCharArray());
	}
	public static boolean verifyHash(String password, String toVerify) {
		return BCrypt.verifyer().verify(password.toCharArray(), toVerify).verified;
	}
}
