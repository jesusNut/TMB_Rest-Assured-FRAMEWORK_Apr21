package com.TMB.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class RequestBodyExternalFileReadUtils {

	// a private constructor so that no other class can create an onject of this
	// class

	private RequestBodyExternalFileReadUtils() {
	};

	// a method to get JSON file dynamically as String so request can be manipulated

	public static String getJSONfileAsString(String location) throws IOException {

		return new String(Files.readAllBytes(Paths.get(location)));

	}

}
