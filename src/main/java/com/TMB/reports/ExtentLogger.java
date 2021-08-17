package com.TMB.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	// log pass

	public static void pass(String details) {

		ExtentManager.getExtentTest().pass(details);

	}

	// log fail

	public static void fail(String details) {

		ExtentManager.getExtentTest().fail(details);

	}

	// log skip

	public static void skip(String details) {

		ExtentManager.getExtentTest().skip(details);

	}

	// log Info

	public static void info(String details) {

		ExtentManager.getExtentTest().info(details);

	}

	// log Info:mArkup

	public static void info(Markup markup) {

		ExtentManager.getExtentTest().info(markup);

	}

	// log failure exception in formatted way

	public static void logStackTraceInfoInExtentReport(String message) {
		String formattedText = "<pre>" + message.replace(",", "<br>") + "</pre>";
		ExtentManager.getExtentTest().fail(formattedText);
	}

	// to log both request and response

	public static void logRequestAndResponseInReport(String request, String response) {
		logPrettyRequestToReport(request);
		logPrettyResponseToReport(response);
	}

	// to log only response in case of GET methods

	public static void logOnlyResponse(String response) {

		logPrettyResponseToReport(response);

	}

	// to log response - private method

	private static void logPrettyResponseToReport(String response) {
		ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));
	}

	// to log request - private method

	private static void logPrettyRequestToReport(String request) {
		ExtentManager.getExtentTest().info("<pre>" + request.replace("\n", "<br>") + "</pre>");
	}

}
