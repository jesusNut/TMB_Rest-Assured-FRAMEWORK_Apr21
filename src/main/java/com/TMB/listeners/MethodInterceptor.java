package com.TMB.listeners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.TMB.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

	// "List<IMethodInstance> methods" as param below to intecept method -> contains
	// all the @test methods provided at testNG.xml file

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<IMethodInstance> myCustomMethods = new ArrayList<IMethodInstance>();

		List<Map<String, String>> runManagerContent = null;

		try {
			runManagerContent = ExcelUtils.getExcelData("runManager", "DPwithExcel");
		} catch (IOException e) {

			e.printStackTrace();
		}

		for (int i = 0; i < methods.size(); i++) {

			for (int j = 0; j < runManagerContent.size(); j++) {

				if (isTestNameMatching(methods, runManagerContent, i, j)) {

					if (isTestCaseRunnable(runManagerContent, j)) {

						// if @test method names contained in "List<IMethodInstance> methods" passed as
						// param to intecept method
						// matches the test names from runManager sheet of excel && thats test case is
						// excute = YES, only then add it to 'myCustomMethods'
						// and send for execution.

						myCustomMethods.add(methods.get(i));

					}

				}
				;

			}

		}

		return myCustomMethods;
	}

	private boolean isTestCaseRunnable(List<Map<String, String>> runManagerContent, int j) {
		return runManagerContent.get(j).get("execute").equalsIgnoreCase("yes");
	}

	private boolean isTestNameMatching(List<IMethodInstance> methods, List<Map<String, String>> runManagerContent,
			int i, int j) {
		return methods.get(i).getMethod().getMethodName().equalsIgnoreCase(runManagerContent.get(j).get("testname"));
	}

}
