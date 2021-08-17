package com.TMB.constants;

import java.util.HashMap;
import java.util.Map;

import com.TMB.enums.Constants;

//The constants can be stored in many approaches in a framework -
//FrameworkConstants, FrameworkConstantsWithEagerLoading (using Enum), FrameworkConstantsSingleton.
//Any of the approaches can be used.

public class FrameworkConstantsWithEagerLoading {

	// a private constructor so that no other class can create an object of this
	// class

	public FrameworkConstantsWithEagerLoading() {
	};

	private static Map<Constants, Object> MCONSTANTS = new HashMap<Constants, Object>();

	// creating a static block and passing all the constant values

	static {

		MCONSTANTS.put(Constants.EMPLOYEE_BASEURI, "http://localhost:3000");
		MCONSTANTS.put(Constants.EMPLOYEE_ENDPOINT, "/employees");
		MCONSTANTS.put(Constants.REQUESTBODYEXTERNALFILEFOLDERPATH,
				System.getProperty("user.dir") + "\\src\\test\\resources\\RequestBodyExternalFiles\\");
		MCONSTANTS.put(Constants.STATUSCODE200, 200);
		MCONSTANTS.put(Constants.STATUSCODE201, 201);

	}

	public static Object getConstantValue(Constants value) {

		return MCONSTANTS.get(value);

	}

}
