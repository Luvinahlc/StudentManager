package com.stuman.domain;

/**
 * Applyinfo entity. @author MyEclipse Persistence Tools
 */

public class Applyinfo implements java.io.Serializable {

	// Fields

	private ApplyinfoId id;

	// Constructors

	/** default constructor */
	public Applyinfo() {
	}

	/** full constructor */
	public Applyinfo(ApplyinfoId id) {
		this.id = id;
	}

	// Property accessors

	public ApplyinfoId getId() {
		return this.id;
	}

	public void setId(ApplyinfoId id) {
		this.id = id;
	}

}