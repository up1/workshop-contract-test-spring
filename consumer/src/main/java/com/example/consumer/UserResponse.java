package com.example.consumer;

public class UserResponse {
	private int id;
	private String firstname;
	private String lastname;

	public UserResponse() {
	}

	public UserResponse(int id, String firstname, String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}
}
