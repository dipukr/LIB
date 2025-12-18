package main;

import java.security.MessageDigest;

public class Commons {
	public static MessageDigest SHA256() {
		try {
			return MessageDigest.getInstance("SHA-256");
		} catch (Exception e) {
			Error.error("ERROR: " + e.getMessage());
			return null;
		}
	}
}
