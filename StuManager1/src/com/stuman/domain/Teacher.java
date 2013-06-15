package com.stuman.domain;

import java.util.HashSet;
import java.util.Set;

public class Teacher implements java.io.Serializable {

	// Fields

	private String id;

	private String name;

	private String password;

	private String title;

	private Set classeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** full constructor */
	public Teacher(String name, String password, String title, Set classeses) {
		this.name = name;
		this.password = password;
		this.title = title;
		this.classeses = classeses;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set getClasseses() {
		return this.classeses;
	}

	public void setClasseses(Set classeses) {
		this.classeses = classeses;
	}

}