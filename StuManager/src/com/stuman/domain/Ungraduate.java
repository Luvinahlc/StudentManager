package com.stuman.domain;

/**
 * Ungraduate entity. @author MyEclipse Persistence Tools
 */

public class Ungraduate implements java.io.Serializable {

	// Fields

	private String sno;
	private String reason;

	// Constructors

	/** default constructor */
	public Ungraduate() {
	}

	/** full constructor */
	public Ungraduate(String reason) {
		this.reason = reason;
	}

	// Property accessors

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}