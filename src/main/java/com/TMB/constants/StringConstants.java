package com.TMB.constants;

import lombok.Getter;

public final class StringConstants {
	
	
	// a private constructor so that no other class can create an onject of this
		// class
	
	public StringConstants() {};

	private @Getter static final String reqBodyForPost = "{\r\n" + "    \"id\": 88,\r\n"
			+ "    \"first_name\": \"Parambir\",\r\n" + "    \"last_name\": \"Arknob\",\r\n"
			+ "    \"email\": \"chongla.pongla.com\"\r\n" + "}";

	

}
