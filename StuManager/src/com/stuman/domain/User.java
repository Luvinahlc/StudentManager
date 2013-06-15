package com.stuman.domain;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String id;
	private String password;
	private Integer identity;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String password, Integer identity) {
		this.password = password;
		this.identity = identity;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIdentity() {
		return this.identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

}