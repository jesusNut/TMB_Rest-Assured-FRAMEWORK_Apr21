package com.TMB.constants;


//The constants can be stored in many approaches in a framework -
//FrameworkConstants, FrameworkConstantsWithEagerLoading (using Enum), FrameworkConstantsSingleton.
//Any of the approaches can be used.


import lombok.Getter;

////use of Lombok annotations 

//********Lombok @Getter annotation on the class level can be used only to produce getters for non static variables.


public final class FrameworkConstants {
	
	// a private constructor so that no other class can create an object of this
		// class
	
	public FrameworkConstants() {};

	private @Getter final static String EMPLOYEE_BASEURI = "http://localhost:3000";
	private @Getter final static String EMPLOYEE_ENDPOINT = "/employees";
	private @Getter static final String REQUESTBODYEXTERNALFILEFOLDERPATH=System.getProperty("user.dir") + "\\src\\test\\resources\\RequestBodyExternalFiles\\";
	

	public static final int statusCode200 = 200;
	public static final int statusCode201 = 201;
}
