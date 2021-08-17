package com.TMB.constants;

import lombok.Getter;

//The constants can be stored in many approaches in a framework -
//FrameworkConstants, FrameworkConstantsWithEagerLoading (using Enum), FrameworkConstantsSingleton.
//Any of the approaches can be used.

@Getter
public class FrameworkConstantsSingleton {

	private FrameworkConstantsSingleton() {
	};

	private static FrameworkConstantsSingleton object = null;

	public static FrameworkConstantsSingleton getObject() {

		if (object == null) {

			object = new FrameworkConstantsSingleton();
		}

		return object;
	}

	private String EMPLOYEE_BASEURI = "http://localhost:3000";
	private String EMPLOYEE_ENDPOINT = "/employees";
	private String REQUESTBODYEXTERNALFILEFOLDERPATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\RequestBodyExternalFiles\\";
	
	
	public  final int statusCode200 = 200;
	public  final int statusCode201 = 201;

}
