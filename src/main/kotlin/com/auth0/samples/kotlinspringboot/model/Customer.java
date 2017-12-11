package com.auth0.samples.kotlinspringboot.model;

import com.marklogic.client.pojo.annotation.Id;

/**
 * Created by SCI on 11/18/2017.
 */
public class Customer {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Id
	public String id;
	public String firstName;
	public String lastName;





}
