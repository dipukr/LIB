package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Tools {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static MessageDigest md = algorithm("SHA-256");
	private static final Random rand = new Random();
	
	public static MessageDigest algorithm(String algo) {
		try {
			return MessageDigest.getInstance(algo);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	public static long hash(String key) {
		md.reset();
		md.update(key.getBytes());
		byte[] digest = md.digest();
		long hash = ((long) (digest[0] & 0xFF) << 56) |
			((long) (digest[0] & 0xFF) << 48) |
			((long) (digest[0] & 0xFF) << 40) |
			((long) (digest[0] & 0xFF) << 32) |
			((long) (digest[0] & 0xFF) << 24) |
			((long) (digest[0] & 0xFF) << 16) |
			((long) (digest[0] & 0xFF) << 8) |
			((long) (digest[0] & 0xFF));
		return hash;
	}
	
	public static int randInt(int bound) {
		return rand.nextInt(bound);
	}
	
	public static int randInt(int origin, int bound) {
		return rand.nextInt(origin, bound);
	}
	
	public static String randStr(int len) {
		var sb = new StringBuilder();
		for (int i = 0; i < len; i++)
			sb.append(ALPHABET.charAt(randInt(ALPHABET.length())));
		return sb.toString();
	}
}
