package com.TMB.utils;

import com.github.javafaker.Faker;

//Faker utils implementation using singleton

public final class FakerUtils {

	private FakerUtils() {
	}

	private static  FakerUtils INSTANCE = null;

	public static FakerUtils getFakerInstance() {

		if (INSTANCE == null) {

			
			INSTANCE = new FakerUtils();
		}

		return INSTANCE;

	}

	// get first name

	public String getFirstName() {

		return new Faker().name().firstName();

	}

	// get last name

	public String getLastName() {

		return new Faker().name().lastName();

	}

	// get email

	public String getEmail() {

		return new Faker().bothify("???###@sweetu.com");

	}

	// get jobs

	public String getJobPosition() {

		return new Faker().job().position();

	}

	// get food

	public String getFood() {

		return new Faker().food().dish();

	}

}
