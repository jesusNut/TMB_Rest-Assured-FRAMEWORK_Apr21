package com.TMB.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReportUtil {

	private ExtentReportUtil() {
	}

	private static ExtentReports extent = new ExtentReports();

	protected static ExtentTest test = null;

	public static void initReports() {

		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//index.html");
		spark.config().setDocumentTitle("A Sample Extent Report");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);

	}

	public static void tearDownReports() throws IOException {

		extent.flush();

		Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"//index.html").toURI());
	}

	public static void createTest(String methodname) {

		test = extent.createTest(methodname);
		ExtentManager.setExtentTest(test);

	}

}
