package com.TMB.reports;

import com.aventstack.extentreports.ExtentTest;

//Implementation of thread local class for ExtentTest Object's thread Safety during parallel execution

public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>();

	protected static ExtentTest getExtentTest() {

		return exTest.get();

	}

	protected static void setExtentTest(ExtentTest test) {

		exTest.set(test);
	}

}
