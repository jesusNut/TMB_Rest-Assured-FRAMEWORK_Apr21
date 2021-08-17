package com.TMB.utils;

import java.security.SecureRandom;

public final class RandomUtils {

	// a private constructor so that no other class can create an object of this
	// class

	private RandomUtils() {

	}

	private static final SecureRandom random = new SecureRandom();

	public static String generateRandomString(int length) {

		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(text.charAt(random.nextInt(text.length())));
		return sb.toString();

	}

	public static String generateRandomNumericString(int length) {
		String textnumber = "0123456789";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(textnumber.charAt(random.nextInt(textnumber.length())));
		return sb.toString();

	}

}
