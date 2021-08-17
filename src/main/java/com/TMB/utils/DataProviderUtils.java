package com.TMB.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public final class DataProviderUtils {

	private DataProviderUtils() {
	}

	// DATA PROVIDER with return type as 1D Object Array and HASHMAP : can be used
	// for any test case
	// using 'testname' column of excel sheet.

	@DataProvider(name = "getData")
	public static Object[] getData(Method method) throws IOException {
		
		//getting data from ExcelUtils class method name :: getExcelData()

		List<Map<String, String>> allDatalist = ExcelUtils.getExcelData("iterationData", "DPwithExcel");

		// filter the data based on TestCase name and execute =yes/no.

		List<Map<String, String>> individualTestCaselist = new ArrayList<Map<String, String>>();
		
		for (int i = 0; i < allDatalist.size(); i++) {

			if (isCallingMethodNameEqualsTestCaseName(method, allDatalist, i) && isTestCaseDataExecutable(allDatalist, i)) {

				individualTestCaselist.add(allDatalist.get(i));

			}

		}

		return individualTestCaselist.toArray();
	}
	
	//method to check if data for the test case that needs to be xecuted is marked as yes/no in excel

	private static boolean isTestCaseDataExecutable(List<Map<String, String>> allDatalist, int i) {
		return allDatalist.get(i).get("execute").equalsIgnoreCase("yes");
	}
	
	//method to check if the calling method of DP has samw name as testcase in excel sheet or not

	private static boolean isCallingMethodNameEqualsTestCaseName(Method method, List<Map<String, String>> allDatalist, int i) {
		return method.getName().equalsIgnoreCase(allDatalist.get(i).get("testCaseName"));
	}
	
	

	

}