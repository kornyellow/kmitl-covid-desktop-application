package kmitl.covid.lib.korn.kornutil;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class KornHash {
	public static String getHash(String toHash) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(toHash.getBytes(StandardCharsets.UTF_8));
		} catch (Exception e) {
			System.out.println("ERROR: Unable to hash (" + e.getMessage() + ")");
		}

		if (md != null)
			return KornHash.convertToHex(md.digest());
		return "";
	}

	public static boolean verifyHash(String firstHash, String secondHash) {
		return KornHash.getHash(firstHash).equals(secondHash);
	}

	private static String convertToHex(final byte[] messageDigest) {
		BigInteger bigInteger = new BigInteger(1, messageDigest);
		String hexText = bigInteger.toString(16);
		while (hexText.length() < 32)
			hexText = "0".concat(hexText);
		return hexText;
	}
}
