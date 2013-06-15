package com.stuman.domain;

/**
 * Selectcoursetime entity. @author MyEclipse Persistence Tools
 */

public class Selectcoursetime implements java.io.Serializable {

	// Fields

	private SelectcoursetimeId id;

	// Constructors

	/** default constructor */
	public Selectcoursetime() {
	}

	/** full constructor */
	public Selectcoursetime(SelectcoursetimeId id) {
		this.id = id;
	}

	// Property accessors

	public SelectcoursetimeId getId() {
		return this.id;
	}

	public void setId(SelectcoursetimeId id) {
		this.id = id;
	}

}