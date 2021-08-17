package com.TMB.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TMB.reports.ExtentLogger;
import com.TMB.reports.ExtentReportUtil;

public class ListenerClass implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		ExtentReportUtil.initReports();
	}
	
	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReportUtil.tearDownReports();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportUtil.createTest(result.getName());
		ExtentLogger.pass(result.getName()+ " is started successfully");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		ExtentLogger.pass(result.getName()+ " is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		ExtentLogger.logStackTraceInfoInExtentReport(result.getThrowable().getMessage());
		ExtentLogger.fail(result.getName()+"  is failed");
		
		
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getName()+ " is skipped");
	}


}