
package com.TMB.requests.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "first_name", "last_name", "email", "job", "favfood" })
@Generated("jsonschema2pojo")
public class PersonData {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("job")
	private List<String> job = null;
	@JsonProperty("favfood")
	private Favfood favfood;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	// no-args constructor
	public PersonData() {

	}

	// constructor

	public PersonData(Integer id, String firstname, String lastname, String email, List<String> jobs, Favfood food) {

		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.job = jobs;
		this.favfood = food;

	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("job")
	public List<String> getJob() {
		return job;
	}

	@JsonProperty("job")
	public void setJob(List<String> job) {
		this.job = job;
	}

	@JsonProperty("favfood")
	public Favfood getFavfood() {
		return favfood;
	}

	@JsonProperty("favfood")
	public void setFavfood(Favfood favfood) {
		this.favfood = favfood;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(PersonData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("firstName");
		sb.append('=');
		sb.append(((this.firstName == null) ? "<null>" : this.firstName));
		sb.append(',');
		sb.append("lastName");
		sb.append('=');
		sb.append(((this.lastName == null) ? "<null>" : this.lastName));
		sb.append(',');
		sb.append("email");
		sb.append('=');
		sb.append(((this.email == null) ? "<null>" : this.email));
		sb.append(',');
		sb.append("job");
		sb.append('=');
		sb.append(((this.job == null) ? "<null>" : this.job));
		sb.append(',');
		sb.append("favfood");
		sb.append('=');
		sb.append(((this.favfood == null) ? "<null>" : this.favfood));
		sb.append(',');
		sb.append("additionalProperties");
		sb.append('=');
		sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
