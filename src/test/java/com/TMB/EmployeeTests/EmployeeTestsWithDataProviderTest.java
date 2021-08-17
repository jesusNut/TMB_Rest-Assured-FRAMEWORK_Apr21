package com.TMB.EmployeeTests;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.TMB.baseTests.BaseTest;
import com.TMB.constants.FrameworkConstants;
import com.TMB.constants.FrameworkConstantsSingleton;
import com.TMB.constants.FrameworkConstantsWithEagerLoading;
import com.TMB.enums.Constants;
import com.TMB.reports.ExtentLogger;
import com.TMB.requestSpecificationBuilder.RequestBuilder;
import com.TMB.requests.pojo.Favfood;
import com.TMB.requests.pojo.PersonData;
import com.TMB.reuests.builders.PersonBuilder;
import com.TMB.utils.FakerUtils;
import com.TMB.utils.RandomUtils;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeTestsWithDataProviderTest extends BaseTest {

	// ****** POSTing using Map and Array driven using Excel Sheet with DP

	@Test(enabled = true, dataProvider = "getData", dataProviderClass = com.TMB.utils.DataProviderUtils.class, groups = "post")

	public void postRequestAsMapandArray(Map<String, String> data) {

		Map<String, Object> requestMap = new HashMap<String, Object>();

		requestMap.put("id", Integer.parseInt(data.get("id")));
		requestMap.put("first_name", data.get("firstname"));
		requestMap.put("last_name", data.get("lastname"));
		requestMap.put("email", data.get("email"));

		Response response = given().log().all().baseUri(FrameworkConstants.getEMPLOYEE_BASEURI())
				.filter(new RequestLoggingFilter(captor)).contentType(ContentType.JSON).body(requestMap)
				.post(FrameworkConstants.getEMPLOYEE_ENDPOINT());

		ExtentLogger.logRequestAndResponseInReport(writer.toString(), response.asPrettyString());

		assertThat(response.getStatusCode()).isEqualTo(Integer.parseInt(data.get("statuscode")));

	}

	// ******** POSTing using Json Library driven using Excel Sheet with DP

	@Test(enabled = true, dataProvider = "getData", dataProviderClass = com.TMB.utils.DataProviderUtils.class, groups = "post")

	public void postRequestUsingJSONLibrarywithDP(Map<String, String> data) throws IOException {

		JSONObject outerObj = new JSONObject();
		outerObj.put("id", data.get("id"));
		outerObj.put("first_name", data.get("firstname"));
		outerObj.put("last_name", data.get("lastname"));
		outerObj.put("email", data.get("email"));

		// fetch job data from excel and feed to array

		String[] jobData = data.get("job").split(",");

		JSONArray innerArray = new JSONArray();

		innerArray.putAll(Arrays.asList(jobData));

		outerObj.put("job", innerArray);

		JSONObject innerMapObj = new JSONObject();

		innerMapObj.put("breakfast", data.get("breakfast"));

		innerMapObj.put("lunch", data.get("lunch"));

		outerObj.put("favfood", innerMapObj);

		// Map<String, Object> myMap = outerObj.toMap();

		Response response = RequestBuilder.getRequestBuilder().filter(new RequestLoggingFilter(captor))
				.contentType(ContentType.JSON).body(outerObj.toMap())
				.post(FrameworkConstantsWithEagerLoading.getConstantValue(Constants.EMPLOYEE_ENDPOINT).toString());

		ExtentLogger.logRequestAndResponseInReport(writer.toString(), response.asPrettyString());

		assertThat(response.getStatusCode())
				.isEqualTo(FrameworkConstantsWithEagerLoading.getConstantValue(Constants.STATUSCODE201));

	}

	// ******* POSTing using Pojo driven using excel sheet with DP

	@Test(enabled = true, dataProvider = "getData", dataProviderClass = com.TMB.utils.DataProviderUtils.class, groups = "post")
	public void postRequestUsingPojowithBuilderWithDP(Map<String, String> data) throws IOException {

		// fetch job data from excel and feed to array using a FOR loop

		String[] jobData = data.get("job").split(",");

		List<String> jobs = new ArrayList<String>();

		for (String s : jobData) {

			jobs.add(s);

		}

		Favfood food = new Favfood();
		food.setBreakfast(data.get("breakfast"));
		food.setLunch(data.get("lunch"));

		PersonBuilder personBuilder = new PersonBuilder();
		PersonData requestBody = personBuilder.setId(Integer.parseInt(data.get("id"))).and()
				.setFirst_name(data.get("firstname")).and()
				.setLast_name(data.get("lastname")).and()
				.setEmail(data.get("email")).and().setJob(jobs).and().setFood(food).build()
				.perform();

		Response response = RequestBuilder.getRequestBuilder().filter(new RequestLoggingFilter(captor)).contentType(ContentType.JSON).body(requestBody)
				.post(FrameworkConstantsSingleton.getObject().getEMPLOYEE_ENDPOINT());

	
		ExtentLogger.logRequestAndResponseInReport(writer.toString(), response.asPrettyString());

		assertThat(response.getStatusCode())
				.isEqualTo(FrameworkConstantsWithEagerLoading.getConstantValue(Constants.STATUSCODE201));
		

	}

	// ******** GETting employee and validating using Excel sheet with DP
	
	@Test(enabled = true,dataProvider = "getData",dataProviderClass = com.TMB.utils.DataProviderUtils.class, dependsOnGroups = "post")
	public void getEmployeeDetailWithDP(Map <String, String> map) {

		Response response = given().pathParam("id", map.get("id")).get("http://localhost:3000/employees/{id}");

		assertThat(response.statusCode()).isEqualTo(Integer.parseInt(map.get("statuscode")));

		ExtentLogger.logOnlyResponse(response.asPrettyString());

	}
	
}
