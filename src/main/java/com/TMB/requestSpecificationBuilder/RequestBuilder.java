package com.TMB.requestSpecificationBuilder;

import static io.restassured.RestAssured.given;

import com.TMB.constants.FrameworkConstants;
import com.TMB.constants.FrameworkConstantsWithEagerLoading;
import com.TMB.enums.Constants;

import io.restassured.specification.RequestSpecification;

public final class RequestBuilder {

	// a private constructor so that no other class can create an object of this
	// class

	private RequestBuilder() {
	};

	public static RequestSpecification getRequestBuilder() {

		return given()
				.log().
				all().
				baseUri(FrameworkConstantsWithEagerLoading.getConstantValue(Constants.EMPLOYEE_BASEURI).toString());

	}

}
