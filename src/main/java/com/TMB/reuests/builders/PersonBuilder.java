package com.TMB.reuests.builders;

import java.util.List;

import com.TMB.requests.pojo.Favfood;
import com.TMB.requests.pojo.PersonData;

public class PersonBuilder {

	
	private Integer id;
	private String first_name;
	private String last_name;
	private String email;
	private List<String> job;
	private Favfood food;
	
	
	public PersonBuilder setId(Integer id) {
		this.id = id;
		return this;
	}
	public PersonBuilder setFirst_name(String first_name) {
		this.first_name = first_name;
		return this;
	}
	public PersonBuilder setLast_name(String last_name) {
		this.last_name = last_name;
		return this;
	}
	public PersonBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	public PersonBuilder setJob(List<String> job) {
		this.job = job;
		return this;
	}
	public PersonBuilder setFood(Favfood food) {
		this.food = food;
		return this;
	}
	
	public PersonBuilder build() {

		return this;
	}

	public PersonBuilder and() {

		return this;
	}

	// this method creates a new PersonArrayPayload object
	
	
	public PersonData perform() {

		PersonData temp_person = new PersonData();
		temp_person.setId(this.id);
		temp_person.setFirstName(this.first_name);
		temp_person.setLastName(this.last_name);
		temp_person.setEmail(this.email);
		temp_person.setJob(this.job);
		temp_person.setFavfood(this.food);

		return temp_person;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
