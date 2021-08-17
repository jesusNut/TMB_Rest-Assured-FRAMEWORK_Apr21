package com.TMB.EmployeeTests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.testng.annotations.Test;

import com.TMB.baseTests.BaseTest;
import com.TMB.constants.FrameworkConstantsSingleton;
import com.TMB.reports.ExtentLogger;
import com.TMB.requestSpecificationBuilder.RequestBuilder;
import com.TMB.requests.pojo.PersonData;
import com.TMB.reuests.builders.PersonBuilder;
import com.TMB.requests.pojo.Favfood;
import com.TMB.utils.FakerUtils;
import com.TMB.utils.RandomUtils;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeePostWithPojoTest extends BaseTest {

	// post method using Pojo- 1

	@Test(enabled = false)
	public void postRequestUsingPojo() throws IOException {

		PersonData data = new PersonData();
		data.setId(Integer.parseInt(RandomUtils.generateRandomNumericString(3)));
		data.setFirstName("Narender");
		data.setLastName("Modi");
		data.setEmail("NarenderModi@pmo.com");

		List<String> jobs = new ArrayList<String>();
		jobs.add("Chief minister");
		jobs.add("Pradhan Mantri");
		jobs.add("actor");

		data.setJob(jobs);

		Favfood food = new Favfood();
		food.setBreakfast("dosa");
		food.setLunch("whey");

		data.setFavfood(food);

		Response response = RequestBuilder.getRequestBuilder().contentType(ContentType.JSON).body(data)
				.post(FrameworkConstantsSingleton.getObject().getEMPLOYEE_ENDPOINT());

		response.prettyPrint();

	}

	// post method using Pojo- 2

	@Test(enabled = false)
	public void postRequestUsingPojowithConstructor() throws IOException {

		List<String> jobs = new ArrayList<String>();
		jobs.add("trainer");
		jobs.add("darubaaz");
		jobs.add("gardulla");

		PersonData data = new PersonData(Integer.parseInt(RandomUtils.generateRandomNumericString(3)), "ZamanUllah", "Karimi",
				"Zaman.islam@khooni.com", jobs, new Favfood("dosa", "Idli"));

		Response response = RequestBuilder.getRequestBuilder().contentType(ContentType.JSON).body(data)
				.post(FrameworkConstantsSingleton.getObject().getEMPLOYEE_ENDPOINT());

		response.prettyPrint();

	}
	
	// post method using Pojo- 3 :using Faker names

		@Test(enabled = true)
		public void postRequestUsingPojowithBuilder() throws IOException {
			
			
			List <String> jobs = new ArrayList<String>();
			jobs.add(FakerUtils.getFakerInstance().getJobPosition());
			jobs.add(FakerUtils.getFakerInstance().getJobPosition());
			jobs.add(FakerUtils.getFakerInstance().getJobPosition());
			
			Favfood food = new Favfood();
			food.setBreakfast(FakerUtils.getFakerInstance().getFood());
			food.setLunch(FakerUtils.getFakerInstance().getFood());

			PersonBuilder personBuilder = new PersonBuilder();
			PersonData requestBody = personBuilder.setId(Integer.parseInt(RandomUtils.generateRandomNumericString(3))).and()
			.setFirst_name(FakerUtils.getFakerInstance().getFirstName())
			.and().setLast_name(FakerUtils.getFakerInstance().getLastName())
			.and().setEmail(FakerUtils.getFakerInstance().getEmail())
			.and().setJob(jobs)
			.and().setFood(food).build().perform();
			

			Response response = RequestBuilder.getRequestBuilder().contentType(ContentType.JSON).body(requestBody)
					.post(FrameworkConstantsSingleton.getObject().getEMPLOYEE_ENDPOINT());

			//response.prettyPrint();
			
			ExtentLogger.info(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));

		}

}
