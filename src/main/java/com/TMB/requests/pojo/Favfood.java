
package com.TMB.requests.pojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "breakfast", "lunch" })
@Generated("jsonschema2pojo")
public class Favfood {

	@JsonProperty("breakfast")
	private String breakfast;
	@JsonProperty("lunch")
	private String lunch;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	// no-args constructor

	public Favfood() {

	}

	// constructor
	public Favfood(String breakfast, String lunch) {

		this.breakfast = breakfast;
		this.lunch = lunch;

	}

	@JsonProperty("breakfast")
	public String getBreakfast() {
		return breakfast;
	}

	@JsonProperty("breakfast")
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	@JsonProperty("lunch")
	public String getLunch() {
		return lunch;
	}

	@JsonProperty("lunch")
	public void setLunch(String lunch) {
		this.lunch = lunch;
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
		sb.append(Favfood.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("breakfast");
		sb.append('=');
		sb.append(((this.breakfast == null) ? "<null>" : this.breakfast));
		sb.append(',');
		sb.append("lunch");
		sb.append('=');
		sb.append(((this.lunch == null) ? "<null>" : this.lunch));
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
