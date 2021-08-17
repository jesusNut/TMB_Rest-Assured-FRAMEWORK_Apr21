package com.TMB.EmployeeTests;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TMB.baseTests.BaseTest;
import com.TMB.constants.FrameworkConstants;
import com.TMB.constants.FrameworkConstantsSingleton;
import com.TMB.reports.ExtentLogger;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.response.Response;

public class EmployeeGetTest extends BaseTest {

	@Test(enabled = false)
	public void getEmployeesTest() {

		Response response = given().baseUri(FrameworkConstants.getEMPLOYEE_BASEURI())
				.basePath(FrameworkConstants.getEMPLOYEE_ENDPOINT()).get();

		assertThat(response.statusCode()).isEqualTo(FrameworkConstants.statusCode200);

		ExtentLogger.info(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));

	}

	@Test(enabled = true,dataProvider = "getData",dataProviderClass = com.TMB.utils.DataProviderUtils.class)
	public void getEmployeeDetail(Map <String, String> map) {

		Response response = given().pathParam("id", map.get("id")).get("http://localhost:3000/employees/{id}");

		assertThat(response.statusCode()).isEqualTo(Integer.parseInt(map.get("statuscode")));

		String expectedEmail = response.jsonPath().get("email").toString();

		assertThat(expectedEmail).isEqualTo(map.get("email"));

		// logging response as String in ExtentReport

		// ExtentLogger.pass(response.asPrettyString());

		// logging resposne as beuatified as JSON in Extent Report

		ExtentLogger.info(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));

	}

//	@DataProvider(name = "getData")
//	private Object[][] getData() {
//
//		Object[][] data = new Object[3][];
//
//		Map<String, Object> map1 = new HashMap<String,Object>();
//
//		map1.put("email", "sebastian@codingthesmartway.com");
//		map1.put("id", 1);
//
//		Map<String, Object> map2 = new HashMap<String,Object>();
//
//		map2.put("email", "steve@codingthesmartway.com");
//		map2.put("id", 2);
//
//		Map<String, Object> map3 = new HashMap<String,Object>();
//
//		map3.put("email", "ann@codingthesmartway.com");
//		map3.put("id", 3);
//		
//		data[0]= new Object[] {map1};
//		data[1]= new Object[] {map2};
//		data[2]= new Object[] {map3};
//
//		return data;
//
//	}

}
