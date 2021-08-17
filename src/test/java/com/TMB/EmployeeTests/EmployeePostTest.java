package com.TMB.EmployeeTests;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.TMB.baseTests.BaseTest;
import com.TMB.constants.FrameworkConstants;
import com.TMB.constants.FrameworkConstantsWithEagerLoading;
import com.TMB.constants.StringConstants;
import com.TMB.enums.Constants;
import com.TMB.requestSpecificationBuilder.RequestBuilder;
import com.TMB.utils.RandomUtils;
import com.TMB.utils.RequestBodyExternalFileReadUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeePostTest extends BaseTest {

	
	//post method -1
	@Test(enabled = false)
	public void postRequestAsString() {

		Response response  = given().log().all().baseUri(FrameworkConstants.getEMPLOYEE_BASEURI())
				.contentType(ContentType.JSON)
				.body(StringConstants.getReqBodyForPost())
				.post(FrameworkConstants.getEMPLOYEE_ENDPOINT());
		
		response.prettyPrint();

	}

	//post method -2
	
	@Test(enabled = false)
	public void postRequestAsMapandArray() {
		

		
		Map<String, Object> requestMap = new HashMap<String, Object>();

		requestMap.put("id", Integer.parseInt(RandomUtils.generateRandomNumericString(2)));
		requestMap.put("first_name", "Mona");
		requestMap.put("last_name", "Darling");
		requestMap.put("email", "MonaDarling@yahoo.co.uk");

		List<String> reqArrayinMap = new ArrayList<String>();

		reqArrayinMap.add("Trainer");
		reqArrayinMap.add("Tester");

		requestMap.put("job", reqArrayinMap);

		Map<String, String> requestMapinMap = new HashMap<String, String>();

		requestMapinMap.put("breakfast", "dosa");
		requestMapinMap.put("lunch", "rice");

		requestMap.put("favfood", requestMapinMap);


		Response response  = given().log().all().baseUri(FrameworkConstants.getEMPLOYEE_BASEURI())
				.contentType(ContentType.JSON)
				.body(requestMap)
				.post(FrameworkConstants.getEMPLOYEE_ENDPOINT());
		
		response.prettyPrint();
		
		assertThat(response.getStatusCode()).isEqualTo(201);
		
		
	}
	
	
	//post method -3
	
	@Test(enabled = false)
	public void postRequestByReadingExternalFile() throws IOException {
		
		String fetchBody =
				
				RequestBodyExternalFileReadUtils.
				getJSONfileAsString(FrameworkConstantsWithEagerLoading.getConstantValue(Constants.REQUESTBODYEXTERNALFILEFOLDERPATH)+"test.json");
		
		String requestBody = fetchBody.replace("999", RandomUtils.generateRandomNumericString(3))
				.replace("{firstname}", RandomUtils.generateRandomString(6));

		Response response  = given().log().all().baseUri(FrameworkConstants.getEMPLOYEE_BASEURI())
				.contentType(ContentType.JSON)
				.body(requestBody)
				.post(FrameworkConstants.getEMPLOYEE_ENDPOINT());
		
		response.prettyPrint();

	}
	
	//post method -4
	
		@Test(enabled = true)
		public void postRequestUsingJSONLibrary() throws IOException {
			
			JSONObject outerObj = new JSONObject();
			outerObj.put("id", RandomUtils.generateRandomNumericString(3));
			outerObj.put("first_name", "Mona");
			outerObj.put("last_name", "Darling");
			outerObj.put("email", "MonaDarling@yahoo.co.uk");

			JSONArray innerArray = new JSONArray();

			innerArray.put("Trainer");
			innerArray.put("Tester");
			innerArray.put("Farmer");

			outerObj.put("job", innerArray);

			JSONObject innerMapObj = new JSONObject();

			innerMapObj.put("breakfast", "dosa");
			innerMapObj.put("lunch", "rice");

			outerObj.put("favfood", innerMapObj);

			//Map<String, Object> myMap = outerObj.toMap();
			

			Response response  = RequestBuilder.getRequestBuilder()
					.contentType(ContentType.JSON)
					.body(outerObj.toMap())
					.post(FrameworkConstantsWithEagerLoading.getConstantValue(Constants.EMPLOYEE_ENDPOINT).toString());
			
			response.prettyPrint();
			
			assertThat(response.getStatusCode()).isEqualTo(FrameworkConstantsWithEagerLoading.getConstantValue(Constants.STATUSCODE201));

		}
	
}
